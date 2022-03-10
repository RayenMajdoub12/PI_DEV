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
import javafx.stage.Stage;
import Services.ProgrammeService;

/**
 * FXML Controller class
 *
 * @author 23yas
 */


public class Client_ProgController implements Initializable {

    @FXML
    private Button btn_Acc;
     private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableColumn<Programme, String> coltitre;
    @FXML
    private TableColumn<Programme, String> colCat;
    @FXML
    private TableColumn<Programme, String> colDes;
    
    ObservableList<Programme> ListP;
    ObservableList<Programme> dataList;
    @FXML
    private TableView<Programme> tvprog;
    private ProgrammeService ProgrammeService;
    @FXML
    private TextField filterfield;
    @FXML
    private Button btnstat;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.ProgrammeService = new ProgrammeService();
        coltitre.setCellValueFactory(new PropertyValueFactory<Programme, String>("title"));
        colCat.setCellValueFactory(new PropertyValueFactory<Programme, String>("categorie"));
        colDes.setCellValueFactory(new PropertyValueFactory<Programme, String>("description"));
        
        ListP = ProgrammeService.getDataProgramme();
        tvprog.setItems(ListP);
        recherche();
    }    

    @FXML
    private void GoBack(ActionEvent event) throws IOException {
     Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }
    
    void recherche(){
        coltitre.setCellValueFactory(new PropertyValueFactory<Programme, String>("title"));
        colCat.setCellValueFactory(new PropertyValueFactory<Programme, String>("categorie"));
        colDes.setCellValueFactory(new PropertyValueFactory<Programme, String>("description"));
        
        dataList = ProgrammeService.getDataProgramme();
        tvprog.setItems(dataList);
        
        FilteredList<Programme> filteredata = new FilteredList<>(dataList, b ->true);
        filterfield.textProperty().addListener((observable, oldvalue, newvalue) -> {
            filteredata.setPredicate(Programme -> {
                if(newvalue.isEmpty() || newvalue == null){
                    return  true;
                }
                String lowercasefilter = newvalue.toLowerCase();
                if(Programme.getTitle().toLowerCase().indexOf(lowercasefilter) != -1){
                    return true;
                    
                } else if(Programme.getCategorie().toLowerCase().indexOf(lowercasefilter) != -1){
                    return true;
                    
                } else if(Programme.getDescription().toLowerCase().indexOf(lowercasefilter) != -1){
                    return true;
                    
                }else{
                    return false;
                }
                
            });
        });
        SortedList<Programme> sorteddate = new SortedList<>(filteredata);
        sorteddate.comparatorProperty().bind(tvprog.comparatorProperty());
        tvprog.setItems(sorteddate);
    }

    @FXML
    private void GotoStat(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Stat.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new  Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
