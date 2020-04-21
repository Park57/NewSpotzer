

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
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
		DAOJPA.viderBase();
		Genre.setGenres(DAOJPA.creerGenre());
	}

	@Test
	public void test() {

	}
	/* Fin de Test */
} /* Fin de TestDAOGenre */