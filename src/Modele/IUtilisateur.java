package Modele;

import java.util.List;

public interface IUtilisateur {
    boolean seAuthentifier(String email, String motDePasse);

    boolean sauvegarderCandidats(String lienFichierCandidat);

    void chargerCandidats(String lienFichierCandidat);

    void consulterListeElectorales();

    int nombreDeListes();

    void consulterCharteNombreScore(Candidat candidat);

    ListeElectoriale chercherListe(int index);

    Candidat chercherCandidat(int numListe,int cin);

}
