/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class Profile_coachController implements Initializable {

    @FXML
    private BorderPane pane;
    @FXML
    private Label pseudo;
    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label email;
    @FXML
    private Label tel;
    @FXML
    private Label age;
    @FXML
    private Label specialite;
    @FXML
    private Label salaire;

    /**
     * Initializes the controller class.
     */
    @FXML
    Parent fxml;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        init_data();

    }

    public void init_data() {
        System.out.println("hello");
        pseudo.setText(Main_app_CoachController.user_passed.getPseudo());
        nom.setText(Main_app_CoachController.user_passed.getNom());
        prenom.setText(Main_app_CoachController.user_passed.getPrenom());
        email.setText(Main_app_CoachController.user_passed.getEmail());
        tel.setText("" + Main_app_CoachController.user_passed.getTel());
        age.setText("" + Main_app_CoachController.user_passed.getAge());
        specialite.setText(Main_app_CoachController.user_passed.getSpecialite());
        salaire.setText("" + Main_app_CoachController.user_passed.getSalaire());

    }

    public void return_home() {
        try {

            fxml = FXMLLoader.load(getClass().getResource("Main_app_Coach.fxml"));
            pane.getChildren().removeAll();
            pane.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(Main_app_ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modif_client() {
        try {

            fxml = FXMLLoader.load(getClass().getResource("Modifier_coach.fxml"));
            pane.getChildren().removeAll();
            pane.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(Main_app_ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
