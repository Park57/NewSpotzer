package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class DAOJPA {
	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;
	private static EntityTransaction tx = null;

	// Pattern singleton
	public static EntityManager getManager() {
		if (em == null) {
			emf = Persistence.createEntityManagerFactory("NewSpotzer");// Indique quelle PersistenceUnit est utilis�e
																			// (�quivalent � quelle base de donn�es)
			em = emf.createEntityManager();
			tx = em.getTransaction();
		}
		if (!tx.isActive()) // On s�arrange pour �tre s�r qu�une transac6on est active dans l�EntityManager,
			// sinon il y aura plein d�exceptions�
		{ 
			tx.begin();
		}
		return em;
	}

	public static void commit() {
		// Pour commiter une transaction. Mais avant, on s�assure que les objets sont
		// bien synchronis�s sinon on peut rencontrer quelques probl�mes
		em.flush();
		em.clear();
		tx.commit();
	}

	public static void rollback() {
		// Pour annuler une transaction
		tx.rollback();
	}

	public static void close() {
		// Pour terminer une session
		em.close();
		em = null;
		emf.close();
		emf = null;
	}
	
	public static ArrayList<String> creerGenre(){
		FileReader f;
		ArrayList<String> a = new ArrayList<String>();
		try {
			
			f = new FileReader("./genres.txt");
			BufferedReader r = new BufferedReader(f);
			String line = r.readLine();
			while(line != null){
				System.out.println(line);
				line.trim();
				a.add(line);
				//Ajout à la base de donnees
				DAOGenreJPA.getInstance().save(new Genre(line));
				line = r.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e){
			
		}
		return a;
		
	}

	public static void viderBase() // Pra6que pour remeVre � 0 la base avant des tests
	{
		getManager().createQuery("DELETE FROM Morceau").executeUpdate();
		getManager().createNativeQuery("ALTER TABLE morceau AUTO_INCREMENT = 1").executeUpdate();
		getManager().createQuery("DELETE FROM Album").executeUpdate();
		getManager().createNativeQuery("ALTER TABLE album AUTO_INCREMENT = 1").executeUpdate();
		getManager().createQuery("DELETE FROM Artiste").executeUpdate();
		getManager().createNativeQuery("ALTER TABLE artiste AUTO_INCREMENT = 1").executeUpdate();
		getManager().createQuery("DELETE FROM Genre").executeUpdate();
		getManager().createNativeQuery("ALTER TABLE genre AUTO_INCREMENT = 1").executeUpdate();
		getManager().createQuery("DELETE FROM Utilisateur").executeUpdate();
		getManager().createNativeQuery("ALTER TABLE utilisateur AUTO_INCREMENT = 1").executeUpdate();
		
	}
	
	
	
}/* Fin de la classe DAOJPA */
