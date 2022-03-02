/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.EvenementService;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class SupprimeFxmlController implements Initializable {

    @FXML
    private TextField IDEVENT;
    @FXML
    private Button can;
    @FXML
    private Button can1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void supprimerevent(ActionEvent event) throws IOException {
        EvenementService s = new EvenementService();
        int i=Integer.parseInt(IDEVENT.getText());  

        s.delete(i);
        
        Stage stage1=(Stage)   can.getScene().getWindow();
       Parent root =FXMLLoader.load(getClass().getResource("AfficherFxml.fxml"));
   
        stage1.setScene(new Scene(root));
        stage1.show();
    }

    @FXML
    private void cancan(ActionEvent event) throws IOException {
        Stage stage1=(Stage)   can.getScene().getWindow();
       Parent root =FXMLLoader.load(getClass().getResource("AfficherFxml.fxml"));
   
        stage1.setScene(new Scene(root));
        stage1.show();
    }
    
}
