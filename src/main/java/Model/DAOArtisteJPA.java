package Model;

import java.util.HashSet;
import java.util.Set;

public class DAOArtisteJPA extends DAOJPA implements DAOArtiste {

	static private DAOArtisteJPA instance = null;

	private DAOArtisteJPA() {
	}

	static public DAOArtiste getInstance() {
		if (instance == null)
			instance = new DAOArtisteJPA();
		return instance;
	}

	@Override
	public void saveAll(Set<Artiste> listeArtiste) {
		for (Artiste a : listeArtiste) {
				if (a.getEtatMetier() != Bibliotheque.INCHANGE) {
					if (a.getEtatMetier() == Bibliotheque.CREE){
						System.out.println("Artiste " +a.getNomArtiste()+" sauvegarde");
						save(a);
						a.setEtatMetier(Bibliotheque.INCHANGE);
					}
					else if (a.getEtatMetier() == Bibliotheque.MODIFIE){
						System.out.println("Artiste " +a.getNomArtiste()+" modifie");
						merge(a);
						a.setEtatMetier(Bibliotheque.INCHANGE);
					}
						
					else if (a.getEtatMetier() == Bibliotheque.SUPPRIMER){
						System.out.println("Artiste " +a.getNomArtiste()+" supprime");
						delete(a);
					}
						
					a.setEtatMetier(Bibliotheque.INCHANGE);
				}
				//save(m);
		}
	}

	@Override
	public void save(Artiste artiste) {
		DAOJPA.getManager().persist(artiste);
	}

	@Override
	public void merge(Artiste artiste) {
		DAOJPA.getManager().merge(artiste);
	}

	@Override
	public void delete(Artiste artiste) {
		Artiste art = get(artiste.getCodeArtiste());
		Artiste a = DAOJPA.getManager().merge(art);
		DAOJPA.getManager().remove(a);
	}

	@Override
	public Set<Artiste> loadAll() {
		return new HashSet<Artiste>(
				DAOJPA.getManager().createQuery("SELECT a FROM Artiste a", Artiste.class).getResultList());
	}

	public Artiste get(int code) {
		Artiste Artiste = DAOJPA.getManager().find(Artiste.class, code);
		return Artiste;
	}
}
