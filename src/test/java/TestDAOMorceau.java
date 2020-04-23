import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import Model.DAOJPA;
import Model.DAOMorceau;
import Model.DAOMorceauJPA;
import Model.Genre;
import Model.Morceau;
import Model.Playlist;
import Model.Utilisateur;

public class TestDAOMorceau {
	@Before
	public void init() {
		DAOJPA.viderBase();
		Genre.setGenres(DAOJPA.creerGenre());
		DAOJPA.replacerFichierMp3();
	}

	@Test
    public void test() {
    	DAOMorceau dao = DAOMorceauJPA.getInstance();
    	Set<Morceau> listeMorceaux = new HashSet<Morceau>();
    	Morceau temp;
    	File[] dirf = new java.io.File("./import").listFiles();
    	Utilisateur thom = new Utilisateur("Filipi", "toma", "toto", "1234");
    	Playlist alb = new Playlist(thom,"playlist de toto", "ma playlist");

    	for(File f : dirf) {
    		temp = new Morceau(f);
    		try{
    			if(temp.getCodeMorceau()==-1)
    				listeMorceaux.add(temp);
    			if(temp.getAlbumMorceau().getTitreAlbum() == "lol")
    				alb.ajoutMorceauPlaylist(temp);
    		} catch(Exception e){System.out.println("probleme qu'on doit savoir");}
    	}
    	/*DAOUtilisateur daoU = DAOUtilisateurJPA.getInstance();
    	daoU.save(thom);
    	DAOPlaylist daoA = DAOPlaylistJPA.getInstance();
    	daoA.save(alb);*/
    	
    	dao.saveAll(listeMorceaux);
    }
	/* Fin de Test */
} /* Fin de TestDAOGenre */