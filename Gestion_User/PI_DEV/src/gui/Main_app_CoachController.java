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
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class Main_app_CoachController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
    Pane pane;
    Parent fxml;
        public static User user_passed;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
       @FXML
    public void profile() {
        try {
            fxml = FXMLLoader.load(getClass().getResource("Profile_coach.fxml"));
            pane.getChildren().removeAll();
            pane.getChildren().setAll(fxml);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    public void Gestion_des_seances()
    {
        
    }
     public void Gestion_des_programmes()
    {
        
    }
    
}
