/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;


import Model.Programme;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import Services.ProgrammeService;

/**
 * FXML Controller class
 *
 * @author 23yas
 */
public class ProgrammeController implements Initializable {

    @FXML
    private TextField tfid;
    @FXML
    private TextField tftitre;
    @FXML
    private TextField tfcategorie;
    @FXML
    private TextArea tfdes;
    @FXML
    private TableView<Programme> tvprogramme;
    @FXML
    private TableColumn<Programme, Integer> colID;
    @FXML
    private TableColumn<Programme, String> colTitre;
    @FXML
    private TableColumn<Programme, String> colcat;
    @FXML
    private TableColumn<Programme, String> coldes;
    
    private ProgrammeService ProgrammeService;
    
    ObservableList<Programme> ListP;
     int index =-1;
     Connection  conn = null;
    ResultSet rs = null;
    PreparedStatement pst= null;
    Statement ste = null;
    @FXML
    private Button b_ajouter;
    @FXML
    private Button b_delete;
    @FXML
    private Button b_update;
    @FXML
    private Button btn_Acc;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.ProgrammeService = new ProgrammeService();
        
        colID.setCellValueFactory(new PropertyValueFactory<Programme, Integer>("id"));
        colTitre.setCellValueFactory(new PropertyValueFactory<Programme, String>("title"));
        colcat.setCellValueFactory(new PropertyValueFactory<Programme, String>("categorie"));
        coldes.setCellValueFactory(new PropertyValueFactory<Programme, String>("description"));
        
        ListP = ProgrammeService.getDataProgramme();
        tvprogramme.setItems(ListP);
        
        
        
        
    }    

    

    

    @FXML
    private void Add(ActionEvent event) {
        
        int id = Integer.parseInt(tfid.getText());
        String titre = tftitre.getText();
        String categorie = tfcategorie.getText();
        String description = tfdes.getText();
        
        Programme p = new Programme(id, titre, categorie, description);
        ProgrammeService.insert(p);
        showprogramme();
        
        
    }

    @FXML
    private void Delete(ActionEvent event) {
        
        int id = Integer.parseInt(tfid.getText());
        String titre = tftitre.getText();
        String categorie = tfcategorie.getText();
        String description = tfdes.getText();
        
        Programme p = new Programme(id, titre, categorie, description);
        ProgrammeService.delete(p);
        showprogramme();
    }

    @FXML
    private void Update(ActionEvent event) {
        
        int id = Integer.parseInt(tfid.getText());
        String titre = tftitre.getText();
        String categorie = tfcategorie.getText();
        String description = tfdes.getText();
        
        Programme p = new Programme(id, titre, categorie, description);
        ProgrammeService.update(p);
        showprogramme();
    }

    @FXML
    private void handlemouseAction(MouseEvent event) {
        
        Programme prog  = tvprogramme.getSelectionModel().getSelectedItem();
        tfid.setText(""+prog.getId());
        tftitre.setText(""+prog.getTitle());
        tfcategorie.setText(""+prog.getCategorie());
        tfdes.setText(""+prog.getDescription());
        
    }

    @FXML
    private void GoBack(ActionEvent event) throws IOException {
      Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }
    
    public void showprogramme(){
        ListP = ProgrammeService.getDataProgramme();
        
        colID.setCellValueFactory(new PropertyValueFactory<Programme, Integer>("id"));
        colTitre.setCellValueFactory(new PropertyValueFactory<Programme, String>("title"));
        colcat.setCellValueFactory(new PropertyValueFactory<Programme, String>("categorie"));
        coldes.setCellValueFactory(new PropertyValueFactory<Programme, String>("description"));
        
        tvprogramme.setItems(ListP);
    }
    
    
   
    
    

}
