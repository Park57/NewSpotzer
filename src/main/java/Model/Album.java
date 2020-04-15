package Model;

public class Album {

	private int codeAlbum;
	private String titreAlbum;
	private int annee;

	public Album(String titreAlbum, int annee) {
		this.codeAlbum = -1;
		this.titreAlbum = titreAlbum;
		this.annee = annee;
	}

	
	public Album() {
		super();
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

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + annee;
		result = prime * result + codeAlbum;
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
		if (annee != other.annee)
			return false;
		if (codeAlbum != other.codeAlbum)
			return false;
		if (titreAlbum == null) {
			if (other.titreAlbum != null)
				return false;
		} else if (!titreAlbum.equals(other.titreAlbum))
			return false;
		return true;
	}
	
	
}
