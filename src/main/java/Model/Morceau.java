package Model;

public class Morceau {
	private int id;
	private String titre;
	private Album album;
	private Artiste artiste;
	private Genre genre;

	public Morceau( String titre, Album album, Artiste artiste, Genre genre) {
		this.id = -1;
		this.titre = titre;
		this.album = album;
		this.artiste = artiste;
		this.genre = genre;
	}

	public Morceau() {
		super();
	}
	
	/*
	 * public static void main(String[] args) { try { FileInputStream
	 * fileInputStream = new FileInputStream("song.mp3"); Player player = new
	 * Player(fileInputStream); System.out.println("Song is playing...");
	 * player.play(); } catch (FileNotFoundException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } catch (JavaLayerException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * }
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Artiste getArtiste() {
		return artiste;
	}

	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((album == null) ? 0 : album.hashCode());
		result = prime * result + ((artiste == null) ? 0 : artiste.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + id;
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
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
		Morceau other = (Morceau) obj;
		if (album == null) {
			if (other.album != null)
				return false;
		} else if (!album.equals(other.album))
			return false;
		if (artiste == null) {
			if (other.artiste != null)
				return false;
		} else if (!artiste.equals(other.artiste))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id != other.id)
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}

	

	
}
