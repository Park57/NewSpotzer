import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import Model.DAOJPA;
import Model.DAOUtilisateurJPA;
import Model.Playlist;
import Model.Utilisateur;


public class TestDAOPlaylist {
	 @Before
	    public void init() {
	        DAOJPA.viderBase();
	    }

	    @Test
	    public void test() {
	    	Utilisateur thomas = new Utilisateur("Philipe", "Thomas", "TOMYDU57", "password1234");
	    	Playlist Rock = new Playlist(thomas,"lol","lele");
	    	//DAOPlaylist dao = DAOPlaylistJPA.getInstance();
	    	
	    	Set<Utilisateur> listeUtilisateurs = new HashSet<Utilisateur>();
	        Set<Playlist> listePlaylists = new HashSet<Playlist>();

	       listePlaylists.add(Rock);
	       listeUtilisateurs.add(thomas);
	       thomas.ajoutPlaylistUtilisateur(Rock);
	       DAOUtilisateurJPA.getInstance().saveAll(listeUtilisateurs);
	    }
}
