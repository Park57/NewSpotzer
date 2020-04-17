package Model;

import java.util.Set;

public interface DAOPlaylist {
	Playlist getAvecCode(int code);
	Set<Playlist> getAvecUtilisateur(Utilisateur u);
	Set<Playlist> getAvecMorceau(Morceau m);
	Set<Playlist> getAvecTitre(String titre);
	void save(Playlist pl);
	Set<Playlist> loadAll();
}
