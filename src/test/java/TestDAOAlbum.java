import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Model.Album;
import Model.DAOAlbum;
import Model.DAOAlbumJPA;
import Model.DAOJPA;

public class TestDAOAlbum {
    @Before
    public void init() {
        DAOJPA.viderBase();
    }

    @Test
    public void test() {
        Album slipknot = new Album("We are not",1687);/* State = new */
        Album skillet = new Album("Victorious",1745);
        Album amonamarth = new Album("Berserker",2038);

        DAOAlbum dao = DAOAlbumJPA.getInstance();
        /** * Pr�-conditions */
        List<Album> listeAlbum = dao.loadAll();

        assertEquals(0, listeAlbum.size());
        assertEquals(-1, slipknot.getCodeAlbum());

        assertEquals("We are not", slipknot.getTitreAlbum());

        dao.save(slipknot);
        /* State = managed */
        /** * Quelques post-conditions dans le cas g�n�ral */
        listeAlbum = dao.loadAll();
        assertEquals(1, listeAlbum.size());
        assertTrue(slipknot.getCodeAlbum() != -1);
        Album slipknot2 = dao.get(1); // recherche par code
        
        assertEquals(slipknot, slipknot2);
        
        List<Album> slipknot3 = dao.get("We are not"); // recherche par libell�
        assertEquals(slipknot, slipknot3.get(0));
        
        List<Album> slipknot4 = dao.getAvecAnnee(1687); // recherche par libell�
        assertEquals(slipknot, slipknot4.get(0));
        
        dao.save(skillet);
        dao.save(amonamarth);
        assertEquals(3, dao.loadAll().size());
        /** * On v�rifie quand m�me que le DAO ne * trouve pas ce qui n'existe pas */
        List<Album> bidon = dao.get("Bidon");
        assertNull(bidon);
    }
    /* Fin de Test */
} /* Fin de TestDAOGenre */