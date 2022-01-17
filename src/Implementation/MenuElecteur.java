package Implementation;

import Donnees.ManipulationDeDonnes;
import Modele.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuElecteur implements IMenuElecteur {

    private Administrateur administrateur;
    private Scanner scanner;
    private int reponse;
    //private List<Electeur> electeurs;
    private Electeur electeur;
    private ManipulationDeDonnes manipulationDeDonnes;
    private List<Chart> charts;

    public MenuElecteur() {
        administrateur = new Administrateur();
        scanner = new Scanner(System.in);
        reponse = 0;
        //electeurs = new ArrayList<>();
        electeur = new Electeur();
        manipulationDeDonnes = new ManipulationDeDonnes();
    }

    @Override
    public void application() {
        do {
            menu();
        }
        while (reponse != 13);
        scanner.close();
    }


    @Override
    public void menu() {
        System.out.println("---------Menu---------");
        System.out.println("1) Consulter les listes");
        System.out.println("2) Consulter les candidat d'une liste");
        System.out.println("3) Consulter un candidat en détails");
        System.out.println("4) Ajouter un avis  a un candidat");
        System.out.println("5) Modifier un avis  a un candidat");
        System.out.println("6) Supprimer un avis sur un candidat");
        System.out.println("7) Consulter une charte par client");
        System.out.println("8) Consulter une charte par liste electoriale");
        System.out.println("9) Consulter les reclamations de chaque client");
        System.out.println("10) Ajouter une reclamation concernant un client");
        System.out.println("11) Modifier une reclamation concernant un client");
        System.out.println("12) Supprimer s'a  reclamation sur un candidat");
        System.out.println("13) Quitter l'application");
        /*
        System.out.println("1) Chart par  score par liste electoriale");
            System.out.println("2) Charte par score par candidat");
         */
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
            case 10:
                choix10();
                break;
            case 11:
                choix11();
                break;
            case 12:
                //choix11();
                break;
            case 13:
                //choix11();
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
        //System.out.println("2) Consulter les candidat d'une liste");
        int numListe = 0;
        do {
            System.out.println("Vous avez " + administrateur.nombreDeListes() + " listes a utiliser");
            System.out.println("Donner le numéro de la liste que vous allez consulter");
            numListe = scanner.nextInt();
        }
        while (numListe > administrateur.nombreDeListes());
        numListe--;
        ListeElectoriale listeElectoriale = administrateur.chercherListe(numListe);
    }

    @Override
    public void choix3() {
        // System.out.println("3) Consulter un candidat en détails");
        administrateur.consulterListeElectorales();
        int numListe = 0;
        do {
            System.out.println("Vous avez " + administrateur.nombreDeListes() + " listes a utiliser");
            System.out.println("Donner le numéro de la liste dans la quelle le candidat que vous chercher appartient");
            numListe = scanner.nextInt();
        }
        while (numListe > administrateur.nombreDeListes());
        numListe--;
        int cin = 0;
        System.out.println("Donner le cin du candidat que vous chercher");
        cin = scanner.nextInt();
        Candidat candidat = administrateur.chercherCandidat(numListe, cin);
        if (candidat != null) {
            candidat.afficherCandidat();
            //System.out.println("Liste des activité");
            candidat.consulterActivites();
            //System.out.println("Liste des reclamations");
            candidat.consulterAvis();
        } else {
            System.out.println("Candidat introuvable !");
        }
    }

    @Override
    public void choix4() {
        //System.out.println("4) Ajouter un avis  a un candidat");
        administrateur.consulterListeElectorales();
        int numListe = 0;
        do {
            System.out.println("Vous avez " + administrateur.nombreDeListes() + " listes a utiliser");
            System.out.println("Donner le numéro de la liste dans la quelle le candidat que vous chercher appartient");
            numListe = scanner.nextInt();
        }
        while (numListe > administrateur.nombreDeListes());
        numListe--;
        int cin = 0;
        System.out.println("Donner le cin du candidat que vous chercher");
        cin = scanner.nextInt();
        Candidat candidat = administrateur.chercherCandidat(numListe, cin);
        if (candidat != null) {
            Avis avis = new Avis();
            //avis.getCandidat();
            boolean test = false;
            do {
                System.out.println("Donner la note que vous allez attribuer a cet canidat");
                avis.setNote(scanner.nextDouble());
                if (avis.getNote() >= 0 || avis.getNote() <= 100) {
                    test = true;
                } else {
                    System.out.println("La note doit etre entre 0 et 100 !!!");
                }
            }
            while (test == false);
            avis.setElecteur(electeur);
            test = candidat.ajouterAvis(avis);
            if (test) {
                System.out.println("La note e été attribué avec succès ");
            } else {
                System.out.println("Echec de l'attrubution de la note ");
            }
        } else {
            System.out.println("Candidat introuvable !");
        }
    }

    @Override
    public void choix5() {
        //   System.out.println("5) Modifier un avis  a un candidat");
        int choix = 0;
        do {
            System.out.println("Voulez vous vraiemnt modifier un avis ?");
        }
        while (choix < 1 || choix > 2);
        if (choix == 1) {
            administrateur.consulterListeElectorales();
            int numListe = 0;
            do {
                System.out.println("Vous avez " + administrateur.nombreDeListes() + " listes a utiliser");
                System.out.println("Donner le numéro de la liste dans la quelle le candidat que vous chercher appartient");
                numListe = scanner.nextInt();
            }
            while (numListe > administrateur.nombreDeListes());
            numListe--;
            int cin = 0;
            System.out.println("Donner le cin du candidat que vous chercher");
            cin = scanner.nextInt();
            Candidat candidat = administrateur.chercherCandidat(numListe, cin);
            if (candidat != null) {
                int idAvis = 0;
                do {
                    candidat.consulterAvis();
                    System.out.println("Donner l'id de l'avis que vous voulez modifier ");
                    idAvis = scanner.nextInt();
                }
                while (idAvis > candidat.getAvis().size());
                Avis avis = candidat.chercherActivite(idAvis);
                boolean test = false;
                if (avis != null) {
                    do {
                        System.out.println("Donner la note que vous allez attribuer a cet canidat");
                        avis.setNote(scanner.nextDouble());
                        if (avis.getNote() >= 0 || avis.getNote() <= 100) {
                            test = true;
                        } else {
                            System.out.println("La note doit etre entre 0 et 100 !!!");
                        }
                    }
                    while (test == false);
                    test = candidat.modifierAvis(avis);
                    if (test) {
                        System.out.println("Avis modifié avec succès !");
                    } else {
                        System.out.println("Echec de modifié !");
                    }
                } else {
                    System.out.println("Avis introuvable !");
                }

            } else {
                System.out.println("Candidat introuvable !");
            }
        } else {
        }
    }

    @Override
    public void choix6() {
        System.out.println("6) Supprimer un avis sur un candidat");
        int choix = 0;
        do {
            System.out.println("Voulez vous vraiemnt modifier un avis ?");
        }
        while (choix < 1 || choix > 2);
        if (choix == 1) {
            administrateur.consulterListeElectorales();
            int numListe = 0;
            do {
                System.out.println("Vous avez " + administrateur.nombreDeListes() + " listes a utiliser");
                System.out.println("Donner le numéro de la liste dans la quelle le candidat que vous chercher appartient");
                numListe = scanner.nextInt();
            }
            while (numListe > administrateur.nombreDeListes());
            numListe--;
            int cin = 0;
            System.out.println("Donner le cin du candidat que vous chercher");
            cin = scanner.nextInt();
            Candidat candidat = administrateur.chercherCandidat(numListe, cin);
            if (candidat != null) {
                int idAvis = 0;
                do {
                    candidat.consulterAvis();
                    System.out.println("Donner l'id de l'avis que vous voulez supprime ");
                    idAvis = scanner.nextInt();
                }
                while (idAvis > candidat.getAvis().size());
                Avis avis = candidat.chercherActivite(idAvis);
                boolean test = false;
                if (avis != null) {
                    do {
                        System.out.println("Donner la note que vous allez attribuer a cet candidat");
                        avis.setNote(scanner.nextDouble());
                        if (avis.getNote() >= 0 || avis.getNote() <= 100) {
                            test = true;
                        } else {
                            System.out.println("La note doit etre entre 0 et 100 !!!");
                        }
                    }
                    while (test == false);
                    test = candidat.supprimerAvis(avis);
                    if (test) {
                        System.out.println("Avis supprimé avec succès !");
                    } else {
                        System.out.println("Echec de suppression !");
                    }
                } else {
                    System.out.println("Avis introuvable !");
                }

            } else {
                System.out.println("Candidat introuvable !");
            }
        } else {
        }
    }

    @Override
    public void choix7() {
        //System.out.println("7) Consulter une charte par client");
        administrateur.consulterListeElectorales();
        int numListe = 0;
        do {
            System.out.println("Vous avez " + administrateur.nombreDeListes() + " listes a utiliser");
            System.out.println("Donner le numéro de la liste dans la quelle le candidat que vous chercher appartient");
            numListe = scanner.nextInt();
        }
        while (numListe > administrateur.nombreDeListes());
        numListe--;
        int cin = 0;
        System.out.println("Donner le cin du candidat que vous chercher");
        cin = scanner.nextInt();
        Candidat candidat = administrateur.chercherCandidat(numListe, cin);
        if (candidat != null) {
            for (Chart chart : charts
            ) {
                if (chart.getCandidat().equals(candidat)) {
                    System.out.println(chart);
                }
            }
        } else {
            System.out.println("Candidat intouvable ! ");
        }
    }

    @Override
    public void choix8() {
        //System.out.println("8) Consulter une charte par liste electoriale");
        administrateur.consulterListeElectorales();
        int numListe = 0;
        do {
            System.out.println("Vous avez " + administrateur.nombreDeListes() + " listes a utiliser");
            System.out.println("Donner le numéro de la liste dans la quelle le candidat que vous chercher appartient");
            numListe = scanner.nextInt();
        }
        while (numListe > administrateur.nombreDeListes());
        numListe--;
        ListeElectoriale listeElectoriale = administrateur.chercherListe(numListe);
        listeElectoriale.scoreDeLaListe();
        //System.out.println(cli);
    }

    @Override
    public void choix9() {

    }

    @Override
    public void choix10() {

    }

    @Override
    public void choix11() {

    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getReponse() {
        return reponse;
    }

    public void setReponse(int reponse) {
        this.reponse = reponse;
    }

    public Electeur getElecteur() {
        return electeur;
    }

    public void setElecteur(Electeur electeur) {
        this.electeur = electeur;
    }

    public ManipulationDeDonnes getManipulationDeDonnes() {
        return manipulationDeDonnes;
    }

    public void setManipulationDeDonnes(ManipulationDeDonnes manipulationDeDonnes) {
        this.manipulationDeDonnes = manipulationDeDonnes;
    }

    public List<Chart> getCharts() {
        return charts;
    }

    public void setCharts(List<Chart> charts) {
        this.charts = charts;
    }
}
