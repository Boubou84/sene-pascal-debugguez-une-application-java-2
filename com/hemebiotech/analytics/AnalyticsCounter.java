package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
  private ISymptomReader reader;
  private ISymptomWriter writer;
  private ISymptomCounter counter;

  /**
   * Constructeur avec trois objets.
   *
   * @param reader   L'objet de lecture des symptômes.
   * @param writer   L'objet d'écriture des symptômes.
   * @param counter  L'objet de comptage des symptômes.
   */
  public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer, ISymptomCounter counter) {
    this.reader = reader;
    this.writer = writer;
    this.counter = counter;
  }

  /**
   * Constructeur avec deux objets et une instance par défaut de SymptomCounter.
   *
   * @param reader  L'objet de lecture des symptômes.
   * @param writer  L'objet d'écriture des symptômes.
   */
  public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
    this.reader = reader;
    this.writer = writer;
    this.counter = new SymptomCounter(); // Crée une nouvelle instance de SymptomCounter par défaut
  }

  // Récupérer la liste des symptômes
  public List<String> getSymptoms() {
    return reader.getSymptoms();
  }

  // Compter les symptômes
  public Map<String, Integer> countSymptoms(List<String> symptoms) {
    return counter.countSymptoms(symptoms);
  }

  // Trier les symptômes
  public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
    return new TreeMap<>(symptoms);
  }

  // Écrire les symptômes
  public void writeSymptoms(Map<String, Integer> symptoms) {
    writer.writeSymptoms(symptoms);
  }
}
