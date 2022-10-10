package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.implement.AlphabeticallySort;
import com.hemebiotech.analytics.implement.NumberOfOccurrencesCounter;
import com.hemebiotech.analytics.implement.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.implement.ResultWriter;
import com.hemebiotech.analytics.interfaces.IAlphabeticallySort;
import com.hemebiotech.analytics.interfaces.INumberOfOccurrencesCounter;
import com.hemebiotech.analytics.interfaces.IResultWriter;
import com.hemebiotech.analytics.interfaces.ISymptomReader;
/**
 * The main class of the application. The launch will produce the file of results.
 * 
 * 
 * @author steve
 *
 */
public class AnalyticsCounter {
		
	public static void main(String args[]) {
			
		ISymptomReader fileReader = new ReadSymptomDataFromFile("symptoms.txt");
		
		// put the symptoms in a list
		List<String> rawListOfSymptoms = fileReader.getSymptoms();
		
		// transfer in a map the symptoms by counting them and removing duplicates
		INumberOfOccurrencesCounter occurrencesCounter = new NumberOfOccurrencesCounter();
		Map<String,Integer> unorderedCountedSymptomMap =occurrencesCounter.numberOfOccurrences(rawListOfSymptoms);
		
		// sort the map alphabetically
		IAlphabeticallySort as = new AlphabeticallySort();
		Map<String,Integer> orderedCountedSymptomMap = as.alphabeticallySort(unorderedCountedSymptomMap);
		
		IResultWriter resultWriter = new ResultWriter(orderedCountedSymptomMap,"result.out");
		resultWriter.resultWriter();
		
	}
}
