package Model;

import java.util.List;

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
	public Artiste get(int code) {
		Artiste Artiste = DAOJPA.getManager().find(Artiste.class, code);
		return Artiste;
	}

	@Override
	public List<Artiste> get(String nom) {
		List<Artiste> listArtiste = DAOJPA.getManager()
				.createQuery("SELECT a FROM Artiste a WHERE a.nomArtiste LIKE ?1", Artiste.class)
				.setParameter(1, "%" + nom + "%").getResultList();
		if (listArtiste.size() == 0)
			return null;
		else
			return listArtiste;
	}

	@Override
	public void save(Artiste Artiste) {
		DAOJPA.getManager().persist(Artiste);
		DAOJPA.commit(); /* discutable de commiter ici */

	}

	@Override
	public List<Artiste> loadAll() {
		return DAOJPA.getManager().createQuery("SELECT a FROM Artiste a", Artiste.class).getResultList();
	}

}
