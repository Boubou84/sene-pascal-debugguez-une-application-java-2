package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String inputPath = "symptoms.txt";
        String outputPath = "result.out";

        ISymptomReader reader = new ReadSymptomDataFromFile(inputPath);
        ISymptomWriter writer = new WriteSymptomDataToFile(outputPath);
        ISymptomCounter counter = new SymptomCounter();

        AnalyticsCounter analytics = new AnalyticsCounter(reader, writer, counter);
        List<String> symptoms = analytics.getSymptoms();
        Map<String, Integer> symptomCounts = analytics.countSymptoms(symptoms);
        Map<String, Integer> sortedSymptomCounts = analytics.sortSymptoms(symptomCounts);
        analytics.writeSymptoms(sortedSymptomCounts);
    }
}
