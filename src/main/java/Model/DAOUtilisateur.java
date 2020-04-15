package Model;

import java.util.List;

public interface DAOUtilisateur {
	Utilisateur get(int codeUtilisateur);
	
	Utilisateur getAvecPseudo(String pseudo);
	
	List<Utilisateur> getAvecNom(String nom);
	
	List<Utilisateur> getAvecPrenom(String prenom);
	
	//Utilisateur get(String pseudo);

	// Album get(Morceau morceau); A FAIRE EN CASCADE

	void save(Utilisateur utilisateur);

	List<Utilisateur> loadAll();
}
