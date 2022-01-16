package Donnees;

import Modele.Candidat;
import Modele.Chart;
import Modele.ListeElectoriale;

import java.io.*;
import java.util.List;

public class ManipulationDeDonnes implements IManipulatationDeDonnes {

    @Override
    public boolean sauvegarderListeElectoriale(String nomFichier, ListeElectoriale liste) {

        File fichier = new File(nomFichier);
        if (!fichier.exists()) {
            try {
                fichier.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!liste.getCandidatList().isEmpty()) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(fichier);
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    for (Candidat candidat : liste.getCandidatList()
                    ) {
                        objectOutputStream.writeObject(candidat);
                    }
                    objectOutputStream.close();
                    fileOutputStream.close();
                } catch (IOException e) {
                    return false;
                    //e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                return false;
                //e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public ListeElectoriale chargerListeElectoriale(String nomFichier) {
        File fichier = new File(nomFichier);
        if (fichier.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(fichier);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Candidat candidat = null;
                ListeElectoriale listeElectoriale = new ListeElectoriale();
                /*do {
                    candidat = (Candidat) objectInputStream.readObject();
                    listeElectoriale.ajouterCandidat(candidat);
                }
                while (candidat != null);*/
                while(null !=  objectInputStream.readObject()){
                    //candidat=(Candidat) objectInputStream.readObject();
                    listeElectoriale.ajouterCandidat(candidat);
                }
                objectInputStream.close();
                fileInputStream.close();
                return listeElectoriale;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override
    public boolean sauvegarderCharts(String nomFichier, List<Chart> charts) {
        return false;
    }

    @Override
    public List<Chart> chargerCharts(String nomFichier) {
        return null;
    }
}
