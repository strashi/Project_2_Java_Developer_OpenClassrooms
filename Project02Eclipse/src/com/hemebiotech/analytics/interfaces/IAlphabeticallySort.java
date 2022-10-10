package com.hemebiotech.analytics.interfaces;

import java.util.Map;
/**
 * Anything that will order data alphabetically.
 * 
 * @param Map alphabetically unordered.
 * @return Map alphabetically ordered.
 * 
 * @author steve
 *
 */
public interface IAlphabeticallySort {
	Map<String, Integer> alphabeticallySort(Map<String, Integer> map);
}
