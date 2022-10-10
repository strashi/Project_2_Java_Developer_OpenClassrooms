package com.hemebiotech.analytics.implement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import com.hemebiotech.analytics.interfaces.IResultWriter;

public class ResultWriter implements IResultWriter{
	/**
	 * Write the results in a output file.
	 * 
	 * @param Map, String of the output file
	 * 
	 * @author steve
	 *
	 */
	private String outPutFilePath ;
	private Map<String, Integer> map ;
	
	public ResultWriter(Map<String, Integer> map, String outPutFilePath)  {
		this.map = map ;
		this.outPutFilePath = outPutFilePath;		
	}
	
	@Override
	public void resultWriter() {		
		
		try {
			Iterator<String> it = map.keySet().iterator();
			FileWriter writer = new FileWriter (outPutFilePath);
		
			// write result in a file by parsing the number of character to adjust the
			//tabulations
			while (it.hasNext()) {
				String str = it.next();
				if (str.length()<= 4) {
					writer.write("Symptom : " + str + " \t\t\t\t " + map.get(str) + " time(s) \n");
				}else if (str.length()>= 14) {
					writer.write("Symptom : " + str + " \t\t " + map.get(str) + " time(s) \n");
				}else {
					writer.write("Symptom : " + str + " \t\t\t " + map.get(str) + " time(s) \n");
				}
			}
			
			writer.close();
			
		}catch (IOException e) {
				e.printStackTrace();
		}
	}
	
	// -------------- Getters and Setters ---------------//
	
	public String getOutFilePath() {
		return outPutFilePath;
	}
	
	public Map<String, Integer> getMap() {
		return map;
	}
	
	public void setOutFilePath (String outPutFilePath) {
		this.outPutFilePath = outPutFilePath;
	}
	
	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}
}
