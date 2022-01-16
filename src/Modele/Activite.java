package Modele;

import Enumeration.Support;

import java.io.Serializable;
import java.util.Objects;

public class Activite implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int dernierId;
    private int id;
    private float duree;
    private Support support;
    private Candidat candidat;

    public Activite() {
        dernierId++;
        id = dernierId;
    }

    public Activite(float duree, Support support, Candidat candidat) {
        dernierId++;
        this.id = dernierId;
        this.duree = duree;
        this.support = support;
        this.candidat = candidat;
    }

    public static int getDernierId() {
        return dernierId;
    }

    public static void setDernierId(int dernierId) {
        Activite.dernierId = dernierId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getDuree() {
        return duree;
    }

    public void setDuree(float duree) {
        this.duree = duree;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
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
        if (!(o instanceof Activite)) return false;
        Activite activite = (Activite) o;
        return getId() == activite.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "" + id + "" + duree + "" + support + "" + candidat;
       /* return "Activite{" +
                "id=" + id +
                ", duree=" + duree +
                ", support=" + support +
                ", candidat=" + candidat +
                '}';*/
    }
}
