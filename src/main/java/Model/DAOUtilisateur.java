package Model;

import java.util.Set;

public interface DAOUtilisateur {
	void saveAll(Set<Utilisateur> listeUtilisateur);
	void save(Utilisateur utilisateur);
	Set<Utilisateur> loadAll();
}
