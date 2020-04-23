import org.junit.Before;
import org.junit.Test;
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