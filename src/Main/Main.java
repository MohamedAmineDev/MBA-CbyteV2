package Main;

import Enumeration.Support;
import Enumeration.Type;
import Implementation.MenuAdministrateur;
import Implementation.MenuElecteur;
import Modele.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Administrateur administrateur = new Administrateur();
        //Scanner scanner = new Scanner(System.in);
        /*MenuAdministrateur menuAdministrateur = new MenuAdministrateur();
        menuAdministrateur.application();*/
       /* Electeur e=new Electeur();
        e.setUserName("mmmmmmmmm");
        e.setPassword("ppppppppppppppppppp");
        Reclamation reclamation=new Reclamation();
        reclamation.setAuteur(e);
        try{
            Candidat c= (Candidat) reclamation.getAuteur();
            //System.out.println(c);
        }
        catch (Exception ex){
            System.out.println("Erreur !!!!");
        }*/
        Administrateur administrateur = new Administrateur();
        Scanner scanner=new Scanner(System.in);
        Electeur electeur = new Electeur();
        electeur.setUserName("aminos");
        electeur.setPassword("mmmmmm");
        Candidat candidat = new Candidat();
        candidat.setCin(100);
        candidat.setNom("Hatsune");
        candidat.setPrenom("Miku");
        candidat.ajouterActivite(Type.AUTRE, new Activite(90, Support.VIDEO, null));
        administrateur.ajouterListeElectoriale();
        administrateur.ajouterCandidat(0, candidat);
        MenuAdministrateur menuAdministrateur = new MenuAdministrateur();
        menuAdministrateur.setAdministrateur(administrateur);
        menuAdministrateur.setScanner(scanner);
        menuAdministrateur.application();
        administrateur = menuAdministrateur.getAdministrateur();
        menuAdministrateur.getElecteurs().add(electeur);
        MenuElecteur menuElecteur = new MenuElecteur();
        menuElecteur.setElecteur(electeur);
        menuElecteur.setScanner(scanner);
        menuElecteur.setCharts(administrateur.getCharts());
        menuElecteur.setAdministrateur(administrateur);
        menuElecteur.application();
        scanner.close();
    }
}
