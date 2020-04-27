package Model;

import java.util.HashSet;
import java.util.Set;

public class DAOArtisteJPA extends DAOJPA implements DAOArtiste {

	static private DAOArtisteJPA instance = null;

	private DAOArtisteJPA() {
	}

	static public DAOArtiste getInstance() {
		if (instance == null)
			instance = new DAOArtisteJPA();
		return instance;
	}

	@Override
	public void saveAll(Set<Artiste> listeArtiste) {
		for (Artiste art : listeArtiste) {
			save(art);
		}
	}

	@Override
	public void save(Artiste artiste) {
		DAOJPA.getManager().persist(artiste);
		DAOJPA.commit(); /* discutable de commiter ici */

	}

	@Override
	public void merge(Artiste artiste) {
		DAOJPA.getManager().merge(artiste);
		DAOJPA.commit(); /* discutable de commiter ici */

	}

	@Override
	public void delete(Artiste artiste) {
		DAOJPA.getManager().remove(artiste);
		DAOJPA.commit(); /* discutable de commiter ici */

	}

	@Override
	public Set<Artiste> loadAll() {
		return new HashSet<Artiste>(
				DAOJPA.getManager().createQuery("SELECT a FROM Artiste a", Artiste.class).getResultList());
	}

	public Artiste get(int code) {
		Artiste Artiste = DAOJPA.getManager().find(Artiste.class, code);
		return Artiste;
	}
}
