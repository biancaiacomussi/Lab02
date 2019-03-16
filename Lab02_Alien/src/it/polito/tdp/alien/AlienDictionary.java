package it.polito.tdp.alien;

import java.awt.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class AlienDictionary {
	
	private Map <String, WordEnhanced> dizionario;
	
	public AlienDictionary() {
		dizionario = new HashMap<String, WordEnhanced>();
	}
	
	public void add(String alienWord, String translation) {
		
		WordEnhanced w=null;
	
		if(dizionario.containsKey(alienWord)==false) {
				w = new WordEnhanced(alienWord);
				dizionario.put(alienWord, w);
			}
			
		w=dizionario.get(alienWord);
		
				for(String t : dizionario.get(alienWord).getTraduzioni()) {
					if(translation.equals(t)==false) { //se devo aggiungere una traduzione
						
						w.add(translation);
					}
				}
				
			}
		
	

	public String translate(String alienWord) {
		
		String risultato=null;
		WordEnhanced w=dizionario.get(alienWord);
		
		if(w!=null) {
		for(String s: w.getTraduzioni()) {
			risultato += s+"\n";
		}return risultato;
		
		}else return null;
		
		
	}
}
