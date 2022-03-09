/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymgeeks;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class HomeController implements Initializable {
    public static int usern;
private Parent fxml;
  @FXML
  private AnchorPane root;
    @FXML
    private Label user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        HomeController.setUsern(user.getText().length());
    }    

    @FXML
    private void produit(MouseEvent event) {
    try {
        fxml =FXMLLoader.load(getClass().getResource("produit.fxml"));
        root.getChildren().removeAll();
        root.getChildren().setAll(fxml);
        
    }catch (IOException ex){
       
        ex.printStackTrace();
    }
    }

    @FXML
    private void commande(MouseEvent event) {
    try {
        fxml =FXMLLoader.load(getClass().getResource("commande.fxml"));
        root.getChildren().removeAll();
        root.getChildren().setAll(fxml);
        
    }catch (IOException ex){
       
        ex.printStackTrace();
    }
    }

    @FXML
    private void livraison(MouseEvent event) {
    try {
        fxml =FXMLLoader.load(getClass().getResource("livraison.fxml"));
        root.getChildren().removeAll();
        root.getChildren().setAll(fxml);
        
    }catch (IOException ex){
       
        ex.printStackTrace();
    }
    }

    public static int getUsern() {
        return usern;
    }

    public static void setUsern(int usern) {
        HomeController.usern = usern;
    }
    
   
}
