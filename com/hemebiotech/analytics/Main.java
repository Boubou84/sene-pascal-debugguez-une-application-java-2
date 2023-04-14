package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Classe principale du programme, elle lit la liste des symptômes depuis un fichier texte
 * utilise la classe AnalyticsCounter pour compter le nombre d'occurrences de chaque symptôme
 * puis écrit les résultats dans le fichier de sortie.
 */
public class Main {

  public static void main(String[] args) {
    // Définir les chemins des fichiers d'entrée et de sortie
    String inputPath = "symptoms.txt";
    String outputPath = "result.out";

    // Créer les instances des classes nécessaires
    ISymptomReader reader = new ReadSymptomDataFromFile(inputPath);
    ISymptomWriter writer = new WriteSymptomDataToFile(outputPath);
    ISymptomCounter counter = new SymptomCounter();

    // Créer une instance de la classe AnalyticsCounter
    AnalyticsCounter analytics = new AnalyticsCounter(reader, writer, counter);

    // Récupérer la liste des symptômes et compter leurs occurrences
    List<String> symptoms = analytics.getSymptoms();
    Map<String, Integer> symptomCounts = analytics.countSymptoms(symptoms);

    // Trier les symptômes par ordre alphabétique
    Map<String, Integer> sortedSymptomCounts = analytics.sortSymptoms(symptomCounts);

    // Écrire les symptômes triés et leurs occurrences dans le fichier de sortie
    analytics.writeSymptoms(sortedSymptomCounts);
  }
}
