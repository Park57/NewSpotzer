package Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Genre implements Serializable {

	private int codeGenre;
	private String libelleGenre;

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
		return true;
	}


}
