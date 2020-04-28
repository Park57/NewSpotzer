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
			System.out.println("---------------"+a.getTitreAlbum() + " A l'etat : "+a.getEtatMetier());
			if (a.getEtatMetier() != Bibliotheque.INCHANGE) {
				if (a.getEtatMetier() == Bibliotheque.CREE){
					System.out.println("On sauvegarde " +a.getTitreAlbum());
					save(a);
					a.setEtatMetier(Bibliotheque.INCHANGE);
				}
				else if (a.getEtatMetier() == Bibliotheque.MODIFIE){
					System.out.println("On modifie " +a.getTitreAlbum());
					merge(a);
					a.setEtatMetier(Bibliotheque.INCHANGE);
				}
					
				else if (a.getEtatMetier() == Bibliotheque.SUPPRIMER){
					System.out.println("On supprime " +a.getTitreAlbum());
					delete(a);
				}
					
				a.setEtatMetier(Bibliotheque.INCHANGE);
			}
		}
	}

	@Override
	public void save(Album album) {
		DAOJPA.getManager().persist(album);
		//DAOJPA.commit(); /* discutable de commiter ici */
		//DAOJPA.commit(); /* discutable de commiter ici */
	}

	@Override
	public void merge(Album album) {
		DAOJPA.getManager().merge(album);
		//DAOJPA.commit(); /* discutable de commiter ici */
	}

	@Override
	public void delete(Album album) {
		/*for(Morceau m : album.getMorceauxAlbum())
		{
			DAOMorceauJPA.getInstance().delete(m);
		}*/
		Album alb = DAOAlbumJPA.getInstance().get(album.getCodeAlbum());
		Album a = DAOJPA.getManager().merge(alb);
		DAOJPA.getManager().remove(a);
		//DAOJPA.commit(); /* discutable de commiter ici */
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
