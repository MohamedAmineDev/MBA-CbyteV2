package Implementation;

import Modele.Electeur;

public interface IApplication {
    void applicationPrincipale();

    void menuPrincipale();

    void versionAdministrateur();

    void versionElecteur(Electeur electeur);

    void versionCandidat();
}
