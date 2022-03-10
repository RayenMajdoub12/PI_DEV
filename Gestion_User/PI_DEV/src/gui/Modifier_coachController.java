/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Model.User;
import Services.ClientServices;
import Services.CoachServices;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class Modifier_coachController implements Initializable {

    @FXML
    private BorderPane pane;
    @FXML
    private TextField pseudo;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField tel;
    @FXML
    private TextField age;
    @FXML
    private TextField specialite;
    @FXML
    private TextField salaire;
       @FXML
    Parent fxml;
  User u = new User();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        u = Main_app_CoachController.user_passed;
        nom.setText(u.getNom());
        pseudo.setText(u.getPseudo());
        prenom.setText(u.getPrenom());
        email.setText(u.getEmail());
        tel.setText("" + u.getTel());
        age.setText("" + u.getAge());
        specialite.setText(u.getSpecialite());
        salaire.setText("" + u.getSalaire());
    }    

    @FXML
    private void return_home(ActionEvent event) {
                  try {
            
            fxml = FXMLLoader.load(getClass().getResource("Profile_coach.fxml"));
            pane.getChildren().removeAll();
            pane.getChildren().setAll(fxml);
        } catch (IOException ex) {
                System.out.println(ex);
        }
    }

    @FXML
    private void modif_client(ActionEvent event) {
        u.setNom(nom.getText());
        u.setPseudo(pseudo.getText());
        u.setPrenom(prenom.getText());
        u.setEmail(email.getText());
        u.setTel(Integer.parseInt(tel.getText()));
        u.setAge(Integer.parseInt(age.getText()));
        u.setSpecialite(specialite.getText());
        u.setSalaire(Integer.parseInt(salaire.getText()));
        CoachServices CS = new CoachServices();
        CS.update(u);
        Main_app_CoachController.user_passed=u;
    }
    
}
