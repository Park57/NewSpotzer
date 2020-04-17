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
	public Album getAvecCode(int code) {
		Album Album = DAOJPA.getManager().find(Album.class, code);
		return Album;
	}
	
	@Override
    public Set<Album> getAvecTitre(String nomAlbum) {
        Set<Album> listAlbum = new HashSet<Album>(DAOJPA.getManager()
                .createQuery("SELECT a FROM Album a WHERE a.titreAlbum LIKE ?1", Album.class)
                .setParameter(1, "%" + nomAlbum + "%").getResultList());
        if (listAlbum.size() == 0)
            return null;
        else
            return listAlbum;
    }
	
	@Override
	public Set<Album> getAvecAnnee(int annee){
        Set<Album> listAlbum = new HashSet<Album>(DAOJPA.getManager()
                .createQuery("SELECT a FROM Album a WHERE a.anneeAlbum LIKE ?1", Album.class)
                .setParameter(1, annee).getResultList());
        if (listAlbum.size() == 0)
            return null;
        else
            return listAlbum;
    }
	
	@Override
	public Album getAvecMorceau(Morceau m) {
		// TODO
		//pas sur de l'importance de cette méthode....
		return null;
	}
	
	@Override
	public Set<Album> getAvecTitreMorceau(String m) {
		// TODO
		return null;
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

