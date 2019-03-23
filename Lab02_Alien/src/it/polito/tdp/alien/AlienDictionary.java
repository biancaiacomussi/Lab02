package it.polito.tdp.alien;


import java.util.HashMap;
import java.util.*;
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
		
				//for(String t : dizionario.get(alienWord).getTraduzioni()) {
				//	if(translation.equals(t)==false) { //se devo aggiungere una traduzione
					if(!w.getTraduzioni().contains(translation))
						w.add(translation);
					//}
				//}
				
			}
		
	

	public Map<String, WordEnhanced> getDizionario() {
		return dizionario;
	}

	
	public String translate(String alienWord, AlienDictionary diz) {
		
		String risultato="";
		WordEnhanced w=diz.getDizionario().get(alienWord);
		System.out.println(w);
		System.out.println(w.getTraduzioni());
		
		if(w!=null) {
		for(String s: w.getTraduzioni()) {
			risultato += s+", ";
		}return risultato.substring(0, risultato.length()-2)+".";
		
		}else return null;
		
		
	}
}
