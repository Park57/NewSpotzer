package Model;

import java.util.Set;

public interface DAOUtilisateur {
	Utilisateur getAvecCode(int code);
	Set<Utilisateur> getAvecPseudo(String pseudo);
	Set<Utilisateur> getAvecNom(String nom);
	Set<Utilisateur> getAvecPrenom(String prenom);
	Utilisateur getAvecPlaylist(Playlist pl);
	void save(Utilisateur utilisateur);
	Set<Utilisateur> loadAll();
}
