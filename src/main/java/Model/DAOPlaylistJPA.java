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
	public Playlist getAvecCode(int code) {
		Playlist p = DAOJPA.getManager().find(Playlist.class, code);
		return p;
	}

	@Override
	public Set<Playlist> getAvecUtilisateur(Utilisateur u){
		//TODO
		return null;
	}

	@Override
	public Set<Playlist> getAvecMorceau(Morceau m) {
		//TODO
		return null;
	}

	@Override
	public Set<Playlist> getAvecTitre(String titre) {
		Set<Playlist> lp = new HashSet<Playlist> (DAOJPA.getManager()
		.createQuery("SELECT p FROM Playlist p WHERE p.titrePlaylist LIKE ?1", Playlist.class)
		.setParameter(1, "%" + titre + "%").getResultList());

		return lp;
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
