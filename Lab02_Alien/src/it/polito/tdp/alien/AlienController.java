package it.polito.tdp.alien;

import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ResourceBundle;
import java.util.*;

import com.sun.javafx.collections.MappingChange.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	private HashMap <String, String> parole =  new HashMap<String,String>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtWord;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtMessaggi;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void doTranslate(ActionEvent event) {

    	//this.txtMessaggi.clear();
    	String parola = this.txtWord.getText();
    	String traduzione;
    	String [] parts = parola.trim().split(" ");
    	
    	  	
    	if(parts.length==2) { //memorizzo la parola
    		
    		if(!parts[0].matches("[a-zA-Z]+") || !parts[1].matches("[a-zA-Z]+")) {
    			txtMessaggi.appendText("Devi inserire una parola!\n");
    			throw new InvalidParameterException("Devi inserire una parola!\n");
    		}
    		parole.put(parts[0].toLowerCase(), parts[1].toLowerCase());
    		txtMessaggi.appendText("Inserita nuova parola al dizionario\n");
    	}
  
    	else if(parts.length==1) {
    		
    		if(!parts[0].matches("[a-zA-Z]+")) {
    			txtMessaggi.appendText("Devi inserire una parola!\n");
    			throw new InvalidParameterException("Devi inserire una parola!\n");
    		}
    		traduzione = parole.get(parola.toLowerCase());
    		if(traduzione == null) {
    			txtMessaggi.appendText("Parola non presente.\n");
    		} else {
    			txtMessaggi.appendText(parola+ " significa "+traduzione+"\n");
    		}
    	}
    	txtWord.clear();
    }

    @FXML
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtMessaggi != null : "fx:id=\"txtMessaggi\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";

    }
}
