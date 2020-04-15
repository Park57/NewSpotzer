package Model;

import java.util.List;

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
	public Genre get(int code) {
		Genre Genre = DAOJPA.getManager().find(Genre.class, code);
		return Genre;
	}

	@Override
	public Genre get(String libelle) {
		List<Genre> listGenre = DAOJPA.getManager()
				.createQuery("SELECT g FROM Genre g WHERE g.libelle LIKE ?1", Genre.class)
				.setParameter(1, "%" + libelle + "%").getResultList();
		if (listGenre.size() == 0)
			return null;
		else
			return listGenre.get(0);
	}

	@Override
	public void save(Genre Genre) {
		DAOJPA.getManager().persist(Genre);
		DAOJPA.commit(); /* discutable de commiter ici */

	}

	@Override
	public List<Genre> loadAll() {
		return DAOJPA.getManager().createQuery("SELECT g FROM Genre g", Genre.class).getResultList();
	}

}
