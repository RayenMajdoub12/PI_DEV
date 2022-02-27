/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Services.ClientServices;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
public class Change_mdpController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public static String mail_passing ;
        @FXML
    private VBox vbox;    
        @FXML
    private Parent fxml;
        @FXML
    TextField nv_mdp1 ;
        @FXML
    TextField nv_mdp2;
        @FXML
    TextField notif ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 @FXML
    public void new_mdp()
    {
        if(nv_mdp1.getText().toString().equals(nv_mdp2.getText().toString()))
        {
            ClientServices cs  = new  ClientServices();
            cs.update_mdp(nv_mdp1.getText().toString(),mail_passing);
                  try {
                fxml = FXMLLoader.load(getClass().getResource("Login.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
                      System.out.println("cbn yekhdem");
            } catch (IOException ex) {

            }
        }
        else 
        {
            System.out.println(nv_mdp1.getText().toString());     System.out.println(nv_mdp2.getText().toString());
            notif.setText("les 2 mots de passe ne sont pas identiques");
        }
    }
    
}
