package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
    private ISymptomReader reader;
    private ISymptomWriter writer;
    private ISymptomCounter counter;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer, ISymptomCounter counter) {
        this.reader = reader;
        this.writer = writer;
        this.counter = counter;

    }

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
        this.counter = new SymptomCounter(); // Créez une nouvelle instance de SymptomCounter par défaut
    }

    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        return counter.countSymptoms(symptoms);
    }

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms);
    }

    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }

    public void processSymptoms() {
        List<String> symptoms = getSymptoms();
        Map<String, Integer> symptomCounts = countSymptoms(symptoms);
        Map<String, Integer> sortedSymptoms = sortSymptoms(symptomCounts);
        writeSymptoms(sortedSymptoms);
    }

}
