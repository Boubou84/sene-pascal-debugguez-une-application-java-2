package com.hemebiotech.analytics;

import java.util.Map;
/**
 * Anything that will write symptom data on a valid data output format
 */
public interface ISymptomWriter {
/**
* Write the given symptoms and their quantities to a file
*
* @param symptoms A map containing the symptoms and their quantities
*/
   void writeSymptoms(Map<String, Integer> symptoms);
}
