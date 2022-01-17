package Modele;

import java.io.Serializable;
import java.util.Objects;

public class Reclamation implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int dernierId;
    private int id;
    private IUtilisateursP auteur;
    private IUtilisateursP cible;
    private String sujet;
    private String justification;

    public Reclamation() {
        dernierId++;
        id = dernierId;
    }

    public Reclamation(String sujet, String justification) {
        dernierId++;
        id = dernierId;
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

    public IUtilisateursP getAuteur() {
        return auteur;
    }

    public void setAuteur(IUtilisateursP auteur) {
        this.auteur = auteur;
    }

    public IUtilisateursP getCible() {
        return cible;
    }

    public void setCible(IUtilisateursP cible) {
        this.cible = cible;
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
        return "id=" + id + ",sujet=" + sujet + ",justification" + justification;
        /*return "Reclamation{" +
                "id=" + id +
                ", administrateur=" + administrateur +
                ", electeur=" + electeur +
                ", candidat=" + candidat +
                ", sujet='" + sujet + '\'' +
                ", justification='" + justification + '\'' +
                '}';*/
    }
}
