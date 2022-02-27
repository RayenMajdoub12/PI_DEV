/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modele.Evenements;
import service.EvenementService;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class EvenementController implements Initializable {

    @FXML
    private TextField textFieldIdevent;
    @FXML
    private TextField textFieldNom;
    @FXML
    private TextField textFieldPrix;
    @FXML
    private TextField textFieldLieu;
    @FXML
    private TextField textFieldDatedebut;
    @FXML
    private TextField textFieldDatefin;
    @FXML
    private TextField textFieldDescription;
    @FXML
    private Button btnSubmit;
    
    private EvenementService evenementService;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.evenementService = new EvenementService();
        
    }    

    @FXML
    private void onCreate(ActionEvent event) {
////        try {
////            
//        } catch (NumberFormatException ex) {
//            return;
////        }
        int Id =Integer.parseInt(textFieldIdevent.getText());
        String nom = textFieldNom.getText();
        int prix = Integer.parseInt(textFieldPrix.getText());
        String lieu =textFieldLieu.getText();
        String datedebut =textFieldDatedebut.getText();
        String datefin =textFieldDatefin.getText();
        String description=textFieldDescription.getText();
        
        Evenements e =new Evenements(Id, nom, prix, lieu, datedebut, datefin, description);
        evenementService.insert(e);
        
    }
    
}
