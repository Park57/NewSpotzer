import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Model.Bibliotheque;
import Model.DAOJPA;
import Model.Morceau;

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
    		System.out.println("§§§§§§§§§§§§§§§§§§§§§    Ajout numero "+compteur+" dans la partie metier     §§§§§§§§§§§§§§§§§§§§§§§§§§ ");
    		b.ajouterUnMorceau(f);
    	}
	}
	
	@After
	public void fin()
	{
		System.out.println("\n///////////////////////// On ajoute maintenant a la bdd la partie metier ////////////////////////////////\n");
		/*for(Morceau m : b.getListeMorceaux())
		{
			System.out.println(m.getTitreMorceau() +"     " +m.getEtatMetier());
		}*/
		b.sauvegarderLaPartieMetierEnBaseDeDonnées();
		Scanner scan = new Scanner(System.in);
		System.out.println("On va maintenant refresh ");
		//String str = scan.nextLine();
		
		ArrayList<Morceau> arrayl = new ArrayList<Morceau>(b.getListeMorceaux());
		System.out.println("*******************"+arrayl.get(2));
		arrayl.get(2).setAlbumMorceau(arrayl.get(0).getAlbumMorceau());;
		b.sauvegarderLaPartieMetierEnBaseDeDonnées();
		//str = scan.nextLine();
		/*arrayl.get(3).supprimerMorceau();;
		b.sauvegarderLaPartieMetierEnBaseDeDonnées();*/
		
		DAOJPA.commit();
		
	}
}
