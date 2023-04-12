package com.hemebiotech.analytics;

import java.util.List;

/**
 * Interface pour lire les données des symptômes à partir d'une source.
 *
 * <p>L'implémentation n'a pas besoin de trier la liste.
 */
public interface ISymptomReader {
  /**
  * Si aucune donnée n'est disponible, retourne une liste vide.
  *
  * @return une liste brute de tous les symptômes obtenus à partir d'une source de données,
  *         les doublons sont possibles/probables
  */
  List<String> getSymptoms();
}
