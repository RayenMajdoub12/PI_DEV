/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import Model.evenement;
import Model.livraison;
import java.net.URL;
import java.sql.Connection;
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

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class evenementcontroller implements Initializable {

    @FXML
    private TextField tfideve;
    @FXML
    private TextField tfnomeve;
    @FXML
    private TextField tfprixeve;
    @FXML
    private DatePicker datedebuteve;
    @FXML
    private DatePicker datefineve;
    @FXML
    private TextField tfdescriptioneve;
    @FXML
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
    private Button tfinserereve;
    @FXML
    private Button tfsupprimereve;
    @FXML
    private Button tfupdateeve;
    @FXML
    private Button tfevesend;
    @FXML
    private TableColumn<evenement, String> colieu;
    @FXML
    private TextField tflieu;
        ValidationSupport validationSupport =new ValidationSupport();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     showevent();
         validationSupport.registerValidator(tfideve,Validator.createEmptyValidator("Text is required"));
        validationSupport.registerValidator(tfnomeve,Validator.createEmptyValidator("Text is required"));
        validationSupport.registerValidator(tfprixeve,Validator.createEmptyValidator("Text is required"));
        validationSupport.registerValidator(tflieu,Validator.createEmptyValidator("Text is required"));
        validationSupport.registerValidator(datedebuteve,Validator.createEmptyValidator("Text is required"));
                validationSupport.registerValidator(datefineve,Validator.createEmptyValidator("Text is required"));
        validationSupport.registerValidator(tfdescriptioneve,Validator.createEmptyValidator("Text is required"));

//combo.setItems(getBlogList());
    }   
 public void showevent()
    {   tvevents.getItems().clear();
        ObservableList<evenement> list=getEventList();
        coid_e.setCellValueFactory(new PropertyValueFactory<evenement, Integer>("id"));
    //colid_a.setCellValueFactory(new PropertyValueFactory<livraison, Integer>("id_a"));
    co_nomev.setCellValueFactory(new PropertyValueFactory<evenement, String>("nom"));
    coprixeve.setCellValueFactory(new PropertyValueFactory<evenement, Integer>("prix"));
    colieu.setCellValueFactory(new PropertyValueFactory<evenement, String>("lieu"));
    codatedeve .setCellValueFactory(new PropertyValueFactory<evenement, String>("datedebut"));
     codatefineve .setCellValueFactory(new PropertyValueFactory<evenement, String>("datefin"));
         codesceve .setCellValueFactory(new PropertyValueFactory<evenement, String>("description"));
     tvevents.setItems(list);//pour affcher les information de la bdd sur la table view
    }

   
    @FXML
    private void handleButtonAction(ActionEvent event) {
   System.out.println("You clicked me!");
        //label.setText("Hello World!");
    
      if(event.getSource() == tfinserereve){
            insertevent();
        }else if (event.getSource() == tfupdateeve){
           updateevent();
        }else if(event.getSource() == tfsupprimereve){
           deleteevent();
    }}
    


//    @FXML
//    private void mailing(ActionEvent event) throws Exception {
//        Email.sendmail("mohamedgasmi1998@gmail.com");
//    }



    private void updateevent() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           try {
          
            String value1 = tfideve.getText();
          
            String value2= tfnomeve.getText();
               String value3= tfprixeve.getText();
                  String value4= tflieu.getText();
                     String value5= datedebuteve.getValue().toString();
                     String value6= datefineve.getValue().toString();
            //String value4 = tfréf_c.getText();
            String value7 = tfdescriptioneve.getText();
           //String query = "update livraison set id_l= '"+value1+"',date_l= '"+ value3+"',Réf_c= "+"value4"+", état= '"+value5+"' where id_l='"+value1+"' ";
//            String query = "update livraison set id_l= '"+value1+"
//',id_a= '"+value2+"',date_l= '"+ value3+"',réf_c= '"+"value4"+"', état= '"+value5+"' where id_l='"+value1+"' ";
            String query = "update evenement set id= "+value1+",nom= '"+value2+"',prix= '"+value3+"',lieu= '"+value4+"', datedebut= '"+value5+"',datefin= '"+value6+"',description= '"+value7+"' where id='"+value1+"'";
executeQuery(query);
            showevent();
            JOptionPane.showMessageDialog(null, "evenement Updated");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }  
      
    
    
    
    
    
    }

    private void deleteevent() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       String query = "DELETE FROM evenement WHERE id=" + tfideve.getText() + "";
executeQuery(query);
showevent();
    
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

     private void insertevent() {
 
//        String query = "INSERT INTO livraison VALUES (" + tfid.getText() + ",'" + tfdate.getValue() + "'," + tfréf_c.getValue() + ",'" + tfetat.getText() + "')";
         String query = "INSERT INTO evenement VALUES (" + tfideve.getText() + ",'" + tfnomeve.getText() + "'," + tfprixeve.getText() + ",'" +tflieu.getText() + "','" + datedebuteve.getValue()+ "', '"+ datefineve.getValue()+"', '"+ tfdescriptioneve.getText()+"')";
//        "INSERT INTO commande VALUES (" + tfref.getText() + "," + tfid_a.getText() 
//                + ",'" + tfdate.getText() + "'," + tftotal.getText() + ")";
        
    executeQuery(query);
    showevent();}  

    @FXML
      private void handleMouseAction(MouseEvent event) {

     evenement evenement =tvevents.getSelectionModel().getSelectedItem();
    tfideve.setText("" +evenement.getId());
   
    //tfdate.setText("" + livraison.getDate_l());
    //tfréf_c.setText("" + livraison.getRéf_c());
    tfnomeve.setText("" + evenement.getNom());
    tfprixeve.setText("" + evenement.getPrix());
    tflieu.setText("" + evenement.getLieu());
     tfdescriptioneve.setText("" + evenement.getDescription());
    
    }

    private void executeQuery(String query) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
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
    private void mailing(ActionEvent event) {
    }
     
     
}













































