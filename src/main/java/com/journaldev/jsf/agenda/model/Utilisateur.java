package main.java.com.journaldev.jsf.agenda.model;

public class Utilisateur {
	private String nom;
	private String prenom;
	private String matricule;
	public Utilisateur(String nom, String prenom, String matricule) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

}
