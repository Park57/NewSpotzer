package Model;

import java.util.HashSet;
import java.util.Set;

public class DAOMorceauJPA extends DAOJPA implements DAOMorceau {

	static private DAOMorceauJPA instance = null;

	private DAOMorceauJPA() {
	}

	static public DAOMorceau getInstance() {
		if (instance == null)
			instance = new DAOMorceauJPA();
		return instance;
	}

	@Override
	public void saveAll(Set<Morceau> listeM) {
		for(Morceau m : listeM) {
			System.out.println("-----------------------------------------------------------------------------------\n"+ m.toString()+"\n");
			save(m);
		}
	}
	
	@Override
	public void save(Morceau morceau) {
		try{
		DAOJPA.getManager().persist(morceau);
		DAOJPA.commit(); /* discutable de commiter ici */
		} catch(Exception e){System.out.println("Morceau null");}
	}

	@Override
	public Set<Morceau> loadAll() {
		return new HashSet<Morceau>(DAOJPA.getManager().createQuery("SELECT m FROM Morceau m", Morceau.class).getResultList());
	}

}
