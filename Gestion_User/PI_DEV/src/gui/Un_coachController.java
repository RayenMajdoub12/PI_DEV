/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Model.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class Un_coachController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label coach_nom;

    @FXML
    private Label coach_spec;
    @FXML
    private Label coach_pren ;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setData(User u)
    {
        coach_nom.setText(u.getNom());
        coach_pren.setText(u.getPrenom());
        coach_spec.setText(u.getSpecialite());
        
    }
}
