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
import Model.DAOMorceauJPA;
import Model.DAOPlaylistJPA;
import Model.Morceau;
import Model.Playlist;

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
		System.out.println("\n///////////////////////// PARTIE METIER ////////////////////////////////\n");
		File[] dirf = new java.io.File("./import").listFiles();
		for (File f : dirf) {
			b.ajouterUnMorceau(f);
		}
	}

	@After
	public void fin() {
		System.out.println("\n///////////////////////// PARTIE BDD ////////////////////////////////\n");
		for (Morceau m : b.getListeMorceaux()) {
			System.out.println("Le morceau " + m.getTitreMorceau() + " est donc a l'état " + m.getEtatMetier());
		}
		b.sauvegarderLaPartieMetierEnBaseDeDonnées();
		ArrayList<Morceau> lm = new ArrayList<Morceau>(b.getListeMorceaux());
		Scanner scan = new Scanner(System.in);
		System.out.println("\n///////////////////////// On modifie le titre de " + lm.get(1).getTitreMorceau()
				+ " ////////////////////////////////\n");
		lm.get(1).setTitreMorceau("Nouveau titre");
		String str;
		// String str = scan.nextLine();
		b.sauvegarderLaPartieMetierEnBaseDeDonnées();
		DAOJPA.commit();
		System.out.println("\n///////////////////////// On modifie l'album de " + lm.get(2).getTitreMorceau()
				+ " qui devient l'album de " + lm.get(0).getTitreMorceau() + " ////////////////////////////////\n");
		lm.get(2).setAlbumMorceau(lm.get(0).getAlbumMorceau());
		;
		// str = scan.nextLine();
		b.sauvegarderLaPartieMetierEnBaseDeDonnées();
		DAOJPA.commit();
		System.out.println("\n///////////////////////// On modifie l'artistede " + lm.get(4).getTitreMorceau()
				+ " qui devient l'artiste de " + lm.get(2).getTitreMorceau() + " ////////////////////////////////\n");
		lm.get(4).setArtisteMorceau(lm.get(2).getArtisteMorceau());
		;
		// str = scan.nextLine();
		b.sauvegarderLaPartieMetierEnBaseDeDonnées();
		DAOJPA.commit();
		System.out.println("\n///////////////////////// On supprime le morceau " + lm.get(3).getTitreMorceau()
				+ " ////////////////////////////////\n");
		lm.get(3).supprimerMorceau();
		// str = scan.nextLine();
		b.sauvegarderLaPartieMetierEnBaseDeDonnées();
		DAOJPA.commit();
		System.out.println("\n///////////////////////// Ajout de la playlist  ////////////////////////////////\n");
		Playlist playlistTest = new Playlist("Ma playlist", "c'est un test");
		b.getListPlaylists().add(playlistTest);
		str = scan.nextLine();
		b.sauvegarderLaPartieMetierEnBaseDeDonnées();
		// DAOJPA.commit();
		System.out.println(
				"\n///////////////////////// Ajout de plusieurs morceaux a la playlist  ////////////////////////////////\n");

		b.ajouterMorceauPlaylist(lm.get(0));
		b.ajouterMorceauPlaylist(lm.get(1));
		b.ajouterMorceauPlaylist(lm.get(2));
		for (Playlist p : b.getListPlaylists()) {
			for (Morceau m : p.getMorceauxPlaylist()) {
				DAOMorceauJPA.getInstance().merge(m);
			}
		}
		str = scan.nextLine();

		b.sauvegarderLaPartieMetierEnBaseDeDonnées();
		DAOJPA.commit();

		;
		System.out.println(
				"\n///////////////////////// Supression de plusieurs morceaux a la playlist  ////////////////////////////////\n");
		str = scan.nextLine();
		b.retirerMorceauPlaylist(lm.get(0));
		DAOMorceauJPA.getInstance().merge(lm.get(0));
		b.sauvegarderLaPartieMetierEnBaseDeDonnées();
		DAOJPA.commit();
	}
}
