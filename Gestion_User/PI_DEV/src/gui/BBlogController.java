/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.itextpdf.text.BadElementException;
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
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javax.swing.JOptionPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.ToggleGroup;


import java.awt.HeadlessException;
import javafx.scene.control.ComboBox;
//import javafx.scene.image.Image;
import org.controlsfx.control.Rating;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;
import Conn.Datasource;
import Model.blog;
/**
 *
 * @author Molka
 */
public class BBlogController implements Initializable {
    
    private Label label;
    @FXML
    private TextField tfid_b;
    @FXML
    private TextField tftitre;
    @FXML
    private TextField tfdescription;
    @FXML
    private TextField tfcontenu;
    @FXML
    private TextField tfimageblog;
    @FXML
    private TableView<blog> tvblogs;
    @FXML
    private TableColumn<blog, Integer> coid_b;
    @FXML
    private TableColumn<blog, String> cotitre;
    @FXML
    private TableColumn<blog, String> codescription;
    @FXML
    private TableColumn<blog, String> cocontenu;
    @FXML
    private TableColumn<blog, String> coimage;
    @FXML
    private Button tfinsererblog;
    @FXML
    private Button tfsupprimerblog;
    @FXML
    private Button tfupdateblog;
    @FXML
    private Button tfimprimer;
    @FXML
    private Button btnbrowser;
        private Image image,image1;
      private String uuid;
//    private FileInputStream fis;
    private Desktop desktop = Desktop.getDesktop();
//    final FileChooser fileChooser = new FileChooser();
//        final Button openButton = new Button("Open a Picture...");
//        final Button openMultipleButton = new Button("Open Pictures..."); 
     private FileChooser fc = new FileChooser();
    private File f;
    ValidationSupport validationSupport =new ValidationSupport();
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        //label.setText("Hello World!");
    
      if(event.getSource() == tfinsererblog){
            insertblog();
        }else if (event.getSource() == tfupdateblog){
           updateblog();
        }else if(event.getSource() == tfsupprimerblog){
           deleteblog();
        }
      else if (event.getSource() == btnbrowser){
                   browserblog();
                   }
           
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     
   showblog();
   
        validationSupport.registerValidator(tfid_b,Validator.createEmptyValidator("Text is required"));
        validationSupport.registerValidator(tftitre,Validator.createEmptyValidator("Text is required"));
        validationSupport.registerValidator(tfimageblog,Validator.createEmptyValidator("Text is required"));
        validationSupport.registerValidator(tfcontenu,Validator.createEmptyValidator("Text is required"));
        validationSupport.registerValidator(tfdescription,Validator.createEmptyValidator("Text is required"));
   //combo.setItems(getBlogList());
    
    }    
     
      public ObservableList<blog> getBlogList(){
        ObservableList<blog> blogList = FXCollections.observableArrayList();
        Connection conn= Datasource.getInstance().getCnx();
        String query = "SELECT * FROM blog";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            blog blog;
            while(rs.next()){
                blog = new blog(rs.getInt("id_blog"), rs.getString("titre"), rs.getString("description"), rs.getString("contenu"),rs.getString("image_b"));
                blogList.add(blog);
            }
                
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return blogList;
    }
     
    
       public void showblog(){
           tvblogs.getItems().clear();
        ObservableList<blog> list = getBlogList();
        
        coid_b.setCellValueFactory(new PropertyValueFactory<blog, Integer>("id_blog"));
        cotitre.setCellValueFactory(new PropertyValueFactory<blog, String>("titre"));
        codescription.setCellValueFactory(new PropertyValueFactory<blog, String>("description"));
        cocontenu.setCellValueFactory(new PropertyValueFactory<blog, String>("contenu"));
        coimage.setCellValueFactory(new PropertyValueFactory<blog, String>("image_b"));
        
        tvblogs.setItems(list);
    }
   
        
     private void insertblog(){
        String query = "INSERT INTO blog VALUES (" + tfid_b.getText() + ",'" + tftitre.getText() + "','" + tfdescription.getText() + "','"
                + tfcontenu.getText() + "','" + tfimageblog.getText() + "')";
        executeQuery(query);
        showblog();
    }
    private void updateblog(){
//
//     try {
          
            String value1 = tfid_b.getText();
            String value2 = tftitre.getText();
            String value3 = tfdescription.getText();
            String value4 = tfcontenu.getText();
            String value5 = tfimageblog.getText();
            String query = "update blog set id_blog= "+value1+",titre= '"+value2+"',description= '"+
                    value3+"',contenu= '"+value4+"',image_b= '"+value5+"' where id_blog="+value1+" ";
            
            executeQuery(query);
            showblog();
////            JOptionPane.showMessageDialog(null, "Blog Updated");
           
//        } catch (HeadlessException e) {
//            JOptionPane.showMessageDialog(null, e);
        }  
      
     
    
    
       private void deleteblog(){
        String query = "DELETE FROM blog WHERE id_blog =" + tfid_b.getText() + "";
        executeQuery(query);
        showblog();
    }
    
    
    private void executeQuery(String query) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
  
      Connection conn= Datasource.getInstance().getCnx();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
