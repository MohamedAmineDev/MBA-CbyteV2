package Modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Design.Design;

public class ListeElectoriale implements IListeElectoriale, Serializable {
    private List<Candidat> candidatList;
    private double score;

    public ListeElectoriale() {
        candidatList = new ArrayList<>();
        score = 0;
    }

    public List<Candidat> getCandidatList() {
        return candidatList;
    }

    public void setCandidatList(List<Candidat> candidatList) {
        this.candidatList = candidatList;
    }

    public double getScore() {
        if (score == 0) {
            this.scoreDeLaListe();
            return score;
        }
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


    @Override
    public void scoreDeLaListe() {
        if (!candidatList.isEmpty()) {
            double res;
            res = 0;
            // Pour mettre la position du candidat en valeur
            int n;
            n = candidatList.size();
            for (Candidat candidat : candidatList
            ) {
                res += candidat.getScore() + n;
                n--;
            }
            score = res;
        }

    }

    @Override
    public Candidat chercherCandidat(int cin) {
        Candidat candidat = new Candidat();
        candidat.setCin(cin);
        int index = candidatList.indexOf(candidat);
        if (index > -1) {
            return candidatList.get(index);
        } else {
            return null;
        }
    }

    @Override
    public boolean ajouterCandidat(Candidat candidat) {
        if (candidat != null) {
            return candidatList.add(candidat);
        }
        return false;
    }

    @Override
    public boolean modifierCandidat(Candidat candidat) {
        if (candidat != null) {
            int index = candidatList.indexOf(candidat);
            if (index > -1) {
                return null != candidatList.set(index, candidat);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean supprimerCandidat(Candidat candidat) {
        if (candidat != null) {
            return candidatList.remove(candidat);
        }
        return false;
    }

    @Override
    public void consulterCandidats() {
        if (!candidatList.isEmpty()) {
           /* String[] tab = new String[7];
            tab[0] = " Num Liste |";
            tab[1] = " Cin            |";
            tab[2] = " Nom                 |";
            tab[3] = " Prenom              |";
            tab[4] = " Compte Facebook     |";
            tab[5] = " Compte Tweeter      |";
            tab[6] = " Score";
            Design.dessinerLigne(180);
            Design.dessinerCases(tab, tab.length);
            Design.dessinerLigne(180);*/
            for (Candidat candidat : candidatList
            ) {
                candidat.afficherCandidat();
            }

        } else {
            Design.dessinerLigne(180);
            System.out.println("La Liste est vide !!!");
        }
    }

    @Override
    public String toString() {
        return "" + candidatList + "" + score;
        /*return "ListeElectoriale{" +
                "candidatList=" + candidatList +
                ", score=" + score +
                '}';*/
    }
}
