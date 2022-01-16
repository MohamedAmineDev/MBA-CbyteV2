package Modele;

public interface IListeElectoriale {
    void scoreDeLaListe();

    Candidat chercherCandidat(int cin);
    boolean ajouterCandidat(Candidat candidat);
    boolean modifierCandidat(Candidat candidat);
    boolean supprimerCandidat(Candidat candidat);
    void consulterCandidats();
}
