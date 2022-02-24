/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Model.Client;
import Services.ClientServices;
import Services.GeneralServices;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class SignupController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
   @FXML
    private TextField email;
   @FXML 
   private TextField username;
   @FXML
   private TextField password;
   @FXML
   private TextField phone;
   @FXML
   private TextField age;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      @FXML
    public void ajout(ActionEvent event)
    {
        //notification 
        Image img  = new Image("/images/success-24.png");
        Image img_error  = new Image("/images/error-icon-4.png");
        ClientServices GS = new ClientServices();
        Client c = new Client(firstname.getText().toString(),lastname.getText().toString(),email.getText().toString(),username.getText().toString(),password.getText().toString(),Integer.parseInt(phone.getText()),Integer.parseInt(age.getText()),"client");
        System.out.println(username.getText().toString());
        System.out.println(password.getText().toString());
     
        if(GS.test_used_pseudo_or_email(c))
        {
            
        GS.insert(c);
           Notifications notificationbuilder = Notifications.create().title("ajout avec succes").
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
              Notifications notificationbuilder = Notifications.create().title("Échec de l'ajout").
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
        
    }}
    
    
    

