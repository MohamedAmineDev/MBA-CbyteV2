package Modele;

import Design.Design;
import Enumeration.Type;

import java.io.Serializable;
import java.util.*;

public class Candidat implements ICandidat, Serializable {
    private static final long serialVersionUID = 1L;
    private int cin;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String photo;
    private String nomPartie;
    private String facebook;
    private String tweeter;
    HashMap<Type, Activite> activites;
    private double score;
    private HashSet<Avis> avis;
    private List<Reclamation> reclamations;

    public Candidat() {
        this.activites = new HashMap<>();
        this.avis = new HashSet<>();
        this.reclamations = new ArrayList<>();
        facebook = new String();
        tweeter = new String();
        photo = new String();
        prenom = new String();
        dateNaissance = new String();
        nom = new String();

    }

    public Candidat(int cin, String nom, String prenom, String dateNaissance, String photo, String nomPartie, String facebook, String tweeter) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.photo = photo;
        this.nomPartie = nomPartie;
        this.facebook = facebook;
        this.tweeter = tweeter;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNomPartie() {
        return nomPartie;
    }

    public void setNomPartie(String nomPartie) {
        this.nomPartie = nomPartie;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTweeter() {
        return tweeter;
    }

    public void setTweeter(String tweeter) {
        this.tweeter = tweeter;
    }

    public HashMap<Type, Activite> getActivites() {
        return activites;
    }

    public void setActivites(HashMap<Type, Activite> activites) {
        this.activites = activites;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public HashSet<Avis> getAvis() {
        return avis;
    }

    public void setAvis(HashSet<Avis> avis) {
        this.avis = avis;
    }

    public List<Reclamation> getReclamations() {
        return reclamations;
    }

    public void setReclamations(List<Reclamation> reclamations) {
        this.reclamations = reclamations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidat)) return false;
        Candidat candidat = (Candidat) o;
        return getCin() == candidat.getCin();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCin(), getNom(), getPrenom(), getDateNaissance(), getPhoto(), getNomPartie(), getFacebook(), getTweeter(), getActivites(), getScore(), getAvis(), getReclamations());
    }

    @Override
    public void calculerScore() {
        this.score += 1;
        if (!this.facebook.isEmpty()) {
            score += 10;
        }
        if (!this.tweeter.isEmpty()) {
            score += 10;
        }
        if (!activites.isEmpty()) {
            int i = 1;
            for (Map.Entry activite : this.activites.entrySet()) {
                i++;
                if (activite.getKey() == Type.ECONOMIQUE) {
                    score += 20;
                }
                if (activite.getKey() == Type.HUMANITAIRE) {
                    score += 21;
                }
                if (activite.getKey() == Type.POLITIQUE) {
                    score += 22;
                }
                if (activite.getKey() == Type.SCIENTIFIQUE) {
                    score += 23;
                }
                if (activite.getKey() == Type.SOCIALE) {
                    score += 24;
                }
                if (activite.getKey() == Type.AUTRE) {
                    score += 19;
                }

            }
        }


    }

    @Override
    public void methodeDeCalculeDuScore() {
        System.out.println("La methode de calcule est : ");
        System.out.println("Pour avoir un compte facebook on ajoute 10 points");
        System.out.println("Pour avoir un compte tweeter on ajoute 10 points");
        System.out.println("Pour avoir une activité economique on ajoute 20 points");
        System.out.println("Pour avoir une activité humanitaire on ajoute 21 points");
        System.out.println("Pour avoir une activité politique on ajoute 22 points");
        System.out.println("Pour avoir une activité scientifique on ajoute 23 points");
        System.out.println("Pour avoir une activité sociale on ajoute 24 points");
        System.out.println("Pour avoir une activité d'autre type on ajoute 19 points");
    }

    @Override
    public boolean ajouterActivite(Type type, Activite activite) {
        if (type != null && activite != null) {
            //return this.activites.a
            activite.setCandidat(this);
            Activite activite1 = this.activites.put(type, activite);
            if (activite1 != null) {
                return true;
            }
            return true;

        }
        return false;
    }

    @Override
    public boolean modifierActivite(Type type, Activite activite) {
        if (type != null && activite != null) {
            if (this.activites.containsKey(type) == true && this.activites.containsValue(activite) == true) {
                Activite activite1 = this.activites.replace(type, activite);
                if (activite1 != null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean supprimerActivite(Type type, Activite activite) {
        if (type != null && activite != null) {
            if (activites.containsKey(type) == true && activites.containsValue(activite) == true) {
                return activites.remove(type, activite);
            }
        }
        return false;
    }


    @Override
    public void consulterActivites() {
        if (!activites.isEmpty()) {
            System.out.println("La liste des activitées du candidat Monsieur " + nom + " :");
            Design.dessinerLigne(180);
            String[] tab = new String[4];
            tab[0] = " Id |";
            tab[1] = " Duree par Seconds (S) |";
            tab[2] = " Type  D'activitée |";
            tab[3] = " Support de l'activitée ";
            System.out.println(tab[0] + tab[1] + tab[2] + tab[3]);
            Design.dessinerLigne(180);
            for (Map.Entry mapentry : this.activites.entrySet()) {
                String[] ts = new String[4];
                Activite activite = (Activite) mapentry.getValue();
                Type type = (Type) mapentry.getKey();
                ts[0] = " " + activite.getId() + "";
                ts[1] = " " + activite.getDuree() + "";
                ts[2] = " " + type.toString();
                ts[3] = " " + activite.getSupport() + "";
                int i;
                int j = 0;
                while (j < 4) {
                    i = tab[j].length() - ts[j].length();
                    i--;
                    if (i > 0) {
                        while (i > 0) {
                            ts[j] = ts[j] + " ";
                            i--;
                        }
                    }
                    if (j < 3) {
                        ts[j] = ts[j] + "|";
                    }
                    j++;
                }
                System.out.println(ts[0] + ts[1] + ts[2] + ts[3]);
                Design.dessinerLigne(180);
            }
        } else {
            System.out.println("La liste des activitées du candidat Monsieur " + nom + " est encore vide !");
        }
    }

    @Override
    public boolean ajouterReclamation(Reclamation reclamation) {
        if (reclamation != null) {
            reclamation.setCandidat(this);
            return this.reclamations.add(reclamation);
        }
        return false;
    }

    @Override
    public boolean modifierReclamation(Reclamation reclamation) {
        if (reclamation != null) {
            if (this.reclamations.contains(reclamation) == true) {
                this.reclamations.remove(reclamation);
                return this.reclamations.add(reclamation);
            }
        }
        return false;
    }

    @Override
    public boolean supprimerReclamation(Reclamation reclamation) {
        if (reclamation != null) {
            return this.reclamations.remove(reclamation);
        }
        return false;
    }

    @Override
    public void consulterReclamation() {
        if (!reclamations.isEmpty()) {
            Design.dessinerLigne(180);
            String[] tab = new String[4];
            tab[0] = " Id |";
            tab[1] = " Sujet |";
            tab[2] = " Réclamé par            |";
            tab[3] = " Justfication ";
            System.out.println(tab[0] + tab[1] + tab[2] + tab[3]);
            Design.dessinerLigne(180);
            for (Reclamation reclamation : reclamations
            ) {
                System.out.println("La liste des reclamations concernant le candidat Monsieur " + nom + " :");
                String[] ts = new String[4];
                ts[0] = " " + reclamation.getId() + "";
                ts[1] = " " + reclamation.getSujet() + "";
                ts[2] = " " + reclamation.getElecteur().getUserName();
                ts[3] = " " + reclamation.getJustification();
                int i;
                int j = 0;
                while (j < 4) {
                    i = tab[j].length() - ts[j].length();
                    i--;
                    if (i > 0) {
                        while (i > 0) {
                            ts[j] = ts[j] + " ";
                            i--;
                        }
                    }
                    if (j < 3) {
                        ts[j] = ts[j] + "|";
                    }
                    j++;
                }
                System.out.println(ts[0] + ts[1] + ts[2] + ts[3]);
                Design.dessinerLigne(180);
            }
        } else {
            System.out.println("La liste des reclamations concernant le candidat Monsieur " + nom + " est encore vide !");

        }
    }

    @Override
    public boolean ajouterAvis(Avis avis) {
        if (avis != null) {
            avis.setCandidat(this);
            return this.avis.add(avis);
        }
        return false;
    }

    @Override
    public boolean modifierAvis(Avis avis) {
        if (avis != null) {
            if (this.avis.contains(avis) == true) {
                this.avis.remove(avis);
                return this.avis.add(avis);
            }
        }
        return false;
    }

    @Override
    public boolean supprimerAvis(Avis avis) {
        if (avis != null) {
            return this.avis.remove(avis);
        }
        return false;
    }

    @Override
    public void consulterAvis() {
        if (!this.avis.isEmpty()) {
            System.out.println("La liste des avis des electeurs concernant le candidat Monsieur " + nom + " :");
            Design.dessinerLigne(180);
            String[] tab = new String[4];
            tab[0] = " Id |";
            tab[1] = " Note sur 100 |";
            tab[2] = " Noté par                     |";
            tab[3] = " Nom Candidat        ";
            System.out.println(tab[0] + tab[1] + tab[2] + tab[3]);
            Design.dessinerLigne(180);
            for (Avis avis : this.avis
            ) {

                String[] ts = new String[4];
                ts[0] = " " + avis.getId() + "";
                ts[1] = " " + avis.getNote() + "";
                ts[2] = " " + avis.getElecteur().getUserName() + "";
                ts[3] = " " + this.nom;
                int i;
                int j = 0;
                while (j < 4) {
                    i = tab[j].length() - ts[j].length();
                    i--;
                    if (i > 0) {
                        while (i > 0) {
                            ts[j] = ts[j] + " ";
                            i--;
                        }
                    }
                    if (j < 3) {
                        ts[j] = ts[j] + "|";
                    }
                    j++;
                }
                //System.out.println(ts[0] + ts[1] + ts[2] + ts[3]);
                Design.dessinerCases(ts, ts.length);
                Design.dessinerLigne(180);
            }
        } else {
            System.out.println("La liste des avis concerant le condidat Monsieur " + nom + " est vide !");
        }

    }

    @Override
    public void consulterAvisDunElecteur(Electeur electeur) {
        if (!this.avis.isEmpty()) {
            System.out.println("La liste des avis des electeurs concernant le candidat Monsieur " + nom + " :");
            Design.dessinerLigne(180);
            String[] tab = new String[4];
            tab[0] = " Id |";
            tab[1] = " Note sur 100 |";
            tab[2] = " Noté par                     |";
            tab[3] = " Nom Candidat        ";
            //System.out.println(tab[0] + tab[1] + tab[2] + tab[3]);
            Design.dessinerCases(tab, tab.length);
            Design.dessinerLigne(180);
            for (Avis avis : this.avis
            ) {
                if (avis.getElecteur().equals(electeur) == true) {
                    String[] ts = new String[4];
                    ts[0] = " " + avis.getId() + "";
                    ts[1] = " " + avis.getNote() + "";
                    ts[2] = " " + avis.getElecteur().getUserName() + "";
                    ts[3] = " " + this.nom;
                    int i;
                    int j = 0;
                    while (j < 4) {
                        i = tab[j].length() - ts[j].length();
                        i--;
                        if (i > 0) {
                            while (i > 0) {
                                ts[j] = ts[j] + " ";
                                i--;
                            }
                        }
                        if (j < 3) {
                            ts[j] = ts[j] + "|";
                        }
                        j++;
                    }
                    //System.out.println(ts[0] + ts[1] + ts[2] + ts[3]);
                    Design.dessinerCases(ts, ts.length);
                    Design.dessinerLigne(180);
                }
            }
        } else {
            System.out.println("La liste des avis concerant le condidat Monsieur " + nom + " est vide !");
        }
    }

    @Override
    public void afficherCandidat(int n, String[] tab) {
        String[] ts = new String[7];
        ts[0] = " " + n + "";
        ts[1] = " " + getCin() + "";
        ts[2] = " " + getNom() + "";
        if (getPrenom().isEmpty()) {
            ts[3] = " " + "Vide" + "";
        } else {
            ts[3] = " " + getPrenom() + "";
        }
        if (getFacebook().isEmpty()) {
            ts[4] = " " + "Vide" + "";
        } else {
            ts[4] = " " + getFacebook() + "";
        }
        if (getTweeter().isEmpty()) {
            ts[5] = " " + "Vide" + "";
        } else {
            ts[5] = " " + getTweeter() + "";
        }
        ts[6] = " " + getScore();
        int i;
        int j = 0;
        while (j < 7) {
            i = tab[j].length() - ts[j].length();
            i--;
            if (i > 0) {
                while (i > 0) {
                    ts[j] = ts[j] + " ";
                    i--;
                }
            }
            if (j < 6) {
                ts[j] = ts[j] + "|";
            }
            j++;

        }
        Design.dessinerCases(ts, ts.length);
        Design.dessinerLigne(180);
    }

    @Override
    public Reclamation chercherReclamation(int id) {
        Reclamation reclamation = new Reclamation();
        reclamation.setId(id);
        int index = reclamations.indexOf(reclamation);
        if (index > -1) {
            return reclamations.get(index);
        } else {
            return null;
        }
    }

    public void afficherCandidat() {
        int n = 1;
        String[] tab = new String[7];
        tab[0] = " Num Liste |";
        tab[1] = " Cin            |";
        tab[2] = " Nom                 |";
        tab[3] = " Prenom              |";
        tab[4] = " Compte Facebook     |";
        tab[5] = " Compte Tweeter      |";
        tab[6] = " Score";
        Design.dessinerLigne(180);
        Design.dessinerCases(tab, tab.length);
        Design.dessinerLigne(180);
        String[] ts = new String[7];
        ts[0] = " " + n + "";
        ts[1] = " " + getCin() + "";
        ts[2] = " " + getNom() + "";
        if (getPrenom().isEmpty()) {
            ts[3] = " " + "Vide" + "";
        } else {
            ts[3] = " " + getPrenom() + "";
        }
        if (getFacebook().isEmpty()) {
            ts[4] = " " + "Vide" + "";
        } else {
            ts[4] = " " + getFacebook() + "";
        }
        if (getTweeter().isEmpty()) {
            ts[5] = " " + "Vide" + "";
        } else {
            ts[5] = " " + getTweeter() + "";
        }
        ts[6] = " " + getScore();
        int i;
        int j = 0;
        while (j < 7) {
            i = tab[j].length() - ts[j].length();
            i--;
            if (i > 0) {
                while (i > 0) {
                    ts[j] = ts[j] + " ";
                    i--;
                }
            }
            if (j < 6) {
                ts[j] = ts[j] + "|";
            }
            j++;

        }
        Design.dessinerCases(ts, ts.length);
        Design.dessinerLigne(180);
    }

    @Override
    public String toString() {
        return "nom=" + nom + ",prenom=" + prenom + ",dateNaissance=" + dateNaissance + ",photo=" + photo + ",nomPartie=" + nomPartie + ",facebook=" + facebook + ",tweeter=" + tweeter + ",activites=>" + activites + ",avis=>" + avis + ",reclamations=>" + reclamations + "\n";
    }

    @Override
    public Avis chercherActivite(int id) {
        for (Avis avis : this.getAvis()
        ) {
            if (avis.getId() == id) {
                return avis;
            }
        }
        return null;
    }
}
