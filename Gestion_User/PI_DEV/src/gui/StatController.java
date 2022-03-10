/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import Model.Programme;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import Services.ProgrammeService;
import Services.SeanceService;

/**
 * FXML Controller class
 *
 * @author 23yas
 */
public class StatController implements Initializable {

    @FXML
    private Button btnretour;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private BarChart<?, ?> stats;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;
    private SeanceService seanceService;
    ObservableList<Integer> ListP;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.seanceService = new SeanceService();
        ListP = seanceService.getDataProgramme_id();
        
        for (int i =0 ; i< ListP.size(); i++){
        int j = seanceService.nbreSeance(ListP.get(i));
        XYChart.Series s = new XYChart.Series<>();
        s.getData().add( new XYChart.Data(""+ListP.get(i), j));
        stats.getData().addAll(s);
            
        }
        
        
        
        
        
    }    

    @FXML
    private void GoBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Client_Prog.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new  Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
