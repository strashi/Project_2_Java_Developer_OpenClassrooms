package com.hemebiotech.analytics.implement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.interfaces.INumberOfOccurrencesCounter;

/**
 * Count the number of occurrences from a list and return a map with symptoms without duplicates as key and
 * number of occurrences as value
 *  
 * @param List of symptom
 * @return Map with symptom as key without duplicates and number of occurrences as value
 * 
 * @author steve
 *
 */
public class NumberOfOccurrencesCounter implements INumberOfOccurrencesCounter{
	@Override
	public Map<String, Integer> numberOfOccurrences(List<String> symptomList) {
		
		HashMap<String, Integer> numberOccurrencesList = new HashMap<String, Integer>();
		
		// read symptom from list, compare if symptom is already in map and put it with the 
		// correct number of occurrences 
		
		for (String symptom : symptomList) {
			if (numberOccurrencesList.containsKey(symptom)) {
				int count = numberOccurrencesList.get(symptom);
				count++;
				numberOccurrencesList.replace(symptom, count);
			}else {
				numberOccurrencesList.put(symptom, 1);
			}
		}
		
		return numberOccurrencesList;
	}
}
