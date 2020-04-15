package Model;

import java.util.List;

public class DAOAlbumJPA extends DAOJPA implements DAOAlbum {

	static private DAOAlbumJPA instance = null;

	private DAOAlbumJPA() {}

	static public DAOAlbum getInstance() {
		if (instance == null)
			instance = new DAOAlbumJPA();
		return instance;
	}

	@Override
	public Album get(int code) {
		Album Album = DAOJPA.getManager().find(Album.class, code);
		return Album;
	}
	
	@Override
    public List<Album> get(String nomAlbum) {
        List<Album> listAlbum = DAOJPA.getManager()
                .createQuery("SELECT a FROM Album a WHERE a.titreAlbum LIKE ?1", Album.class)
                .setParameter(1, "%" + nomAlbum + "%").getResultList();
        if (listAlbum.size() == 0)
            return null;
        else
            return listAlbum;
    }
	
	public List<Album> getAvecAnnee(int annee){
        List<Album> listAlbum = DAOJPA.getManager()
                .createQuery("SELECT a FROM Album a WHERE a.annee LIKE ?1", Album.class)
                .setParameter(1, annee).getResultList();
        if (listAlbum.size() == 0)
            return null;
        else
            return listAlbum;
    }

	@Override
	public void save(Album Album) {
		DAOJPA.getManager().persist(Album);
		DAOJPA.commit(); /* discutable de commiter ici */
	}

	@Override
	public List<Album> loadAll() {
		return DAOJPA.getManager().createQuery("SELECT a FROM Album a", Album.class).getResultList();
	}

}

