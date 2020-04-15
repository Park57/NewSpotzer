import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

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
        List<Utilisateur> listeUtilisateurs = dao.loadAll();

        assertEquals(0, listeUtilisateurs.size());

        assertEquals(-1, romain.getCodeUtilisateur());
        assertEquals("Milk", romain.getPseudo());
        assertEquals("Romain", romain.getPrenom());
        assertEquals("Caruanavirus", romain.getNom());
        assertEquals("1234", romain.getMotDePasse());

        dao.save(romain);
        /* State = managed */
        /** * Quelques post-conditions dans le cas g�n�ral */
        listeUtilisateurs = dao.loadAll();
        assertEquals(1, listeUtilisateurs.size());
        assertTrue(romain.getCodeUtilisateur() != -1);
        Utilisateur romain2 = dao.get(1); // recherche par code
        
        assertEquals(romain, romain2);
        
        Utilisateur romain3 = dao.getAvecPseudo("Milk"); // recherche par libell�
        assertEquals(romain, romain3);

        List<Utilisateur> romain4 = dao.getAvecNom("Caruanavirus");
        assertEquals(romain, romain4.get(0));
        
        List<Utilisateur> romain5 = dao.getAvecPrenom("Romain");
        assertEquals(romain, romain5.get(0));
        
        dao.save(thomas);
        dao.save(vincent);
        assertEquals(3, dao.loadAll().size());
        /** * On v�rifie quand m�me que le DAO ne * trouve pas ce qui n'existe pas */
        Utilisateur bidon = dao.getAvecPseudo("Bidon");
        assertNull(bidon);
    }
    /* Fin de Test */
} /* Fin de TestDAOGenre */