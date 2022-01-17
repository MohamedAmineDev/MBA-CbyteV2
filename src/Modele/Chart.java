package Modele;

import java.io.Serializable;
import java.util.Objects;

public class Chart implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int dernierId;
    private int id;
    private String titre;
    private double resultat;
    private Candidat candidat;
    private int numListe;

    public Chart() {
        dernierId++;
        id = dernierId;
        titre = new String();
        resultat = 0;
        candidat = new Candidat();
        numListe = 0;
    }

    public Chart(String titre, double resultat, Candidat candidat, int numListe) {
        this.titre = titre;
        this.resultat = resultat;
        this.candidat = candidat;
        this.numListe = numListe;
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

    public int getId() {
        return id;
    }

    public int getNumListe() {
        return numListe;
    }

    public void setNumListe(int numListe) {
        this.numListe = numListe;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chart)) return false;
        Chart chart = (Chart) o;
        return getNumListe() == chart.getNumListe() && Objects.equals(getCandidat(), chart.getCandidat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCandidat(), numListe);
    }

    @Override
    public String toString() {
        return "" + titre + " : " + (resultat * 100) + "%";
    }
}
