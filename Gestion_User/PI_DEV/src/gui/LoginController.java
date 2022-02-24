/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import Services.GeneralServices ;
import Model.Client;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import org.controlsfx.control.Notifications;


/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */    @FXML
   
    private Parent fxml;
     @FXML
    private TextField username;
     @FXML
    private TextField password;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void Connect(ActionEvent event)
    {
        //notification 
        Image img  = new Image("/images/success-24.png");
        Image img_error  = new Image("/images/error-icon-4.png");
        GeneralServices GS = new GeneralServices();
       if(GS.Login(username.getText(),password.getText())!=(-1))
       {  
           Notifications notificationbuilder = Notifications.create().title("succès de l'authentification").
                   graphic(new ImageView(img)).
                   hideAfter(Duration.seconds(5)).
                   position(Pos.BOTTOM_RIGHT).
                   onAction(new EventHandler<ActionEvent>(){
                       
                       @Override
                       public void handle(ActionEvent event)
                       {
                           System.out.println("clicked on notification");
                       }
                   }) ;
           notificationbuilder.darkStyle();
           notificationbuilder.show();
           
               //main interface de l'application
//         try{
//        fxml = FXMLLoader. load (getClass ().getResource ("Main_app_interface.fxml"));
//        vbox_main_app.getChildren ().removeAll ();
//        vbox_main_app.getChildren (). setAll (fxml);
//    }catch (IOException ex) {
//    
//}
             }
       else
       {
              Notifications notificationbuilder = Notifications.create().title("Échec de l'authentification").
                   graphic(new ImageView(img_error)).
                   hideAfter(Duration.seconds(5)).
                   position(Pos.BOTTOM_RIGHT).
                   onAction(new EventHandler<ActionEvent>(){
                       
                       @Override
                       public void handle(ActionEvent event)
                       {
                           System.out.println("clicked on notification");
                       }
                   }) ;
           notificationbuilder.darkStyle();
           notificationbuilder.show();
       }
        
    }
    
}
