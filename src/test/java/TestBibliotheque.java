import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Model.Bibliotheque;
import Model.DAOJPA;

public class TestBibliotheque {
	Bibliotheque b = new Bibliotheque();
	
	@Before
	public void init() {
		DAOJPA.viderBase();
		DAOJPA.creerGenre();
		b.chargerLaBaseDeDonnéesEnMetier();
	}

	@Test
	public void test() {
		b.afficherLesGenres();
		File[] dirf = new java.io.File("./import").listFiles();
		int compteur = 0;
    	for(File f : dirf) {
    		compteur ++;
    		System.out.println("§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§ "+compteur);
    		b.ajouterUnMorceau(f);
    	}
	}
	
	@After
	public void fin()
	{
		b.sauvegarderLaPartieMetierEnBaseDeDonnées();
	}
}
