/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtFIn"
    private TextField txtFIn; // Value injected by FXMLLoader

    @FXML // fx:id="txtAOutCorretti"
    private TextArea txtAOutCorretti; // Value injected by FXMLLoader

    @FXML // fx:id="txtxAOutErrati"
    private TextArea txtxAOutErrati; // Value injected by FXMLLoader
    
    Model modello = new Model();
    
    @FXML
    void calcolaAnagrammi(ActionEvent event) {
    	
    	txtAOutCorretti.clear();
    	txtxAOutErrati.clear();

    	String parola = txtFIn.getText();
    	
    	if(parola.equals("")) {
    		
    		txtxAOutErrati.setText("Devi inserire una parola");
    		return;
    	}
    	if(parola.contains(" ")) {
    		
    		txtxAOutErrati.setText("Devi inserire una sola parola");
    		return;
    	}
    	
    	
    	List<String> listaAnagrammi = modello.calcolaAnagrammi(parola);
    	
    	int nErr = listaAnagrammi.size();
    	
    	for(String s: listaAnagrammi) {
    		
    		if(modello.parolaCorretta(s)) {
    			
    			txtAOutCorretti.appendText(s+"\n");
    			nErr--;
    		}
    	}
    	
    	txtxAOutErrati.setText("Ci sono "+nErr+" anagrammi errati");
    }

    @FXML
    void reset(ActionEvent event) {

    	txtAOutCorretti.clear();
    	txtxAOutErrati.clear();
    	txtFIn.clear();
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtFIn != null : "fx:id=\"txtFIn\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAOutCorretti != null : "fx:id=\"txtAOutCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtxAOutErrati != null : "fx:id=\"txtxAOutErrati\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}

