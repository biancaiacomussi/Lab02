package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class WordEnhanced {

	private String alienWord;
	private List<String> traduzioni;
	
	
	public WordEnhanced(String alienWord) {
		traduzioni = new LinkedList<String>();
		this.alienWord = alienWord;
	}


	public String getAlienWord() {
		return alienWord;
	}


	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}


	public List<String> getTraduzioni() {
		return traduzioni;
	}
	
	public void add(String t) {
		traduzioni.add(t);
	}

}