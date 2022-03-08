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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Rayen
 */

public class Main_dashboardController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    VBox vbox;
    @FXML
    Parent fxml ;
    @FXML
    AnchorPane anchor;
    public static User user_passed ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    } 
  public void  load_choix ()
  {
       try {
            fxml = FXMLLoader.load(getClass().getResource("Gestion_User_dashboard.fxml"));
            vbox.getChildren().removeAll();
            vbox.getChildren().setAll(fxml);
        } catch (IOException ex) {

        }
  }
    
}
