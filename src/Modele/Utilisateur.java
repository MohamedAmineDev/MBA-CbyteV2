package Modele;

import Design.Design;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public abstract class Utilisateur implements IUtilisateur, Serializable {
    private static final long serialVersionUID = 1L;
    private String userName;
    private String password;
    private List<ListeElectoriale> listeElectorale;
    private HashSet<Chart> charts;

    public Utilisateur() {
        this.listeElectorale = new ArrayList<>();
    }

    public Utilisateur(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Utilisateur)) return false;
        Utilisateur that = (Utilisateur) o;
        return Objects.equals(getUserName(), that.getUserName()) && Objects.equals(getPassword(), that.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getPassword());
    }

    @Override
    public String toString() {
        return "username=" + userName + ",password=" + password + "" + listeElectorale + "" + charts;
    }

    @Override
    public boolean seAuthentifier(String email, String motDePasse) {
        return false;
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
            int i = 0;
            for (ListeElectoriale liste : listeElectorale
            ) {
                // System.out.println("Liste numéro '" + (i + 1) + "'\n");
                liste.consulterCandidats();
                //System.out.println("");
                i++;
            }
            Design.dessinerLigne(180);
            System.out.println("");
        } else {
            System.out.println("Les listes electoriales sont vides !!!");
        }
    }

    @Override
    public boolean sauvegarderCandidats(String lienFichierCandidat) {
      /*  try {
            FileOutputStream ecritureFichier = new FileOutputStream(lienFichierCandidat);
            ObjectOutputStream ecriture = new ObjectOutputStream(ecritureFichier);
            for (HashSet<Candidat> candidats : listeElectorale
            ) {
                for (Candidat candidat : candidats
                ) {
                    ecriture.writeObject(candidat);
                }
            }
            System.out.println("Sauvegarde terminé !");
            ecriture.close();
        } catch (Exception exception) {
            System.out.println("Echec de sauvegarde !");
            System.out.println(exception.getMessage());
        }*/
        return false;
    }

    @Override
    public void chargerCandidats(String lienFichierCandidat) {
        File file = new File(lienFichierCandidat);
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            BufferedReader reader1 = new BufferedReader(reader);
            String ch = reader1.readLine();
            while (ch != null) {
                System.out.println(ch);
                ch = reader1.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
}

