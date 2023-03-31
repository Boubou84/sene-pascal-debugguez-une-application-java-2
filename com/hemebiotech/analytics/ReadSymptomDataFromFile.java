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

}




