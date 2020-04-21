package Model;

import java.util.Set;

public interface DAOMorceau {
	
	void saveAll(Set<Morceau> listeMorceaux);
	void save(Morceau morceau);
	Set<Morceau> loadAll();
}
