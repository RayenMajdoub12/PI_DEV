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
import Services.GeneralServices;
import Model.User;
import Services.ClientServices;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private VBox vbox;
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
    public void Connect(ActionEvent event) {
        User u = new User();
        ClientServices CS = new ClientServices();
        GeneralServices GS = new GeneralServices();
        int id_user;

        Image img = new Image("/images/success-24.png",50,50,false,false);
        Image img_error = new Image("/images/error-icon-4.png",50,50,false,false);

        id_user = GS.Login(username.getText().toString(), password.getText().toString());

        if (id_user != (-1)) {
            //notification desktop
            Notifications notificationbuilder = Notifications.create().title("succès de l'authentification").
                    graphic(new ImageView(img)).
                    hideAfter(Duration.seconds(5)).
                    position(Pos.BOTTOM_RIGHT).
                    onAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("clicked on notification");
                        }
                    });
            notificationbuilder.darkStyle();
            notificationbuilder.show();
//new stage pour l'application selon le role
            u = CS.readById(id_user);
            System.out.println(u.getRole());
            //role client
            if (u.getRole().equalsIgnoreCase("client")) {
                try {
                    Stage stage = new Stage();
                   FXMLLoader fx = new FXMLLoader();
                   Pane  root = fx.load(getClass().getResource("Main_app_Client.fxml").openStream());
                   root.getStylesheets().add(getClass().getResource("CSS.css").toString());
                   Main_app_ClientController CC = fx.getController();
                   CC.user_passed=u;    
                   CC.initdata();
               stage.setScene(new Scene(root));
               stage.initStyle (StageStyle. TRANSPARENT);
                 
                   stage.showAndWait();
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
//role coach
            } else if(u.getRole().equalsIgnoreCase("coach")) {  
       //   try {
//                    Stage stage = new Stage();
//                   FXMLLoader fx = new FXMLLoader();
//                   Pane  root = fx.load(getClass().getResource("Main_app_coach.fxml").openStream());
//                   Main_app_clientController CC = fx.getController();
//                   CC.user_passed=u;        
//               stage.setScene(new Scene(root));
//               stage.initStyle (StageStyle. TRANSPARENT);
//                 
//                   stage.showAndWait();
//                } catch (IOException ex) {
//                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//                }}
         }}else{
            //notif error
            Notifications notificationbuilder = Notifications.create().title("Échec de l'authentification").
                    graphic(new ImageView(img_error)).
                    hideAfter(Duration.seconds(5)).
                    position(Pos.BOTTOM_RIGHT).
                    onAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("clicked on notification");
                        }
                    });
            notificationbuilder.darkStyle();
            notificationbuilder.show();
        }

    }
    

    public void mdp_oublie_button(ActionEvent event) {
        try {
            fxml = FXMLLoader.load(getClass().getResource("mdp_oublie.fxml"));
            vbox.getChildren().removeAll();
            vbox.getChildren().setAll(fxml);
        } catch (IOException ex) {

        }

    }

}
