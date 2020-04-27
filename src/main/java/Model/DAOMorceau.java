package Model;

import java.util.Set;

public interface DAOMorceau {
	
	void saveAll(Set<Morceau> listeMorceaux);
	void save(Morceau morceau);
	void delete(Morceau morceau);
	void refresh(Morceau morceau);
	Set<Morceau> loadAll();
	void refAll(Set<Morceau> listeMorceaux);
}
