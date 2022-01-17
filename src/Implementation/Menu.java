package Implementation;

import java.util.Scanner;

public class Menu implements IApplication {
    private MenuAdministrateur menuAdministrateur;
    private MenuElecteur menuElecteur;
    private MenuCandidat menuCandidat;
    private Scanner scanner;
    private int reponse;

    public Menu() {
        menuAdministrateur = new MenuAdministrateur();
        menuElecteur = new MenuElecteur();
        menuCandidat = new MenuCandidat();
        scanner = new Scanner(System.in);
    }

    @Override
    public void applicationPrincipale() {

    }

    @Override
    public void menuPrincipale() {
        //System.out.println("");
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
}
