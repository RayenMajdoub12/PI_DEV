/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymgeeks;

import entites.produit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ItemController implements Initializable {

    @FXML
    private Label nameLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private ImageView img;

    /**
     * Initializes the controller class.
     */
    private produit Produit;
    private MyListener myListener;
   

    public void setData(produit produit, MyListener myListener) {
        this.Produit = produit;
        this.myListener = myListener;
        nameLabel.setText(produit.getNom_p());
        priceLabel.setText(produit.getPrix()+GymGeeks.CURRENCY );
        Image image = new Image(getClass().getResourceAsStream(produit.getImgSrc()));
        img.setImage(image);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
@FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(Produit);
    }

    
    
}
