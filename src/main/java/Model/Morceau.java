package Model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Transient;

import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.farng.mp3.id3.AbstractID3v2;

public class Morceau {
	private int codeMorceau;
	private String titreMorceau;
	private Album albumMorceau;
	private Artiste artisteMorceau;
	private Set<Genre> genresMorceau = new HashSet<Genre>();
	private Set<Playlist> playlistsMorceau = new HashSet<Playlist>();
	private String cheminMorceau;
	private int anneeMorceau;
	private String parolesMorceau;
	private String auteurCompositeurMorceau;
	private String commentaireMorceau;
	@Transient
	private int etatMetier;

	public Morceau() {
		this.codeMorceau = -1;
		etatMetier = Bibliotheque.CREE;
	}

	/*
	 * Ici on construit un morceau. On reçoit un type File, qu'on passe en MP3File,
	 * si cela soulève une exception alors on sait que ce n'est pas un mp3
	 */
	public Morceau(File mp3) {
		MP3File morceau;
		try {
			morceau = new MP3File(mp3);
			AbstractID3v2 tags = morceau.getID3v2Tag();

			// on complète les champs
			this.codeMorceau = -1;

			// completion du titre
			try {
				this.titreMorceau = tags.getSongTitle();
				System.out.println("Titre morceau : " + this.titreMorceau + "\n");
			} catch (NullPointerException e) {
				this.titreMorceau = "null";
				System.out.println("Titre vide\n");
			}

			// completion de l'album
			try {
				this.albumMorceau = new Album(tags.getAlbumTitle(), Integer.parseInt(tags.getYearReleased()));
				System.out.println("Album : " + this.albumMorceau + "\n");
			} catch (NullPointerException e) {
				this.albumMorceau = new Album();
				System.out.println("Album vide\n");
			} catch (NumberFormatException e) {
				System.out.println("Erreur nombre dans annee\n");
			}

			// completion de l'artiste
			try {
				this.artisteMorceau = new Artiste(tags.getLeadArtist());
				System.out.println("Artiste : " + this.artisteMorceau + "\n");
			} catch (NullPointerException e) {
				this.artisteMorceau = new Artiste("null");
			}

			// completion des genres
			try {
				String[] genres = tags.getSongGenre().split(",");
				for (String genre : genres) {
					try {
						if (genre.length() != 0) {
							String libelleGenre = Genre.getGenres()
									.get(Integer.parseInt(genre.substring(1, genre.length() - 1)));
							this.genresMorceau.add(new Genre(libelleGenre));
						}
					} catch (NumberFormatException e) {
						System.out.println("Genre inconnu");
					}
					System.out.println("//////////////////" + genre);
				}
				System.out.println("Genre(s) : " + this.genresMorceau + "\n");
			} catch (NullPointerException e) {
				System.out.println("Genre vide\n");
			}

			// completion du chemin
			try {
				File rep = new File("./bibliotheque");
				File fileApresDeplacement = new File(rep, mp3.getName());
				boolean resultat = mp3.renameTo(fileApresDeplacement);
				if (resultat) {
					System.out.println("Le fichier a été déplacé vers==> " + rep);
				} else
					System.out.println("Impossible de déplacer ce fichier");

				String cheminAbsolu = fileApresDeplacement.getAbsolutePath();
				System.out.println("Le chemin absolu : " + cheminAbsolu);
				String[] decoup = cheminAbsolu.split("NewSpotzer");
				String cheminRelatif = decoup[1].substring(1, decoup[1].length());
				System.out.println("Le chemin relatif : " + cheminRelatif);

				this.cheminMorceau = cheminRelatif;
				System.out.println("Chemin du morceau après déplacement : " + this.cheminMorceau + "\n");

			} catch (NullPointerException e) {
				System.out.println("On est pas censé passer par là\n");
			}

			// completion de l'annee
			try {
				this.anneeMorceau = Integer.parseInt(tags.getYearReleased());
				System.out.println("Annee : " + this.anneeMorceau + "\n");
			} catch (NullPointerException e) {
				this.anneeMorceau = -1;
				System.out.println("Annee nulle\n");
			} catch (NumberFormatException e) {
				System.out.println("Erreur dans annee\n");
			}

			// completion des paroles
			try {
				this.parolesMorceau = tags.getSongLyric();
				System.out.println("Paroles du morceau " + this.parolesMorceau + "\n");
			} catch (NullPointerException e) {
				System.out.println("Pas de paroles\n");
			}

			// completion de l'auteur compositeur
			try {
				this.auteurCompositeurMorceau = tags.getAuthorComposer();
				System.out.println("Auteur compositeur : " + this.auteurCompositeurMorceau + "\n");
			} catch (NullPointerException e) {
				this.auteurCompositeurMorceau = "null";
				System.out.println("Auteur compositeur vide\n");
			}

			// completion des commentaires
			try {
				this.commentaireMorceau = tags.getSongComment();
				System.out.println("Commentaire : " + this.commentaireMorceau + "\n");
			} catch (NullPointerException e) {
				System.out.println("PAS DE COMMENTAIRE\n");
			}

			System.out.println("\n----------------------------------------------------------------------\n");

		} catch (IOException e) {
			System.out.println(mp3.getName() + " n'est pas un fihcier de type mp3...");
			// e.printStackTrace();
		} catch (TagException e) {
			System.out.println("tag excpetion");
			// e.printStackTrace();
		}

	}

