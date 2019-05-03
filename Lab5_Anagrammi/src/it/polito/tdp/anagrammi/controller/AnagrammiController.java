package it.polito.tdp.anagrammi.controller;

import it.polito.tdp.anagrammi.model.Anagramma;
import it.polito.tdp.anagrammi.model.Model;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {

	private Model model;
	Anagramma anagramma = new Anagramma();

	 @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TextField parolaTxt;

	    @FXML
	    private Button calcolaAnagrammiButton;

	    @FXML
	    private TextArea anagrammiCorrettiTxt;

	    @FXML
	    private TextArea anagrammiErratiTxt;

	    @FXML
	    private Button resetButton;


    @FXML
    void handleCalcolaAnagrammi(ActionEvent event) {
    	this.anagrammiCorrettiTxt.clear();
    	this.anagrammiErratiTxt.clear();
    	try {
    		String parola = this.parolaTxt.getText();
    		anagramma = model.cercaAnagrammi(parola);
    		this.anagrammiCorrettiTxt.appendText(anagramma.validiToString());
    		this.anagrammiErratiTxt.appendText(anagramma.nonValidiToString());
    	} catch(RuntimeException e) {
    		this.anagrammiCorrettiTxt.appendText("Reinserisci la parola della quale si vuole"
    				+ "trovare l'anagramma");
    	}

    }

    @FXML
    void handleReset(ActionEvent event) {
    	this.anagrammiCorrettiTxt.clear();
    	this.anagrammiErratiTxt.clear();
    	this.parolaTxt.clear();

    }
    
    @FXML
    void initialize() {
        assert parolaTxt != null : "fx:id=\"parolaTxt\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert calcolaAnagrammiButton != null : "fx:id=\"calcolaAnagrammiButton\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert anagrammiCorrettiTxt != null : "fx:id=\"anagrammiCorrettiTxt\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert anagrammiErratiTxt != null : "fx:id=\"anagrammiErratiTxt\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert resetButton != null : "fx:id=\"resetButton\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }

	public void setModel(Model model) {
		this.model= model;		
	}

	
}

