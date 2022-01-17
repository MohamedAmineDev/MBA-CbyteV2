package Modele;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

public class Administrateur extends Utilisateur implements IAdministrateur {

    public Administrateur() {
        super();
    }



    @Override
    public void ajouterListeElectoriale() {
        this.getListeElectorale().add(new ListeElectoriale());
    }

    @Override
    public boolean supprimerListeElectoriale(int numeroListe) {
        if (numeroListe < this.nombreDeListes()) {
            return this.getListeElectorale().remove(this.getListeElectorale().get(numeroListe));
        }
        return false;
    }

    @Override
    public boolean ajouterCandidat(int numeroListe, Candidat candidat) {
        if (numeroListe < this.nombreDeListes() && candidat != null) {
            return this.getListeElectorale().get(numeroListe).ajouterCandidat(candidat);
        }
        return false;
    }

    @Override
    public boolean modifierCandidat(int numeroListe, Candidat candidat) {
        if (numeroListe < this.nombreDeListes() && candidat != null) {
            return getListeElectorale().get(numeroListe).modifierCandidat(candidat);
        }
        return false;
    }

    @Override
    public boolean supprimerCandidat(int numeroLite, Candidat candidat) {
        if (numeroLite < this.nombreDeListes() && candidat != null) {
            return getListeElectorale().get(numeroLite).supprimerCandidat(candidat);
        }
        return false;
    }


    @Override
    public boolean caluclerScoreDesCandidatDeUneListe(int numeroListe) {
        if (numeroListe < nombreDeListes()) {
            getListeElectorale().get(numeroListe).scoreDeLaListe();
            return true;
        }
        return false;
    }

    @Override
    public Chart chartScoreParCandidat(Candidat candidat, List<Electeur> electeurs) {
        double score = 0;
        if (!candidat.getAvis().isEmpty()) {
            for (Avis avis : candidat.getAvis()
            ) {
                score += avis.getNote();
                //System.out.println(score);
            }
            score = score / electeurs.size();
            System.out.println(score);
            //System.out.println("Score de Monsieur  " + candidat.getNom() + " : " + score + "%");
            return new Chart("Chart de Monsieur " + candidat.getNom(), score, candidat, 0);
        } else {
            return null;
        }
    }

    @Override
    public Chart chartScoreParListeElectoriale(int numroListe, List<Electeur> electeurs) {
        double score = 0;
        if (numroListe < nombreDeListes()) {
            ListeElectoriale candidats = getListeElectorale().get(numroListe);
            return new Chart("Score de la liste electoriale numéro " + numroListe, candidats.getScore(), null, numroListe);
        }
        return null;
    }


    @Override
    public boolean ajouterCharte(Chart chart) {
        if (chart != null) {
            return this.getCharts().add(chart);
        }
        return false;
    }
}

