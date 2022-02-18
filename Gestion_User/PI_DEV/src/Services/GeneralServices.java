/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Model.Coach;
import Model.Client;
import Services.ClientServices ;
import Services.CoachServices ;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Conn.Datasource;
import java.util.Random;
/**
 *
 * @author Rayen
 */
public class GeneralServices {
      private  Connection conn;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public GeneralServices() {
        conn = Datasource.getInstance().getCnx();
    }

    public int Login(String pseudo,String mdp)//authentification
    {
        String req="select id_user from user WHERE pseudo='"+pseudo+"'AND mdp='"+mdp+"'";  
          try {
              ste=conn.createStatement();
              rs= ste.executeQuery(req);
            return  rs.getInt("id_user"); // en utilisant l'id je vais extraire les informations du user et choisir l'interface qui le correspond
          } catch (SQLException ex) {
              Logger.getLogger(GeneralServices.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println("l'utilisateur n'existe pas "); 
             return -1 ;
             
          }
     }

    
   public void Token_Mdp_Oublie (int id) // générer le token  
   {   Random rand = new Random();
       int token = rand.nextInt(99999);
     String req = "UPDATE user SET (token_mdp ='" +token+ "') WHERE id_user = '"+id+"'";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("token envoyé par mail");
        } catch (SQLException ex) {
            Logger.getLogger(CoachServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
   
   
           public int readToken(int id) // chercher le token
    {     int token ;
          String req="select token_mdp from user WHERE id_user='"+id+"'";  
        
          try {
              ste=conn.createStatement();
                rs= ste.executeQuery(req);
            token= rs.getInt("token_mdp");
          } catch (SQLException ex) {
              Logger.getLogger(GeneralServices.class.getName()).log(Level.SEVERE, null, ex);
              token=0;
          }
            return token;   
        
    }
}
