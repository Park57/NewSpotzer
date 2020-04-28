package Model;

import java.util.Set;

public interface DAOMorceau {
	
	void saveAll(Set<Morceau> listeMorceaux);
	void save(Morceau morceau);
	void delete(Morceau morceau);
	void merge(Morceau morceau);
	Set<Morceau> loadAll();
	Morceau get(int codeMorceau);
}
