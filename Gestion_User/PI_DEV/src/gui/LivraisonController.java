/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;
import Conn.Datasource;
import Model.livraison;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class LivraisonController implements Initializable {

    @FXML
    private TextField tfid;
   
    @FXML
    private DatePicker tfdate;
    @FXML
    private ComboBox tfréf_c;
    @FXML
    private TextField tfetat;
    @FXML
    private TableView<livraison> tvlivraison;
    @FXML
    private TableColumn<livraison, Integer> colid;
   
    @FXML
    private TableColumn<livraison, String> coldate;
    @FXML
    private TableColumn<livraison, Integer> colréf_c;
    @FXML
    private TableColumn<livraison, String> coletat;
    @FXML
    private Button btninsert;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btndelete;
ValidationSupport validationSupport =new ValidationSupport();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ShowLivraison();
       tfréf_c.setItems(getCommandeList());
      
        validationSupport.registerValidator(tfid,Validator.createEmptyValidator("Text is required"));
         validationSupport.registerValidator(tfetat,Validator.createEmptyValidator("Text is required"));
        tfréf_c.getItems().addAll(getCommandeList());
        validationSupport.registerValidator(tfréf_c,Validator.createEmptyValidator("ComboBox Selection required"));
        validationSupport.registerValidator(tfdate,Validator.createEmptyValidator("Date Selection required"));
  
       
    }    


    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    if(event.getSource()==btninsert) {
        insertLivraison();
    }
    else if (event.getSource()==btnupdate){
        updateLivraison();
    }
    else if(event.getSource()==btndelete)
    {
        deleteLivraison();
    }
    }
    
    public ObservableList<livraison> getLivraisonList()
    {
    ObservableList<livraison> livraisonList =FXCollections.observableArrayList();
   Connection conn= Datasource.getInstance().getCnx();
    String query ="Select * FROM livraison";
    Statement st;
    ResultSet rs;
    try {
        st=conn.createStatement();
        rs= st.executeQuery(query);
        livraison livraison;
        while(rs.next()){
             livraison =new livraison(rs.getInt("id_l"), rs.getString("date_l"),rs.getInt("réf_c"),rs.getString("état"));
             livraisonList.add(livraison);
        }
    }catch(SQLException ex){
        ex.printStackTrace();
    }
    return livraisonList;
    
    
    
    
    
    }
    public ObservableList<String> getCommandeList()
    {
    ObservableList<String> commandeList =FXCollections.observableArrayList();
    Connection conn= Datasource.getInstance().getCnx();
    String query ="Select * FROM commande";
    Statement st;
    ResultSet rs;
    try {
        st=conn.createStatement();
        rs= st.executeQuery(query);
        //commande commande;
        while(rs.next()){
             //commande =new commande(rs.getInt("réf_c"), rs.getInt("id_a"), rs.getString("date_c"),rs.getInt("total_e"));
             commandeList.add(String.valueOf(rs.getInt("réf_c")));
        }
    }catch(SQLException ex){
        ex.printStackTrace();
    }
    
    return commandeList;
    }
    
    public void ShowLivraison()
    {
        ObservableList<livraison> list=getLivraisonList();
        colid.setCellValueFactory(new PropertyValueFactory<livraison, Integer>("id_l"));
    //colid_a.setCellValueFactory(new PropertyValueFactory<livraison, Integer>("id_a"));
    coldate.setCellValueFactory(new PropertyValueFactory<livraison, String>("date_l"));
    colréf_c.setCellValueFactory(new PropertyValueFactory<livraison, Integer>("réf_c"));
    coletat.setCellValueFactory(new PropertyValueFactory<livraison, String>("état"));
    tvlivraison.setItems(list);//pour affcher les information de la bdd sur la table view
    }
    private void insertLivraison()
    {
        // commande cmd=(commande)tfréf_c.getValue();
//        String query = "INSERT INTO livraison VALUES (" + tfid.getText() + ",'" + tfdate.getValue() + "'," + tfréf_c.getValue() + ",'" + tfetat.getText() + "')";
         String query = "INSERT INTO livraison VALUES (" + tfid.getText() + ",'" + tfdate.getValue() + "'," + tfréf_c.getValue() + ",'" + tfetat.getText() + "')";
//        "INSERT INTO commande VALUES (" + tfref.getText() + "," + tfid_a.getText() 
//                + ",'" + tfdate.getText() + "'," + tftotal.getText() + ")";
        
    executeQuery(query);
    ShowLivraison();
    }

    private void updateLivraison(){
        try {
          
            String value1 = tfid.getText();
          
            String value3 = tfdate.getValue().toString();
            String value4 = tfréf_c.getValue().toString();
            String value5 = tfetat.getText();
           //String query = "update livraison set id_l= '"+value1+"',date_l= '"+ value3+"',Réf_c= "+"value4"+", état= '"+value5+"' where id_l='"+value1+"' ";
//            String query = "update livraison set id_l= '"+value1+"
//',id_a= '"+value2+"',date_l= '"+ value3+"',réf_c= '"+"value4"+"', état= '"+value5+"' where id_l='"+value1+"' ";
            String query = "update livraison set id_l= "+value1+",date_l= '"+value3+"',réf_c= '"+value4+"',état= '"+value5+"' where id_l="+value1+"";
executeQuery(query);
            ShowLivraison();
            JOptionPane.showMessageDialog(null, "livraison Updated");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }  
      
     }
private void deleteLivraison(){
    String query = "DELETE FROM livraison WHERE id_l=" + tfid.getText() + "";
executeQuery(query);
ShowLivraison();
}
        private void executeQuery(String query) {
       Connection conn= Datasource.getInstance().getCnx();
        Statement st;
        try{
           st= conn.createStatement();
           st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
    }


    
    
    
    @FXML
    private void handleMouseAction(MouseEvent event) {
     livraison livraison =tvlivraison.getSelectionModel().getSelectedItem();
    tfid.setText("" +livraison.getId_l());
   
    //tfdate.setText("" + livraison.getDate_l());
    //tfréf_c.setText("" + livraison.getRéf_c());
    tfetat.setText("" + livraison.getÉtat());
    }
}
