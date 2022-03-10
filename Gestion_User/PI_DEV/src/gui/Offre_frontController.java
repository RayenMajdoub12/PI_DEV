/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Conn.Datasource;
import Model.offre;
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
public class Offre_frontController implements Initializable {

    /**
     * Initializes the controller class.
     */
       @FXML
    private TableView<offre> tvoff;
    @FXML
    private TableColumn<offre, Integer> coid_off;
    @FXML
    private TableColumn<offre, String> co_nomoff;
    @FXML
    private TableColumn<offre, String> codateoff;
    @FXML
    private TableColumn<offre, String> codatefinoff;
    @FXML
    private TableColumn<offre, String> codescoff;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      showoffre();
    }    
    public void showoffre()
    {
        tvoff.getItems().clear();
              ObservableList<offre> list=getOffreList();
        coid_off.setCellValueFactory(new PropertyValueFactory<offre, Integer>("id_offre"));
    //colid_a.setCellValueFactory(new PropertyValueFactory<livraison, Integer>("id_a"));
    co_nomoff.setCellValueFactory(new PropertyValueFactory<offre, String>("nom_o"));
    codateoff .setCellValueFactory(new PropertyValueFactory<offre, String>("datedebut_o"));
     codatefinoff .setCellValueFactory(new PropertyValueFactory<offre, String>("datefin_o"));
         codescoff .setCellValueFactory(new PropertyValueFactory<offre, String>("descr_off"));
     tvoff.setItems(list);//pour affcher les information de la bdd sur la table view
    }

     
    public ObservableList<offre> getOffreList(){
        ObservableList<offre> offrelist = FXCollections.observableArrayList();
        Connection conn= Datasource.getInstance().getCnx();
        String query = "SELECT * FROM offre";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);

            while(rs.next()){
              offre  offre = new offre(rs.getInt("id_offre"), rs.getString("nom_o"), rs.getString("datedebut_o"),rs.getString("datefin_o"),rs.getString("descr_off"));
                offrelist.add(offre);
            }
                
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return offrelist;
    }

    
}

