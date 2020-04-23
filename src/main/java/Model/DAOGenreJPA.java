package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DAOGenreJPA extends DAOJPA implements DAOGenre {

	static private DAOGenreJPA instance = null;

	private DAOGenreJPA() {
		}

	static public DAOGenre getInstance() {
		if (instance == null)
			instance = new DAOGenreJPA();
		return instance;
	}


	@Override
	public void save(Genre Genre) {
		DAOJPA.getManager().persist(Genre);
		DAOJPA.commit(); /* discutable de commiter ici */

	}

	@Override
	public Set<Genre> loadAll() {
		return new HashSet<Genre>(DAOJPA.getManager().createQuery("SELECT g FROM Genre g", Genre.class).getResultList());
	}

}
