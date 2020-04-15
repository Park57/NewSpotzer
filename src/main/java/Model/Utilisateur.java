package Model;

public class Utilisateur {
	
	private int codeUtilisateur;
	private String nom;
	private String prenom;
	private String pseudo;
	private String motDePasse;
	
	
	public Utilisateur(String nom, String prenom, String pseudo, String motDePasse){
		// TODO : hasher le motDePasse
		this.codeUtilisateur = -1;
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
	}
	
	
	public Utilisateur() {
		super();
	}


	public int getCodeUtilisateur() {
		return codeUtilisateur;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}


	public String getPseudo() {
		return pseudo;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		if (motDePasse == null) {
			if (other.motDePasse != null)
				return false;
		} else if (!motDePasse.equals(other.motDePasse))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (pseudo == null) {
			if (other.pseudo != null)
				return false;
		} else if (!pseudo.equals(other.pseudo))
			return false;
		return true;
	}
	
	
}
