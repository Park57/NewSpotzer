package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Genre implements Serializable {

    private int codeGenre;
    private String libelleGenre;
    private Set<Morceau> morceauxGenre = new HashSet<Morceau>();
    
    static private ArrayList<String> genres = Genre.creerListe();

    /*public Genre(String libelleGenre) {
        this.codeGenre = -1;
        if (libelleGenre != null)
            this.libelleGenre = libelleGenre;
    }*/
    
    public Genre(String libelleGenre) {
        this.codeGenre = -1;
        System.out.println(libelleGenre);
        String s = libelleGenre.substring(1, libelleGenre.length()-1);
        System.out.println(s);
        Byte b = Byte.parseByte(s);
        this.libelleGenre = genres.get(Byte.toUnsignedInt(b));
    }
    
    public Genre(){
        
    }
    
    public static ArrayList<String> creerListe(){
    	ArrayList<String> l = new ArrayList<String>();
    	l.add("Blues");
    	l.add("ClassicRock");
    	l.add("Country");
    	l.add("Dance");
    	l.add("Disco");
    	l.add("Funk");
    	l.add("Grunge");
    	l.add("Hip-Hop");
    	l.add("Jazz");
    	l.add("Metal");
    	l.add("NewAge");
    	l.add("Oldies");
    	l.add("Other");
    	l.add("Pop");
    	l.add("R&B");
    	l.add("Rap");
    	l.add("Reggae");
    	l.add("Rock");
    	l.add("Techno");
    	l.add("Industrial");
    	l.add("Alternative");
    	l.add("Ska");
    	l.add("DeathMetal");
    	l.add("Pranks");
    	l.add("Soundtrack");
    	l.add("Euro-Techno");
    	l.add("Ambient");
    	l.add("Trip-Hop");
    	l.add("Vocal");
    	l.add("Jazz+Funk");
    	l.add("Fusion");
    	l.add("Trance");
    	l.add("Classical");
    	l.add("Instrumental");
    	l.add("Acid");
    	l.add("House");
    	l.add("Game");
    	l.add("SoundClip");
    	l.add("Gospel");
    	l.add("Noise");
    	l.add("Alt.Rock");
    	l.add("Bass");
    	l.add("Soul");
    	l.add("Punk");
    	l.add("Space");
    	l.add("Meditative");
    	l.add("InstrumentalPop");
    	l.add("InstrumentalRock");
    	l.add("Ethnic");
    	l.add("Gothic");
    	l.add("Darkwave");
    	l.add("Techno-Industrial");
    	l.add("Electronic");
    	l.add("Pop-Folk");
    	l.add("Eurodance");
    	l.add("Dream");
    	l.add("SouthernRock");
    	l.add("Comedy");
    	l.add("Cult");
    	l.add("GangstaRap");
    	l.add("Top");
    	l.add("ChristianRap");
    	l.add("Pop/Funk");
    	l.add("Jungle");
    	l.add("NativeAmerican");
    	l.add("Cabaret");
    	l.add("NewWave");
    	l.add("Psychedelic");
    	l.add("Rave");
    	l.add("Showtunes");
    	l.add("Trailer");
    	l.add("Lo-Fi");
    	l.add("Tribal");
    	l.add("AcidPunk");
    	l.add("AcidJazz");
    	l.add("Polka");
    	l.add("Retro");
    	l.add("Musical");
    	l.add("Rock&Roll");
    	l.add("HardRock");
    	l.add("Folk");
    	l.add("Folk/Rock");
    	l.add("NationalFolk");
    	l.add("Swing");
    	l.add("Fast-Fusion");
    	l.add("Bebob");
    	l.add("Latin");
    	l.add("Revival");
    	l.add("Celtic");
    	l.add("Bluegrass");
    	l.add("Avantgarde");
    	l.add("GothicRock");
    	l.add("ProgressiveRock");
    	l.add("PsychedelicRock");
    	l.add("SymphonicRock");
    	l.add("SlowRock");
    	l.add("BigBand");
    	l.add("Chorus");
    	l.add("EasyListening");
    	l.add("Acoustic");
    	l.add("Humour");
    	l.add("Speech");
    	l.add("Chanson");
    	l.add("Opera");
    	l.add("ChamberMusic");
    	l.add("Sonata");
    	l.add("Symphony");
    	l.add("BootyBass");
    	l.add("Primus");
    	l.add("PornGroove");
    	l.add("Satire");
    	l.add("SlowJam");
    	l.add("Club");
    	l.add("Tango");
    	l.add("Samba");
    	l.add("Folklore");
    	l.add("Ballad");
    	l.add("PowerBallad");
    	l.add("RhythmicSoul");
    	l.add("Freestyle");
    	l.add("Duet");
    	l.add("PunkRock");
    	l.add("DrumSolo");
    	l.add("ACappella");
    	l.add("Euro-House");
    	l.add("DanceHall");
    	l.add("Goa");
    	l.add("Drum&Bass");
    	l.add("Club-House");
    	l.add("Hardcore");
    	l.add("Terror");
    	l.add("Indie");
    	l.add("BritPop");
    	l.add("Negerpunk");
    	l.add("PolskPunk");
    	l.add("Beat");
    	l.add("ChristianGangstaRap");
    	l.add("HeavyMetal");
    	l.add("BlackMetal");
    	l.add("Crossover");
    	l.add("ContemporaryChristian");
    	l.add("ChristianRock");
    	l.add("Merengue");
    	l.add("Salsa");
    	l.add("ThrashMetal");
    	l.add("Anime");
    	l.add("JPop");
    	l.add("Synthpop");
    	return l;
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