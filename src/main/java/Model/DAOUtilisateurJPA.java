package Model;

import java.util.HashSet;
import java.util.Set;

public class DAOUtilisateurJPA extends DAOJPA implements DAOUtilisateur {

	static private DAOUtilisateurJPA instance = null;

	private DAOUtilisateurJPA() {
	}

	@Override
	public void saveAll(Set<Utilisateur> listeUtili) {
		for(Utilisateur u : listeUtili) {
			save(u);
		}
	}
	
	static public DAOUtilisateur getInstance() {
		if (instance == null)
			instance = new DAOUtilisateurJPA();
		return instance;
	}


	@Override
	public void save(Utilisateur Utilisateur) {
		DAOJPA.getManager().persist(Utilisateur);
		 DAOJPA.commit(); /* discutable de commiter ici */
	}

	@Override
	public Set<Utilisateur> loadAll() {
		return new HashSet<Utilisateur>(DAOJPA.getManager().createQuery("SELECT u FROM Utilisateur u", Utilisateur.class).getResultList());
	}

}
