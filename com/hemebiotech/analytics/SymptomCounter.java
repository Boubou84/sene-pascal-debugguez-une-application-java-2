package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymptomCounter implements ISymptomCounter {

    @Override
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        // <p>Créer une nouvelle HashMap pour stocker les occurrences des symptômes</p>
        Map<String, Integer> symptomOccurrences = new HashMap<>();

        // <p>Pour chaque symptôme dans la liste de symptômes</p>
        for (String symptom : symptoms) {
            // <p>Ajouter le symptôme à la HashMap et incrémenter le compteur d'occurrences</p>
            symptomOccurrences.put(symptom, symptomOccurrences.getOrDefault(symptom, 0) + 1);
        }

        // <p>Retourner la HashMap contenant les occurrences des symptômes</p>
        return symptomOccurrences;
    }
}
