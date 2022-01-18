package Implementation;

import Modele.Administrateur;
import Modele.Candidat;
import Modele.Electeur;
import Modele.ListeElectoriale;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu implements IApplication {
    private MenuAdministrateur menuAdministrateur;
    private MenuElecteur menuElecteur;
    private MenuCandidat menuCandidat;
    private Scanner scanner;
    private int reponse;
    private List<Electeur> electeurs;
    private Administrateur administrateur;

    public Menu() {
        administrateur = new Administrateur();
        menuAdministrateur = new MenuAdministrateur();
        menuElecteur = new MenuElecteur();
        menuCandidat = new MenuCandidat();
        scanner = new Scanner(System.in);
        electeurs = new ArrayList<>();
    }

    @Override
    public void applicationPrincipale() {
        Electeur electeur = new Electeur();
        electeur.setUserName("Mohamed Amine Ben Safta");
        electeur.setPassword("mmmmm");
        Electeur electeur1 = new Electeur();
        electeur1.setUserName("Zaineb Rajhi");
        electeur1.setPassword("mmmmmm");
        Electeur electeur2 = new Electeur();
        electeur2.setUserName("Hanen Beji");
        electeur2.setPassword("mmmmmmm");
        administrateur.setUserName("Testeur1");
        administrateur.setPassword("Testeur1");
        int i = 0;
        electeurs.add(electeur);
        electeurs.add(electeur1);
        electeurs.add(electeur2);
        do {
            menuPrincipale();
        }
        while (reponse != 4);
        scanner.close();
    }

    @Override
    public void menuPrincipale() {
        //System.out.println("");
        String username = new String();
        String password = new String();
        int choix = 0;
        System.out.println("--------- Menu Principale ---------");
        System.out.println("Choisissez votre type de compte");
        System.out.println("1) Compte administrateur");
        System.out.println("2) Compte electeur");
        System.out.println("3) Compte candidat");
        System.out.println("4) Quitter l'application");
        reponse = scanner.nextInt();
        scanner.nextLine();
        switch (reponse) {
            case 1:
                System.out.println("Donner votre nom D'utilisateur");
                username = scanner.nextLine();
                System.out.println("Donner votre mot de passe");
                password = scanner.nextLine();
                if (administrateur.getUserName().equalsIgnoreCase(username) == true && administrateur.getPassword().equalsIgnoreCase(password) == true) {
                    versionAdministrateur();
                } else {
                    System.out.println("Le nom d'utilisateur ou mot de passe sont faux !!!");
                }
                break;
            case 2:
                System.out.println("Donner votre nom D'utilisateur");
                username = scanner.nextLine();
                System.out.println("Donner votre mot de passe");
                password = scanner.nextLine();
                for (Electeur electeur : electeurs
                ) {
                    if (electeur.getUserName().equalsIgnoreCase(username) == true && electeur.getPassword().equalsIgnoreCase(password) == true) {
                        versionElecteur(electeur);
                        break;
                    }
                }
                System.out.println("Le nom d'utilisateur ou mot de passe sont faux !!!");
                break;
            case 3:
                System.out.println("Donner votre nom D'utilisateur");
                username = scanner.nextLine();
                System.out.println("Donner votre mot de passe");
                password = scanner.nextLine();
                int index = 1;
                for (ListeElectoriale listes : administrateur.getListeElectorale()
                ) {
                    for (Candidat candidat : listes.getCandidatList()
                    ) {
                        if (candidat.getUserName().equalsIgnoreCase(username) == true && candidat.getPassword().equalsIgnoreCase(password) == true) {
                            versionCandidat(candidat, index);
                            break;
                        }
                    }
                    index++;
                }

            case 4:
                do {
                    System.out.println("Voulez vous vraiment quitter l'application ?");
                    System.out.println("1) Oui");
                    System.out.println("2) Non");
                    choix = scanner.nextInt();
                }
                while (choix < 1 || choix > 2);
                if (choix == 2) {
                    menuPrincipale();
                }
                break;
            default:
                System.out.println("Vous devez choisir une des options du menu !!!! ");
        }

    }

    public MenuAdministrateur getMenuAdministrateur() {
        return menuAdministrateur;
    }

    public void setMenuAdministrateur(MenuAdministrateur menuAdministrateur) {
        this.menuAdministrateur = menuAdministrateur;
    }

    public MenuElecteur getMenuElecteur() {
        return menuElecteur;
    }

    public void setMenuElecteur(MenuElecteur menuElecteur) {
        this.menuElecteur = menuElecteur;
    }

    public MenuCandidat getMenuCandidat() {
        return menuCandidat;
    }

    public void setMenuCandidat(MenuCandidat menuCandidat) {
        this.menuCandidat = menuCandidat;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void versionAdministrateur() {
        this.menuAdministrateur.setElecteurs(this.electeurs);
        this.menuAdministrateur.setAdministrateur(administrateur);
        this.menuAdministrateur.setScanner(scanner);
        this.menuAdministrateur.application();
        this.administrateur = menuAdministrateur.getAdministrateur();
    }

    @Override
    public void versionElecteur(Electeur electeur) {
        this.menuElecteur.setScanner(scanner);
        this.menuElecteur.setElecteur(electeur);
        this.menuElecteur.setAdministrateur(administrateur);
        menuElecteur.application();
        this.administrateur = menuElecteur.getAdministrateur();
        Electeur e = menuElecteur.getElecteur();
        int index = electeurs.indexOf(e);
        this.electeurs.set(index, e);
    }

    @Override
    public void versionCandidat(Candidat candidat, int index) {
        this.menuCandidat.setScanner(scanner);
        this.menuCandidat.setIndex(index);
        this.menuCandidat.setCandidat(candidat);
        this.menuCandidat.setAdministrateur(administrateur);
        this.menuCandidat.application();
        this.administrateur = menuCandidat.getAdministrateur();
    }

    public int getReponse() {
        return reponse;
    }

    public void setReponse(int reponse) {
        this.reponse = reponse;
    }


    public List<Electeur> getElecteurs() {
        return electeurs;
    }

    public void setElecteurs(List<Electeur> electeurs) {
        this.electeurs = electeurs;
    }
}
