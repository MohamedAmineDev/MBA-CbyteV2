package Modele;

import java.io.Serializable;
import java.util.Objects;

public class Avis implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int dernierId;
    private int id;
    private double note;
    private Electeur electeur;
    private Candidat candidat;

    public Avis() {
        dernierId++;
        id = dernierId;
    }

    public Avis(double note, Electeur electeur, Candidat candidat) {
        dernierId++;
        id = dernierId;
        this.note = note;
        this.electeur = electeur;
        this.candidat = candidat;
    }

    public static int getDernierId() {
        return dernierId;
    }

    public static void setDernierId(int dernierId) {
        Avis.dernierId = dernierId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public Electeur getElecteur() {
        return electeur;
    }

    public void setElecteur(Electeur electeur) {
        this.electeur = electeur;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Avis)) return false;
        Avis avis = (Avis) o;
        return getElecteur().equals(avis.getElecteur()) && getCandidat().equals(avis.getCandidat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getElecteur(), getCandidat());
    }

    @Override
    public String toString() {
        return "" + id + "" + note + "" + electeur + "" + candidat + "";
       /* return "Avis{" +
                "id=" + id +
                ", note=" + note +
                ", electeur=" + electeur +
                ", candidat=" + candidat +
                '}';*/
    }
}
