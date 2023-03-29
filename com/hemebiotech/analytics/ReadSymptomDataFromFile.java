package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
      BufferedReader reader = null;
			try {
				 reader = new BufferedReader (new FileReader(filepath));
				 String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				System.out.println("Erreur lors de la lecture des symptômes: Veuillez vérifier l'emplacement du fichier ");
			}
			finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        Collections.sort(result); // Tri la liste des symptôms par ordre alphabétique ! 
        return result;
    }

private Map<String, Integer> countSymptomOccurrences(List<String> symptoms) {
		Map<String, Integer> symptomOccurrences = new TreeMap<>();

		for (String symptom : symptoms) {
			symptomOccurrences.put(symptom, symptomOccurrences.getOrDefault(symptom, 0) + 1);
		}
		
    System.out.println("Occurrences des symptômes comptées : " + symptomOccurrences);
    return symptomOccurrences;
	}

	public static void main(String[] args) {
		ReadSymptomDataFromFile symptomReader = new ReadSymptomDataFromFile("Symptoms.txt");
		List<String> symptoms = symptomReader.getSymptoms();
		System.out.println("Symptômes lus depuis le fichier : " + symptoms);

		Map<String, Integer> symptomOccurrences = symptomReader.countSymptomOccurrences(symptoms);

		WriteSymptomDataToFile symptomWriter = new WriteSymptomDataToFile("result.out");
		symptomWriter.writeSymptoms(symptomOccurrences);
    		System.out.println("Symptômes et occurrences écrits dans le fichier de sortie");
	}
}




