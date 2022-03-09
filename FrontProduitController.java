/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymgeeks;

import entites.produit;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FrontProduitController implements Initializable {

    @FXML
    private VBox chosenProduitCard;
    @FXML
    private Label ProduitNameLabel;
    @FXML
    private Label produitPriceLabel;
    @FXML
    private ImageView produitImage;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;

    
    
   private List<produit> produits = new ArrayList<>();
    private Image image;
    private MyListener myListener;

    private List<produit> getData() {
        List<produit> produits = new ArrayList<>();
        produit Produit;

        Produit = new produit();
        Produit.setNom_p("TAPIS DU SPORT");
        Produit.setPrix(3);
        Produit.setImgSrc("/img/2.png");
        Produit.setColor("DC143C");
        produits.add(Produit);

         Produit = new produit();
        Produit.setNom_p("CORDE À SAUTER");
        Produit.setPrix(2);
        Produit.setImgSrc("/img/8.png");
        Produit.setColor("8A2BE2");
        produits.add(Produit);

        Produit = new produit();
        Produit.setNom_p("HALTERE");
        Produit.setPrix(5);
        Produit.setImgSrc("/img/4.png");
        Produit.setColor("6495ED");
        produits.add(Produit);

        Produit = new produit();
        Produit.setNom_p("HALTERE");
        Produit.setPrix(2);
        Produit.setImgSrc("/img/3.png");
        Produit.setColor("00BFFF");
        produits.add(Produit);
        
         Produit = new produit();
        Produit.setNom_p("SAC DE FRAPPE");
        Produit.setPrix(2);
        Produit.setImgSrc("/img/5.png");
        Produit.setColor("F08080");
        produits.add(Produit);
        
        Produit = new produit();
        Produit.setNom_p("TENUE DU SPORT");
        Produit.setPrix(3);
        Produit.setImgSrc("/img/7.png");
        Produit.setColor("DC143C");
        produits.add(Produit);

         Produit = new produit();
        Produit.setNom_p("MINCEUR EQUIPEMENT");
        Produit.setPrix(2);
        Produit.setImgSrc("/img/10.png");
        Produit.setColor("8A2BE2");
        produits.add(Produit);

        Produit = new produit();
        Produit.setNom_p("GANTS DE BOXE");
        Produit.setPrix(5);
        Produit.setImgSrc("/img/11.png");
        Produit.setColor("6495ED");
        produits.add(Produit);

        Produit = new produit();
        Produit.setNom_p("MONTRE DU SPORT");
        Produit.setPrix(23);
        Produit.setImgSrc("/img/6.png");
        Produit.setColor("00BFFF");
        produits.add(Produit);
        
         Produit = new produit();
        Produit.setNom_p("TAPIS ROULANT");
        Produit.setPrix(2);
        Produit.setImgSrc("/img/9.png");
        Produit.setColor("F08080");
        produits.add(Produit);


        return produits;
    }

    private void setChosenProduit(produit produit) {
        ProduitNameLabel.setText(produit.getNom_p());
        produitPriceLabel.setText( produit.getPrix()+GymGeeks.CURRENCY );
        image = new Image(getClass().getResourceAsStream(produit.getImgSrc()));
        produitImage.setImage(image);
        chosenProduitCard.setStyle("-fx-background-color: #" + produit.getColor() + ";\n" +
                "    -fx-background-radius: 30;");
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       produits.addAll(getData());
        if (produits.size() > 0) {
            setChosenProduit(produits.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(produit produit) {
                    setChosenProduit(produit);
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < produits.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(produits.get(i),myListener);

                if (column == 3) {
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

}   
    
