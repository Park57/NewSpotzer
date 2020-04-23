package Model;

import java.util.ArrayList;
import java.util.Set;

public interface DAOGenre {

	void save(Genre Genre);
	Set<Genre> loadAll();
	
}
