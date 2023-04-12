package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Interface pour compter les occurrences des symptômes
 */
public interface ISymptomCounter {
  /**
  * Compte les occurrences des symptômes dans la liste fournie
  * 
  * @param symptoms une liste de symptômes, possiblement avec des doublons
  * @return une Map avec les symptômes en clés et leurs occurrences en valeurs
  */
    Map<String, Integer> countSymptoms(List<String> symptoms);
}
