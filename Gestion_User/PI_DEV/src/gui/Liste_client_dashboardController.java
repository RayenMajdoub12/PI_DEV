/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Model.User;
import Services.ClientServices;
import Services.CoachServices;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class Liste_client_dashboardController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField rechercher;

    @FXML
    private ListView<AnchorPane> listview;
    private MyListener myListener;

    public String rech = "";

    private TextField id_text;
    @FXML
    private TextField nom_text;
    @FXML
    private TextField prenom_text;
    @FXML
    private TextField email_text;
    @FXML
    private TextField pseudo_text;
    @FXML
    private TextField mdp_text;
    @FXML
    private TextField tel_text;
    @FXML
    private TextField age_text;
    @FXML
    private Label photo;
    @FXML
    private Label fruitNameLable;
    @FXML
    private VBox chosenFruitCard;
    @FXML
    private Label Pseudo_du_client;
    @FXML
    private ScrollPane scroll;
    @FXML
    private Pane scrol_right;
    @FXML
    private Button button_modifier;
    @FXML
    private Button button_supprimer;
    @FXML
    private Label label_id;
    @FXML
    private TextField iduss;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ClientServices cs = new ClientServices();
        List<User> list_client = new ArrayList<>();
        list_client = cs.recherche_c(rech);

        if (list_client.size() > 0) {
            myListener = new MyListener() {
                @Override
                public void onClickListener(User u) {
                    iduss.setText(""+u.getId_user());
                    nom_text.setText(u.getNom());
                    prenom_text.setText(u.getPrenom());
                    email_text.setText(u.getEmail());
                    pseudo_text.setText(u.getPseudo());
                    mdp_text.setText(u.getMdp());
                    tel_text.setText(""+u.getTel());
                    age_text.setText(""+u.getAge());

                }
            };
        }
        for (int i = 0; i < list_client.size(); i++) {

            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Un_Client.fxml"));
                AnchorPane a = fxmlLoader.load();
                Un_ClientController coachcont = fxmlLoader.getController();
                a.getStylesheets().add(getClass().getResource("CSS.css").toString());
                coachcont.setData(list_client.get(i),myListener);
                listview.getItems().add(a);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

    }

    @FXML
    public void edit_client() {

    }

    @FXML
    public void modifier_terminer() {

    }

    @FXML
    public void supprimer_terminer() {

    }

    @FXML
    public void to_menu_back() //close men projet tofla 
    {

    }

    @FXML
       public void onclicksearch()
    {
        if(rechercher.getText().isEmpty())
        rech="" ;
        else
        rech =rechercher.getText();
        
        }

    @FXML
    private void rechercher(KeyEvent event) {
    }
}
