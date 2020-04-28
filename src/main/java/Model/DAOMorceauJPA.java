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
			if (m.getEtatMetier() != Bibliotheque.INCHANGE) {
				if (m.getEtatMetier() == Bibliotheque.CREE) {
					System.out.println("Morceau " + m.getTitreMorceau()+" sauvegarde");
					save(m);
					m.setEtatMetier(Bibliotheque.INCHANGE);
				} else if (m.getEtatMetier() == Bibliotheque.MODIFIE) {
					System.out.println("Morceau "+ m.getTitreMorceau()+" modifie");
					merge(m);
					m.setEtatMetier(Bibliotheque.INCHANGE);
				} else if (m.getEtatMetier() == Bibliotheque.SUPPRIMER) {
					System.out.println("Morceau " + m.getTitreMorceau()+" supprime");
					delete(m);
				}
				m.setEtatMetier(Bibliotheque.INCHANGE);
			}
		}
	}

	@Override
	public void save(Morceau morceau) {
		try {
			DAOJPA.getManager().persist(morceau);
			DAOJPA.commit(); /* discutable de commiter ici */
		} catch (Exception e) {
			e.printStackTrace();
			/* System.out.println("Morceau null"); */}
	}

	@Override
	public void delete(Morceau morceau) {
		if (DAOMorceauJPA.getInstance().get(morceau.getCodeMorceau()) != null) {
			Morceau m = DAOJPA.getManager().merge(morceau);
			DAOJPA.getManager().remove(m);
		}
	}

	@Override
	public void merge(Morceau morceau) {
		DAOJPA.getManager().merge(morceau);
	}

	@Override
	public Set<Morceau> loadAll() {
		return new HashSet<Morceau>(
				DAOJPA.getManager().createQuery("SELECT m FROM Morceau m", Morceau.class).getResultList());
	}

	@Override
	public Morceau get(int codeMorceau) {
		Morceau morceau = DAOJPA.getManager().find(Morceau.class, codeMorceau);
		return morceau;

	}

}
