package Model;

import java.util.Set;

public interface DAOGenre {
	Genre getAvecCode(int code);
	Genre getAvecLibelle(String libelle);
	Set<Genre> getAvecMorceau(Morceau m);
	void save(Genre Genre);
	Set<Genre> loadAll();
	
}
