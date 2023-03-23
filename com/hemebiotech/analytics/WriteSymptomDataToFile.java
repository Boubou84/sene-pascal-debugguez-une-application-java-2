package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filepath;

    /**
     * Default constructor with a default file path.
     */
    public WriteSymptomDataToFile() {
        this.filepath = "default_output_path.txt";
    }

    /**
     * @param filepath A complete or partial path to a file where the symptoms and their
     *                 quantities will be written, one per line
     */
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        if (filepath != null && symptoms != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
                for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                    writer.write(entry.getKey() + ": " + entry.getValue());
                    writer.newLine();
                }
            } catch (IOException e) {
                System.err.println("Error while writing symptoms to file : " + e.getMessage());
            }
        }
    }
}
