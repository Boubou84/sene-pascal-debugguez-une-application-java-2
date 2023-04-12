package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Implémentation simple pour écrire les données de symptômes dans un fichier.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
  private String filepath;

  /**
   * Constructeur.
   *
   * @param filepath un chemin d'accès complet ou partiel vers le fichier où les données des
   *                 symptômes seront écrites.
   */
  public WriteSymptomDataToFile(String filepath) {
    this.filepath = filepath;
  }

  @Override
  public void writeSymptoms(Map<String, Integer> symptoms) {
    if (filepath != null && symptoms != null) {
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
        for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
          writer.write(entry.getKey() + ": " + entry.getValue());
          writer.newLine();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
