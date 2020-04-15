import java.io.File;
import java.io.IOException;

import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.junit.Test;

public class TestImportMP3 {

	@Test
	public void test() {
		// Lister les noms des contenus du répertoire courant
		String[] dir = new java.io.File("./import").list();
		File[] dirf = new java.io.File("./import").listFiles();
		for (int i = 0; i < dir.length; i++) {
			// Afficher le nom de chaque élément
			System.out.println("Nom du fichier : "+dir[i]);

			MP3File test = null;
			// recupere le fichier mp3
			try {
				test = new MP3File(dirf[i]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TagException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//TITRE
			System.out.print("Voici le titre : ");
			try {
				System.out.println(test.getID3v1Tag().getTitle());
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				System.out.println("null");
			}
			
			//ARTISTE
			System.out.print("Voici l'artiste : ");
			try {
				System.out.println(test.getID3v1Tag().getArtist());
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				System.out.println("null");
			}
			
			//Album
			System.out.print("Voici l'album : ");
			try {
				System.out.println(test.getID3v1Tag().getAlbum());
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				System.out.println("null");
			}
			
			//Album
			System.out.print("Voici l'annee : ");
			try {
				System.out.println(test.getID3v1Tag().getYear());
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				System.out.println("null");
			}
			
			//Album
			System.out.print("Voici le genre (en byte) : ");
			try {
				System.out.println(test.getID3v1Tag().getGenre());
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				System.out.println("null");
			}

			System.out.println("\n-----------------------------\n");
		}
	}
}
