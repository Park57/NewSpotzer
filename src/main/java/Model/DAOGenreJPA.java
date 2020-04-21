package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
	public Genre getAvecCode(int code) {
		Genre Genre = DAOJPA.getManager().find(Genre.class, code);
		return Genre;
	}

	@Override
	public Genre getAvecLibelle(String libelle) {
		List <Genre> listGenre = DAOJPA.getManager()
				.createQuery("SELECT g FROM Genre g WHERE g.libelleGenre = :libelle", Genre.class)
				.setParameter("libelle",libelle).getResultList();
		if (listGenre.size() == 0)
			return null;
		else
			return listGenre.get(0);
	}
	
	@Override
	public Set<Genre> getAvecMorceau(Morceau m) {
		// TODO
		//pas sur de l'importance de cette méthode....
		return null;
	}

	@Override
	public void save(Genre Genre) {
		DAOJPA.getManager().persist(Genre);
		DAOJPA.commit(); /* discutable de commiter ici */

	}

	@Override
	public ArrayList<Genre> loadAll() {
		return new ArrayList<Genre>(DAOJPA.getManager().createQuery("SELECT g FROM Genre g", Genre.class).getResultList());
	}

}
