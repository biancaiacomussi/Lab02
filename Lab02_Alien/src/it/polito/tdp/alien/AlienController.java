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
	private AlienDictionary dizionario = new AlienDictionary();

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
    	txtMessaggi.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String [] parola = txtWord.getText().split(" ");
    	if(parola.length==2) {
    		if(!parola[0].matches("[a-zA-Z]+") || !parola[1].matches("[a-zA-Z]+")) {
    			txtMessaggi.appendText("Devi inserire una parola\n");
    			throw new InvalidParameterException("Devi inserire una parola\n");
    		}
    		
    		dizionario.add(parola[0],parola[1]);
    		txtMessaggi.appendText("Inserita nuova parola\n");
    	}
    	
    	if(parola.length==1) {
    		if(!parola[0].matches("[a-zA-Z]+")) {
    			txtMessaggi.appendText("Devi inserire una parola\n");
    			throw new InvalidParameterException("Devi inserire una parola\n");
    		}
    		
    		String s = dizionario.translate(parola[0],dizionario);
    		
    		if(s!=null)
    		txtMessaggi.appendText(parola[0]+" vuol dire "+dizionario.translate(parola[0],dizionario)+"\n");

    		if(s==null)
    			txtMessaggi.appendText("Parola non presente\n");
    	}
    	
    	txtWord.clear();
    	
    	
    		System.out.println(dizionario.getDizionario().toString());
    	
    	
    	
    }

    
    
    public AlienDictionary getDizionario() {
		return dizionario;
	}

	@FXML
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtMessaggi != null : "fx:id=\"txtMessaggi\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";

    }
}
