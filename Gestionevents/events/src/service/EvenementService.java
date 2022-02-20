/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import cnxdb.Datasource;
import java.sql.*;
import java.text.SimpleDateFormat;
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
    public void insert(Evenements e) {
   //TODATE BECH NSALHOUHAAAAAAAA  W9AYET EKHER

         String request = "INSERT INTO evenement (nom,prix,lieu,datedebut,datefin,description) VALUES ('"+e.getNom()+"','"+e.getPrix()+"','"+e.getLieu()+"',TO_DATE('"+e.getDatedebut()+"', 'SYYYY-MM-DD'),'"+e.getDatefin()+"','"+e.getDescription()+"')";
        
        try {
            ste = conn.createStatement();
            ste.executeUpdate(request );
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
           
                       
    }

    @Override
    public void delete(Evenements t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Evenements t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Evenements> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Evenements readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   
    
    
    
    
    
    
    
    
    
    
}
