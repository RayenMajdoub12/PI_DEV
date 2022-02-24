/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Services.GeneralServices;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class Mdp_oublieController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField email_user;
    @FXML
    private VBox vbox;
    @FXML
    private Parent fxml;
    
    public static String mail ;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
@FXML
    public String send_code() {
        GeneralServices GS = new GeneralServices();
        try {
            GS.sendMail(email_user.getText(), GS.Token_Mdp_Oublie(email_user.getText().toString()));
            fxml = FXMLLoader.load(getClass().getResource("verif_token.fxml"));
            vbox.getChildren().removeAll();
            vbox.getChildren().setAll(fxml);
        } catch (Exception ex) {
            Logger.getLogger(Mdp_oublieController.class.getName()).log(Level.SEVERE, null, ex);
        }
   return mail=email_user.getText();
    }
  
    
    
}
