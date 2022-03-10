/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Conn.Datasource;
import Model.evenement;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class Evenement_frontController implements Initializable {

    /**
     * Initializes the controller class.
     */    @FXML
    private TableView<evenement> tvevents;
    @FXML
    private TableColumn<evenement,Integer > coid_e;
    @FXML
    private TableColumn<evenement, String> co_nomev;
    @FXML
    private TableColumn<evenement, Integer> coprixeve;
    @FXML
    private TableColumn<evenement, String> codatedeve;
    @FXML
    private TableColumn<evenement, String>  codatefineve;
    @FXML
    private TableColumn<evenement, String> codesceve;
    @FXML
    private TableColumn<evenement, String> colieu;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       showevent();
    }  
     public void showevent()
    {   tvevents.getItems().clear();
        ObservableList<evenement> list=getEventList();
        coid_e.setCellValueFactory(new PropertyValueFactory<evenement, Integer>("id"));
    //colid_a.setCellValueFactory(new PropertyValueFactory<livraison, Integer>("id_a"));
    co_nomev.setCellValueFactory(new PropertyValueFactory<evenement, String>("nom"));
    coprixeve.setCellValueFactory(new PropertyValueFactory<evenement, Integer>("prix"));
    colieu.setCellValueFactory(new PropertyValueFactory<evenement, String>("lieu"));
    codatedeve.setCellValueFactory(new PropertyValueFactory<evenement, String>("datedebut"));
     codatefineve .setCellValueFactory(new PropertyValueFactory<evenement, String>("datefin"));
         codesceve .setCellValueFactory(new PropertyValueFactory<evenement, String>("description"));
     tvevents.setItems(list);//pour affcher les information de la bdd sur la table view
    }
    public ObservableList<evenement> getEventList(){
        ObservableList<evenement> eventList = FXCollections.observableArrayList();
        Connection conn= Datasource.getInstance().getCnx();
        String query = "SELECT * FROM evenement";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);

            while(rs.next()){
              evenement  evenement = new evenement(rs.getInt("id"), rs.getString("nom"), rs.getInt("prix"),rs.getString("lieu"), rs.getString("datedebut"),rs.getString("datefin"),rs.getString("description"));
                eventList.add(evenement);
            }
                
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return eventList;
    }
}
