package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface pour écrire les données des symptômes dans une destination.
 */
public interface ISymptomWriter {
  /**
  * Écrit les symptômes et leurs occurrences dans la destination.
  *
  * @param symptoms une Map contenant les symptômes et leurs occurrences.
  */
  void writeSymptoms(Map<String, Integer> symptoms);
}
