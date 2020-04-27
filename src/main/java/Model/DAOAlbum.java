package Model;

import java.util.Set;

public interface DAOAlbum {

	void save(Album album);
	
	void merge(Album album);
	
	void delete(Album album);
	
	void saveAll(Set<Album> listAlb);

	Set<Album> loadAll();
	
	void deleteAlbum(Album alb);
	
	Album get(int code);


}
