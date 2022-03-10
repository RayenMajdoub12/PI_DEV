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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    Parent fxml;
    @FXML
    AnchorPane anchor;
    public static User user_passed;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void load_choix() {
        try {
            fxml = FXMLLoader.load(getClass().getResource("Gestion_User_dashboard.fxml"));
            vbox.getChildren().removeAll();
            vbox.getChildren().setAll(fxml);
        } catch (IOException ex) {

        }
    }

    public void load_choix_equi() {
        try {
            fxml = FXMLLoader.load(getClass().getResource("Gestion_equi_dashboard.fxml"));
            vbox.getChildren().removeAll();
            vbox.getChildren().setAll(fxml);
        } catch (IOException ex) {

        }
    }

    public void load_choix_blog() {
        try {
            Stage stage = new Stage();
            FXMLLoader fx = new FXMLLoader();
            Pane root = fx.load(getClass().getResource("bBlog.fxml").openStream());
            root.getStylesheets().add(getClass().getResource("CSS.css").toString());
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void load_choix_event() {
        try {
            fxml = FXMLLoader.load(getClass().getResource("Gestion_event_dashboard.fxml"));
            vbox.getChildren().removeAll();
            vbox.getChildren().setAll(fxml);
        } catch (IOException ex) {

        }
    }

    public void load_choix_seance() {
        try {
            fxml = FXMLLoader.load(getClass().getResource("Gestion_seance_dashboard.fxml"));
            vbox.getChildren().removeAll();
            vbox.getChildren().setAll(fxml);
        } catch (IOException ex) {

        }
    }

}
