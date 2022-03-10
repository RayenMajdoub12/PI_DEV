/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import Model.Programme;
import Model.Seance;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Services.SeanceService;

/**
 * FXML Controller class
 *
 * @author 23yas
 */
public class Client_SeanceController implements Initializable {

    @FXML
    private Button btn_Acc;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableColumn<Seance, String> colnom;
    @FXML
    private TableColumn<Seance, Date> coldate;
    @FXML
    private TableColumn<Seance, String> colheure;
    @FXML
    private TableColumn<Seance, String> coldes;
    @FXML
    private TableView<Seance> tvsea;
    private SeanceService SeanceService;
    ObservableList<Seance> ListS;
    
    ObservableList<Seance> dataList;
    
    @FXML
    private TextField filter;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.SeanceService = new SeanceService();
        
        colnom.setCellValueFactory(new PropertyValueFactory<Seance, String>("nom"));
        coldate.setCellValueFactory(new PropertyValueFactory<Seance, Date>("date"));
        colheure.setCellValueFactory(new PropertyValueFactory<Seance, String>("heure"));
        coldes.setCellValueFactory(new PropertyValueFactory<Seance, String>("description"));
        
        
        ListS = SeanceService.getDataSeance();
        tvsea.setItems(ListS);
        recherche();
        
    }    

    @FXML
    private void GoBack(ActionEvent event) throws IOException {
    Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
        
    }
    
    @FXML
    void recherche(){
        colnom.setCellValueFactory(new PropertyValueFactory<Seance, String>("nom"));
        coldate.setCellValueFactory(new PropertyValueFactory<Seance, Date>("date"));
        colheure.setCellValueFactory(new PropertyValueFactory<Seance, String>("heure"));
        coldes.setCellValueFactory(new PropertyValueFactory<Seance, String>("description"));
        
        dataList = SeanceService.getDataSeance();
        tvsea.setItems(dataList);
        
        FilteredList<Seance> filteredata = new FilteredList<>(dataList, b ->true);
        filter.textProperty().addListener((observable, oldvalue, newvalue) -> {
            filteredata.setPredicate(Seance -> {
                if(newvalue.isEmpty() || newvalue == null){
                    return  true;
                }
                String lowercasefilter = newvalue.toLowerCase();
                if(Seance.getNom().toLowerCase().indexOf(lowercasefilter) != -1){
                    return true;
                    
                } else if(Seance.getHeure().toLowerCase().indexOf(lowercasefilter) != -1){
                    return true;
                    
                } else if(Seance.getDescription().toLowerCase().indexOf(lowercasefilter) != -1){
                    return true;
                    
                }
                else if(Seance.getDate().toString().indexOf(lowercasefilter) != -1){
                    return true;
                    
                }else{
                    return false;
                }
                
            });
        });
        SortedList<Seance> sorteddate = new SortedList<>(filteredata);
        sorteddate.comparatorProperty().bind(tvsea.comparatorProperty());
        tvsea.setItems(sorteddate);
    }
    
    
    
}
