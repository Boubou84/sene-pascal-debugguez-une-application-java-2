package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
  * Implémentation de l'interface ISymptomReader pour lire
  * les symptômes à partir d'un fichier.
  */
public class ReadSymptomDataFromFile implements ISymptomReader {
  private String filepath;

  /**
  * Constructeur.
  *
  * @param filepath un chemin vers la liste des symptômes.
  */
  public ReadSymptomDataFromFile(String filepath) {
    this.filepath = filepath;
  }

  @Override
  public List<String> getSymptoms() {
    ArrayList<String> result = new ArrayList<String>();

    if (filepath != null) {
      try {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line = reader.readLine();

        // Lire les lignes du fichier et les ajouter à la liste
        while (line != null) {
          result.add(line);
          line = reader.readLine();
        }
        // Fermer le lecteur
        reader.close();
      } catch (IOException e) {
        // Imprimer la trace de la pile en cas d'exception
        e.printStackTrace();
      }
    }

    return result;
  }
}
