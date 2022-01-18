package Implementation;

import Donnees.ManipulationDeDonnes;
import Modele.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class MenuElecteur implements IMenuElecteur {

    private Administrateur administrateur;
    private Scanner scanner;
    private int reponse;
    //private List<Electeur> electeurs;
    private Electeur electeur;
    private ManipulationDeDonnes manipulationDeDonnes;

    public MenuElecteur() {
        administrateur = new Administrateur();
        //scanner = new Scanner(System.in);
        reponse = 0;
        //electeurs = new ArrayList<>();
        electeur = new Electeur();
        manipulationDeDonnes = new ManipulationDeDonnes();
        //charts = new HashSet<>();
    }

    @Override
    public void application() {
        do {
            menu();
        }
        while (reponse != 15);
        // scanner.close();
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
        System.out.println("9) Consulter les reclamations d'un candidat");
        System.out.println("10) Ajouter une reclamation concernant un candidat");
        System.out.println("11) Modifier une reclamation concernant un candidat");
        System.out.println("12) Supprimer s'a  reclamation sur un candidat");
        System.out.println("13) Consulter score de la liste");
        System.out.println("14) Changer de mot de passe");
        System.out.println("15) Quitter l'application");
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
                choix12();
                break;
            case 13:
                choix13();
                break;
            case 14:
                choix14();
                break;
            case 15:
                choix15();
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
        listeElectoriale.consulterCandidats();
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
            candidat.afficherMonCompte((numListe + 1));
            //System.out.println("Liste des activité");
            candidat.consulterActivites();
            System.out.println("");
            //System.out.println("Liste des reclamations");
            candidat.consulterAvis();
            System.out.println("");
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
                System.out.println("Donner la note que vous allez attribuer a cet candidat");
                avis.setNote(scanner.nextDouble());
                if (avis.getNote() >= 0 && avis.getNote() <= 100) {
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
            choix = scanner.nextInt();
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
        //System.out.println("6) Supprimer un avis sur un candidat");
        int choix = 0;
        do {
            System.out.println("Voulez vous vraiemnt supprimer un avis ?");
            System.out.println("1) Oui");
            System.out.println("2) Non");
            choix = scanner.nextInt();
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
                candidat.consulterAvisDunElecteur(electeur);
                System.out.println("Donner l'id de l'avis que vous voulez supprimer ");
                idAvis = scanner.nextInt();
                Avis avis = candidat.chercherActivite(idAvis);
                boolean test = false;
                if (avis != null) {
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
        for (Chart chart : administrateur.getCharts()
        ) {
            System.out.println(chart);
        }
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
            Chart chart = administrateur.chercherCharte(candidat, 0);
            if (chart != null) {
                System.out.println(chart);
            } else {
                System.out.println("Charte intouvable !");
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
        /*ListeElectoriale listeElectoriale = administrateur.chercherListe(numListe);
        listeElectoriale.scoreDeLaListe();*/
        //System.out.println(cli);
        Chart chart = administrateur.chercherCharte(null, numListe);
        if (chart != null) {
            System.out.println("Titre de la charte : " + chart.getTitre());
            System.out.println("Resulat : " + chart.getResultat());
        } else {
            System.out.println("Charte introuvable !!");
        }
    }

    @Override
    public void choix9() {
        // System.out.println("9) Consulter les reclamations d'un candidat");
        administrateur.consulterListeElectorales();
        int numListe = 0;
        do {
            //System.out.println("Vous avez " + administrateur.nombreDeListes() + " listes a utiliser");
            System.out.println("Donner le numéro de la liste dans la quelle le candidat que vous chercher appartient");
            numListe = scanner.nextInt();
        }
        while (numListe > administrateur.nombreDeListes());
        numListe--;
        int cin = 0;
        System.out.println("Donner le cin du candidat ");
        cin = scanner.nextInt();
        Candidat candidat = administrateur.chercherCandidat(numListe, cin);
        if (candidat != null) {
            candidat.consulterReclamation();
        } else {
            System.out.println("Candidat introuvable !!");
        }

    }

    @Override
    public void choix10() {
        //System.out.println("10) Ajouter une reclamation concernant un candidat");
        administrateur.consulterListeElectorales();
        int numListe = 0;
        do {
            //System.out.println("Vous avez " + administrateur.nombreDeListes() + " listes a utiliser");
            System.out.println("Donner le numéro de la liste dans la quelle le candidat que vous chercher appartient");
            numListe = scanner.nextInt();
        }
        while (numListe > administrateur.nombreDeListes());
        numListe--;
        int cin = 0;
        System.out.println("Donner le cin du candidat ");
        cin = scanner.nextInt();
        Candidat candidat = administrateur.chercherCandidat(numListe, cin);
        if (candidat != null) {
            Reclamation reclamation = new Reclamation();
            //reclamation.getJustification();
            //reclamation.getSujet();
            scanner.nextLine();
            System.out.println("Donner le sujet de la reclamation");
            reclamation.setSujet(scanner.nextLine());
            System.out.println("Donner une justification");
            reclamation.setJustification(scanner.nextLine());
            reclamation.setAuteur(electeur);
            boolean test = candidat.ajouterReclamation(reclamation);
            if (test) {
                System.out.println("La reclamation a été ajouté avec succès");
            } else {
                System.out.println("Echec de l'ajout de la reclamation ");
            }

        } else {
            System.out.println("Candidat introuvable !");
        }
    }

    @Override
    public void choix11() {
        //System.out.println("11) Modifier une reclamation concernant un candidat");
        administrateur.consulterListeElectorales();
        int numListe = 0;
        do {
            //System.out.println("Vous avez " + administrateur.nombreDeListes() + " listes a utiliser");
            System.out.println("Donner le numéro de la liste dans la quelle le candidat que vous chercher appartient");
            numListe = scanner.nextInt();
        }
        while (numListe > administrateur.nombreDeListes());
        numListe--;
        int cin = 0;
        System.out.println("Donner le cin du candidat ");
        cin = scanner.nextInt();
        Candidat candidat = administrateur.chercherCandidat(numListe, cin);
        if (candidat != null) {
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
                reclamation.setAuteur(electeur);
                boolean test = candidat.modifierReclamation(reclamation);
                if (test) {
                    System.out.println("La reclamation a été modifié avec succès");
                } else {
                    System.out.println("Echec de la modification de la reclamation ");
                }
            } else {
                System.out.println("Reclamation introuvable !!");
            }

        } else {
            System.out.println("Candidat introuvable !");
        }

    }

    @Override
    public void choix12() {
        //System.out.println("12) Supprimer s'a  reclamation sur un candidat");
        administrateur.consulterListeElectorales();
        int numListe = 0;
        do {
            System.out.println("Donner le numéro de la liste dans la quelle le candidat que vous chercher appartient");
            numListe = scanner.nextInt();
        }
        while (numListe > administrateur.nombreDeListes());
        System.out.println("Donner le cin du candidat");
        int cin = scanner.nextInt();
        numListe--;
        Candidat candidat = administrateur.chercherCandidat(numListe, cin);
        if (candidat != null) {
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
        } else {
            System.out.println("Candidat introuvable !");

        }
    }

    @Override
    public void choix13() {
        //System.out.println("13) Quitter l'application");
        int numListe = 0;
        do {
            System.out.println("Vous avez " + administrateur.nombreDeListes() + " listes a utiliser");
            System.out.println("Donner le numéro de la liste dans la quelle le candidat que vous chercher appartient");
            numListe = scanner.nextInt();
        }
        while (numListe > administrateur.nombreDeListes());
        numListe--;
        System.out.println("Le score de la liste " + (numListe + 1) + " est " + administrateur.getListeElectorale().get(numListe).getScore());

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

    @Override
    public void choix14() {
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
                electeur.setPassword(scanner.nextLine());
                System.out.println("Retaper le nouveau mot de passe");
                confirmationMotDePasse = scanner.nextLine();
                test = electeur.getPassword().equalsIgnoreCase(confirmationMotDePasse);
            }
            while (test == false);
            System.out.println("Le mot de passe a été changé avec succès ");
        }
    }

    @Override
    public void choix15() {
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
}
