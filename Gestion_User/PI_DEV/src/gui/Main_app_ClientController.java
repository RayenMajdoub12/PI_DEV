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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class Main_app_ClientController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public static User user_passed;
    @FXML
    Pane pane;
    Parent fxml;
    @FXML
    Label hello;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void initdata() {
        hello.setText("  WELCOME   " + user_passed.getNom());
    }

    @FXML
    public void profile() {

        try {

            fxml = FXMLLoader.load(getClass().getResource("Profile.fxml"));
            pane.getChildren().removeAll();
            pane.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(Main_app_ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void Liste_coach() {
        try {
            fxml = FXMLLoader.load(getClass().getResource("Liste_coach.fxml"));
            pane.getChildren().removeAll();
            pane.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(Main_app_ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void open_commande(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fx = new FXMLLoader();
            Pane root = fx.load(getClass().getResource("fcommande.fxml").openStream());
            root.getStylesheets().add(getClass().getResource("style.css").toString());
            CommandeController CC = fx.getController();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.TRANSPARENT);

            stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void open_produit(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fx = new FXMLLoader();
            Pane root = fx.load(getClass().getResource("frontProduit.fxml").openStream());
            FrontProduitController CC = fx.getController();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.TRANSPARENT);

            stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        @FXML
    private void open_blog(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fx = new FXMLLoader();
            Pane root = fx.load(getClass().getResource("commentaire.fxml").openStream());
             root.getStylesheets().add(getClass().getResource("CSS.css").toString());
            CommentaireController CC = fx.getController();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.TRANSPARENT);

            stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void open_prog(ActionEvent event) {
          try {
            Stage stage = new Stage();
            FXMLLoader fx = new FXMLLoader();
            Pane root = fx.load(getClass().getResource("Client_Prog.fxml").openStream());
        root.getStylesheets().add(getClass().getResource("CSS.css").toString());
            Client_ProgController CC = fx.getController();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.TRANSPARENT);

            stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    @FXML
    private void open_sean(ActionEvent event) {
            try {
            Stage stage = new Stage();
            FXMLLoader fx = new FXMLLoader();
            Pane root = fx.load(getClass().getResource("Client_Seance.fxml").openStream());
            root.getStylesheets().add(getClass().getResource("CSS.css").toString());   
            Client_SeanceController CC = fx.getController();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void open_offre(ActionEvent event) {
                 try {
            Stage stage = new Stage();
            FXMLLoader fx = new FXMLLoader();
            Pane root = fx.load(getClass().getResource("offre_front.fxml").openStream());
            root.getStylesheets().add(getClass().getResource("CSS.css").toString());   
            Offre_frontController CC = fx.getController();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @FXML
    private void open_event(ActionEvent event) {
            try {
            Stage stage = new Stage();
            FXMLLoader fx = new FXMLLoader();
            Pane root = fx.load(getClass().getResource("evenement_front.fxml").openStream());
            root.getStylesheets().add(getClass().getResource("CSS.css").toString());   
            Evenement_frontController CC = fx.getController();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
