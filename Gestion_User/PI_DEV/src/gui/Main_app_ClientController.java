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
public class Main_app_ClientController implements Initializable {

    /**
     * Initializes the controller class.
     */
    static User user_passed ;
    @FXML
    Label hello;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
    }
     public void initdata()
     {
         hello.setText("Hello : "+user_passed.getNom());
     }
    
    
}