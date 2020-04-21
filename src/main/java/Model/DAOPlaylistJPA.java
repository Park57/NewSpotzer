package Model;

import java.util.HashSet;
import java.util.Set;

public class DAOPlaylistJPA extends DAOJPA implements DAOPlaylist {

	static private DAOPlaylistJPA instance = null;

	private DAOPlaylistJPA() {

	}

	static public DAOPlaylist getInstance(){
		if (instance == null)
			instance = new DAOPlaylistJPA();
		return instance;
	}

	@Override
	public void saveAll(Set<Playlist> listeP) {
		for(Playlist p : listeP) {
			save(p);
		}
	}

	@Override
	public void save(Playlist pl) {
		DAOJPA.getManager().persist(pl);
		DAOJPA.commit();
	}

	@Override
	public Set<Playlist> loadAll() {
		return new HashSet<Playlist>(DAOJPA.getManager()
		.createQuery("SELECT p FROM Playlist p", Playlist.class).getResultList());
	}
}
