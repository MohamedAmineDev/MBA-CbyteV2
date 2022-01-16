package Modele;

import java.util.List;

public interface IAdministrateur {
    void ajouterListeElectoriale();

    boolean supprimerListeElectoriale(int numeroListe);

    boolean ajouterCandidat(int numeroListe, Candidat candidat);

    boolean modifierCandidat(int numeroListe, Candidat candidat);

    boolean supprimerCandidat(int numeroLite, Candidat candidat);

    boolean caluclerScoreDesCandidatDeUneListe(int numeroListe);

    Chart chartScoreParCandidat(Candidat candidat, List<Electeur> electeurs);

    Chart chartScoreParListeElectoriale(int numroListe, List<Electeur> electeurs);

    boolean ajouterCharte(Chart chart);


}
