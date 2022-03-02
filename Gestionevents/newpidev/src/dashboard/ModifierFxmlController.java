/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modele.Evenements;
import service.EvenementService;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class ModifierFxmlController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tflieu;
    @FXML
    private TextField tfdescription;
    @FXML
    private TextField id_event;
    @FXML
    private Button can;
    @FXML
    private DatePicker datepick1;
    @FXML
    private DatePicker datepick2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifierevent(ActionEvent event) throws IOException, Exception {


          Date d1= new Date( datepick1.getValue().getYear(),  datepick1.getValue().getMonthValue(),  datepick1.getValue().getDayOfMonth());
               Date d2= new Date( datepick2.getValue().getYear(),  datepick2.getValue().getMonthValue(),  datepick2.getValue().getDayOfMonth());
           
        int pr=Integer.parseInt(tfprix.getText());  
        Evenements e = new Evenements(tfnom.getText(), pr, tflieu.getText(), d1, d2, tfdescription.getText());
        EvenementService s = new EvenementService();
                int i=Integer.parseInt(id_event.getText());  

              s.update(e,i);
              
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
