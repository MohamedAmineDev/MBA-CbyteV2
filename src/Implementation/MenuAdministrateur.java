package Implementation;

import Donnees.ManipulationDeDonnes;
import Enumeration.Support;
import Enumeration.Type;
import Modele.*;

import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuAdministrateur implements IMenuAdministrateur {
    private Administrateur administrateur;
    private Scanner scanner;
    private int reponse;
    private List<Electeur> electeurs;
    private ManipulationDeDonnes manipulationDeDonnes;

    public MenuAdministrateur() {
        administrateur = new Administrateur();
        //scanner = new Scanner(System.in);
        reponse = 0;
        electeurs = new ArrayList<>();
        manipulationDeDonnes = new ManipulationDeDonnes();
    }


    @Override
    public void application() {
        do {
            menu();
        }
        while (reponse != 12);
        //scanner.close();
    }

    @Override
    public void menu() {
        System.out.println("---------Menu---------");
        System.out.println("1) Ajouter une Liste d'election");
        System.out.println("2) Ajouter un nouveau candidat");
        System.out.println("3) Consulter les candidat de chaque liste");
        System.out.println("4) Consulter un candidat en détails");
        System.out.println("5) Modifier un candidat");
        System.out.println("6) Supprimer un candidat");
        System.out.println("7) Créer charte");
        System.out.println("8) Consulter les reclamations de chaque client");
        System.out.println("9) Supprimer un reclamation");
        System.out.println("10) Calculer score des candidats");
        System.out.println("11) Calculer score d'une liste");
        System.out.println("12) Quitter l'application");
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
            default:
                System.out.println("Vous devez choisir une des options du menu !!!! ");
        }
        //scanner.close();
        //System.out.println(a);
    }

    @Override
    public void choix1() {
        //Administrateur administrateur = (Administrateur) utilisateur;
        administrateur.ajouterListeElectoriale();
        System.out.println("L'ajout de la liste electoriale est un succès ! ");
    }

    @Override
    public void choix2() {
        Candidat candidat = new Candidat();
        System.out.println("Donner un cin");
        candidat.setCin(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Donner un nom");
        candidat.setNom(scanner.nextLine());
        System.out.println("Donner un prenom");
        candidat.setPrenom(scanner.nextLine());
        int jour = 0;
        do {
            System.out.println("Donner le jour entre(1 et 31)");
            jour = scanner.nextInt();
        }
        while (jour < 1 || jour > 31);
        int mois = 0;
        do {
            System.out.println("Donner le mois entre(1 et 12)");
            mois = scanner.nextInt();
        }
        while (mois < 1 || mois > 12);
        int annee = 0;
        do {
            System.out.println("Donner l'annee (positive)");
            annee = scanner.nextInt();
        }
        while (annee < 0);
        candidat.setDateNaissance(jour, mois, annee);
        scanner.nextLine();
        System.out.println("Donner un nom d'utilisateur");
        candidat.setUserName(scanner.nextLine());
        System.out.println("Donner un mot de passe");
        candidat.setPassword(scanner.nextLine());
        System.out.println("Donner votre compte facebook");
        candidat.setFacebook(scanner.nextLine());
        System.out.println("Donner votre compte tweeter");
        candidat.setTweeter(scanner.nextLine());
        System.out.println("Donner votre photo");
        candidat.setPhoto(scanner.nextLine());
        System.out.println("Donner votre nom de la partie");
        candidat.setNomPartie(scanner.nextLine());
        /// Saisie activites
        int nbrActivite = 0;
        System.out.println("Donner le nombre d'acitivité");
        nbrActivite = scanner.nextInt();
        int i = 0;
        int choix = 0;
        while (i < nbrActivite) {
            Activite activite = new Activite();
            System.out.println("Donner durée");
            activite.setDuree(scanner.nextFloat());
            ///Saisie de support
            do {
                System.out.println("Quelle support le candidat a utilisé ?");
                System.out.println("1) Video");
                System.out.println("2) Photos");
                System.out.println("3) Liens");
                System.out.println("4) Texte");
                System.out.println("5) Papiers");
                choix = scanner.nextInt();
                switch (choix) {
                    case 1:
                        activite.setSupport(Support.VIDEO);
                        break;
                    case 2:
                        activite.setSupport(Support.PHOTOS);
                        break;
                    case 3:
                        activite.setSupport(Support.LIENS);
                        break;
                    case 4:
                        activite.setSupport(Support.TEXTE);
                        break;
                    case 5:
                        activite.setSupport(Support.PAPIERS);
                        break;
                    default:
                        System.out.println("Vous devez choisir l'un de ces 5 support !!!!!");
                }
            }
            while (choix < 1 || choix > 5);
            ///Saisie type activité
            Type type = Type.AUTRE;
            do {
                System.out.println("Quelle type d'acitivité le candidat pratique ?");
                System.out.println("1) Scientifique");
                System.out.println("2) Politique");
                System.out.println("3) Economique");
                System.out.println("4) Sociale");
                System.out.println("5) Humanitaire");
                System.out.println("6) Autre");
                choix = scanner.nextInt();
                switch (choix) {
                    case 1:
                        type = Type.SCIENTIFIQUE;
                        break;
                    case 2:
                        type = Type.POLITIQUE;
                        break;
                    case 3:
                        type = Type.ECONOMIQUE;
                        break;
                    case 4:
                        type = Type.SOCIALE;
                        break;
                    case 5:
                        type = Type.HUMANITAIRE;
                        break;
                    case 6:
                        type = Type.AUTRE;
                        break;
                    default:
                        System.out.println("Vous devez choisir l'un de ces 5 support !!!!!");
                }
            }
            while (choix < 1 || choix > 6);
            boolean test;
            test = candidat.ajouterActivite(type, activite);
            if (test) {
                System.out.println("L'activité a été ajouté avec succès !");
            } else {
                System.out.println("Echec de l'ajout !");
            }
            i++;

        }
        if (administrateur.nombreDeListes() > 0) {
            System.out.println("Vous avez " + administrateur.nombreDeListes() + " listes a utiliser");
            System.out.println("Donner le numéro de la liste que vous allez remplir");
            choix = scanner.nextInt();
            boolean test = administrateur.ajouterCandidat(choix - 1, candidat);
            if (test) {
                System.out.println("Candidat a été ajouté avec succès !");
            } else {
                System.out.println("Echec de l'ajout du candidat !");
            }
        } else {
            administrateur.ajouterListeElectoriale();
            System.out.println("Une nouvelle  liste a été ajouté");
            boolean test = administrateur.ajouterCandidat(0, candidat);
            if (test) {
                System.out.println("Candidat a été ajouté avec succès !");
            } else {
                System.out.println("Echec de l'ajout du candidat !");
            }

        }
        scanner.nextLine();
    }

    @Override
    public void choix3() {
        administrateur.consulterListeElectorales();
    }

    @Override
    public void choix4() {
        administrateur.consulterListeElectorales();
        int numListe = 0;
        System.out.println("Donner le numero de la liste du candidat");
        numListe = scanner.nextInt();
        System.out.println("Donner le cin du candidat");
        int cin = scanner.nextInt();
        numListe--;
        Candidat candidat = administrateur.chercherCandidat(numListe, cin);
        if (candidat != null) {
            candidat.afficherMonCompte(numListe);
            System.out.println("");
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
    public void choix5() {
        administrateur.consulterListeElectorales();

        int numListe = 0;
        do {
            System.out.println("Donner le numero de la liste");
            numListe = scanner.nextInt();
        }
        while (numListe > administrateur.getListeElectorale().size());
        System.out.println("Donner le cin du candidat que vous voulez modifier");
        numListe--;
        int cin = scanner.nextInt();
        Candidat candidat = administrateur.chercherCandidat(numListe, cin);
        if (candidat != null) {
            //System.out.println("Cin");
            int rep = 0;
            do {
                System.out.println("Etes vous sur de vouloir modifier ce candiat ?");
                System.out.println("1) Oui");
                System.out.println("2) Non");
                rep = scanner.nextInt();
            }
            while (rep < 1 || rep > 2);
            ///modification candidat
            do {
                System.out.println("Voulez vous modifier ce nom ? (" + candidat.getNom() + ")");
                System.out.println("1) Oui");
                System.out.println("2) Non");
                rep = scanner.nextInt();
            }
            while (rep < 1 || rep > 2);

            if (rep == 1) {
                scanner.nextLine();
                System.out.println("Donner un nouveau nom");
                candidat.setNom(scanner.nextLine());
            }
            do {
                System.out.println("Voulez vous modifier ce prenom ? (" + candidat.getPrenom() + ")");
                System.out.println("1) Oui");
                System.out.println("2) Non");
                rep = scanner.nextInt();
            }
            while (rep < 1 || rep > 2);
            if (rep == 1) {
                scanner.nextLine();
                System.out.println("Donner un nouveau prenom");
                candidat.setPrenom(scanner.nextLine());
            }
            do {
                System.out.println("Voulez vous modifier cette date de naissance ? (" + candidat.getDateNaissance() + ")");
                System.out.println("1) Oui");
                System.out.println("2) Non");
                rep = scanner.nextInt();
            }
            while (rep < 1 || rep > 2);
            if (rep == 1) {
                int jour = 0;
                do {
                    System.out.println("Donner le jour entre(1 et 31)");
                    jour = scanner.nextInt();
                }
                while (jour < 1 || jour > 31);
                int mois = 0;
                do {
                    System.out.println("Donner le mois entre(1 et 12)");
                    mois = scanner.nextInt();
                }
                while (mois < 1 || mois > 12);
                int annee = 0;
                do {
                    System.out.println("Donner l'annee (positive)");
                    annee = scanner.nextInt();
                }
                while (annee < 0);
                candidat.setDateNaissance(jour, mois, annee);
            }
            do {
                System.out.println("Voulez vous modifier ce compte facebook ? (" + candidat.getFacebook() + ")");
                System.out.println("1) Oui");
                System.out.println("2) Non");
                rep = scanner.nextInt();
            }
            while (rep < 1 || rep > 2);
            if (rep == 1) {
                scanner.nextLine();
                System.out.println("Donner un nouveau compte facebook");
                candidat.setFacebook(scanner.nextLine());
            }
            do {
                System.out.println("Voulez vous modifier ce compte tweeter ? (" + candidat.getTweeter() + ")");
                System.out.println("1) Oui");
                System.out.println("2) Non");
                rep = scanner.nextInt();
            }
            while (rep < 1 || rep > 2);
            if (rep == 1) {
                scanner.nextLine();
                System.out.println("Donner un nouveau compte tweeter");
                candidat.setTweeter(scanner.nextLine());
            }
            do {
                System.out.println("Voulez vous modifier cette photo ? (" + candidat.getPhoto() + ")");
                System.out.println("1) Oui");
                System.out.println("2) Non");
                rep = scanner.nextInt();
            }
            while (rep < 1 || rep > 2);
            if (rep == 1) {
                scanner.nextLine();
                System.out.println("Donner une nouvelle  photo");
                candidat.setPhoto(scanner.nextLine());
            }
            do {
                System.out.println("Voulez vous modifier ce nom de partie ? (" + candidat.getNomPartie() + ")");
                System.out.println("1) Oui");
                System.out.println("2) Non");
                rep = scanner.nextInt();
            }
            while (rep < 1 || rep > 2);
            if (rep == 1) {
                scanner.nextLine();
                System.out.println("Donner un nouveau nom de la partie");
                candidat.setNomPartie(scanner.nextLine());
            }
            do {
                System.out.println("Voulez vous modifier les activités du candidat ?");
                System.out.println("1) Oui");
                System.out.println("2) Non");
                rep = scanner.nextInt();
            }
            while (rep < 1 || rep > 2);
            if (rep == 1) {
                for (Map.Entry activite : candidat.getActivites().entrySet()
                ) {
                    int k;
                    Activite activite1 = (Activite) activite.getValue();
                    int choix = 0;
                    do {
                        System.out.println("Voulez vous modifier la durée de cette activité ? (" + activite1.getDuree() + " s)");
                        System.out.println("1) Oui");
                        System.out.println("2) Non");
                        choix = scanner.nextInt();
                    }
                    while (choix < 1 || choix > 2);
                    if (choix == 1) {
                        System.out.println("Donner une nouvelle durée");
                        activite1.setDuree(scanner.nextFloat());
                    }
                    do {
                        System.out.println("Voulez vous modifier le support de cette activité ? (" + activite1.getSupport() + " s)");
                        System.out.println("1) Oui");
                        System.out.println("2) Non");
                        choix = scanner.nextInt();
                    }
                    while (choix < 1 || choix > 2);
                    if (choix == 1) {
                        do {
                            System.out.println("Quelle support le candidat a utilisé ?");
                            System.out.println("1) Video");
                            System.out.println("2) Photos");
                            System.out.println("3) Liens");
                            System.out.println("4) Texte");
                            System.out.println("5) Papiers");
                            k = scanner.nextInt();
                            switch (k) {
                                case 1:
                                    activite1.setSupport(Support.VIDEO);
                                    break;
                                case 2:
                                    activite1.setSupport(Support.PHOTOS);
                                    break;
                                case 3:
                                    activite1.setSupport(Support.LIENS);
                                    break;
                                case 4:
                                    activite1.setSupport(Support.TEXTE);
                                    break;
                                case 5:
                                    activite1.setSupport(Support.PAPIERS);
                                    break;
                                default:
                                    System.out.println("Vous devez choisir l'un de ces 5 support !!!!!");
                            }
                        }
                        while (k < 1 || k > 5);

                    }
                    Type type = (Type) activite.getKey();
                    boolean test = candidat.modifierActivite(type, activite1);
                    if (test) {
                        System.out.println("Activité modifier avec succès !");
                    } else {
                        System.out.println("Echec de modification de l'activité");
                    }

                }
            }
            do {
                System.out.println("Voulez vous ajouter de nouvelles activités a ce candidat ?");
                System.out.println("1) Oui");
                System.out.println("2) Non");
                rep = scanner.nextInt();
            }
            while (rep < 1 || rep > 2);
            if (rep == 1) {
                System.out.println("Donner le nombre d'activités que vous voulez ajouter");
                rep = scanner.nextInt();
                int i = 0;
                int choix = 0;
                while (i < rep) {
                    Activite activite = new Activite();
                    System.out.println("Donner durée");
                    activite.setDuree(scanner.nextFloat());
                    ///Saisie de support
                    do {
                        System.out.println("Quelle support le candidat a utilisé ?");
                        System.out.println("1) Video");
                        System.out.println("2) Photos");
                        System.out.println("3) Liens");
                        System.out.println("4) Texte");
                        System.out.println("5) Papiers");
                        choix = scanner.nextInt();
                        switch (choix) {
                            case 1:
                                activite.setSupport(Support.VIDEO);
                                break;
                            case 2:
                                activite.setSupport(Support.PHOTOS);
                                break;
                            case 3:
                                activite.setSupport(Support.LIENS);
                                break;
                            case 4:
                                activite.setSupport(Support.TEXTE);
                                break;
                            case 5:
                                activite.setSupport(Support.PAPIERS);
                                break;
                            default:
                                System.out.println("Vous devez choisir l'un de ces 5 support !!!!!");
                        }
                    }
                    while (choix < 1 || choix > 5);
                    ///Saisie type activité
                    Type type = Type.AUTRE;
                    do {
                        System.out.println("Quelle type d'acitivité le candidat pratique ?");
                        System.out.println("1) Scientifique");
                        System.out.println("2) Politique");
                        System.out.println("3) Economique");
                        System.out.println("4) Sociale");
                        System.out.println("5) Humanitaire");
                        System.out.println("6) Autre");
                        choix = scanner.nextInt();
                        switch (choix) {
                            case 1:
                                type = Type.SCIENTIFIQUE;
                                break;
                            case 2:
                                type = Type.POLITIQUE;
                                break;
                            case 3:
                                type = Type.ECONOMIQUE;
                                break;
                            case 4:
                                type = Type.SOCIALE;
                                break;
                            case 5:
                                type = Type.HUMANITAIRE;
                                break;
                            case 6:
                                type = Type.AUTRE;
                                break;
                            default:
                                System.out.println("Vous devez choisir l'un de ces 5 support !!!!!");
                        }
                    }
                    while (choix < 1 || choix > 6);
                    boolean test;
                    test = candidat.ajouterActivite(type, activite);
                    if (test) {
                        System.out.println("L'activité a été ajouté avec succès !");
                    } else {
                        System.out.println("Echec de l'ajout !");
                    }
                    i++;

                }
            }
            boolean test = administrateur.modifierCandidat(numListe, candidat);
            if (test) {
                System.out.println("Le candidat est mis à jour avec succès !");
            } else {
                System.out.println("Echec de modification du candidat !!!!");
            }
        } else {
        }
    }

    @Override
    public void choix6() {
        administrateur.consulterListeElectorales();
        int numListe = 0;
        do {
            System.out.println("Donner le numero de la liste");
            numListe = scanner.nextInt();
        }
        while (numListe > administrateur.getListeElectorale().size());
        numListe--;
        int cin = 0;
        System.out.println("Donner le cin du candidat");
        cin = scanner.nextInt();
        Candidat candidat = administrateur.chercherCandidat(numListe, cin);
        boolean test = administrateur.supprimerCandidat(numListe, candidat);
        if (test) {
            System.out.println("Suppression est un succès !");
        } else {
            System.out.println("Echec de la suppression !");
        }
    }

    @Override
    public void choix7() {
        int choix = 0;
        do {
            System.out.println("Quel type de charte vous voulez crée ?");
            System.out.println("1) Chart par  score par liste electoriale");
            System.out.println("2) Charte par score par candidat");
            choix = scanner.nextInt();
        }
        while (choix < 1 || choix > 2);
        int numList = 0;
        if (choix == 1) {
            do {
                System.out.println("Vous avez " + administrateur.nombreDeListes() + " listes a utiliser");
                System.out.println("Donner le numéro de la liste");
                numList = scanner.nextInt();
            }
            while (numList > administrateur.nombreDeListes());
            numList--;
            ListeElectoriale listeElectoriale = administrateur.chercherListe(numList);
            Chart chart = administrateur.chartScoreParListeElectoriale(numList, electeurs);
            if (chart != null) {
                System.out.println("La charte a été créer avec succès");
                boolean test = administrateur.ajouterCharte(chart);
                if (test) {
                    System.out.println("La charte a été ajouté avec succès !");
                } else {
                    System.out.println("Echec de l'ajout de la charte !");
                }
            } else {
                System.out.println("Echec de création de la charte par liste !!");
            }
        } else {
            administrateur.consulterListeElectorales();
            do {
                System.out.println("Vous avez " + administrateur.nombreDeListes() + " listes a utiliser");
                System.out.println("Donner le numéro de la liste");
                numList = scanner.nextInt();
            }
            while (numList > administrateur.nombreDeListes());
            numList--;
            System.out.println("Donner le cin du candidat");
            int cin = scanner.nextInt();
            Candidat candidat = administrateur.chercherCandidat(numList, cin);
            if (candidat != null) {
                Chart chart = administrateur.chartScoreParCandidat(candidat, electeurs, numList);
                if (chart != null) {
                    System.out.println("La charte a été créer avec succès");
                    boolean test = administrateur.ajouterCharte(chart);
                    if (test) {
                        System.out.println("La charte a été ajouté avec succès !");
                    } else {
                        System.out.println("Echec de l'ajout de la charte !");
                    }
                } else {
                    System.out.println("Echec au creation de la charte !!");
                }
            } else {
                System.out.println("Le candidat est introuvable !");
            }
        }
    }

    @Override
    public void choix8() {
        if (!administrateur.getListeElectorale().isEmpty()) {
            for (ListeElectoriale liste : administrateur.getListeElectorale()) {
                if (!liste.getCandidatList().isEmpty()) {
                    for (Candidat candidat : liste.getCandidatList()
                    ) {
                        if (!candidat.getReclamations().isEmpty()) {
                            candidat.consulterReclamation();
                        } else {
                            System.out.println("Le candidat " + candidat.getNom() + " n'a pas de reclamation !");
                        }
                    }
                }
            }
        } else {
            System.out.println("Les listes electoriales sont vides !!!");
        }
    }

    @Override
    public void choix9() {
        administrateur.consulterListeElectorales();
        int numListe = 0;
        do {
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
    public void choix10() {
        for (ListeElectoriale liste : administrateur.getListeElectorale()
        ) {
            for (Candidat candidat : liste.getCandidatList()
            ) {
                candidat.calculerScore();
            }
        }
        System.out.println("Les scores sont maitenant calculé ");
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

    public List<Electeur> getElecteurs() {
        return electeurs;
    }

    public void setElecteurs(List<Electeur> electeurs) {
        this.electeurs = electeurs;
    }

    @Override
    public void choix11() {
        int numListe = 0;
        do {
            System.out.println("Vous avez " + administrateur.nombreDeListes() + " listes a utiliser");
            System.out.println("Donner le numéro de la liste");
            numListe = scanner.nextInt();
        }
        while (numListe > administrateur.nombreDeListes());
        numListe--;
        System.out.println("Le score de la liste " + (numListe + 1) + " est " + administrateur.getListeElectorale().get(numListe).getScore());
    }

    @Override
    public void choix12() {
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
