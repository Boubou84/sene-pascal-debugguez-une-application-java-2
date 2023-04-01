package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Cette classe est utilisée pour analyser et traiter les symptômes.
 */
public class AnalyticsCounter {
  private ISymptomReader reader;
  private ISymptomWriter writer;
  private ISymptomCounter counter;

  /**
   * Constructeur avec tous les composants fournis.
   *
   * @param reader   Un lecteur de symptômes
   * @param writer   L'ecriture de symptômes
   * @param counter  Un compteur de symptômes
   */
  public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer, ISymptomCounter counter) {
    this.reader = reader;
    this.writer = writer;
    this.counter = counter;
  }

  /**
   * Constructeur avec lecture et écriture fournis, mais avec compteur par défaut.
   *
   * @param reader Lecture des symptômes
   * @param writer Ecriture des symptômes
   */
  public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
    this.reader = reader;
    this.writer = writer;
    // Créez une nouvelle instance de SymptomCounter par défaut
    this.counter = new SymptomCounter();
  }

  /**
   * Récupère la liste des symptômes.
   *
   * @return Une liste de symptômes
   */
  public List<String> getSymptoms() {
    return reader.getSymptoms();
  }

  /**
   * Compte les occurrences de chaque symptôme dans la liste.
   *
   * @param symptoms Une liste de symptômes
   * @return Une carte de symptômes et de leurs occurrences
   */
  public Map<String, Integer> countSymptoms(List<String> symptoms) {
    return counter.countSymptoms(symptoms);
  }

  /**
   * Trie les symptômes par ordre alphabétique.
   *
   * @param symptoms Une carte de symptômes et de leurs occurrences
   * @return Une carte triée de symptômes et de leurs occurrences
   */
  public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
    return new TreeMap<>(symptoms);
  }

  /**
   * Écrit les symptômes et leurs occurrences dans un fichier.
   *
   * @param symptoms Une carte de symptômes et de leurs occurrences
   */
  public void writeSymptoms(Map<String, Integer> symptoms) {
    writer.writeSymptoms(symptoms);
  }

  /**
   * Traite les symptômes en les lisant, les comptant, les triant et en les écrivant.
   */
  public void processSymptoms() {
    List<String> symptoms = getSymptoms();
    Map<String, Integer> symptomCounts = countSymptoms(symptoms);
    Map<String, Integer> sortedSymptoms = sortSymptoms(symptomCounts);
    writeSymptoms(sortedSymptoms);
  }
}
