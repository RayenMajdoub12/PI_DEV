/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
import Model.commande;
import Services.GeneralServices;
import com.sun.javafx.image.impl.General;
/**
 *
 * @author ASUS
 */
public class CommandeController implements Initializable {
    private Parent fxml;
    
    @FXML
    private TextField tfref;
    @FXML
    private DatePicker tfdate;
    @FXML
    private ComboBox tftotal;
    @FXML
    private TableView<commande> tvcommande;
    @FXML
    private TableColumn<commande, Integer> colref;
    @FXML
    private TableColumn<commande, String> coldate;
    @FXML
    private TableColumn<commande, String> coltotal_e;
    @FXML
    private Button btninsert;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btndelete;
    @FXML
    private Button btnsend;
    @FXML
    private TextField tfid_a;
    @FXML
    private Button btnsend1;

  
    ValidationSupport validationSupport =new ValidationSupport();
   
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    if(event.getSource()==btninsert) {
        insertCommande();
    }
    else if (event.getSource()==btnupdate){
        updateCommande();
    }
    else if(event.getSource()==btndelete)
    {
        deleteCommande();
    }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ShowCommande();
        
        tftotal.setItems(getProduitList());
        validationSupport.registerValidator(tfref,Validator.createEmptyValidator("Text is required"));
        tftotal.getItems().addAll(getProduitList());
        validationSupport.registerValidator(tftotal,Validator.createEmptyValidator("ComboBox Selection required"));
        validationSupport.registerValidator(tfdate,Validator.createEmptyValidator("Date Selection required"));
        validationSupport.registerValidator(tfid_a,Validator.createEmptyValidator("Text is required"));
    }
    public ObservableList<commande> getCommandeList()
    {
    ObservableList<commande> commandeList =FXCollections.observableArrayList();
    Connection conn= Datasource.getInstance().getCnx();
    String query ="Select * FROM commande";
    Statement st;
    ResultSet rs;
    try {
        st=conn.createStatement();
        rs= st.executeQuery(query);
        commande commande;
        while(rs.next()){
             commande =new commande(rs.getInt("réf_c"), rs.getInt("id_a"), rs.getString("date_c"),rs.getString("nom_e"));
             commandeList.add(commande);
        }
    }catch(SQLException ex){
        ex.printStackTrace();
    }
    return commandeList;
    }
     
    public ObservableList<String> getProduitList()
    {
    ObservableList<String> produitList =FXCollections.observableArrayList();
       Connection conn= Datasource.getInstance().getCnx();
    String query ="Select * FROM produit";
    Statement st;
    ResultSet rs;
    try {
        st=conn.createStatement();
        rs= st.executeQuery(query);
        //produit produit;
        while(rs.next()){
             //produit =new produit(rs.getInt("id_p"), rs.getString("nom_p"), rs.getString("description_p"),rs.getInt("prix"),rs.getString("stock"),rs.getString("stock"),rs.getString("stock"));
             produitList.add(String.valueOf(rs.getString("nom_p")));
        }
    }catch(SQLException ex){
        ex.printStackTrace();
    }
    return produitList;
    }
    
    public void ShowCommande()
    {
        ObservableList<commande> list=getCommandeList();
        colref.setCellValueFactory(new PropertyValueFactory<commande, Integer>("réf_c"));
    //colid_a.setCellValueFactory(new PropertyValueFactory<commande, Integer>("id_a"));
    coldate.setCellValueFactory(new PropertyValueFactory<commande, String>("date_c"));
    coltotal_e.setCellValueFactory(new PropertyValueFactory<commande, String>("nom_e"));
    tvcommande.setItems(list);//pour affcher les information de la bdd sur la table view
    }
    private void insertCommande()
    {
//        String query = "INSERT INTO commande VALUES (" + tfref.getText() + "," + 
//                ",'" + tfdate.getValue() + "','" + tftotal.getValue() + "')";
        String query = "INSERT INTO commande VALUES (" + tfref.getText() + "," + tfid_a.getText() + ",'" + tfdate.getValue() + "','" + tftotal.getValue() + "')";
    executeQuery(query);
    ShowCommande();
    }

    private void updateCommande(){
        try {
          
            String value1 = tfref.getText();
            String value2 = tfid_a.getText();
            String value3 = tfdate.getValue().toString();
            String value4 = tftotal.getValue().toString();
//            String query = "update commande set réf_c= '"+value1+"',id_a= '"+value2+"',date_c= '"+
//                    value3+"',nom_e= '"+"value4"+"' where réf_c='"+value1+"' ";
            String query = "update commande set id_a= '"+ value2+"',date_c= '"+ value3+"',nom_e= '"+value4+"' where réf_c='"+value1+"' ";
            
            
            executeQuery(query);
            ShowCommande();
            JOptionPane.showMessageDialog(null, "commande Updated");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }  
      
     }
