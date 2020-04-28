package Model;

import java.util.Set;

public interface DAOPlaylist {
	void saveAll(Set<Playlist> listeP);
	void save(Playlist p);
	void merge(Playlist p);
	void delete(Playlist p);
	Set<Playlist> loadAll();
	Playlist get(int code);
}
