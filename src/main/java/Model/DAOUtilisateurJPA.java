package Model;

import java.util.List;

public class DAOUtilisateurJPA extends DAOJPA implements DAOUtilisateur {

	static private DAOUtilisateurJPA instance = null;

	private DAOUtilisateurJPA() {
	}

	@Override
	public Utilisateur get(int codeUtilisateur) {
		Utilisateur Utilisateur = DAOJPA.getManager().find(Utilisateur.class, codeUtilisateur);
		return Utilisateur;
	}

	@Override
	public Utilisateur getAvecPseudo(String pseudo) {
		List<Utilisateur> listeUtilisateur = DAOJPA.getManager()
				.createQuery("SELECT u FROM Utilisateur u WHERE u.pseudo LIKE ?1", Utilisateur.class)
				.setParameter(1, "%" + pseudo + "%").getResultList();
		if (listeUtilisateur.size() == 0)
			return null;
		else
			return listeUtilisateur.get(0);
	}

	@Override
	public List<Utilisateur> getAvecPrenom(String prenom) {
		List<Utilisateur> listeUtilisateurs = DAOJPA.getManager()
				.createQuery("SELECT u FROM Utilisateur u WHERE u.prenom LIKE ?1", Utilisateur.class)
				.setParameter(1, "%" + prenom + "%").getResultList();
		return listeUtilisateurs;
	}

	@Override
	public List<Utilisateur> getAvecNom(String nom) {
		List<Utilisateur> listeUtilisateurs = DAOJPA.getManager()
				.createQuery("SELECT u FROM Utilisateur u WHERE u.nom LIKE ?1", Utilisateur.class)
				.setParameter(1, "%" + nom + "%").getResultList();
		return listeUtilisateurs;
	}

	static public DAOUtilisateur getInstance() {
		if (instance == null)
			instance = new DAOUtilisateurJPA();
		return instance;
	}

	/*
	 * @Override public Utilisateur get(String pseudo) { Utilisateur Utilisateur =
	 * DAOJPA.getManager().find(Utilisateur.class, pseudo); return Utilisateur; }
	 */

	@Override
	public void save(Utilisateur Utilisateur) {
		DAOJPA.getManager().persist(Utilisateur);
		 DAOJPA.commit(); /* discutable de commiter ici */
	}

	@Override
	public List<Utilisateur> loadAll() {
		return DAOJPA.getManager().createQuery("SELECT u FROM Utilisateur u", Utilisateur.class).getResultList();
	}

}
