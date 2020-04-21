import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Model.Album;
import Model.Artiste;
import Model.DAOArtiste;
import Model.DAOArtisteJPA;
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
    	File[] dirf = new java.io.File("./import").listFiles();
    	Morceau m1 = new Morceau(dirf[0]);
    	
    	DAOMorceau dao = DAOMorceauJPA.getInstance();
    	
    	dao.save(m1);
    }
    /* Fin de Test */
} /* Fin de TestDAOGenre */