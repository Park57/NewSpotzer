package Model;

import java.util.Set;

public interface DAOArtiste {
	
	void saveAll(Set<Artiste> listeArt);

	void save(Artiste artiste);

	void merge(Artiste artiste);

	void delete(Artiste artiste);

	Set<Artiste> loadAll();

	Artiste get(int code);
}
