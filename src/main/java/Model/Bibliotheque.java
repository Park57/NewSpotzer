package Model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.farng.mp3.id3.AbstractID3v2;

public class Bibliotheque {
	public final static int INCHANGE = 0;
	public final static int CREE = 1;
	public final static int MODIFIE = 2;
	public final static int SUPPRIMER = 3;

	private Set<Artiste> listeArtistes = new HashSet<Artiste>();
	private Set<Album> listeAlbums = new HashSet<Album>();
	private Set<Morceau> listeMorceaux = new HashSet<Morceau>();
	private Set<Genre> listeGenres = new HashSet<Genre>();
	private Set<Playlist>listPlaylists = new HashSet<Playlist>();

	public Bibliotheque() {

	}

	public void afficherLesGenres() {
		for (Genre g : listeGenres) {
			System.out.println(g.getCodeGenre() + " : " + g.getLibelle());
		}
	}

	public void chargerLaBaseDeDonnéesEnMetier() {
		listeArtistes = DAOArtisteJPA.getInstance().loadAll();
		listeAlbums = DAOAlbumJPA.getInstance().loadAll();
		listeGenres = DAOGenreJPA.getInstance().loadAll();
		listeMorceaux = DAOMorceauJPA.getInstance().loadAll();
		listPlaylists = DAOPlaylistJPA.getInstance().loadAll();
	}

	public void sauvegarderLaPartieMetierEnBaseDeDonnées() {
		System.out.println("Sauvegarde de la partie metier en base de données");
		DAOAlbumJPA.getInstance().saveAll(listeAlbums);
		DAOArtisteJPA.getInstance().saveAll(listeArtistes);
		DAOMorceauJPA.getInstance().saveAll(listeMorceaux);
		DAOPlaylistJPA.getInstance().saveAll(listPlaylists);
	}

