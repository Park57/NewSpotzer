import java.io.File;
import java.io.IOException;

import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.junit.Test;

import Model.Morceau;

public class TestImportMP3 {

	@Test
	public void test() {
		// Lister les noms des contenus du répertoire courant
		String[] dir = new java.io.File("./import").list();
		File[] dirf = new java.io.File("./import").listFiles();
		for (int i = 0; i < dir.length; i++) {
			Morceau morcTest = new Morceau(dirf[i]);
		}

	}
}
