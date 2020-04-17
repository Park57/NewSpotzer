package Model;

import java.util.HashSet;
import java.util.Set;

public class Utilisateur {
	
	private int codeUtilisateur;
	private String nomUtilisateur;
	private String prenomUtilisateur;
	private String pseudoUtilisateur;
	private String passwordUtilisateur;
	private Set<Playlist> playlistsUtilisateur = new HashSet<Playlist>();
	
	
	public Utilisateur(int codeUtilisateur, String nomUtilisateur, String prenomUtilisateur, String pseudoUtilisateur,
			String passwordUtilisateur) {
		super();
		this.codeUtilisateur = codeUtilisateur;
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.pseudoUtilisateur = pseudoUtilisateur;
		this.passwordUtilisateur = passwordUtilisateur;
	}
	
	public Utilisateur(){
		
	}

	///////////////////////////
	//// GETTERS & SETTERS ////
	///////////////////////////
	
	public int getCodeUtilisateur() {
		return codeUtilisateur;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public String getPseudoUtilisateur() {
		return pseudoUtilisateur;
	}

	public String getPasswordUtilisateur() {
		return passwordUtilisateur;
	}

	public void setPasswordUtilisateur(String passwordUtilisateur) {
		this.passwordUtilisateur = passwordUtilisateur;
	}

	public Set<Playlist> getPlaylistsUtilisateur() {
		return playlistsUtilisateur;
	}


	public void setPlaylistsUtilisateur(Set<Playlist> playlistsUtilisateur) {
		this.playlistsUtilisateur = playlistsUtilisateur;
	}
	
		
	////////////////////////////////
	/// AJOUTER RETIRER PRESENCE ///
	////////////////////////////////
	
	public void ajoutPlaylistUtilisateur(Playlist p) {
		this.playlistsUtilisateur.add(p);
	}
	
	public boolean presencePlaylistUtilisateur(Playlist p) {
		return this.playlistsUtilisateur.contains(p);
	}
	
	public void retirerPlaylistUtilisateur(Playlist p) {
		this.playlistsUtilisateur.remove(p);
	}

	
	
	
	/////////////////////
	// EQUALS TOSTRING //
	/////////////////////

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		if (codeUtilisateur != other.codeUtilisateur)
			return false;
		if (nomUtilisateur == null) {
			if (other.nomUtilisateur != null)
				return false;
		} else if (!nomUtilisateur.equals(other.nomUtilisateur))
			return false;
		if (passwordUtilisateur == null) {
			if (other.passwordUtilisateur != null)
				return false;
		} else if (!passwordUtilisateur.equals(other.passwordUtilisateur))
			return false;
		if (playlistsUtilisateur == null) {
			if (other.playlistsUtilisateur != null)
				return false;
		} else if (!playlistsUtilisateur.equals(other.playlistsUtilisateur))
			return false;
		if (prenomUtilisateur == null) {
			if (other.prenomUtilisateur != null)
				return false;
		} else if (!prenomUtilisateur.equals(other.prenomUtilisateur))
			return false;
		if (pseudoUtilisateur == null) {
			if (other.pseudoUtilisateur != null)
				return false;
		} else if (!pseudoUtilisateur.equals(other.pseudoUtilisateur))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Utilisateur [codeUtilisateur=" + codeUtilisateur + ", nomUtilisateur=" + nomUtilisateur
				+ ", prenomUtilisateur=" + prenomUtilisateur + ", pseudoUtilisateur=" + pseudoUtilisateur
				+ ", passwordUtilisateur=" + passwordUtilisateur + ", playlistsUtilisateur=" + playlistsUtilisateur
				+ "]";
	}
	
	
}
