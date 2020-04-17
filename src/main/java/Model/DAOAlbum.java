package Model;

import java.util.Set;

public interface DAOAlbum {

	Album getAvecCode(int code);

	Set<Album> getAvecTitre(String nomAlbum);
	
	Set<Album> getAvecAnnee(int annee);
	
	Album getAvecMorceau(Morceau morceau);
	
	Set<Album> getAvecTitreMorceau(String tM);

	void save(Album Album);

	Set<Album> loadAll();

}
