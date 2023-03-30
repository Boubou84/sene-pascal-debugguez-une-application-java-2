package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
    private ISymptomReader reader;
    private ISymptomWriter writer;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomCounts = new HashMap<>();
        for (String symptom : symptoms) {
            symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
        }
        return symptomCounts;
    }

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms);
    }

    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }

    public static void main(String[] args) {
        String inputPath = "symptoms.txt";
        String outputPath = "result.out";
        ISymptomReader reader = new ReadSymptomDataFromFile(inputPath);
        ISymptomWriter writer = new WriteSymptomDataToFile(outputPath);
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        List<String> symptoms = counter.getSymptoms();
        System.out.println("Les symptômes: " + symptoms);

        Map<String, Integer> symptomCounts = counter.countSymptoms(symptoms);
        System.out.println("Comptent les symptômes: " + symptomCounts);

        Map<String, Integer> sortedSymptomCounts = counter.sortSymptoms(symptomCounts);
        System.out.println("Nombre de symptômes triés: " + sortedSymptomCounts);

        counter.writeSymptoms(sortedSymptomCounts);
        System.out.println("Symptômes écrits dans le fichier de sortie");
    }
}
