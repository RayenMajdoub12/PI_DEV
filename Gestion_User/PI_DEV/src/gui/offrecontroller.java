/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Model.evenement;
import Model.offre;
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
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class offrecontroller implements Initializable {

    @FXML
    private TextField tfoff;
    @FXML
    private TextField nomoff;
    @FXML
    private DatePicker datedebutoff;
    @FXML
    private DatePicker datefinoff;
    @FXML
    private TextField descriptionoff;
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
    @FXML
    private Button tfoffsend;
    @FXML
    private Button tfupdateoff;
    @FXML
    private Button tfsupprimeroff;
    @FXML
    private Button tfinsereroff;
        ValidationSupport validationSupport =new ValidationSupport();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          showoffre();
         validationSupport.registerValidator(tfoff,Validator.createEmptyValidator("Text is required"));
        validationSupport.registerValidator(nomoff,Validator.createEmptyValidator("Text is required"));
        validationSupport.registerValidator(datedebutoff,Validator.createEmptyValidator("Text is required"));
        validationSupport.registerValidator(datefinoff,Validator.createEmptyValidator("Text is required"));
        validationSupport.registerValidator(descriptionoff,Validator.createEmptyValidator("Text is required"));
             
    }    

    @FXML
    private void handleMouseAction(MouseEvent event) {
    
    
     offre offre =tvoff.getSelectionModel().getSelectedItem();
    tfoff.setText("" +offre.getId_offre());
   
    //tfdate.setText("" + livraison.getDate_l());
    //tfréf_c.setText("" + livraison.getRéf_c());
    nomoff.setText("" + offre.getNom_o());
   // datedebutoff.setText("" + offre.getDatedebut_o());
    //datefinoff.setText("" + offre.getDatefin_o());
    descriptionoff.setText("" + offre.getDescr_off());
    
    
    }

    @FXML
    private void mailing(ActionEvent event) {
    }

     private void insertoffre() {
 
//        String query = "INSERT INTO livraison VALUES (" + tfid.getText() + ",'" + tfdate.getValue() + "'," + tfréf_c.getValue() + ",'" + tfetat.getText() + "')";
         String query = "INSERT INTO offre VALUES (" +tfoff.getText() + ",'" + nomoff.getText() + "','" + datedebutoff.getValue()+ "', '"+ datefinoff.getValue()+"', '"+ descriptionoff.getText()+"')";
//        "INSERT INTO commande VALUES (" + tfref.getText() + "," + tfid_a.getText() 
//                + ",'" + tfdate.getText() + "'," + tftotal.getText() + ")";
        
    executeQuery(query);
    showoffre();
     Image img = new Image("/images/success-24.png", 50, 50, false, false);
               Notifications notificationbuilder = Notifications.create().title("insertion avec succès").
                    graphic(new ImageView(img)).
                    hideAfter(Duration.seconds(5)).
                    position(Pos.BOTTOM_RIGHT).
                    onAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("clicked on notification");
                        }
                    });
            notificationbuilder.darkStyle();
            notificationbuilder.show();
     }  
    @FXML
    private void handleButtonAction(ActionEvent offre) {
         System.out.println("You clicked me!");
        //label.setText("Hello World!");
    
      if(offre.getSource() == tfinsereroff){
            insertoffre();
        }else if (offre.getSource() == tfupdateoff){
           updateoffre();
        }else if(offre.getSource() == tfsupprimeroff){
           deleteoffre();
    }}
    
          private void updateoffre() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           try {
          
            String value1 = tfoff.getText();
          
            String value2= nomoff.getText();
                     String value5= datedebutoff.getValue().toString();
                     String value6= datefinoff.getValue().toString();
            //String value4 = tfréf_c.getText();
            String value7 = descriptionoff.getText();
           //String query = "update livraison set id_l= '"+value1+"',date_l= '"+ value3+"',Réf_c= "+"value4"+", état= '"+value5+"' where id_l='"+value1+"' ";
//            String query = "update livraison set id_l= '"+value1+"
//',id_a= '"+value2+"',date_l= '"+ value3+"',réf_c= '"+"value4"+"', état= '"+value5+"' where id_l='"+value1+"' ";
            String query = "update offre set nom_o= '"+value2+"', datedebut_o= '"+value5+"',datefin_o= '"+value6+"',descr_off= '"+value7+"' where id_offre='"+value1+"'";
executeQuery(query);
            showoffre();
            JOptionPane.showMessageDialog(null, "evenement Updated");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }  
       Image img = new Image("/images/success-24.png", 50, 50, false, false);
               Notifications notificationbuilder = Notifications.create().title("mise a jour  avec succès").
                    graphic(new ImageView(img)).
                    hideAfter(Duration.seconds(5)).
                    position(Pos.BOTTOM_RIGHT).
                    onAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("clicked on notification");
                        }
                    });
            notificationbuilder.darkStyle();
            notificationbuilder.show();
    
    
    
    
    
    }
        private void deleteoffre() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       String query = "DELETE FROM offre WHERE id_offre=" + tfoff.getText() + "";
executeQuery(query);
showoffre();

     Image img = new Image("/images/success-24.png", 50, 50, false, false);
               Notifications notificationbuilder = Notifications.create().title("suppression avec succès").
                    graphic(new ImageView(img)).
                    hideAfter(Duration.seconds(5)).
                    position(Pos.BOTTOM_RIGHT).
                    onAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("clicked on notification");
                        }
                    });
            notificationbuilder.darkStyle();
            notificationbuilder.show();
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
