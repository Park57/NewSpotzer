import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
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
		DAOJPA.viderBase();
	}

	@Test
	public void test() {
	
		Artiste rihanna = new Artiste("Rihanna");
		Artiste eminem = new Artiste("Eminem");
		Artiste pitbull = new Artiste("Pitbull");

		DAOArtiste dao = DAOArtisteJPA.getInstance();
		/** * Pr�-conditions */
		Set<Artiste> listeArtiste = new HashSet<Artiste>();
		listeArtiste.add(rihanna);
		listeArtiste.add(eminem);
		listeArtiste.add(pitbull);

		dao.saveAll(listeArtiste);
	}
	/* Fin de Test */
} /* Fin de TestDAOGenre */
