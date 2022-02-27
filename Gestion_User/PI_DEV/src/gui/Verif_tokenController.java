/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Services.GeneralServices;
import javafx.fxml.FXMLLoader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Rayen
 */

public class Verif_tokenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML TextField token ;
    public static String mail_passe ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
        @FXML
    private VBox vbox;    
     
    private Parent fxml;
         @FXML
  public  void verif_tok( ) {
        System.out.println(mail_passe);
        GeneralServices Gs = new GeneralServices();
        if( Gs.VerifyToken(mail_passe,Integer.parseInt(token.getText())))
        {
     try {
            fxml = FXMLLoader.load(getClass().getResource("Change_mdp.fxml"));
            FXMLLoader loader = new FXMLLoader();
            Change_mdpController CC = loader.getController();
            CC.mail_passing=mail_passe;     
            vbox.getChildren().removeAll();
                  System.out.println("mat3adach houni 3");
            vbox.getChildren().setAll(fxml);
                  System.out.println("mat3adach houni 4");
            
        } catch (Exception ex) {
            Logger.getLogger(Mdp_oublieController.class.getName()).log(Level.SEVERE, null, ex); 
                 }
        }
        else {
            System.out.println("erooooooooooooooor");
        }
       
    }
    
}
