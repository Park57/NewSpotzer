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
	public Artiste getAvecCode(int code) {
		Artiste Artiste = DAOJPA.getManager().find(Artiste.class, code);
		return Artiste;
	}

	@Override
	public Set<Artiste> getAvecNom(String nom) {
		Set<Artiste> SetArtiste = new HashSet<Artiste>(DAOJPA.getManager()
				.createQuery("SELECT a FROM Artiste a WHERE a.nomArtiste LIKE ?1", Artiste.class)
				.setParameter(1, "%" + nom + "%").getResultList());
		if (SetArtiste.size() == 0)
			return null;
		else
			return SetArtiste;
	}
	
	@Override
	public Artiste getAvecMorceau(Morceau m) {
		// TODO
		//pas sur de l'importance de cette méthode....
		return null;
	}
	
	@Override
	public Set<Artiste> getAvecTitreMorceau(String tM) {
		// TODO
		return null;
	}

	@Override
	public void save(Artiste Artiste) {
		DAOJPA.getManager().persist(Artiste);
		DAOJPA.commit(); /* discutable de commiter ici */

	}

	@Override
	public Set<Artiste> loadAll() {
		return new HashSet<Artiste>(DAOJPA.getManager().createQuery("SELECT a FROM Artiste a", Artiste.class).getResultList());
	}

}
