package Modele;

import Design.Design;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public abstract class Utilisateur extends Compte implements IUtilisateur, Serializable {
    private static final long serialVersionUID = 1L;
    private static int dernierId;
    private int id;

    private List<ListeElectoriale> listeElectorale;
    private HashSet<Chart> charts;

    public Utilisateur() {
        dernierId++;
        id = dernierId;
        this.listeElectorale = new ArrayList<>();
        charts = new HashSet<>();
    }


    public List<ListeElectoriale> getListeElectorale() {
        return listeElectorale;
    }

    public void setListeElectorale(List<ListeElectoriale> listeElectorale) {
        this.listeElectorale = listeElectorale;
    }

    public HashSet<Chart> getCharts() {
        return charts;
    }

    public void setCharts(HashSet<Chart> charts) {
        this.charts = charts;
    }

    @Override
    public String toString() {
        return super.toString() + "" + listeElectorale + "" + charts;
    }

    @Override
    public void consulterListeElectorales() {
        /*if (nombreDeListes() > 0) {
            int n;
            n = 0;
            System.out.println("Les listes electoriales sont :");
            for (HashSet<Candidat> candidats : listeElectorale
            ) {
                //System.out.println();
                n++;
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
                for (Candidat candidat : candidats
                ) {
                    candidat.afficherCandidat(n, tab);
                }
            }
        } else {
            System.out.println("Les listes electoriale sont vides !");
        }
*/
        if (!getListeElectorale().isEmpty()) {
            //System.out.println("La liste des listes :");
            /*String[] tab = new String[7];
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
            int i = 1;
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
            for (ListeElectoriale liste : listeElectorale
            ) {
                // System.out.println("Liste numéro '" + (i + 1) + "'\n");
                liste.consulterCandidats(i);
                //System.out.println("---------------");
                //System.out.println("");
                i++;
            }
            //Design.dessinerLigne(180);
            System.out.println("");
        } else {
            System.out.println("Les listes electoriales sont vides !!!");
        }
    }


    @Override
    public void consulterCharteNombreScore(Candidat candidat) {
        if (!candidat.getAvis().isEmpty()) {
            String[] tab = new String[4];
            tab[0] = "| Cin Candidat            |";
            tab[1] = " Nom Candidat |";
            tab[2] = " Noté par                     |";
            tab[3] = " Note (Score)        ";
            Design.dessinerLigne(180);
            Design.dessinerCases(tab, tab.length);
            Design.dessinerLigne(180);
            for (Avis avis : candidat.getAvis()
            ) {
                String[] ts = new String[4];
                ts[0] = "| " + candidat.getCin() + "";
                ts[1] = " " + candidat.getNom() + "";
                ts[2] = " " + avis.getElecteur().getUserName() + "";
                ts[3] = " " + avis.getNote();
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
                Design.dessinerCases(ts, ts.length);
                Design.dessinerLigne(180);
            }
        } else {
            System.out.println("La listes des avis est vide !!!");
        }
    }

    @Override
    public int nombreDeListes() {
        return listeElectorale.size();
    }

    @Override
    public ListeElectoriale chercherListe(int index) {
        return listeElectorale.get(index);
    }

    @Override
    public Candidat chercherCandidat(int numListe, int cin) {
        return this.chercherListe(numListe).chercherCandidat(cin);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Utilisateur)) return false;
        Utilisateur that = (Utilisateur) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public Chart chercherCharte(Candidat candidat, int numListe) {
        for (Chart chart : charts
        ) {
            if (chart.getCandidat().equals(candidat) && chart.getNumListe() == numListe) {
                return chart;
            }
        }
        return null;
    }
}

