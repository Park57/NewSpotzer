package Model;

import java.util.HashSet;
import java.util.Set;

public class DAOPlaylistJPA extends DAOJPA implements DAOPlaylist {

	static private DAOPlaylistJPA instance = null;

	private DAOPlaylistJPA() {

	}

	static public DAOPlaylist getInstance() {
		if (instance == null)
			instance = new DAOPlaylistJPA();
		return instance;
	}

	@Override
	public void saveAll(Set<Playlist> listeP) {
		for (Playlist p : listeP) {

			if (p.getEtatMetier() != Bibliotheque.INCHANGE) {
				if (p.getEtatMetier() == Bibliotheque.CREE) {
					System.out.println("Morceau " + p.getTitrePlaylist() + " sauvegarde");
					save(p);
					p.setEtatMetier(Bibliotheque.INCHANGE);
				} else if (p.getEtatMetier() == Bibliotheque.MODIFIE) {
					System.out.println("Morceau " + p.getTitrePlaylist()  + " modifie");
					merge(p);
					p.setEtatMetier(Bibliotheque.INCHANGE);
				} else if (p.getEtatMetier() == Bibliotheque.SUPPRIMER) {
					System.out.println("Morceau " + p.getTitrePlaylist()  + " supprime");
					delete(p);
				}
				p.setEtatMetier(Bibliotheque.INCHANGE);

			}
		}
	}

	@Override
	public void save(Playlist pl) {
		DAOJPA.getManager().persist(pl);
		DAOJPA.commit();
	}

	@Override
	public void merge(Playlist playlist) {
		DAOJPA.getManager().merge(playlist);

	}

	@Override
	public void delete(Playlist playlist) {
		Playlist play = get(playlist.getCodePlaylist());
		Playlist p = DAOJPA.getManager().merge(play);
		DAOJPA.getManager().remove(p);

	}

	@Override
	public Set<Playlist> loadAll() {
		return new HashSet<Playlist>(
				DAOJPA.getManager().createQuery("SELECT p FROM Playlist p", Playlist.class).getResultList());
	}

	public Playlist get(int code) {
		Playlist playlist = DAOJPA.getManager().find(Playlist.class, code);
		return playlist;
	}
}
