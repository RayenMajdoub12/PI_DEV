/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymgeeks;

import entites.produit;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import utils.DB_conn;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ProduitController implements Initializable {

    @FXML
    private TextField tfid;
    @FXML
    private TextField tfnom_p;
    @FXML
    private TextField tfdesc;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tfstock;
    @FXML
    private TableView<produit> tvproduit;
    @FXML
    private TableColumn<produit, Integer> colid_p;
    @FXML
    private TableColumn<produit, String> colnom_p;
    @FXML
    private TableColumn<produit, String> coldesc;
    @FXML
    private TableColumn<produit, Integer> colprix;
    @FXML
    private TableColumn<produit, Integer> colstock;
    @FXML
    private Button btninsert;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btndelete;
    

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    if(event.getSource()==btninsert) {
        insertProduit();
    }
    else if (event.getSource()==btnupdate){
        updateProduit();
    }
    else if(event.getSource()==btndelete)
    {
        deleteProduit();
    }
    }
    
       @Override
    public void initialize(URL url, ResourceBundle rb) {
        ShowProduit();
    }    
    public ObservableList<produit> getProduitList()
    {
    ObservableList<produit> produitList =FXCollections.observableArrayList();
    Connection conn= DB_conn.getInstance().getConnexion();
    String query ="Select * FROM produit";
    Statement st;
    ResultSet rs;
    try {
        st=conn.createStatement();
        rs= st.executeQuery(query);
        produit produit;
        while(rs.next()){
             produit =new produit(rs.getInt("id_p"), rs.getString("nom_p"), rs.getString("description_p"),rs.getInt("prix"),rs.getString("stock"),rs.getString("stock"),rs.getString("stock"));
             produitList.add(produit);
        }
    }catch(SQLException ex){
        ex.printStackTrace();
    }
    return produitList;
    }
    public void ShowProduit()
    {
        ObservableList<produit> list=getProduitList();
        colid_p.setCellValueFactory(new PropertyValueFactory<produit, Integer>("id_p"));
    colnom_p.setCellValueFactory(new PropertyValueFactory<produit, String>("nom_p"));
    coldesc.setCellValueFactory(new PropertyValueFactory<produit, String>("description_p"));
    colprix.setCellValueFactory(new PropertyValueFactory<produit, Integer>("prix"));
    colstock.setCellValueFactory(new PropertyValueFactory<produit, Integer>("stock"));
    tvproduit.setItems(list);//pour affcher les information de la bdd sur la table view
    }
    private void insertProduit()
    {
        String query = "INSERT INTO produit VALUES (" + tfid.getText() + ",'" + tfnom_p.getText() 
                + "','" + tfdesc.getText() + "'," + tfprix.getText() + ",'" + tfstock.getText() + "')";
        
//        "INSERT INTO commande VALUES (" + tfref.getText() + "," + tfid_a.getText() 
//                + ",'" + tfdate.getText() + "'," + tftotal.getText() + ")";
        
    executeQuery(query);
    ShowProduit();
    }

    private void updateProduit(){
        try {
          
            String value1 = tfid.getText();
            String value2 = tfnom_p.getText();
            String value3 = tfdesc.getText();
            String value4 = tfprix.getText();
            String value5 = tfstock.getText();
            String query = "update produit set id_p= '"+value1+"',nom_p= '"+value2+"',description_p= '"+
                    value3+"',prix= '"+value4+"', stock= '"+value5+"' where id_p='"+value1+"' ";
            
            executeQuery(query);
            ShowProduit();
            JOptionPane.showMessageDialog(null, "produit Updated");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }  
      
     }
private void deleteProduit(){
    String query = "DELETE FROM produit WHERE id_p=" + tfid.getText() + "";
executeQuery(query);
ShowProduit();
}
        private void executeQuery(String query) {
        Connection conn= DB_conn.getInstance().getConnexion();
        Statement st;
        try{
           st= conn.createStatement();
           st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
    }



    @FXML
    private void handlMouseAction(MouseEvent event) {
        produit produit =tvproduit.getSelectionModel().getSelectedItem();
    tfid.setText("" +produit.getId_p());
    tfnom_p.setText("" + produit.getNom_p());
    tfdesc.setText("" + produit.getDescription_p());
    tfprix.setText("" + produit.getPrix());
    tfstock.setText("" + produit.getStock());
    }
    
    
}
