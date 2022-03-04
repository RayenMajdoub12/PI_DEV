/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Model.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class Main_app_ClientController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public static User user_passed;
    @FXML
    Pane pane;
    @FXML
    Parent fxml;
    @FXML
    Label hello;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
    }

    public void initdata() {
        hello.setText("  WELCOME   " + user_passed.getNom());
    }
@FXML
    public void profile() {
        
        try {
            
            fxml = FXMLLoader.load(getClass().getResource("Profile.fxml"));
            pane.getChildren().removeAll();
            pane.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(Main_app_ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Liste_coach() {
        try {
            fxml = FXMLLoader.load(getClass().getResource("Liste_coach.fxml"));
            pane.getChildren().removeAll();
            pane.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(Main_app_ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
