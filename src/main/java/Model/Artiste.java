package Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Artiste implements Serializable {

	private static final long serialVersionUID = -3376961211561668963L;
	private int codeArtiste;
	private String nomArtiste;
	private Set<Morceau> morceauxArtiste = new HashSet<Morceau>();
	//private int etatMetier;

	public Artiste(String nomArtiste) {
		this.codeArtiste = -1;
		this.nomArtiste = nomArtiste;
		//etatMetier = Bibliotheque.CREE;
	}
	
	public Artiste(){
		this.codeArtiste=-1;
		//etatMetier = Bibliotheque.CREE;
	}

	public int getCodeArtiste() {
		return codeArtiste;
	}

	public void setCodeArtiste(int codeArtiste) {
		this.codeArtiste = codeArtiste;
	}

	/*public int getEtatMetier() {
		return etatMetier;
	}*/

	public void setEtatMetier(int etatMetier) {
		//this.etatMetier = etatMetier;
	}

	public String getNomArtiste() {
		return nomArtiste;
	}

	public void setNomArtiste(String nomArtiste) {
		this.nomArtiste = nomArtiste;
	}

	public Set<Morceau> getMorceauxArtiste() {
		return morceauxArtiste;
	}

	public void setMorceauxArtiste(Set<Morceau> morceauxArtiste) {
		this.morceauxArtiste = morceauxArtiste;
	}

	public void ajoutMorceauArtiste(Morceau m) {
		morceauxArtiste.add(m);
	}

	public void retirerMorceauArtiste(Morceau m) {
		morceauxArtiste.remove(m);
	}

	public boolean presenceMorceauArtiste(Morceau m) {
		if (morceauxArtiste.contains(m))
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codeArtiste;
		result = prime * result + ((morceauxArtiste == null) ? 0 : morceauxArtiste.hashCode());
		result = prime * result + ((nomArtiste == null) ? 0 : nomArtiste.hashCode());
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
		Artiste other = (Artiste) obj;
		if (codeArtiste != other.codeArtiste)
			return false;
		if (morceauxArtiste == null) {
			if (other.morceauxArtiste != null)
				return false;
		} else if (!morceauxArtiste.equals(other.morceauxArtiste))
			return false;
		if (nomArtiste == null) {
			if (other.nomArtiste != null)
				return false;
		} else if (!nomArtiste.equals(other.nomArtiste))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Artiste [codeArtiste=" + codeArtiste + ", nomArtiste=" + nomArtiste + ", morceauxArtiste="
				+ morceauxArtiste + "]";
	}
	
	
}