	public void ajouterUnMorceau(File mp3) {
		MP3File morceau = null;
		Artiste artistemp3 = null;
		Set<Genre> genresmp3 = new HashSet<Genre>();
		Album albummp3 = null;
		Morceau morceaump3 = new Morceau();

		try {
			morceau = new MP3File(mp3);
			System.out.println("Est ID3V1 : " + morceau.hasID3v1Tag());
			System.out.println("Est ID3V2 : " + morceau.hasID3v2Tag());
			AbstractID3v2 tags = morceau.getID3v2Tag();

			// completion de l'artiste
			try {
				String nomArtiste = tags.getLeadArtist();
				nomArtiste = nomArtiste.trim();
				if (!nomArtiste.equals("")) {
					boolean trouve = false;
					for (Artiste a : listeArtistes) {
						// Demander a l'utilisateur

						if (a.getNomArtiste().equals(nomArtiste)) {

							artistemp3 = a;
							trouve = true;
						}
					}
					if (!trouve) {
						artistemp3 = new Artiste(nomArtiste);
						listeArtistes.add(artistemp3);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			// completion des genres
			try {
				String[] genres = tags.getSongGenre().split(",");
				for (String genre : genres) {
					try {
						if (genre.length() != 0) {
							boolean trouve = false;
							int numGenre = -1;
							try {
								numGenre = Byte.parseByte(genre.substring(1, genre.length() - 1));
							} catch (Exception e) {
								// e.printStackTrace();
							}
							for (Genre g : listeGenres) {

								if (g.getCodeGenre() - 1 == numGenre) {
									genresmp3.add(g);
									trouve = true;
								}
								if (genre.equals(g.getLibelle())) {
									genresmp3.add(g);
									trouve = true;
								}
							}
							if (!trouve) {
								System.out.println("ce genre n'existe pas");
							}
						}
					} catch (NumberFormatException e) {
						System.out.println("Genre inconnu");
					}
				}
			} catch (NullPointerException e) {
				System.out.println("Genre vide\n");
			}

			// completion de l'album
			try {
				String nomAlbum = tags.getAlbumTitle();
				int anneeAlbum = Integer.parseInt(tags.getYearReleased());
				boolean trouve = false;
				for (Album a : listeAlbums) {
					if (a.getTitreAlbum().equals(nomAlbum) /* && (a.getAnneeAlbum() == anneeAlbum) */) {

						albummp3 = a;
						trouve = true;
					}

				}
				if (trouve == false) {
					albummp3 = new Album(nomAlbum, anneeAlbum);
					listeAlbums.add(albummp3);
				}

			} catch (NullPointerException e) {
				System.out.println("Album vide\n");
			} catch (NumberFormatException e) {
				System.out.println("Erreur nombre dans annee\n");
			}

			// Titre
			try {
				morceaump3.setTitreMorceau(tags.getSongTitle());
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Commentaires
			try {
				morceaump3.setCommentaireMorceau(tags.getSongComment());
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Paroles
			try {
				morceaump3.setParolesMorceau(tags.getSongLyric());
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Auteur Compositeur
			try {
				morceaump3.setAuteurCompositeurMorceau(tags.getAuthorComposer());
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Chemin
			try {
				File rep = new File("./bibliotheque");
				File fileApresDeplacement = new File(rep, mp3.getName());
				mp3.renameTo(fileApresDeplacement);
				String cheminAbsolu = fileApresDeplacement.getAbsolutePath();
				String[] decoup = cheminAbsolu.split("NewSpotzer");
				String cheminRelatif = decoup[1].substring(1, decoup[1].length());
				morceaump3.setCheminMorceau(cheminRelatif);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Annee
			try {
				String annee = tags.getYearReleased();
				if (annee != "") {
					morceaump3.setAnneeMorceau(Integer.parseInt(annee));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				morceaump3.setAlbumMorceau(albummp3);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				morceaump3.setArtisteMorceau(artistemp3);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				morceaump3.setGenresMorceau(genresmp3);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (artistemp3 != null)
				artistemp3.getMorceauxArtiste().add(morceaump3);
			if (albummp3 != null)
				albummp3.getMorceauxAlbum().add(morceaump3);
			for (Genre g : genresmp3) {
				g.getMorceauxGenre().add(morceaump3);
			}
			morceaump3.setEtatMetier(CREE);
			listeMorceaux.add(morceaump3);

			System.out.println("On a ajouté le morceau : \n" + morceaump3);

		} catch (IOException e) {
			System.out.println(mp3.getName() + " n'est pas un fihcier de type mp3...");
			// e.printStackTrace();
		} catch (TagException e) {
			System.out.println("tag excpetion");
			// e.printStackTrace();
		}
		System.out.println("|||||||||||||||||  Nous avons donc actuellement :  |||||||||||||||||||");
		for (Album a : listeAlbums)
			System.out
					.println("L'album : " + a.getTitreAlbum() + " possede : " + a.getMorceauxAlbum().size() + "titres");
		for (Artiste a : listeArtistes)
			System.out.println(
					"L'artiste " + a.getNomArtiste() + " a chanter : " + a.getMorceauxArtiste().size() + " titres");
		System.out.println("\n----------------------------------------------------------------------\n");
	}

	public Set<Artiste> getListeArtistes() {
		return listeArtistes;
	}

	public void setListeArtistes(Set<Artiste> listeArtistes) {
		this.listeArtistes = listeArtistes;
	}

	public Set<Album> getListeAlbums() {
		return listeAlbums;
	}

	public void setListeAlbums(Set<Album> listeAlbums) {
		this.listeAlbums = listeAlbums;
	}

	public Set<Morceau> getListeMorceaux() {
		return listeMorceaux;
	}

	public void setListeMorceaux(Set<Morceau> listeMorceaux) {
		this.listeMorceaux = listeMorceaux;
	}

	public Set<Genre> getListeGenres() {
		return listeGenres;
	}

	public void setListeGenres(Set<Genre> listeGenres) {
		this.listeGenres = listeGenres;
	}

	public Set<Playlist> getListPlaylists() {
		return listPlaylists;
	}

	public void setListPlaylists(Set<Playlist> listPlaylists) {
		this.listPlaylists = listPlaylists;
	}
	
	

}
