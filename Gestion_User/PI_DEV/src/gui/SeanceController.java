/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;


import Model.Programme;
import Model.Seance;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import Services.ProgrammeService;
import Services.SeanceService;
import Conn.Datasource;

/**
 * FXML Controller class
 *
 * @author 23yas
 */
public class SeanceController implements Initializable {

    @FXML
    private TextField tfid;
    @FXML
    private Button b_ajouter;
    @FXML
    private Button b_update;
    @FXML
    private Button b_delete;
    @FXML
    private TableView<Seance> tvseance;
    @FXML
    private TableColumn<Seance, String> colnom;
    @FXML
    private TableColumn<Seance, Date> coldate;
    @FXML
    private TableColumn<Seance, String> colheure;
    
    @FXML
    private TableColumn<Seance, String> coldes;
    
    private SeanceService SeanceService;
    @FXML
    private TextField tfnom;
    @FXML
    private DatePicker tfdate;
    @FXML
    private TextField tfheure;
    @FXML
    private ComboBox<Integer> tfcombo;
    @FXML
    private TextArea tfdes;
    
    ObservableList<Seance> ListS;
    ObservableList<Integer> ListP;
    @FXML
    private Button btn_Acc;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    private Connection conn ;
    private ResultSet rs;
    private Statement ste ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.SeanceService = new SeanceService();
        
        colnom.setCellValueFactory(new PropertyValueFactory<Seance, String>("nom"));
        coldate.setCellValueFactory(new PropertyValueFactory<Seance, Date>("date"));
        colheure.setCellValueFactory(new PropertyValueFactory<Seance, String>("heure"));
        coldes.setCellValueFactory(new PropertyValueFactory<Seance, String>("description"));
        
        
        ListS = SeanceService.getDataSeance();
        tvseance.setItems(ListS);
        
        ListP = SeanceService.getDataProgramme_id();
        tfcombo.getItems().addAll(ListP);
        conn = Datasource.getInstance().getCnx();
        
        
        
        
        
    }    

    @FXML
    private void Add(ActionEvent event) throws Exception {
        ajouter();
        showseance();
        sendMail("yassine.aridhi@esprit.tn");
        
    }
    
    private void ajouter(){
        String req = "insert into seance (nom,date,heure,description, programme_id) values ('" + tfnom.getText()+ "','" + tfdate.getValue()+ "','" + tfheure.getText()+ "','" + tfdes.getText()+ "','" + tfcombo.getValue()+ "')";
        try {
            
            ste =  conn.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(SeanceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
    @FXML
    private void Update(ActionEvent event) {
        int id = Integer.parseInt(tfid.getText());
        String nom = tfnom.getText();
        Date d = new Date(tfdate.getValue().getYear(), tfdate.getValue().getMonthValue(), tfdate.getValue().getDayOfMonth());
        String heure = tfheure.getText();
        String description = tfdes.getText();
        
        
        Seance s = new Seance(id, nom, d, heure, description);
        SeanceService.update(s);
        showseance();
    }

    @FXML
    private void Delete(ActionEvent event) {
        int id = Integer.parseInt(tfid.getText());
        String nom = tfnom.getText();
        Date d = new Date(tfdate.getValue().getYear(), tfdate.getValue().getMonthValue(), tfdate.getValue().getDayOfMonth());
        String heure = tfheure.getText();
        String description = tfdes.getText();
        
        
        Seance s = new Seance(id, nom, d, heure, description );
        SeanceService.delete(s);
        showseance();
    }

    @FXML
    private void handle(MouseEvent event) {
        Seance s  = tvseance.getSelectionModel().getSelectedItem();
        tfid.setText(""+s.getId());
        tfnom.setText(""+s.getNom());
        tfheure.setText(""+s.getHeure());
        tfdes.setText(""+s.getDescription());
        tfcombo.setValue(tfcombo.getValue());
        LocalDate d = s.getDate().toLocalDate();
        tfdate.setValue(d);
        
        
    }

    @FXML
    private void GoBack(ActionEvent event) throws IOException {
      Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }
    
    public void showseance(){
         ListS = SeanceService.getDataSeance();
         
        colnom.setCellValueFactory(new PropertyValueFactory<Seance, String>("nom"));
        coldate.setCellValueFactory(new PropertyValueFactory<Seance, Date>("date"));
        colheure.setCellValueFactory(new PropertyValueFactory<Seance, String>("heure"));
        coldes.setCellValueFactory(new PropertyValueFactory<Seance, String>("description"));
        
        
        tvseance.setItems(ListS);
    }
    
    public  void sendMail(String recepient) throws Exception{
        
        System.out.println("Preparing to send email");
        
        Properties properties = new Properties();
        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String MyAccountEmail = "wampmail10@gmail.com";
        String PassWord = "sendmail10";
        
        Session session = Session.getInstance(properties, new Authenticator(){
            
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MyAccountEmail, PassWord);
            }
            
            
        
    });
        
        Message message = prepareMessage(session, MyAccountEmail, recepient); 
        
        Transport.send(message);
        System.out.println("Message sent successfully");
    }

    private  Message prepareMessage(Session session, String MyAccountEmail, String recepient) {
        
        
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(MyAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("A new Session has been added");
            String htmlcode ="<!DOCTYPE html>\n" +
                             "<html lang=\"en\">\n" +
                             "<head>\n" +
                             "  <meta charset=\"UTF-8\">\n" +
                             "  <link rel=\"stylesheet\" href=\"email.css\">\n" +
                             "  <title>SEANCE</title>\n" +
                             "\n" +
                             "</head>\n" +
                             "<body>\n" +
                             "\n" +
                             "<table>\n" +
                             "  <tr>\n" +

                             "    <td>\n" +

                             "      <div>\n" +
                             "        <h3>NOM :</h3></br>\n" +tfnom.getText()+
                             "        <h3>DATE :</h3></br>\n" +tfdate.getValue()+
                             "        <h3>HEURE :</h3></br>\n" +tfheure.getText()+
                             "        <h3>DESCRIPTION :</h3></br>\n" +tfdes.getText()+
                             "      </div>\n" +
                             "\n" +
                             "\n" +
                             "    </td>\n" +
                             "    <td>\n" +
                             "\n" +

                             "\n" +
                             "    </td>\n" +
                             "  </tr>\n" +
                             "\n" +
                             "</table>\n" +
                             "\n" +
                             "\n" +
                             "</body>\n" +
                             "</html>";
            message.setContent(htmlcode, "text/html");
            
            
            
            return message;
            
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    
    
    
    
}
