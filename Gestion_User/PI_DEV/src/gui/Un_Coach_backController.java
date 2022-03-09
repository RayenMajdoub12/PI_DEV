/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Model.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class Un_Coach_backController implements Initializable {

    @FXML
    private AnchorPane anchor_client;

    /**
     * Initializes the controller class.
     */
    private MyListener myListener;
    private User u;
    @FXML
    private Label label_id;
    @FXML
    private Label label_nom;
    @FXML
    private Label label_pren;
    @FXML
    private Label label_email;
    @FXML
    private Label label_pseudo;
    @FXML
    private Label label_mdp;
    @FXML
    private Label label_tel;
    @FXML
    private Label label_age;
    @FXML
    private Label label_speci;
    @FXML
    private Label label_sal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setData(User u, MyListener myListener) {
        this.u = u;
        this.myListener = myListener;
        System.out.println("hi");
        label_id.setText("" + u.getId_user());
        label_nom.setText(u.getNom());
        label_pren.setText(u.getPrenom());
        label_pseudo.setText(u.getPseudo());
        label_email.setText(u.getEmail());
        label_mdp.setText(u.getMdp());
        label_tel.setText("" + u.getTel());
        label_age.setText("" + u.getAge());
        label_speci.setText(u.getSpecialite());
        label_sal.setText("" + u.getSalaire());

    }

    @FXML
    private void onclick(MouseEvent event) {
        myListener.onClickListener(u);

    }

}
