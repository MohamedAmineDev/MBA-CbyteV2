package Modele;

import Enumeration.Type;

public interface ICandidat {
    void calculerScore();

    void methodeDeCalculeDuScore();

    boolean ajouterActivite(Type type, Activite activite);

    boolean modifierActivite(Type type, Activite activite);

    boolean supprimerActivite(Type type, Activite activite);

    Avis chercherActivite(int id);

    void consulterActivites();

    boolean ajouterReclamation(Reclamation reclamation);

    boolean modifierReclamation(Reclamation reclamation);

    boolean supprimerReclamation(Reclamation reclamation);

    Reclamation chercherReclamation(int id);

    void consulterReclamation();

    boolean ajouterAvis(Avis avis);

    boolean modifierAvis(Avis avis);

    boolean supprimerAvis(Avis avis);

    void consulterAvis();

    void consulterAvisDunElecteur(Electeur electeur);

    void afficherCandidat(int n, String[] tab);


}
