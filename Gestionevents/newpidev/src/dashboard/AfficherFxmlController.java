/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modele.Evenements;
import service.EvenementService;
import javafx.scene.image.Image;
/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class AfficherFxmlController implements Initializable {

    @FXML
    private AnchorPane holderPane;
    @FXML
    private VBox verticalbox;
    @FXML
    private Label nomlab;
    @FXML
    private Label prixlab;
    @FXML
    private Label lieulab;
    @FXML
    private Label datedeb;
    @FXML
    private Label datefin;
    @FXML
    private Label descrip;
    @FXML
    private Button ajouter12;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ListView e = new ListView();
          ObservableList<AnchorPane> pubss= FXCollections.observableArrayList();

        EvenementService s= new EvenementService();
        for (int i = 0; i <   s.read().size(); i++) {
              Evenements get =   s.read().get(i);
                          AnchorPane v= new AnchorPane();
                          v.setPrefHeight(546.0);
                          v.setPrefWidth(737.0);
                       
    
                  Image llss = new Image("/dashboard/"+i+".jpg");
                    ImageView imav= new ImageView(llss);
                   imav.setFitHeight(358.0);
                   imav.setFitWidth(239.0);
                   imav.setLayoutX(459.0);
                   imav.setLayoutY(113.0);

                          Text t1=new Text();
                          Text t2=new Text();
                          Text t3=new Text();
                          Text t4=new Text();
                          Text t5=new Text();
                          Text t6=new Text();

    
                          Label l1= new Label();
                          Label l2= new Label();
                          Label l3= new Label();
                          Label l4= new Label();
                          Label l5= new Label();
                          Label l6= new Label();
                          
                t1.setLayoutY(105.0);
        t1.setLayoutX(72.0);
        t1.setStrokeType(StrokeType.OUTSIDE);
        t1.setStrokeWidth(0.0);
        t1.setText("nom:");
        t1.setWrappingWidth(67.55859375);             
                  

    t2.setLayoutY(161.0);
        t2.setLayoutX(72.0);
        t2.setStrokeType(StrokeType.OUTSIDE);
        t2.setStrokeWidth(0.0);
        t2.setText("prix:");
                     t2.setWrappingWidth(67.55859375);             

        
          t3.setLayoutY(228.0);
        t3.setLayoutX(70.0);
        t3.setStrokeType(StrokeType.OUTSIDE);
        t3.setStrokeWidth(0.0);
        t3.setText("lieu:");
                t3.setWrappingWidth(67.55859375);             


         t4.setLayoutY(334.0);
        t4.setLayoutX(59.0);
        t4.setStrokeType(StrokeType.OUTSIDE);
        t4.setStrokeWidth(0.0);
        t4.setText("date_deb:");
        t4.setWrappingWidth(67.55859375);             
        
          t5.setLayoutY(398.0);
        t5.setLayoutX(66.0);
        t5.setStrokeType(StrokeType.OUTSIDE);
        t5.setStrokeWidth(0.0);
        t5.setText("date_fin:");
        t5.setWrappingWidth(67.55859375);             
        
        
         t6.setLayoutY(500.0);
        t6.setLayoutX(60.0);
        t6.setStrokeType(StrokeType.OUTSIDE);
        t6.setStrokeWidth(0.0);
        t6.setText("Description:");
        t6.setWrappingWidth(80.55859375);             
        
        
        
        
         l1.setLayoutX(212.0);
        l1.setLayoutY(92.0);
        l1.setPrefHeight(21.0);
        l1.setPrefWidth(100.0);
        
          l2.setLayoutX(227.0);
        l2.setLayoutY(144.0);
        l2.setPrefHeight(21.0);
        l2.setPrefWidth(100.0);
       
        
        
         l3.setLayoutX(227.0);
        l3.setLayoutY(209.0);
        l3.setPrefHeight(21.0);
        l3.setPrefWidth(100.0);
        
        
     
         l4.setLayoutX(227.0);
        l4.setLayoutY(315.0);
        l4.setPrefHeight(21.0);
        l4.setPrefWidth(100.0);
        
        
         l5.setLayoutX(227.0);
        l5.setLayoutY(380.0);
        l5.setPrefHeight(21.0);
        l5.setPrefWidth(100.0);
        
          l6.setLayoutX(227.0);
        l6.setLayoutY(444.0);
        l6.setPrefHeight(100.0);
        l6.setPrefWidth(100.0);
        
        
        
        l1.setText(get.getNom());
String pr=String.valueOf(get.getPrix());  

        l1.setText(get.getNom());
        l2.setText(pr);
        l3.setText(get.getLieu());
        l4.setText(get.getDatefin().toString());
        l5.setText(get.getDatefin().toString());
        l6.setText(get.getDescription());
        
            v.getChildren().add(t1);
            v.getChildren().add(t2);
            v.getChildren().add(t3);
            v.getChildren().add(t4);
            v.getChildren().add(t5);
            v.getChildren().add(t6);
            v.getChildren().add(l1);
            v.getChildren().add(l2);
            v.getChildren().add(l3);
            v.getChildren().add(l4);
            v.getChildren().add(l5);
            v.getChildren().add(l6);
            v.getChildren().add(imav);
            pubss.add(v);
           
         
        }
        
        
         ListView<AnchorPane> listViews = new ListView<AnchorPane>(pubss);
          verticalbox.getChildren().add(listViews);
     
    }    

    @FXML
    private void ajouterevent(ActionEvent event) throws IOException {
        
     Stage stage1=(Stage)   ajouter12.getScene().getWindow();
       Parent root =FXMLLoader.load(getClass().getResource("ajouter.fxml"));
   
        stage1.setScene(new Scene(root));
        stage1.show();
    }

    @FXML
    private void modifierevent(ActionEvent event) throws IOException {
           
     Stage stage1=(Stage)   ajouter12.getScene().getWindow();
       Parent root =FXMLLoader.load(getClass().getResource("ModifierFxml.fxml"));
   
        stage1.setScene(new Scene(root));
        stage1.show();
    }

    @FXML
    private void supprimerevent(ActionEvent event) throws IOException {
           
     Stage stage1=(Stage)   ajouter12.getScene().getWindow();
       Parent root =FXMLLoader.load(getClass().getResource("SupprimeFxml.fxml"));
   
        stage1.setScene(new Scene(root));
        stage1.show();
    }

    
}
