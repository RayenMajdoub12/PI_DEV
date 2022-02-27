/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class DetailsWindowController implements Initializable {

    @FXML
    private TextField tfidevent;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tflieu;
    @FXML
    private TextField tfdatedebut;
    @FXML
    private TextField tfdatefin;
    @FXML
    private TextField tfdescription;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setTfidevent(String value) {
        this.tfidevent.setText(value);
    }

    public void setTfnom(String value) {
        this.tfnom.setText(value);
    }

    public void setTfprix(String value) {
        this.tfprix.setText(value);
    }
    

    public void setTflieu(String value) {
        this.tflieu.setText(value);
    }

    public void setTfdatedebut(String value) {
        this.tfdatedebut.setText(value);
    }

    public void setTfdatefin(String value) {
        this.tfdatefin.setText(value);
    }

    public void setTfdescription(String value) {
        this.tfdescription.setText(value);
    }
     
    
}
