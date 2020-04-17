

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import Model.DAOGenre;
import Model.DAOGenreJPA;
import Model.DAOJPA;
import Model.Genre;


public class TestDAOGenre {
	@Before
	public void init() {
		//DAOJPA.viderBase();
	}

	@Test
	public void test() {
		Genre rock = new Genre("Rock");/* State = new */
		Genre jazz = new Genre("Jazz");
		Genre pop = new Genre("Pop");

		DAOGenre dao = DAOGenreJPA.getInstance();
		/** * Pr�-conditions */
		System.out.println("Je suis avant loadAll");
		Set<Genre> listeGenre = dao.loadAll();

		assertEquals(0, listeGenre.size());
		assertEquals(-1, rock.getCodeGenre());

		assertEquals("Rock", rock.getLibelle());

		dao.save(rock);
		/* State = managed */
		/** * Quelques post-conditions dans le cas g�n�ral */
		listeGenre = dao.loadAll();
		assertEquals(1, listeGenre.size());
		assertTrue(rock.getCodeGenre() != -1);
		Genre rock2 = dao.getAvecCode(1); // recherche par code
		
		System.out.println("Libelle de rock : "+rock.getLibelle());
		System.out.println("Code de rock : "+rock.getCodeGenre());
		System.out.println("Libelle de rock2 : "+rock2.getLibelle());
		System.out.println("Code de rock2 : "+rock2.getCodeGenre());
		assertEquals(rock, rock2);
		
		Genre rock3 = dao.getAvecLibelle("Rock"); // recherche par libelle
		assertEquals(rock, rock3);
		dao.save(jazz);
		dao.save(pop);
		assertEquals(3, dao.loadAll().size());
		/** * On verifie quand m�me que le DAO ne * trouve pas ce qui n'existe pas */
		Genre bidon = dao.getAvecLibelle("Bidon");
		assertNull(bidon);
	}
	/* Fin de Test */
} /* Fin de TestDAOGenre */