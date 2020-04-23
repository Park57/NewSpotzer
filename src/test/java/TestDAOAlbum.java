import java.util.HashSet;
import java.util.Set;

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
       
        
        Set<Album> listeAlb = new HashSet<Album>();
        listeAlb.add(slipknot);
        listeAlb.add(skillet);
        listeAlb.add(amonamarth);

        DAOAlbum dao = DAOAlbumJPA.getInstance();
        

       dao.saveAll(listeAlb);
    }
    /* Fin de Test */
} /* Fin de TestDAOAlbum */