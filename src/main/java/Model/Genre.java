package Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Genre implements Serializable {

	private int codeGenre;
	private String libelleGenre;
	private Set<Morceau> morceauxGenre = new HashSet<Morceau>();

	public Genre(String libelleGenre) {
		this.codeGenre = -1;
		if (libelleGenre != null)
			this.libelleGenre = libelleGenre;
	}
	
	public Genre(){
		
	}

	public int getCodeGenre() {
		return codeGenre;
	}

	public void setCodeGenre(int codeGenre) {
		this.codeGenre = codeGenre;
	}

	public String getLibelle() {
		return libelleGenre;
	}

	public void setLibelle(String libelle) {
		this.libelleGenre = libelle;
	}

	public Set<Morceau> getMorceauxGenre() {
		return morceauxGenre;
	}

	public void setMorceauxGenre(Set<Morceau> morceauxGenre) {
		this.morceauxGenre = morceauxGenre;
	}

	public void ajouterMorceauGenre(Morceau m) {
		morceauxGenre.add(m);
	}

	public void retirerMorceauGenre(Morceau m) {
		morceauxGenre.remove(m);
	}

	public boolean presenceMorceauGenre(Morceau m) {
		if (morceauxGenre.contains(m))
			return true;
		return false;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codeGenre;
		result = prime * result + ((libelleGenre == null) ? 0 : libelleGenre.hashCode());
		result = prime * result + ((morceauxGenre == null) ? 0 : morceauxGenre.hashCode());
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
		Genre other = (Genre) obj;
		if (codeGenre != other.codeGenre)
			return false;
		if (libelleGenre == null) {
			if (other.libelleGenre != null)
				return false;
		} else if (!libelleGenre.equals(other.libelleGenre))
			return false;
		if (morceauxGenre == null) {
			if (other.morceauxGenre != null)
				return false;
		} else if (!morceauxGenre.equals(other.morceauxGenre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Genre [codeGenre=" + codeGenre + ", libelle=" + libelleGenre + ", morceauxGenre=" + morceauxGenre + "]";
	}

}
