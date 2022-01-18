package Implementation;

import Modele.Administrateur;
import Modele.Candidat;
import Modele.ListeElectoriale;
import Modele.Reclamation;

import java.util.Scanner;

public class MenuCandidat implements IMenuCandidat {
    private Administrateur administrateur;
    private int reponse;
    private Scanner scanner;
    private Candidat candidat;
    private int index;

    public MenuCandidat() {
        administrateur = new Administrateur();
        reponse = 0;
        index = 0;
    }

    @Override
    public void application() {
        do {
            menu();
        }
        while (reponse != 9);
    }

    @Override
    public void menu() {
        System.out.println("---------Menu---------");
        System.out.println("1) Consulter les listes electoriales");
        System.out.println("2) Consulter un candidat en détails");
        System.out.println("3) Ajouter une  reclamation");
        System.out.println("4) Modifier une de mes reclamations");
        System.out.println("5) Supprimer une de mes reclamation");
        System.out.println("6) Consulter mes reclamations");
        System.out.println("7) Consulter la méthode de calcule du score");
        System.out.println("8) Changer de mot de passe");
        System.out.println("9) Quitter l'application");
        reponse = this.scanner.nextInt();
        switch (reponse) {
            case 1:
                choix1();
                break;
            case 2:
                choix2();
                break;
            case 3:
                choix3();
                break;
            case 4:
                choix4();
                break;
            case 5:
                choix5();
                break;
            case 6:
                choix6();
                break;
            case 7:
                choix7();
                break;
            case 8:
                choix8();
                break;
            case 9:
                choix9();
                break;
            default:
                System.out.println("Vous devez choisir une des options du menu !!!! ");
        }

    }

    @Override
    public void choix1() {
        administrateur.consulterListeElectorales();
    }

    @Override
    public void choix2() {
        candidat.afficherMonCompte(index);
        System.out.println("");
        candidat.consulterActivites();
        System.out.println("");
        candidat.consulterAvis();
        System.out.println("");
    }

    @Override
    public void choix3() {
        Reclamation reclamation = new Reclamation();
        scanner.nextLine();
        System.out.println("Donner le sujet de la reclamation");
        reclamation.setSujet(scanner.nextLine());
        System.out.println("Donner une justification");
        reclamation.setJustification(scanner.nextLine());
        reclamation.setAuteur(this.candidat);
        boolean test = candidat.ajouterReclamation(reclamation);
        if (test) {
            System.out.println("La reclamation a été ajouté avec succès");
        } else {
            System.out.println("Echec de l'ajout de la reclamation ");
        }
    }


    @Override
    public void choix4() {
        candidat.consulterReclamation();
        int idReclamation = 0;
        System.out.println("Donner l'id de la reclamation que vous voulez modifier ");
        idReclamation = scanner.nextInt();
        Reclamation reclamation = candidat.chercherReclamation(idReclamation);
        if (reclamation != null) {
            scanner.nextLine();
            System.out.println("Donner le nouveau sujet de la reclamation");
            reclamation.setSujet(scanner.nextLine());
            System.out.println("Donner une nouvelle justification");
            reclamation.setJustification(scanner.nextLine());
            reclamation.setAuteur(candidat);
            boolean test = candidat.modifierReclamation(reclamation);
            if (test) {
                System.out.println("La reclamation a été modifié avec succès");
            } else {
                System.out.println("Echec de la modification de la reclamation ");
            }
        } else {
            System.out.println("Reclamation introuvable !!");
        }
    }

    @Override
    public void choix5() {
        candidat.consulterReclamation();
        int numReclamation = 0;
        System.out.println("Donner l'id du reclamation");
        numReclamation = scanner.nextInt();
        Reclamation reclamation = candidat.chercherReclamation(numReclamation);
        if (reclamation != null) {
            boolean test = candidat.supprimerReclamation(reclamation);
            if (test) {
                System.out.println("Suppression de la reclamation est un succès ");
            } else {
                System.out.println("Echec de la suppression !");
            }
        }
    }

    @Override
    public void choix6() {
        candidat.consulterReclamation();
    }

    @Override
    public void choix7() {
        candidat.methodeDeCalculeDuScore();
    }

    @Override
    public void choix8() {
        int choix = 0;
        do {
            System.out.println("Voulez vous vraiment changer de mot de passe ?");
            choix = scanner.nextInt();
        }
        while (choix < 1 || choix > 2);

        if (choix == 1) {
            String confirmationMotDePasse = new String();
            scanner.nextLine();
            boolean test = false;
            do {
                System.out.println("Donner le nouveau mot de passe");
                candidat.setPassword(scanner.nextLine());
                System.out.println("Retaper le nouveau mot de passe");
                confirmationMotDePasse = scanner.nextLine();
                test = candidat.getPassword().equalsIgnoreCase(confirmationMotDePasse);
            }
            while (test == false);
            System.out.println("Le mot de passe a été changé avec succès ");
        }
    }

    @Override
    public void choix9() {
        int choix = 0;
        do {
            System.out.println("Voulez vous vraiment quitter l'application ?");
            System.out.println("1) Oui");
            System.out.println("2) Non");
            choix = scanner.nextInt();
        }
        while (choix < 1 || choix > 2);
        if (choix == 2) {
            menu();
        }
    }

    @Override
    public void choix10() {

    }

    @Override
    public void choix11() {

    }

    @Override
    public void choix12() {

    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }

    public int getReponse() {
        return reponse;
    }

    public void setReponse(int reponse) {
        this.reponse = reponse;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
