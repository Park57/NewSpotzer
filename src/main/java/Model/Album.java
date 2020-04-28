package Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Transient;

public class Album implements Serializable {
	private static final long serialVersionUID = 4926307291255631743L;
	private int codeAlbum;
	private String titreAlbum;
	private Set<Morceau> morceauxAlbum = new HashSet<Morceau>();
	private int anneeAlbum;
	@Transient
	private int etatMetier;


	public Album(String titreAlbum, int anneeAlbum) {
		this.codeAlbum = -1;
		if (titreAlbum != null)
			this.titreAlbum = titreAlbum;
		if (anneeAlbum != -1)
			this.anneeAlbum = anneeAlbum;
		etatMetier = Bibliotheque.CREE;
	}

	public Album() {
		this.codeAlbum=-1;
		etatMetier = Bibliotheque.CREE;
	}

	public int getCodeAlbum() {
		return codeAlbum;
	}

	public void setCodeAlbum(int codeAlbum) {
		this.codeAlbum = codeAlbum;
	}

	public String getTitreAlbum() {
		return titreAlbum;
	}

	public void setTitreAlbum(String titreAlbum) {
		this.titreAlbum = titreAlbum;
	}

	public Set<Morceau> getMorceauxAlbum() {
		return morceauxAlbum;
	}

	public void setMorceauxAlbum(Set<Morceau> morceauxAlbum) {
		this.morceauxAlbum = morceauxAlbum;
	}

	public int getAnneeAlbum() {
		return anneeAlbum;
	}

	public void setAnneeAlbum(int anneeAlbum) {
		this.anneeAlbum = anneeAlbum;
	}
	
	public int getEtatMetier() {
		return etatMetier;
	}

	public void setEtatMetier(int etatMetier) {
		this.etatMetier = etatMetier;
	}

	public void ajoutMorceauAlbum(Morceau m){
		morceauxAlbum.add(m);
	}
	
	public void retirerMorceauAlbum(Morceau m){
		morceauxAlbum.remove(m);
	}
	
	public boolean presenceMorceauAlbum(Morceau m){
		if(morceauxAlbum.contains(m))
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anneeAlbum;
		result = prime * result + codeAlbum;
		result = prime * result + ((morceauxAlbum == null) ? 0 : morceauxAlbum.hashCode());
		result = prime * result + ((titreAlbum == null) ? 0 : titreAlbum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		if (anneeAlbum != other.anneeAlbum)
			return false;
		if (codeAlbum != other.codeAlbum)
			return false;
		if (morceauxAlbum == null) {
			if (other.morceauxAlbum != null)
				return false;
		} else if (!morceauxAlbum.equals(other.morceauxAlbum))
			return false;
		if (titreAlbum == null) {
			if (other.titreAlbum != null)
				return false;
		} else if (!titreAlbum.equals(other.titreAlbum))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Album [codeAlbum=" + codeAlbum + ", titreAlbum=" + titreAlbum + ", morceauxAlbum=" + morceauxAlbum
				+ ", anneeAlbum=" + anneeAlbum + "]";
	}
	
	
	
	

}
