package Model;

import java.util.List;

public interface DAOMorceau {
	Morceau get(int code);
	
	List<Morceau> getAvecTitre(String titre);
	List<Morceau> getAvecAlbum(Album album);
	List<Morceau> getAvecArtiste(Artiste artiste);
	List<Morceau> getAvecGenre(Genre genre);
	
	void save(Morceau morceau);
	List<Morceau> loadAll();
	
	//get avec artiste qui ressort tous les morceaux de l'artiste
	//get avec album
}
