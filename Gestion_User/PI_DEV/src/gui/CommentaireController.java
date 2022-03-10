/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;



import static Model.BadWords.chackwords;
import Model.blog;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.controlsfx.control.Rating;
import org.controlsfx.control.Notifications;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import Conn.Datasource;
import Model.commentaire;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CommentaireController implements Initializable {

    @FXML
    private Button com;
    @FXML
    private TextField comment;
    @FXML
    private ComboBox combo;
    private TableView<commentaire> table;
    @FXML
    private TableColumn<commentaire, String> list1;
    @FXML
    private ImageView produitImage;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private Label BlogNameLabel;
    private Rating rate;
    private Label msg;
      private List<blog> blogs = new ArrayList<>();
    private Image image;
    private MyListener1 myListener1;
    @FXML
    private VBox chosenProduitCard;
    @FXML
    private Rating rating;
    ValidationSupport validationSupport =new ValidationSupport();
private List<blog> getData() {
        List<blog> blogs = new ArrayList<>();
        blog Blog;
        Blog = new blog();
        Blog.setTitre("Fitness");
        Blog.setContenu("Contenu:");
        Blog.setDescription("Le fitness abréviation  \n" +
" de l'expression anglaise\n" +
                " physical fitness, « forme physique »,\n" +
" aussi appelé la gymnastique de forme \n" +
"ou l'entraînement physique");
        Blog.setImage_b("/images/fitness.jpg");
      Blog.setColor("DC143C");
        blogs.add(Blog);
        
         Blog = new blog();
        Blog.setTitre("Gymnastique");
        Blog.setContenu("Contenu:");
        Blog.setDescription("Le gymnastique abréviation  \n" +
" de l'expression anglaise\n" +
                " physical fitness, « forme physique »,\n" +
" aussi appelé la gymnastique de forme \n" +
"ou l'entraînement physique");
        Blog.setImage_b("/images/gymn.jpg");
      Blog.setColor("20B2AA");
        blogs.add(Blog);
        
        
        
        Blog = new blog();
        Blog.setTitre("Boxe");
        Blog.setContenu("Contenu:");
        Blog.setDescription("Le Boxe abréviation  \n" +
" de l'expression anglaise\n" +
                " physical fitness, « forme physique »,\n" +
" aussi appelé la gymnastique de forme \n" +
"ou l'entraînement physique");
        Blog.setImage_b("/images/boxe.PNG");
      Blog.setColor("FF7F50");
        blogs.add(Blog);
        
       Blog = new blog();
        Blog.setTitre("Natation");
        Blog.setContenu("Contenu:");
        Blog.setDescription(" natation description  \n" );
        Blog.setImage_b("/images/e.jpg");
      Blog.setColor("6495ED");
        blogs.add(Blog);   
        
       return blogs;
}   
        
        
        /**
     * Initializes the controller class.
     */
private void setChosenBlog(blog blog) {
        BlogNameLabel.setText(blog.getTitre());
       // produitPriceLabel.setText(GymGeeks.CURRENCY + produit.getPrix());
        image = new Image(getClass().getResourceAsStream(blog.getImage_b()));
        produitImage.setImage(image);
        chosenProduitCard.setStyle("-fx-background-color: #" + blog.getColor() + ";\n" +
                "    -fx-background-radius: 30;");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        validationSupport.registerValidator(comment,Validator.createEmptyValidator("Text is required"));
        combo.getItems().addAll(getBlogList());
        validationSupport.registerValidator(combo,Validator.createEmptyValidator("ComboBox Selection required"));
//        rate.ratingProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
         //   msg.setText("rating :- "+newValue);
        //});
           combo.setItems(getBlogList());
                   
           blogs.addAll(getData());
        if (blogs.size() > 0) {
            setChosenBlog(blogs.get(0));
            myListener1 = new MyListener1() {
                @Override
                public void onClickListener1(blog blog) {
                    setChosenBlog(blog);
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < blogs.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("item_1.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                Item_1Controller item_1Controller = fxmlLoader.getController();
                item_1Controller.setData(blogs.get(i),myListener1);

                if (column == 1) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
                GridPane.setMargin(anchorPane, new Insets(10));
                //GridPane.setMargin(anchorPane, new Insets(5, 0, 0, 0));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
//         public void showcom(){
//     commentaire e = null;
     
//    commServices v =  new  commServices() ;
           // System.out.println(e.getId_blog());
//            ArrayList arrayList = (ArrayList) v.AfficherAllComm();
//            ObservableList observablelist = FXCollections.observableArrayList(arrayList);
//            
//             list1.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
//             table.setItems(observablelist);
//        
//        }
    
    public ObservableList<commentaire> getCommentaireList()
    {
    ObservableList<commentaire> commentaireList =FXCollections.observableArrayList();
  Connection conn= Datasource.getInstance().getCnx();
    String query ="Select * FROM com_event";
    Statement st;
    ResultSet rs;
    try {
        st=conn.createStatement();
        rs= st.executeQuery(query);
        commentaire commentaire;
        while(rs.next()){
             commentaire =new commentaire(rs.getString("commentaire"), rs.getString("titreEvenement"));
             commentaireList.add(commentaire);
        }
    }catch(SQLException ex){
        ex.printStackTrace();
    }
    
    return commentaireList;
    }
    
    public void ShowCommentaire()
    {
        ObservableList<commentaire> list=getCommentaireList();
        list1.setCellValueFactory(new PropertyValueFactory<commentaire,String>("commentaire"));
        table.setItems(list);

    }
         
         
         public ObservableList<String> getBlogList(){
        ObservableList<String> blogList = FXCollections.observableArrayList();
  Connection conn= Datasource.getInstance().getCnx();
        String query = "SELECT * FROM blog";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            //blog blog;
            while(rs.next()){
                //blog = new blog(rs.getInt("id_blog"), rs.getString("titre"), rs.getString("description"), rs.getString("contenu"),rs.getString("image_b"));
                blogList.add(String.valueOf(rs.getString("titre")));
            }
                
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return blogList;
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
      
      private void insertCommentaire(){
        try {
            if(chackwords(comment.getText()).equals("false")){
                String query = "INSERT INTO com_event VALUES ('" + comment.getText() + "','" + combo.getValue() + "')";
//        "INSERT INTO commande VALUES (" + tfref.getText() + "," + tfid_a.getText()
//                + ",'" + tfdate.getText() + "'," + tftotal.getText() + ")";


executeQuery(query);
             Notifications notificationBuilder=Notifications.create();
        notificationBuilder.title("Commentaire inséré avec succés");
        Image img=new Image("/images/icon_bell.png");
                notificationBuilder.text("Merci");
                notificationBuilder.graphic(new ImageView(img));
                 notificationBuilder.darkStyle();
                notificationBuilder.hideAfter(Duration.seconds(5));
                notificationBuilder.position(Pos.BOTTOM_RIGHT);
//         insertCommentaire();
       notificationBuilder.darkStyle();
       notificationBuilder.show();     
            }
            else
            {
              Notifications notificationBuilder=Notifications.create();
        notificationBuilder.title("Commentaire notfications");    
              notificationBuilder.text("bad word");
          notificationBuilder.darkStyle();
          notificationBuilder.hideAfter(Duration.seconds(5));
          notificationBuilder.position(Pos.BOTTOM_RIGHT);
//         insertCommentaire();
notificationBuilder.darkStyle();
notificationBuilder.show();      
            }
            ShowCommentaire();  
        } catch (IOException ex) {
            Logger.getLogger(CommentaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
             @FXML
    private void commenter(ActionEvent event) {
  
   System.out.println("You clicked me!");
    if(event.getSource()==com) {
        
    insertCommentaire();
          
          
     }
        //insertCommentaire();
//            Image img=new Image("/img/icon_bell.png");
//        Notifications notificationBuilder=Notifications.create();
//        notificationBuilder.title("Download Complete");
//                notificationBuilder.text("Saved to home/downloads");
               // notificationBuilder.graphic(new ImageView(img));
//                notificationBuilder.hideAfter(Duration.seconds(5));
//                notificationBuilder.position(Pos.BOTTOM_RIGHT);
//         insertCommentaire();
//        notificationBuilder.darkStyle();
//       notificationBuilder.show();      

   }
       
    }
 

