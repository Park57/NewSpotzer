package Model;

import java.util.Set;

public interface DAOMorceau {
	
	Morceau getAvecCode(int code);
	Set<Morceau> getAvecTitre(String titre);
	Set<Morceau> getAvecAlbum(Album album);
	Set<Morceau> getAvecNomAlbum(String nA);
	Set<Morceau> getAvecArtiste(Artiste artiste);
	Set<Morceau> getAvecNomArtiste(String nA);
	Set<Morceau> getAvecGenre(Genre genre);
	Set<Morceau> getAvecAnnee(int annee);
	Set<Morceau> getAvecPlaylist(Playlist pl);
	void save(Morceau morceau);
	Set<Morceau> loadAll();
}
