package Modele;

import java.util.List;

public interface IUtilisateur {
    boolean seAuthentifier(String email, String motDePasse);

    void consulterListeElectorales();

    int nombreDeListes();

    void consulterCharteNombreScore(Candidat candidat);

    ListeElectoriale chercherListe(int index);

    Candidat chercherCandidat(int numListe, int cin);

    Chart chercherCharte(Candidat candidat, int numListe);

}
