package Model;

public class Artiste {
	private int codeArtiste;
	private String nomArtiste;
	
	
	public Artiste() {
		super();
	}

	public Artiste(String nomArtiste) {
		this.codeArtiste = -1;
		this.nomArtiste = nomArtiste;
	}

	public int getCodeArtiste() {
		return codeArtiste;
	}

	public void setCodeArtiste(int codeArtiste) {
		this.codeArtiste = codeArtiste;
	}

	public String getNomArtiste() {
		return nomArtiste;
	}

	public void setNomArtiste(String nomArtiste) {
		this.nomArtiste = nomArtiste;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codeArtiste;
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
		if (nomArtiste == null) {
			if (other.nomArtiste != null)
				return false;
		} else if (!nomArtiste.equals(other.nomArtiste))
			return false;
		return true;
	}


	
	
	
}