private void deleteCommande(){
    String query = "DELETE FROM commande WHERE réf_c=" + tfref.getText() + "";
executeQuery(query);
ShowCommande();
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
    
    
        commande commande =tvcommande.getSelectionModel().getSelectedItem();
    tfref.setText("" +commande.getRéf_c());
    tfid_a.setText("" + commande.getId_a());
    //tfdate.setText("" + commande.getDate_c());
    //tftotal.setText("" + commande.getNom_e());
    
            
            }

    @FXML
    private void handlemailAction(ActionEvent event) throws Exception {
        
        GeneralServices gs = new GeneralServices () ;
        String htmlCode =  " <!doctype html>\n" +
"<html lang=\"en-US\">\n" +
"\n" +
"<head>\n" +
"    <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />\n" +
"    <title>Reset Password Email Template</title>\n" +
"    <meta name=\"description\" content=\"Reset Password Email Template.\">\n" +
"    <style type=\"text/css\">\n" +
"        a:hover {text-decoration: underline !important;}\n" +
"    </style>\n" +
"</head>\n" +
"\n" +
"<body marginheight=\"0\" topmargin=\"0\" marginwidth=\"0\" style=\"margin: 0px; background-color: #f2f3f8;\" leftmargin=\"0\">\n" +
"    <!--100% body table-->\n" +
"    <table cellspacing=\"0\" border=\"0\" cellpadding=\"0\" width=\"100%\" bgcolor=\"#f2f3f8\"\n" +
"        style=\"@import url(https://fonts.googleapis.com/css?family=Rubik:300,400,500,700|Open+Sans:300,400,600,700); font-family: 'Open Sans', sans-serif;\">\n" +
"        <tr>\n" +
"            <td>\n" +
"                <table style=\"background-color: #f2f3f8; max-width:670px;  margin:0 auto;\" width=\"100%\" border=\"0\"\n" +
"                    align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
"                    <tr>\n" +
"                        <td style=\"height:80px;\">&nbsp;</td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td style=\"text-align:center;\">\n" +
"                           <h1> Gym Geeks</h1>\n" +
"                          </a>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td style=\"height:20px;\">&nbsp;</td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td>\n" +
"                            <table width=\"95%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\"\n" +
"                                style=\"max-width:670px;background:#fff; border-radius:3px; text-align:center;-webkit-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);-moz-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);box-shadow:0 6px 18px 0 rgba(0,0,0,.06);\">\n" +
"                                <tr>\n" +
"                                    <td style=\"height:40px;\">&nbsp;</td>\n" +
"                                </tr>\n" +
"                                <tr>\n" +
"                                    <td style=\"padding:0 35px;\">\n" +
"                                        <h1 style=\"color:#1e1e2d; font-weight:500; margin:0;font-size:32px;font-family:'Rubik',sans-serif;\">You have a \n" +
"                                            new Order </h1> <br><h1>  <br>\n " +
"                                        <span\n" +
"                                            style=\"display:inline-block; vertical-align:middle; margin:29px 0 26px; border-bottom:1px solid #cecece; width:100px;\"></span>\n" +
"                                        <p style=\"color:#455056; font-size:15px;line-height:24px; margin:0;\">\n" +
"                                            Commande au cours de traitement ...\n" +
"                                           Quand la commande est prete, elle sera automatiquement livré au client correspondant.\n" +
"                                        </p>\n" +
"                                    </td>\n" +
"                                </tr>\n" +
"                                <tr>\n" +
"                                    <td style=\"height:40px;\">&nbsp;</td>\n" +
"                                </tr>\n" +
"                            </table>\n" +
"                        </td>\n" +
"                    <tr>\n" +
"                        <td style=\"height:20px;\">&nbsp;</td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td style=\"text-align:center;\">\n" +
"                            <p style=\"font-size:14px; color:rgba(69, 80, 86, 0.7411764705882353); line-height:18px; margin:0 0 0;\">&copy; <strong>www.GymGeeks.com</strong></p>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td style=\"height:80px;\">&nbsp;</td>\n" +
"                    </tr>\n" +
"                </table>\n" +
"            </td>\n" +
"        </tr>\n" +
"    </table>\n" +
"    <!--/100% body table-->\n" +
"</body>\n" +
"\n" +
"</html> ";
        gs.sendMail("siwar.dhrif5@gmail.com", htmlCode);
                
    }

    @FXML
    private void imprimercom(ActionEvent event) throws SQLException {
     Document Doc = new Document();
         
         Statement st;
         ResultSet rs;
        
          Connection conn= Datasource.getInstance().getCnx();
         
         
         String query = "select * from `commande` WHERE réf_c=(SELECT max(réf_c) FROM `commande`)";
         st = conn.createStatement();
         rs = st.executeQuery(query);
          try {
             
          PdfWriter.getInstance(Doc,new FileOutputStream("C:\\Users\\Rayen\\Desktop\\commande.pdf"));
            Doc.open();
        //C:\Users\Rayen\Desktop\PI_Dev\JAVA_FX\Gestion_User\PI_DEV\images
            Image img = Image.getInstance("C:\\Users\\Rayen\\Desktop\\PI_Dev\\JAVA_FX\\Gestion_User\\PI_DEV\\src\\images\\logo.jpg");
            //C:\Users\Molka\Desktop\gymgeeks git 1\gymgeekss\src
            //C:\Users\ASUS\Documents\NetBeansProjects\GymGeeks2\src\img
            img.scaleAbsoluteWidth(250);
            img.scaleAbsoluteHeight(250);
            img.setAlignment(Image.ALIGN_CENTER);
              Doc.add(new Paragraph("FACTURE :"));
            Doc.add(img);
            //Doc.add(new Paragraph("Nous accompagnons des milliers de clients à domicile, en plein air ou encore en entreprise dans le but de réaliser leurs nombreux objectifs. Notre force ? Une entreprise à taille humaine et des coachs sportifs recrutés avec une grande rigueur qui proposent un suivi client très personnalisé."));
          
            Doc.add(new Paragraph(" "));
            Doc.add(new Paragraph(" "));
            PdfPTable table = new PdfPTable(3) ;
            table.setWidthPercentage(100);
            PdfPCell cell;
            ////////////////////////HEADER////////////////////////////////
//            cell = new PdfPCell(new Phrase ("id_a", FontFactory.getFont("Cambria", 12)) );
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            cell.setBackgroundColor(BaseColor.GRAY);
//            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase ("réf_c", FontFactory.getFont("Cambria", 12)) );
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase ("date_c", FontFactory.getFont("Cambria", 12)) );
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase ("nom_e", FontFactory.getFont("Cambria", 12)) );
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);
           
            
         
             ////////////////////////HEADER////////////////////////////////
              ////////////////////////BODY////////////////////////////////
            while (rs.next()) 
       {
           
//            cell = new PdfPCell(new Phrase (rs.getString("id_a"), FontFactory.getFont("Cambria", 12)) );
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            cell.setBackgroundColor(BaseColor.WHITE);
//            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase (rs.getString("réf_c"), FontFactory.getFont("Cambria", 12)) );
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase (rs.getString("date_c"), FontFactory.getFont("Cambria", 12)) );
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase (rs.getString("nom_e"), FontFactory.getFont("Cambria", 12)) );
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            table.addCell(cell);
            
           
    
       
     
       }
               ////////////////////////BODY////////////////////////////////
           
            
            Doc.add(table);
            Doc.add(new Paragraph("Merci d'avoir choisir notre shop "));
     Doc.add(new Paragraph("*****GYMGEEKS*****"));
     Doc.add(new Paragraph("Votre commande est en train de traitement.... "));
            Doc.close();
            Desktop.getDesktop().open(new File("C:\\Users\\Rayen\\Desktop\\commande.pdf"));
            
        } catch (DocumentException ex) {
            Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
        }   
         
    
    
    
    
    }
}