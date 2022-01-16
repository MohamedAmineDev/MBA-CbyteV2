package Donnees;

import Modele.Chart;
import Modele.ListeElectoriale;

import java.util.List;

public interface IManipulatationDeDonnes {
    boolean sauvegarderListeElectoriale(String nomFichier,ListeElectoriale liste);

    ListeElectoriale chargerListeElectoriale(String nomFichier);

    boolean sauvegarderCharts(String nomFichier,List<Chart>charts);

    List<Chart> chargerCharts(String nomFichier);
}
