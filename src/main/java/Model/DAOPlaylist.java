package Model;

import java.util.Set;

public interface DAOPlaylist {
	void saveAll(Set<Playlist> listeP);
	void save(Playlist pl);
	Set<Playlist> loadAll();
}
