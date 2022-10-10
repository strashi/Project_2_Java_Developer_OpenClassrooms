package com.hemebiotech.analytics.implement;

import java.util.Map;
import java.util.TreeMap;

import com.hemebiotech.analytics.interfaces.IAlphabeticallySort;

/**
 * @param a map alphabetically unordered.
 * @result a treemap alphabetically ordered.
 * 
 * @author steve
 *
 */
public class AlphabeticallySort implements IAlphabeticallySort {
	@Override
	public Map<String, Integer> alphabeticallySort(Map<String, Integer> map) {
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>(map);
		return tm ;
	}
}
