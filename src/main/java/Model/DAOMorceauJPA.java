package Model;

import java.util.HashSet;
import java.util.Set;

public class DAOMorceauJPA extends DAOJPA implements DAOMorceau {

	static private DAOMorceauJPA instance = null;

	private DAOMorceauJPA() {
	}

	static public DAOMorceau getInstance() {
		if (instance == null)
			instance = new DAOMorceauJPA();
		return instance;
	}

	@Override
	public void saveAll(Set<Morceau> listeM) {
		System.out.println("            APPEL DE SAVEALL  \n");
		for (Morceau m : listeM) {
			System.out.println("---------------"+m.getTitreMorceau() + " A l'etat : "+m.getEtatMetier());
			if (m.getEtatMetier() != Bibliotheque.INCHANGE) {
				if (m.getEtatMetier() == Bibliotheque.CREE){
					System.out.println("On sauvegarde " +m.getTitreMorceau());
					save(m);
					m.setEtatMetier(Bibliotheque.INCHANGE);
				}
				else if (m.getEtatMetier() == Bibliotheque.MODIFIE){
					System.out.println("On modifie " +m.getTitreMorceau());
					merge(m);
					m.setEtatMetier(Bibliotheque.INCHANGE);
				}
					
				else if (m.getEtatMetier() == Bibliotheque.SUPPRIMER){
					System.out.println("On supprime " +m.getTitreMorceau());
					delete(m);
				}
					
				m.setEtatMetier(Bibliotheque.INCHANGE);
			}
			//save(m);
		}
		//DAOJPA.commit();
	}

	@Override
	public void save(Morceau morceau) {
		try {
			/*if (morceau.getAlbumMorceau() != null) {
				if (DAOAlbumJPA.getInstance().get(morceau.getAlbumMorceau().getCodeAlbum()) != null) {
					System.out.println("Existe déjà");
				} else
					DAOJPA.getManager().persist(morceau.getAlbumMorceau());
			}
			if (morceau.getArtisteMorceau() != null) {
				if (DAOArtisteJPA.getInstance().get(morceau.getArtisteMorceau().getCodeArtiste()) != null) {
					System.out.println("Existe déjà");
				} else
					DAOJPA.getManager().persist(morceau.getArtisteMorceau());
			}*/
			DAOJPA.getManager().persist(morceau);
			DAOJPA.commit(); /* discutable de commiter ici */
		} catch (Exception e) {
			e.printStackTrace();
			/* System.out.println("Morceau null"); */}
	}

	@Override
	public void delete(Morceau morceau) {
		if(DAOMorceauJPA.getInstance().get(morceau.getCodeMorceau())!=null)
		{
			Morceau m =DAOJPA.getManager().merge(morceau);
			DAOJPA.getManager().remove(m);
		}		
		//DAOJPA.commit();
	}

	@Override
	public void merge(Morceau morceau) {
		DAOJPA.getManager().merge(morceau);
		//DAOJPA.getManager().refresh(m);
		//DAOJPA.commit(); /* discutable de commiter ici */

	}

	@Override
	public Set<Morceau> loadAll() {
		return new HashSet<Morceau>(
				DAOJPA.getManager().createQuery("SELECT m FROM Morceau m", Morceau.class).getResultList());
	}

	@Override
	public Morceau get(int codeMorceau) {
		Morceau morceau = DAOJPA.getManager().find(Morceau.class, codeMorceau);
		return morceau;
		
	}

}
