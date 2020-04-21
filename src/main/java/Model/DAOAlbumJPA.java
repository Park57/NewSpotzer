package Model;

import java.util.HashSet;
import java.util.Set;

public class DAOAlbumJPA extends DAOJPA implements DAOAlbum {

	static private DAOAlbumJPA instance = null;

	private DAOAlbumJPA() {}

	static public DAOAlbum getInstance() {
		if (instance == null)
			instance = new DAOAlbumJPA();
		return instance;
	}
	
	
	@Override
	public void saveAll(Set<Album> listeAlbum) {
		for(Album alb : listeAlbum) {
			save(alb);
		}
	}

	@Override
	public void save(Album Album) {
		DAOJPA.getManager().persist(Album);
		DAOJPA.commit(); /* discutable de commiter ici */
	}

	@Override
	public Set<Album> loadAll() {
		return new HashSet<Album>(DAOJPA.getManager().createQuery("SELECT a FROM Album a", Album.class).getResultList());
	}

}

