package Modele;

import java.io.Serializable;

public class Chart implements Serializable {
    private static final long serialVersionUID = 1L;
    private String titre;
    private double resultat;
    private Candidat candidat;

    public Chart() {
        titre = new String();
        resultat = 0;
        candidat = new Candidat();
    }

    public Chart(String titre, double resultat, Candidat candidat) {
        this.titre = titre;
        this.resultat = resultat;
        this.candidat = candidat;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public double getResultat() {
        return resultat;
    }

    public void setResultat(double resultat) {
        this.resultat = resultat;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    @Override
    public String toString() {
        return "" + titre + " : " + resultat + "%";
    }
}
