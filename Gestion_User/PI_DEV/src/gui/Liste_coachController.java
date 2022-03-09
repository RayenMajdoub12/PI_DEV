/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Model.User;
import Services.CoachServices;
import Services.GeneralServices;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class Liste_coachController implements Initializable {

    @FXML
    private TextField recherche;
    @FXML
    private Label nom_coach;
    @FXML
    private Label specialite_coach;
    @FXML
    private GridPane grid;
    @FXML
    private ScrollPane scrollpane;

    private MyListener myListener;

    public String rech = "";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setdata();

    }

    public void setdata() {
        grid.setGridLinesVisible(false);
        grid.getColumnConstraints().clear();
        grid.getRowConstraints().clear();
        grid.getChildren().clear();
        grid.setGridLinesVisible(false);

        CoachServices cs = new CoachServices();
        List<User> list_coach = new ArrayList<>();
        list_coach = cs.recherche_coach(rech);
        int col = 0, row = 1;
        if (list_coach.size() > 0) {
            nom_coach.setText(list_coach.get(0).getNom());
            specialite_coach.setText(list_coach.get(0).getSpecialite());
            myListener = new MyListener() {
                @Override
                public void onClickListener(User u) {
                    nom_coach.setText(u.getNom());
                    specialite_coach.setText(u.getSpecialite());
                }
            };
        }
        for (int i = 0; i < list_coach.size(); i++) {

            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("un_coach.fxml"));
                Pane a = fxmlLoader.load();
                Un_coachController coachcont = fxmlLoader.getController();
                a.getStylesheets().add(getClass().getResource("CSS.css").toString());
                coachcont.setData(list_coach.get(i), myListener);
                if (col == 3) {
                    col = 0;
                    row++;
                }
                grid.add(a, col++, row);
                //widh
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);
                //hight
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
                GridPane.setMargin(a, new Insets(10));

            } catch (IOException ex) {
                System.out.println(ex);
            }

        }
    }

    @FXML
    public void onclicksearch() {
        if (recherche.getText().isEmpty()) {
            rech = "";
        } else {
            rech = recherche.getText();
        }
        setdata();
    }

}
