import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Model.Artiste;
import Model.DAOArtiste;
import Model.DAOArtisteJPA;

import Model.DAOJPA;

public class TestDAOArtiste {
	@Before
	public void init() {
		DAOJPA.viderBase();
	}

	@Test
	public void test() {
	
		Artiste rihanna = new Artiste("Rihanna");
		Artiste eminem = new Artiste("Eminem");
		Artiste pitbull = new Artiste("Pitbull");

		DAOArtiste dao = DAOArtisteJPA.getInstance();
		/** * Pr�-conditions */
		List<Artiste> listeArtiste = dao.loadAll();

		assertEquals(0, listeArtiste.size());
		assertEquals(-1, rihanna.getCodeArtiste());

		assertEquals("Rihanna", rihanna.getNomArtiste());

		dao.save(rihanna);
		/* State = managed */
		/** * Quelques post-conditions dans le cas g�n�ral */
		listeArtiste = dao.loadAll();
		assertEquals(1, listeArtiste.size());
		assertTrue(rihanna.getCodeArtiste() != -1);
		Artiste rihanna2 = dao.get(1); // recherche par code

		assertEquals(rihanna, rihanna2);
		
		List<Artiste> listRihanna3 = dao.get("Rihanna"); // recherche par nom
		assertEquals(rihanna, listRihanna3.get(0));
		dao.save(eminem);
		dao.save(pitbull);
		assertEquals(3, dao.loadAll().size());
		/** * On v�rifie quand m�me que le DAO ne * trouve pas ce qui n'existe pas */
		List<Artiste> bidon = dao.get("Bidon");
		assertNull(bidon);
	}
	/* Fin de Test */
} /* Fin de TestDAOGenre */
