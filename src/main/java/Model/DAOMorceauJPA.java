package Model;

import java.util.List;

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
	public Morceau get(int code) {
		Morceau morceau = DAOJPA.getManager().find(Morceau.class, code);
		return morceau;
	}

	@Override
	public List<Morceau> getAvecTitre(String titre) {
		List<Morceau> listMorceau = DAOJPA.getManager()
				.createQuery("SELECT m FROM Morceau m WHERE m.titre LIKE ?1", Morceau.class).setParameter(1, "%" + titre + "%").getResultList();
		if (listMorceau.size()==0) 
			return null; 
		else 
			return listMorceau;
	}
	
	@Override
	public void save(Morceau morceau) {
		DAOJPA.getManager().persist(morceau);
		DAOJPA.commit(); /* discutable de commiter ici */

	}

	@Override
	public List<Morceau> loadAll() {
		return DAOJPA.getManager().createQuery("SELECT m FROM Morceau m", Morceau.class).getResultList();
	}

	@Override
	public List<Morceau> getAvecAlbum(Album album) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Morceau> getAvecArtiste(Artiste artiste) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Morceau> getAvecGenre(Genre genre) {
		// TODO Auto-generated method stub
		return null;
	}



}
