package Implementation;

import Modele.Candidat;
import Modele.Electeur;

public interface IApplication {
    void applicationPrincipale();

    void menuPrincipale();

    void versionAdministrateur();

    void versionElecteur(Electeur electeur);

    void versionCandidat(Candidat candidat, int index);
}
