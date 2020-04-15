package Model;

import java.util.List;

public interface DAOArtiste {
	Artiste get(int code);
	List<Artiste> get(String nom);
	void save(Artiste artiste);
	List<Artiste> loadAll();
}