	// fin constructeur

	public void supprimerMorceau() {
		this.etatMetier = Bibliotheque.SUPPRIMER;
		if (this.albumMorceau != null) {
			if (this.albumMorceau.getMorceauxAlbum().size() <= 1) {
				this.albumMorceau.setEtatMetier(Bibliotheque.SUPPRIMER);
			}
		}
		if (this.artisteMorceau != null) {
			if (this.artisteMorceau.getMorceauxArtiste().size() <= 1) {
				this.artisteMorceau.setEtatMetier(Bibliotheque.SUPPRIMER);
			}
		}
		for(Playlist p : this.playlistsMorceau){
			p.retirerMorceauPlaylist(this);
		}
	}
	///////////////////////////
	//// GETTERS & SETTERS ////
	///////////////////////////

	public int getCodeMorceau() {
		return codeMorceau;
	}

	public int getEtatMetier() {
		return etatMetier;
	}

	public void setEtatMetier(int etatMetier) {
		this.etatMetier = etatMetier;
	}

	public String getTitreMorceau() {
		return titreMorceau;
	}

	public void setTitreMorceau(String titreMorceau) {
		this.etatMetier = Bibliotheque.MODIFIE;
		this.titreMorceau = titreMorceau;
	}

	public Album getAlbumMorceau() {
		return albumMorceau;
	}

	public void setAlbumMorceau(Album albumMorceau) {
		this.albumMorceau = albumMorceau;
		this.etatMetier = Bibliotheque.MODIFIE;
	}

	public Artiste getArtisteMorceau() {
		return artisteMorceau;
	}

	public void setArtisteMorceau(Artiste artisteMorceau) {
		this.artisteMorceau = artisteMorceau;
		this.etatMetier = Bibliotheque.MODIFIE;
	}

	public Set<Genre> getGenresMorceau() {
		return genresMorceau;
	}

	public void setGenresMorceau(Set<Genre> genresMorceau) {
		this.genresMorceau = genresMorceau;
		this.etatMetier = Bibliotheque.MODIFIE;
	}

	public String getCheminMorceau() {
		return cheminMorceau;
	}

	public void setCheminMorceau(String cheminMorceau) {
		this.cheminMorceau = cheminMorceau;
	}

	public int getAnneeMorceau() {
		return anneeMorceau;
	}

	public void setAnneeMorceau(int anneeMorceau) {
		this.anneeMorceau = anneeMorceau;
	}

	public String getParolesMorceau() {
		return parolesMorceau;
	}

	public void setParolesMorceau(String parolesMorceau) {
		this.parolesMorceau = parolesMorceau;
	}

	public String getAuteurCompositeurMorceau() {
		return auteurCompositeurMorceau;
	}

	public void setAuteurCompositeurMorceau(String auteurCompositeurMorceau) {
		this.auteurCompositeurMorceau = auteurCompositeurMorceau;
	}

	public String getCommentaireMorceau() {
		return commentaireMorceau;
	}

