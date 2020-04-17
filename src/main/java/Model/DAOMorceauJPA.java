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
	public Morceau getAvecCode(int code) {
		Morceau morceau = DAOJPA.getManager().find(Morceau.class, code);
		return morceau;
	}

	@Override
	public Set<Morceau> getAvecTitre(String titre) {
		Set<Morceau> listMorceau = new HashSet<Morceau>(DAOJPA.getManager()
				.createQuery("SELECT m FROM Morceau m WHERE m.titre LIKE ?1", Morceau.class)
				.setParameter(1, "%" + titre + "%").getResultList());
		return listMorceau;
	}
	
	@Override
	public Set<Morceau> getAvecAlbum(Album album) {
		// TODO
		return null;
	}
	
	@Override
	public Set<Morceau> getAvecNomAlbum(String nA)  {
		// TODO
		return null;
	}

	@Override
	public Set<Morceau> getAvecArtiste(Artiste artiste) {
		// TODO
		return null;
	}
	
	@Override
	public Set<Morceau> getAvecNomArtiste(String nA) {
		// TODO
		return null;
	}

	@Override
	public Set<Morceau> getAvecGenre(Genre genre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Morceau> getAvecAnnee(int a) {
		// TODO
		return null;
	}
	
	@Override
	public Set<Morceau> getAvecPlaylist(Playlist pl) {
		// TODO
		return null;
	}
	
	@Override
	public void save(Morceau morceau) {
		DAOJPA.getManager().persist(morceau);
		DAOJPA.commit(); /* discutable de commiter ici */
	}

	@Override
	public Set<Morceau> loadAll() {
		return new HashSet<Morceau>(DAOJPA.getManager().createQuery("SELECT m FROM Morceau m", Morceau.class).getResultList());
	}

}
