package main.java.com.journaldev.jsf.agenda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import main.java.com.journaldev.jsf.agenda.model.Utilisateur;

@ManagedBean(name = "MyClassjsf_test")
@SessionScoped
public class MyClassjsf_test implements Serializable {

	private static final long serialVersionUID = -6913972022251814607L;

	private String s1 = "Contenu de l'attribut!!";
	
	private final Utilisateur[] listUsers = new Utilisateur[]{
			new Utilisateur("Nom1", "Prenom1", "Matricule1"),
			new Utilisateur("Nom2", "Prenom2", "Matricule2"),
			new Utilisateur("Nom3", "Prenom3", "Matricule3"),
			new Utilisateur("Nom4", "Prenom4", "Matricule4"),
			new Utilisateur("Nom5", "Prenom5", "Matricule5")
	};
	
	private String[] listNames = new String[]{
		"Nom1",
		"Nom2",
		"Nom3"
		
	};

	public Utilisateur[] getListUsers() {
		return listUsers;
	}

	public String getS1() {
		System.out.println(s1);
		return s1;
	}

	public void setS1(String s1) {
		this.s1 = s1;
	}
	
	public String methodePourIndex(){
		
		System.out.println("ici je me le code a executer lors de l'appel à cette methode");
		
		return "admin.xhtml";
	}
	
	public List<String> taritementQuiChercheEnBase(){
		System.out.println("L'appel à ce code va chercher en base");
		ArrayList<String> listeDeNoms = new ArrayList<String>();
		listeDeNoms.add("Nom1");
		listeDeNoms.add("Nom2");
		listeDeNoms.add("Nom3");
		listeDeNoms.add("Nom4");
		
		return listeDeNoms;
	}

	public String[] getListNames() {
		return listNames;
	}

	public void setListNames(String[] listNames) {
		this.listNames = listNames;
	}

	public Utilisateur[] getListusers() {
		return listUsers;
	}

}