	public void setCommentaireMorceau(String commentaireMorceau) {
		this.commentaireMorceau = commentaireMorceau;
		this.etatMetier = Bibliotheque.MODIFIE;
	}

	public Set<Playlist> getPlaylistsMorceau() {
		return playlistsMorceau;
	}

	public void setPlaylistsMorceau(Set<Playlist> playlistsMorceau) {
		this.playlistsMorceau = playlistsMorceau;
	}

	////////////////////////////////
	/// AJOUTER RETIRER PRESENCE ///
	////////////////////////////////

	public void ajoutPlaylistMorceau(Playlist p) {
		this.setEtatMetier(Bibliotheque.MODIFIE);
		this.playlistsMorceau.add(p);
	}

	public boolean presencePlaylistMorceau(Playlist p) {
		return this.genresMorceau.contains(p);
	}

	public void retirerPlaylistMorceau(Playlist p) {
		System.out.println(playlistsMorceau.size());
		Playlist play = null;
		for (Playlist pl : playlistsMorceau) {
			if (pl.equals(p)) {
				play = pl;
				System.out.println("ON A BIEN TROUVE LA PLAYLIST");
			}
		}
		this.setEtatMetier(Bibliotheque.MODIFIE);
		this.playlistsMorceau.remove(play);
		System.out.println(playlistsMorceau.size());
	}

	public void ajoutGenreMorceau(Genre g) {
		this.genresMorceau.add(g);
	}

	public boolean presenceGenreMorceau(Genre g) {
		return this.genresMorceau.contains(g);
	}

	public void retirerGenreMorceau(Genre g) {
		this.genresMorceau.remove(g);
	}

	/////////////////////
	// EQUALS TOSTRING //
	/////////////////////

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Morceau other = (Morceau) obj;
		if (albumMorceau == null) {
			if (other.albumMorceau != null)
				return false;
		} else if (!albumMorceau.equals(other.albumMorceau))
			return false;
		if (anneeMorceau != other.anneeMorceau)
			return false;
		if (artisteMorceau == null) {
			if (other.artisteMorceau != null)
				return false;
		} else if (!artisteMorceau.equals(other.artisteMorceau))
			return false;
		if (auteurCompositeurMorceau == null) {
			if (other.auteurCompositeurMorceau != null)
				return false;
		} else if (!auteurCompositeurMorceau.equals(other.auteurCompositeurMorceau))
			return false;
		if (cheminMorceau == null) {
			if (other.cheminMorceau != null)
				return false;
		} else if (!cheminMorceau.equals(other.cheminMorceau))
			return false;
		if (codeMorceau != other.codeMorceau)
			return false;
		if (commentaireMorceau == null) {
			if (other.commentaireMorceau != null)
				return false;
		} else if (!commentaireMorceau.equals(other.commentaireMorceau))
			return false;
		if (genresMorceau == null) {
			if (other.genresMorceau != null)
				return false;
		} else if (!genresMorceau.equals(other.genresMorceau))
			return false;
		if (parolesMorceau == null) {
			if (other.parolesMorceau != null)
				return false;
		} else if (!parolesMorceau.equals(other.parolesMorceau))
			return false;
		if (titreMorceau == null) {
			if (other.titreMorceau != null)
				return false;
		} else if (!titreMorceau.equals(other.titreMorceau))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String res = "";
		res += "\nMorceau \n[\ncodeMorceau=" + codeMorceau + ",\n titreMorceau=" + titreMorceau;
		res += ",\n artisteMorceau=";
		if (this.artisteMorceau != null)
			res += ",\n artisteMorceau=" + this.artisteMorceau.getNomArtiste() + ",\n";
		else
			res += "\nCe morceau n'a pas d'artiste,\n";
		if (this.albumMorceau != null)
			res += " albumMorceau=" + this.albumMorceau.getTitreAlbum();
		else
			res += "Ce morceau n'a pas d'album";
		res += ",\n genresMorceau=" + genresMorceau + ",\n cheminMorceau=" + cheminMorceau + ",\n anneeMorceau="
				+ anneeMorceau + ",\n parolesMorceau=" + parolesMorceau + ",\n auteurCompositeurMorceau="
				+ auteurCompositeurMorceau + ",\n commentaireMorceau=" + commentaireMorceau + "\n]";
		return res;
	}

}
