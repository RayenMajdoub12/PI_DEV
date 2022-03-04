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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CoachServices cs = new CoachServices();
        List<User> list_coach = new ArrayList<>();
        list_coach = cs.read();
        int col = 0, row = 0;
        for (int i = 0; i < list_coach.size(); i++) {

            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("un_coach.fxml"));
                Un_coachController coachcont = fxmlLoader.getController();
                AnchorPane a = fxmlLoader.load();

                coachcont.setData(list_coach.get(i));
                if (col == 3) {
                    col = 0 ;
                    row++;
                }
                grid.add(a, col++, row);
                GridPane.setMargin(a, new Insets(10));

            } catch (IOException ex) {
                Logger.getLogger(Liste_coachController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
