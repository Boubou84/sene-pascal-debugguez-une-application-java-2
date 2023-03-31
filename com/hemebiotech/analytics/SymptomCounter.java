package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymptomCounter implements ISymptomCounter {

    @Override
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomOccurrences = new HashMap<>();

        for (String symptom : symptoms) {
            symptomOccurrences.put(symptom, symptomOccurrences.getOrDefault(symptom, 0) + 1);
        }

        return symptomOccurrences;
    }
}
