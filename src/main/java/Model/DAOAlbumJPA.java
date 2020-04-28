package Model;

import java.util.HashSet;
import java.util.Set;

public class DAOAlbumJPA extends DAOJPA implements DAOAlbum {

	static private DAOAlbumJPA instance = null;

	private DAOAlbumJPA() {
	}

	static public DAOAlbum getInstance() {
		if (instance == null)
			instance = new DAOAlbumJPA();
		return instance;
	}

	@Override
	public void saveAll(Set<Album> listeAlbum) {
		for (Album a : listeAlbum) {
			if (a.getEtatMetier() != Bibliotheque.INCHANGE) {
				if (a.getEtatMetier() == Bibliotheque.CREE) {
					System.out.println("Album " + a.getTitreAlbum()+" sauvegarde");
					save(a);
					a.setEtatMetier(Bibliotheque.INCHANGE);
				} else if (a.getEtatMetier() == Bibliotheque.MODIFIE) {
					System.out.println("Album " + a.getTitreAlbum()+" modifie");
					merge(a);
					a.setEtatMetier(Bibliotheque.INCHANGE);
				}

				else if (a.getEtatMetier() == Bibliotheque.SUPPRIMER) {
					System.out.println("Album " + a.getTitreAlbum()+" supprime");
					delete(a);
				}

				a.setEtatMetier(Bibliotheque.INCHANGE);
			}
		}
	}

	@Override
	public void save(Album album) {
		DAOJPA.getManager().persist(album);
	}

	@Override
	public void merge(Album album) {
		DAOJPA.getManager().merge(album);
	}

	@Override
	public void delete(Album album) {
		Album alb = DAOAlbumJPA.getInstance().get(album.getCodeAlbum());
		Album a = DAOJPA.getManager().merge(alb);
		DAOJPA.getManager().remove(a);
	}

	@Override
	public void deleteAlbum(Album alb) {
		DAOJPA.getManager().remove(alb);
	}

	@Override
	public Set<Album> loadAll() {
		return new HashSet<Album>(
				DAOJPA.getManager().createQuery("SELECT a FROM Album a", Album.class).getResultList());
	}

	public Album get(int code) {
		Album Album = DAOJPA.getManager().find(Album.class, code);
		return Album;
	}

}
