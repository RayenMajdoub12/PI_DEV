/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import cnxdb.Datasource;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Evenements ;
/**
 *
 * @author Mohamed
 */
public class EvenementService implements IService<Evenements>{
    private  Connection conn;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public EvenementService() {
        conn = Datasource.getInstance().getCnx();
    }   
    @Override
    public void insert (Evenements e) {
   //TODATE BECH NSALHOUHAAAAAAAA  W9AYET EKHER

         String request = "INSERT INTO evenement (nom,prix,lieu,datedebut,datefin,description) "
                 + "VALUES ('"+e.getNom()+"',"
                 + "       ('"+e.getPrix()+"'),"
                 + "        ('"+e.getLieu()+"'),"
                 + "        ('"+e.getDatedebut()+"'),"
                 + "        ('"+e.getDatefin()+"'), "
                 + "        ('"+e.getDescription()+"'))";
        
        try {
            ste = conn.createStatement();
            ste.executeUpdate(request );
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
           
                       
    }

    @Override
    public void delete(Evenements e) {
        String requste ="DELETE FROM evenement WHERE idevent= '"+e.getidevent()+"'";
        try {
            ste = conn.createStatement();
             ste.executeUpdate(requste);
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Evenements e) {
        
     String req = "UPDATE evenement SET (nom ='" + e.getNom() + "',prix ='" + e.getPrix() + "',lieu='" + e.getLieu()+ "',datedebut='" + e.getDatedebut()+ "',datefin = '" + e.getDatefin()+ "',description = '" + e.getDescription()+ "') WHERE id_evenement = '"+e.getidevent ()+"'";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Evenements> read() {
        
                  String req="select * from evenement"; //  SELECT *FROM client FULL JOIN login ON client.id_client = login.id_user 
                    List<Evenements> list=new ArrayList<>();
        try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);
            while(rs.next()){
                list.add(new Evenements(rs.getInt("idevent"),rs.getString("nom"),rs.getInt("prix"),rs.getString("lieu"),rs.getString("datedebut"),rs.getString("datefin"),rs.getString("description")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Evenements readById(int idevent) { 
      Evenements e  =new Evenements();
         String req="select * from evenement WHERE idevent='"+idevent+"'";  //SELECT *FROM evenement FULL JOIN login ON client.id_login = login.id_login
        try {
            ste=conn.createStatement();
             rs= ste.executeQuery(req);
     e= new Evenements(rs.getInt("idevent"),rs.getString("nom"),rs.getInt("prix"),rs.getString("lieu"),rs.getString("datedebut"),rs.getString("datefin"),rs.getString("description"));
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
    
    
   
    
    
    
    
    
    
    
    
    
    
}
