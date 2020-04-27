package Model;

import java.util.HashSet;
import java.util.Set;

public class DAOMorceauJPA extends DAOJPA implements DAOMorceau {

	static private DAOMorceauJPA instance = null;

	private DAOMorceauJPA() {
	}

	static public DAOMorceau getInstance() {
		if (instance == null)
			instance = new DAOMorceauJPA();
		return instance;
	}

	@Override
	public void saveAll(Set<Morceau> listeM) {
		for (Morceau m : listeM) {
			System.out.println("---------------"+m.getTitreMorceau() + " A l'etat : "+m.getEtatMetier());
			if (m.getEtatMetier() != Bibliotheque.INCHANGE) {
				if (m.getEtatMetier() == Bibliotheque.CREE)
					save(m);
				else if (m.getEtatMetier() == Bibliotheque.MODIFIE)
					merge(m);
				else if (m.getEtatMetier() == Bibliotheque.SUPPRIMER)
					delete(m);
				m.setEtatMetier(Bibliotheque.INCHANGE);
			}
			//save(m);
		}
	}

	@Override
	public void save(Morceau morceau) {
		try {
			if (morceau.getAlbumMorceau() != null) {
				if (DAOAlbumJPA.getInstance().get(morceau.getAlbumMorceau().getCodeAlbum()) != null) {
					System.out.println("Existe déjà");
				} else
					DAOJPA.getManager().persist(morceau.getAlbumMorceau());
			}
			if (morceau.getArtisteMorceau() != null) {
				if (DAOArtisteJPA.getInstance().get(morceau.getArtisteMorceau().getCodeArtiste()) != null) {
					System.out.println("Existe déjà");
				} else
					DAOJPA.getManager().persist(morceau.getArtisteMorceau());
			}
			DAOJPA.getManager().persist(morceau);
			//DAOJPA.commit(); /* discutable de commiter ici */
		} catch (Exception e) {
			e.printStackTrace();
			/* System.out.println("Morceau null"); */}
	}

	@Override
	public void delete(Morceau morceau) {
		DAOJPA.getManager().remove(morceau);
		
		//DAOJPA.commit();
	}

	@Override
	public void merge(Morceau morceau) {
		DAOJPA.getManager().merge(morceau);
		//DAOJPA.commit(); /* discutable de commiter ici */

	}

	@Override
	public Set<Morceau> loadAll() {
		return new HashSet<Morceau>(
				DAOJPA.getManager().createQuery("SELECT m FROM Morceau m", Morceau.class).getResultList());
	}

}
