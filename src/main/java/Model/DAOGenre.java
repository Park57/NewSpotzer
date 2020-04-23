package Model;

import java.util.ArrayList;

public interface DAOGenre {

	void save(Genre Genre);
	ArrayList<Genre> loadAll();
	
}
