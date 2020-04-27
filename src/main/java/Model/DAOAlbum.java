package Model;

import java.util.Set;

public interface DAOAlbum {

	void save(Album Album);
	
	void saveAll(Set<Album> listAlb);

	Set<Album> loadAll();
	
	void deleteAlbum(Album alb);
	
	Album get(int code);


}
