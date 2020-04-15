package Model;

import java.util.List;

public interface DAOGenre {
	Genre get(int code);
	Genre get(String libelle);
	void save(Genre Genre);
	List<Genre> loadAll();
	
}
