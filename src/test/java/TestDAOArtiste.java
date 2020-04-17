import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import Model.Artiste;
import Model.DAOArtiste;
import Model.DAOArtisteJPA;

import Model.DAOJPA;

public class TestDAOArtiste {
	@Before
	public void init() {
		//DAOJPA.viderBase();
	}

	@Test
	public void test() {
	
		Artiste rihanna = new Artiste("Rihanna");
		Artiste eminem = new Artiste("Eminem");
		Artiste pitbull = new Artiste("Pitbull");

		DAOArtiste dao = DAOArtisteJPA.getInstance();
		/** * Pr�-conditions */
		Set<Artiste> listeArtiste = dao.loadAll();

		assertEquals(0, listeArtiste.size());
		assertEquals(-1, rihanna.getCodeArtiste());

		assertEquals("Rihanna", rihanna.getNomArtiste());

		dao.save(rihanna);
		/* State = managed */
		/** * Quelques post-conditions dans le cas g�n�ral */
		listeArtiste = dao.loadAll();
		assertEquals(1, listeArtiste.size());
		assertTrue(rihanna.getCodeArtiste() != -1);
		Artiste rihanna2 = dao.getAvecCode(1); // recherche par code

		assertEquals(rihanna, rihanna2);
		
		Set<Artiste> listRihanna3 = dao.getAvecNom("Rihanna"); // recherche par nom
		List<Artiste> liste = new ArrayList<Artiste>(listRihanna3);
		assertEquals(rihanna, liste.get(0));
		dao.save(eminem);
		dao.save(pitbull);
		assertEquals(3, dao.loadAll().size());
		/** * On v�rifie quand m�me que le DAO ne * trouve pas ce qui n'existe pas */
		Set<Artiste> bidon = dao.getAvecNom("Bidon");
		assertNull(bidon);
	}
	/* Fin de Test */
} /* Fin de TestDAOGenre */
