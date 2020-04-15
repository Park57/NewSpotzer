package Model;

import java.util.List;

public interface DAOAlbum {

	Album get(int code);

	List<Album> get(String nomAlbum);
	
	List<Album> getAvecAnnee(int annee);
	
	//Album get(Morceau morceau); A FAIRE EN CASCADE 

	void save(Album Album);

	List<Album> loadAll();

}
