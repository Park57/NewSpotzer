package Model;

public class Genre {
	
	private int codeGenre;
	private String libelle;
	
	
	public Genre(int codeGenre, String libelle) {
		this.codeGenre = codeGenre;
		this.libelle = libelle;
	}
	
	public Genre() {
	}

	public Genre(String libelle) {
		this.libelle= libelle;
		this.codeGenre=-1;
	}

	public int getCodeGenre() {
		return codeGenre;
	}

	public void setCodeGenre(int codeGenre) {
		this.codeGenre = codeGenre;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codeGenre;
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
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
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}
}
