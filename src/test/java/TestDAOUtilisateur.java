import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import Model.DAOJPA;
import Model.DAOUtilisateur;
import Model.DAOUtilisateurJPA;
import Model.Utilisateur;

public class TestDAOUtilisateur {
    @Before
    public void init() {
        DAOJPA.viderBase();
    }

    @Test
    public void test() {
    	
    	
        Utilisateur thomas = new Utilisateur("Philipe", "Thomas", "TOMYDU57", "password1234");
        Utilisateur vincent = new Utilisateur("Rorich", "Vincent", "Parking", "password123");
        Utilisateur romain = new Utilisateur("Caruanavirus", "Romain", "Milk", "1234");
       

        DAOUtilisateur dao = DAOUtilisateurJPA.getInstance();
        /** * Pr�-conditions */
        Set<Utilisateur> listeUtilisateurs = dao.loadAll();

       listeUtilisateurs.add(thomas);
       listeUtilisateurs.add(vincent);
       listeUtilisateurs.add(romain);
       
       dao.saveAll(listeUtilisateurs);
    }
    /* Fin de Test */
} /* Fin de TestDAOGenre */