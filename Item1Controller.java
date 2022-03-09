/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymgeeks;

import entites.blog;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Item1Controller implements Initializable {

    @FXML
    private Label nameLabel;
    @FXML
    private ImageView img;

    /**
     * Initializes the controller class.
     */
      private blog blog;
    private MyListener1 myListener1;
    @FXML
    private Label contenu;
    @FXML
    private TextArea descr;
   

    public void setData(blog blog, MyListener1 myListener1) {
        this.blog = blog;
        this.myListener1 = myListener1;
        nameLabel.setText(blog.getTitre());
        contenu.setText(blog.getContenu());
        descr.setText(blog.getDescription());
        //priceLabel.setText(GymGeeks.CURRENCY + blog.getDescription());
        Image image = new Image(getClass().getResourceAsStream(blog.getImage_b()));
        img.setImage(image);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
@FXML
    private void click(MouseEvent mouseEvent) {
        myListener1.onClickListener1(blog);
    }
    
}
