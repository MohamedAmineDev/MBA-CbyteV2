package Modele;

import java.io.Serializable;
import java.util.Objects;

public class Reclamation implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int dernierId;
    private int id;
    private Administrateur administrateur;
    private Electeur electeur;
    private Candidat candidat;
    private String sujet;
    private String justification;

    public Reclamation() {
        dernierId++;
        id=dernierId;
    }

    public Reclamation(String sujet, String justification) {
        dernierId++;
        id=dernierId;
        this.sujet = sujet;
        this.justification = justification;
    }

    public static int getDernierId() {
        return dernierId;
    }

    public static void setDernierId(int dernierId) {
        Reclamation.dernierId = dernierId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }

    public Electeur getElecteur() {
        return electeur;
    }

    public void setElecteur(Electeur electeur) {
        this.electeur = electeur;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
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
        if (!(o instanceof Reclamation)) return false;
        Reclamation that = (Reclamation) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Reclamation{" +
                "id=" + id +
                ", administrateur=" + administrateur +
                ", electeur=" + electeur +
                ", candidat=" + candidat +
                ", sujet='" + sujet + '\'' +
                ", justification='" + justification + '\'' +
                '}';
    }
}
