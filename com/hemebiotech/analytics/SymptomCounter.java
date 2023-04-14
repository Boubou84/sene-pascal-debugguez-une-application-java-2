package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Cette classe implémente l'interface ISymptomCounter pour compter les occurrences
 * des symptômes dans une liste de chaînes de caractères.
 */
public class SymptomCounter implements ISymptomCounter {
	
	/**
     * Compte les occurrences de chaque symptôme dans la liste de symptômes fournie.
     *
     * @param symptoms une liste de chaînes de caractères représentant les symptômes.
     * @return une Map<String, Integer> contenant les symptômes en tant que clés et
     * le nombre d'occurrences en tant que valeurs.
     */
  // Créer une nouvelle HashMap pour stocker les occurrences des symptômes</p>
  @Override
  public Map<String, Integer> countSymptoms(List<String> symptoms) {
  Map<String, Integer> symptomOccurrences = new HashMap<>();

  // Pour chaque symptôme dans la liste de symptômes</p>
  for (String symptom : symptoms) {
            
  // Ajouter le symptôme à la HashMap et incrémenter le compteur d'occurrences</p>
  symptomOccurrences.put(symptom, symptomOccurrences.getOrDefault(symptom, 0) + 1);
  }

  // Retourner la HashMap contenant les occurrences des symptômes</p>
  return symptomOccurrences;
  }
}
