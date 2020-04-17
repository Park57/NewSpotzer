package Model;

import java.util.HashSet;
import java.util.Set;

public class DAOUtilisateurJPA extends DAOJPA implements DAOUtilisateur {

	static private DAOUtilisateurJPA instance = null;

	private DAOUtilisateurJPA() {
	}

	@Override
	public Utilisateur getAvecCode(int code) {
		Utilisateur Utilisateur = DAOJPA.getManager().find(Utilisateur.class, code);
		return Utilisateur;
	}

	@Override
	public Set<Utilisateur> getAvecPseudo(String pseudo) {
		Set<Utilisateur> listeUtilisateur = new HashSet<Utilisateur>(DAOJPA.getManager()
				.createQuery("SELECT u FROM Utilisateur u WHERE u.pseudo LIKE ?1", Utilisateur.class)
				.setParameter(1, "%" + pseudo + "%").getResultList());
		return listeUtilisateur;
	}

	@Override
	public Set<Utilisateur> getAvecPrenom(String prenom) {
		Set<Utilisateur> listeUtilisateur = new HashSet<Utilisateur>(DAOJPA.getManager()
				.createQuery("SELECT u FROM Utilisateur u WHERE u.prenom LIKE ?1", Utilisateur.class)
				.setParameter(1, "%" + prenom + "%").getResultList());
		return listeUtilisateur;
	}

	@Override
	public Set<Utilisateur> getAvecNom(String nom) {
		Set<Utilisateur> listeUtilisateur = new HashSet<Utilisateur>(DAOJPA.getManager()
				.createQuery("SELECT u FROM Utilisateur u WHERE u.nom LIKE ?1", Utilisateur.class)
				.setParameter(1, "%" + nom + "%").getResultList());
		return listeUtilisateur;
	}
	
	@Override
	public Utilisateur getAvecPlaylist(Playlist p) {
		// TODO
		return null;
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
