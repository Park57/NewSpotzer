import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Model.Album;
import Model.Artiste;
import Model.DAOMorceau;
import Model.DAOMorceauJPA;
import Model.Genre;
import Model.Morceau;

public class TestDAOMorceau {
    @Before
    public void init() {
        //DAOJPA.viderBase();
    }

    @Test
    public void test() {
        Album albLost = new Album("Lost", 2020);
        Artiste artLost = new Artiste("Our Last Night");
        Genre genreLost = new Genre("Rock");

        Morceau lost = new Morceau("Lost", albLost, artLost, genreLost);

        Album albDS = new Album("Oak Island", 2015);
        Artiste artDS = artLost;
        Genre genreDS = genreLost;

        Morceau darkStorms = new Morceau("Dark Storms", albDS, artDS, genreDS);

        DAOMorceau dao = DAOMorceauJPA.getInstance();
        /** * Pr�-conditions */
        List<Morceau> listeMorceaux = dao.loadAll();

        assertEquals(0, listeMorceaux.size());

        assertEquals(-1, lost.getId());
        assertEquals("Lost", lost.getTitre());
        assertEquals(albLost, lost.getAlbum());
        assertEquals(artLost, lost.getArtiste());
        assertEquals(genreLost, lost.getGenre());

        dao.save(lost);
        /* State = managed */
        /** * Quelques post-conditions dans le cas g�n�ral */
        listeMorceaux = dao.loadAll();
        assertEquals(1, listeMorceaux.size());
        assertTrue(lost.getId() != -1);
        Morceau lost2 = dao.get(1); // recherche par code
        assertEquals(lost, lost2);

        List<Morceau> lost3 = dao.getAvecTitre("Lost"); //recherche par titre
        assertEquals(lost, lost3.get(0));

        List<Morceau> lost4 = dao.getAvecAlbum(albLost); //recherche par album
        assertEquals(lost, lost4.get(0));

        List<Morceau> lost5 = dao.getAvecArtiste(artLost); //recherche par artiste
        assertEquals(lost, lost5.get(0));

        List<Morceau> lost6 = dao.getAvecGenre(genreLost); //recherche par genre
        assertEquals(lost, lost6.get(0));
        

        dao.save(darkStorms);
        assertEquals(3, dao.loadAll().size());
        /** * On v�rifie quand m�me que le DAO ne * trouve pas ce qui n'existe pas */
        List<Morceau> bidon = dao.getAvecTitre("Bidon");
        assertNull(bidon);
    }
    /* Fin de Test */
} /* Fin de TestDAOGenre */