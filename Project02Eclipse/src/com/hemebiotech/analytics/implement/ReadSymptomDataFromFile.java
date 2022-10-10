package com.hemebiotech.analytics.implement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hemebiotech.analytics.interfaces.ISymptomReader;

/**
 * read symptoms from file
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 *  
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 * 
	 * @return a raw list of symptoms.
	 */
	
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> getSymptoms()  {
		ArrayList<String> result = new ArrayList<String>();
		
			if (filepath != null) {
				try {
					BufferedReader reader = new BufferedReader (new FileReader(filepath));
					String line = reader.readLine();
					
					// variable to detect an empty file
					boolean emptyFile = true;
							
					while (line != null) {
						result.add(line);
						line = reader.readLine();
						emptyFile = false;						
					}
					reader.close();
					
					if (emptyFile) {
						throw new EmptyFileException();					
					}
				
				}catch (FileNotFoundException e) {
					System.out.println("Fichier " + filepath + " introuvable");	
				}catch (EmptyFileException e) {
					System.out.println("Le fichier est vide");								
				}catch (IOException e) {
					System.out.println("Un problème est survenu : " + e.getMessage());	
				}
			}		
			
		return result;
	}
	
	// -------------- Getter and Setter ---------------//
	
	public String getFilePath() {
		return filepath;
	}
	public void setFilePath(String filepath) {
		this.filepath = filepath;
	}

}
