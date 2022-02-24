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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

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
    private String mail_passe ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML

  public  void initData(String mail) {
     mail_passe = mail;
        System.out.println(mail_passe);
//        GeneralServices Gs = new GeneralServices();
//        if( Gs.VerifyToken(mail,Integer.parseInt(token.getText())))
//        {
//            System.out.println("cbn ooooo");
//        }
//        else {
//            System.out.println("erooooooooooooooor");
//        }
       
    }
    
}
