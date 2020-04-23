package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Genre implements Serializable {

	private static final long serialVersionUID = 5226441970590625226L;
	private int codeGenre;
    private String libelleGenre;
    private Set<Morceau> morceauxGenre = new HashSet<Morceau>();
    
    static private ArrayList<String> genres;

    /*public Genre(String libelleGenre) {
        this.codeGenre = -1;
        if (libelleGenre != null)
            this.libelleGenre = libelleGenre;
    }*/
    
    public Genre(String libelleGenre) {
        this.codeGenre = -1;
        this.libelleGenre = libelleGenre;
    }
    
    public Genre(){
        
    }
    
    public static ArrayList<String> creerListe(){
    	ArrayList<String> l = new ArrayList<String>();
    	DAOJPA.creerGenre();
    	return l;
    }
    

    public static ArrayList<String> getGenres() {
		return genres;
	}

	public static void setGenres(ArrayList<String> genres) {
		Genre.genres = genres;
	}

	public int getCodeGenre() {
        return codeGenre;
    }

    public void setCodeGenre(int codeGenre) {
        this.codeGenre = codeGenre;
    }

    public String getLibelle() {
        return libelleGenre;
    }

    public void setLibelle(String libelle) {
        this.libelleGenre = libelle;
    }


    public Set<Morceau> getMorceauxGenre() {
        return morceauxGenre;
    }

    public void setMorceauxGenre(Set<Morceau> morceauxGenre) {
        this.morceauxGenre = morceauxGenre;
    }
    
    public void ajoutMorceauGenre(Morceau m) {
        morceauxGenre.add(m);
    }
    
    public void retirerMorceauGenre(Morceau m) {
        morceauxGenre.remove(m);
    }
    
    public boolean presenceMorceauGenre(Morceau m) {
        return morceauxGenre.contains(m);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Genre other = (Genre) obj;
        if (codeGenre != other.codeGenre)
            return false;
        if (libelleGenre == null) {
            if (other.libelleGenre != null)
                return false;
        } else if (!libelleGenre.equals(other.libelleGenre))
            return false;
        return true;
    }


}