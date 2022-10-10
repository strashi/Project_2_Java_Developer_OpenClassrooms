package com.hemebiotech.analytics.interfaces;

import java.util.List;
import java.util.Map;

/**
 * Anything that will be able to take datas from a source, to put it in
 * a place with a count of occurrences and to cancel duplicated symptom.
 * 
 * There is no duplication more but it is alphabetically unordered 
 * 
 * 
 * @author steve
 *
 */
public interface INumberOfOccurrencesCounter {
	/**
	 * 
	 * @return a map with symptom as key without duplicates and number of occurrences as value
	 * 
	 * @author steve
	 *
	 */	
	Map<String, Integer> numberOfOccurrences(List<String> list);
}
