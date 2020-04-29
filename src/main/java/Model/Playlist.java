package Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Transient;

public class Playlist {
	private int codePlaylist;
	// private Utilisateur createurPlaylist;
	// private int tempsPlaylist;
	private Set<Morceau> morceauxPlaylist = new HashSet<Morceau>();
	private String titrePlaylist;
	private String descriptionPlaylist;
	@Transient
	private int etatMetier;

	public Playlist(/* Utilisateur createurPlaylist, */ String titrePlaylist, String descriptionPlaylist) {
		this.codePlaylist = -1;
		// this.createurPlaylist = createurPlaylist;
		this.titrePlaylist = titrePlaylist;
		this.descriptionPlaylist = descriptionPlaylist;
		etatMetier = Bibliotheque.CREE;
	}

	public Playlist() {
		this.codePlaylist = -1;
		etatMetier = Bibliotheque.CREE;
	}

	///////////////////////////
	//// GETTERS & SETTERS ////
	///////////////////////////

	public int getCodePlaylist() {
		return codePlaylist;
	}

	/*
	 * public int getTempsPlaylist() { return tempsPlaylist; }
	 */

	/*
	 * public void setTempsPlaylist(int tempsPlaylist) { this.tempsPlaylist =
	 * tempsPlaylist; }
	 */
	/*
	 * public Utilisateur getCreateurPlaylist() { return createurPlaylist; }
	 */

	public Set<Morceau> getMorceauxPlaylist() {
		return morceauxPlaylist;
	}

	public void setMorceauxPlaylist(Set<Morceau> morceauxPlaylist) {
		this.morceauxPlaylist = morceauxPlaylist;
	}

	public String getTitrePlaylist() {
		return titrePlaylist;
	}

	public void setTitrePlaylist(String titrePlaylist) {
		this.titrePlaylist = titrePlaylist;
	}

	public String getDescriptionPlaylist() {
		return descriptionPlaylist;
	}

	public void setDescriptionPlaylist(String descriptionPlaylist) {
		this.descriptionPlaylist = descriptionPlaylist;
	}

	public int getEtatMetier() {
		return etatMetier;
	}

	public void setEtatMetier(int etatMetier) {
		this.etatMetier = etatMetier;

		////////////////////////////////
		/// AJOUTER RETIRER PRESENCE ///
		////////////////////////////////

	}

	public void ajoutMorceauPlaylist(Morceau m) {
		this.morceauxPlaylist.add(m);
		this.etatMetier = Bibliotheque.MODIFIE;
	}

	public boolean presenceMorceauPlaylist(Morceau m) {
		return this.morceauxPlaylist.contains(m);
	}

	public void retirerMorceauPlaylist(Morceau m) {
		Morceau mo = null;
		for (Morceau morc : morceauxPlaylist) {
			if (morc.equals(m)) {
				mo = morc;
				System.out.println("ON A BIEN TROUVE LE MORCEAU");
			}
		}
		this.morceauxPlaylist.remove(mo);
		// this.morceauxPlaylist.remove(m);
		this.etatMetier = Bibliotheque.MODIFIE;
	}

	public void supprimerPlaylist() {
		this.etatMetier = Bibliotheque.SUPPRIMER;
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
		Playlist other = (Playlist) obj;
		if (codePlaylist != other.codePlaylist)
			return false;
		/*
		 * if (createurPlaylist == null) { if (other.createurPlaylist != null)
		 * return false; } else if
		 * (!createurPlaylist.equals(other.createurPlaylist)) return false;
		 */
		if (descriptionPlaylist == null) {
			if (other.descriptionPlaylist != null)
				return false;
		} else if (!descriptionPlaylist.equals(other.descriptionPlaylist))
			return false;
		if (morceauxPlaylist == null) {
			if (other.morceauxPlaylist != null)
				return false;
		} else if (!morceauxPlaylist.equals(other.morceauxPlaylist))
			return false;
		if (titrePlaylist == null) {
			if (other.titrePlaylist != null)
				return false;
		} else if (!titrePlaylist.equals(other.titrePlaylist))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Playlist [codePlaylist=" + codePlaylist
				+ /*
					 * ", createurPlaylist=" + createurPlaylist +
					 */", morceauxPlaylist=" + morceauxPlaylist + ", titrePlaylist=" + titrePlaylist
				+ ", descriptionPlaylist=" + descriptionPlaylist + "]";
	}

}
