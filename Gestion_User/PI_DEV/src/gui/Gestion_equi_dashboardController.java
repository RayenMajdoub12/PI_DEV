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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class Gestion_equi_dashboardController implements Initializable {

    /**
     * Initializes the controller class.
     */
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
 @FXML
    public void ouvre_liv() {
              try {
                    Stage stage = new Stage();
                    FXMLLoader fx = new FXMLLoader();
                    Pane root = fx.load(getClass().getResource("livraison.fxml").openStream());   
                    stage.setScene(new Scene(root));
                    stage.initStyle(StageStyle.TRANSPARENT);
                    stage.showAndWait();
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @FXML
    public void ouvre_produit() {
    try {
                    Stage stage = new Stage();
                    FXMLLoader fx = new FXMLLoader();
                    Pane root = fx.load(getClass().getResource("produit.fxml").openStream());
                    stage.setScene(new Scene(root));
                    stage.initStyle(StageStyle.TRANSPARENT);
                    stage.showAndWait();
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }


}
