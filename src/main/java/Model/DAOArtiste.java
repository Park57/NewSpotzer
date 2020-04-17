package Model;

import java.util.Set;

public interface DAOArtiste {
	Artiste getAvecCode(int code);
	Set<Artiste> getAvecNom(String nom);
	Artiste getAvecMorceau(Morceau m);
	Set<Artiste> getAvecTitreMorceau(String tM);
	void save(Artiste artiste);
	Set<Artiste> loadAll();
}