//    private void handleMouseAction(MouseEvent event) {
//    
//    
//        commande commande =tvcommande.getSelectionModel().getSelectedItem();
//    tfref.setText("" +commande.getRéf_c());
//    tfid_a.setText("" + commande.getId_a());
//    tfdate.setText("" + commande.getDate_c());
//    tftotal.setText("" + commande.getTotal_e());
//    
//            
//            }

    @FXML
    private void handleMouseAction(MouseEvent event) {
    
    
        blog blog =tvblogs.getSelectionModel().getSelectedItem();
    tfid_b.setText("" +blog.getId_blog());
    tftitre.setText("" +blog.getTitre());
    tfdescription.setText("" + blog.getDescription());
    tfcontenu.setText("" + blog.getContenu());
    tfimageblog.setText("" + blog.getImage_b());
    
            
            }

    
    private void configureFileChooser(FileChooser fileChooser) {
         //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
    
            fileChooser.setTitle("View Pictures");
        //   fileChooser.setInitialDirectory( new File(System.getProperty("User.Desktop"))
        boolean addAll = fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png"))
;
    }

    private void openFile(File file) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(
                Level.SEVERE, null, ex
            );
        }
    }
      
    private void browserblog() throws IOException {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    
       configureFileChooser(fc);
        Window stage = null;
                     f = fc.showOpenDialog(stage);
                    if (f != null) {
              //   imagearea.setText(file.getAbsolutePath());
                //imagearea = new ImageView(file.toURI().toString(), 100, 150, true, true);//path, PrefWidth, PrefHeight, PreserveRatio, Smooth
                
                //imagearea = new ImageView(image);
                //imagearea.setFitWidth(100);
                //imagearea.setFitHeight(150);
                //imagearea.setPreserveRatio(true);
                
                //layout.setCenter(imageView);
               // BorderPane.setAlignment(imageView, Pos.TOP_LEFT);
 openFile(f); 
 uuid=UUID.randomUUID().toString().replaceAll("--","")+".jpg";                         
 //Image  image1;
// image1 = new Image (f.toURI().toString(),100,150,true,true) ;
// imagearea.setImage(image1); 
// Utils u =new Utils();
// String Emp ="C:\\Users\\Molka\\Desktop\\imagegym\\"+uuid;
// //C:\Users\Molka\Desktop\imagegym       
// u.CopyImage(Emp, f.toPath().toString());
   }
    
    
    
    }

    @FXML
    private void imprimer(ActionEvent event) throws SQLException {
   
    
         Document Doc = new Document();
         
         Statement st;
         ResultSet rs;
        
         Connection conn= Datasource.getInstance().getCnx();
         
         
         String query = "select * from `blog`";
         st = conn.createStatement();
         rs = st.executeQuery(query);
         
         try {
             
          PdfWriter.getInstance(Doc,new FileOutputStream("C:\\Users\\Rayen\\Desktop\\blog.pdf"));
            Doc.open();
        
            //Image img = Image.getInstance("C:\\Users\\Molka\\Desktop\\gymgeeks git 1\\gymgeekss\\src\\Img\\logo.jpg");
            Image img = Image.getInstance("C:\\Users\\Rayen\\Desktop\\PI_Dev\\JAVA_FX\\Gestion_User\\PI_DEV\\src\\images\\logo.jpg");            
//C:\Users\Molka\Desktop\gymgeeks git 1\gymgeekss\src
            img.scaleAbsoluteWidth(400);
            img.scaleAbsoluteHeight(300);
            img.setAlignment(Image.ALIGN_CENTER);
            Doc.add(img);
             Doc.add(new Paragraph("Nous accompagnons des milliers de clients à domicile, en plein air ou encore en entreprise dans le but de réaliser leurs nombreux objectifs. Notre force ? Une entreprise à taille humaine et des coachs sportifs recrutés avec une grande rigueur qui proposent un suivi client très personnalisé."));
            Doc.add(new Paragraph("vos blogs :"));
            Doc.add(new Paragraph(" "));
            Doc.add(new Paragraph(" "));
            PdfPTable table = new PdfPTable(3) ;
            table.setWidthPercentage(100);
            PdfPCell cell;
            ////////////////////////HEADER////////////////////////////////
//            cell = new PdfPCell(new Phrase ("id_blog", FontFactory.getFont("Cambria", 12)) );
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            cell.setBackgroundColor(BaseColor.GRAY);
//            table.addCell(cell);
//            
            cell = new PdfPCell(new Phrase ("titre", FontFactory.getFont("Cambria", 12)) );
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase ("description", FontFactory.getFont("Cambria", 12)) );
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase ("contenu", FontFactory.getFont("Cambria", 12)) );
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);
           
//            
//            cell = new PdfPCell(new Phrase ("image_b", FontFactory.getFont("Cambria", 12)) );
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            cell.setBackgroundColor(BaseColor.GRAY);
//            table.addCell(cell);
             ////////////////////////HEADER////////////////////////////////
              ////////////////////////BODY////////////////////////////////
            while (rs.next()) 
       {
//           
//            cell = new PdfPCell(new Phrase (rs.getString("id_blog"), FontFactory.getFont("Cambria", 12)) );
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            cell.setBackgroundColor(BaseColor.WHITE);
//            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase (rs.getString("titre"), FontFactory.getFont("Cambria", 12)) );
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase (rs.getString("description"), FontFactory.getFont("Cambria", 12)) );
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase (rs.getString("contenu"), FontFactory.getFont("Cambria", 12)) );
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            table.addCell(cell);
            
//            cell = new PdfPCell(new Phrase (rs.getString("image_b"), FontFactory.getFont("Cambria", 12)) );
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            cell.setBackgroundColor(BaseColor.WHITE);
//            table.addCell(cell);
//    
       
        table.addCell(cell);
       }
               ////////////////////////BODY////////////////////////////////
           
            
            Doc.add(table);
            Doc.close();
            Desktop.getDesktop().open(new File("C:\\Users\\Rayen\\Desktop\\blog.pdf"));
            
        } catch (DocumentException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }   
         
    
    
    
    
    
    
    
    }

//    private static class ImageImpl extends Image {
//
//        public ImageImpl(String toString, int i, int i0, boolean b, boolean b0) {
//          //  super(toString, i, i0, b, b0);
//        }
//    }
}

