/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Model.User;
import Services.ClientServices;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class Modifier_clientController implements Initializable {
   @FXML
    Parent fxml;
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
    User u = new User();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        u = Main_app_ClientController.user_passed;
        nom.setText(u.getNom());
        pseudo.setText(u.getPseudo());
        prenom.setText(u.getPrenom());
        email.setText(u.getEmail());
        tel.setText("" + u.getTel());
        age.setText("" + u.getAge());

    }

    @FXML
    private void modif_client(ActionEvent event) {
        u.setNom(nom.getText());
        u.setPseudo(pseudo.getText());
        u.setPrenom(prenom.getText());
        u.setEmail(email.getText());
        u.setTel(Integer.parseInt(tel.getText()));
        u.setAge(Integer.parseInt(age.getText()));
        ClientServices CS = new ClientServices();
        CS.update(u);
        Main_app_ClientController.user_passed=u;
    }

    @FXML
    private void return_home(ActionEvent event) {
            try {
            
            fxml = FXMLLoader.load(getClass().getResource("Profile.fxml"));
            pane.getChildren().removeAll();
            pane.getChildren().setAll(fxml);
        } catch (IOException ex) {
                System.out.println(ex);
        }
    }

}
