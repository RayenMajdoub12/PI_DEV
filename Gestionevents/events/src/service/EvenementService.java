/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import cnxdb.Datasource;
import com.edu.project.services.Mail;
import java.awt.AWTException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Evenements ;
import modele.TrayIconDemo;
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
                 + "        ('"+e.getDatedebut().toString()+"'),"
                 + "        ('"+e.getDatefin().toString()+"'), "
                 + "        ('"+e.getDescription()+"'))";
        
        try {
            ste = conn.createStatement();
            ste.executeUpdate(request );
            TrayIconDemo td= new TrayIconDemo();
             try {
                 td.displayTray();
             } catch (AWTException ex) {
                 Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
             }
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        try {                
            Mail.sendMail("mohamed.gasmi@esprit.tn");
        } catch (Exception ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void delete(int id) {
        String requste ="DELETE FROM evenement WHERE idevent="+id+"";
        try {
            ste = conn.createStatement();
             ste.executeUpdate(requste);
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public int statistic (int idev)
   {
       int i=0;
          List<Evenements> list=new ArrayList<>();
       
                  String req="SELECT idpart FROM participation WHERE idevent="+idev; 
                 
        try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);
            while(rs.next()){
               i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
     
       
      
       
       
        
        return i;
   }
   
   
   public boolean exist (int id)
           
   {
      boolean result=false;
       
          int i=0;
          List<Evenements> list=new ArrayList<>();
       
                  String req="SELECT * FROM static WHERE idevent="+id; 
                 
        try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);
            while(rs.next()){
               i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
     
       if (i>0)
          result=true;
       
       
       
       
       return result ;
   }
   public void edit (int id , int stat)
   {
       
        String req = "UPDATE static SET nombre_participation="+stat+" WHERE idevent="+id;
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
   
   
   
     public void add ()
     {
          String req="select * from evenement"; //  SELECT *FROM client FULL JOIN login ON client.id_client = login.id_user 
                    List<Evenements> list=new ArrayList<>();
        try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);
            while(rs.next()){
                list.add(new Evenements(rs.getInt("idevent"),rs.getString("nom"),rs.getInt("prix"),rs.getString("lieu"),rs.getDate("datedebut"),rs.getDate("datefin"),rs.getString("description")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    
         for (int i = 0; i < list.size(); i++) {
             Evenements get = list.get(i);
             
             if (exist(get.getidevent())==true)
             {
                 edit(get.getidevent(),statistic(get.getidevent()));
             }
             else
             {
                   String reqt="INSERT INTO `static`(`idevent`, `nombre_participation`) VALUES ("+get.getidevent()+","+statistic(get.getidevent())+")";
           try {
             //insert
             Statement st=conn.createStatement();
             st.executeUpdate(reqt);
          
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
                 
             }
             
            

             
         }
  
         
    
         
     }

    public void update(Evenements e, int id) {
        
     String req = "UPDATE evenement SET nom ='" + e.getNom() + "',prix =" + e.getPrix() + ",lieu='" + e.getLieu()+ "',datedebut='" + e.getDatedebut()+ "',datefin = '" + e.getDatefin()+ "',description = '" + e.getDescription()+ "' WHERE idevent ="+id;
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
                list.add(new Evenements(rs.getInt("idevent"),rs.getString("nom"),rs.getInt("prix"),rs.getString("lieu"),rs.getDate("datedebut"),rs.getDate("datefin"),rs.getString("description")));
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
     e= new Evenements(rs.getInt("idevent"),rs.getString("nom"),rs.getInt("prix"),rs.getString("lieu"),rs.getDate("datedebut"),rs.getDate("datefin"),rs.getString("description"));
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    @Override
    public void update(Evenements t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Evenements t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   
    
       public List<Evenements> chercher(String s) {
        
                  String req="select * from evenement WHERE idevent='"+s+"' OR nom='"+s+"' OR prix='"+s+"' OR lieu='"+s+"' OR  datedebut='"+s+"' OR datefin='"+s+"' OR description='"+s+"'"; //  SELECT *FROM client FULL JOIN login ON client.id_client = login.id_user 
                    List<Evenements> list=new ArrayList<>();
        try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);
            while(rs.next()){
                list.add(new Evenements(rs.getInt("idevent"),rs.getString("nom"),rs.getInt("prix"),rs.getString("lieu"),rs.getDate("datedebut"),rs.getDate("datefin"),rs.getString("description")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
 
    
    
       public List<Evenements> tries(String s) {

                  String req="SELECT * FROM `evenement` ORDER BY `evenement`.`"+s+"` ASC"; //  SELECT *FROM client FULL JOIN login ON client.id_client = login.id_user 
                    List<Evenements> list=new ArrayList<>();
        try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);
            while(rs.next()){
                list.add(new Evenements(rs.getInt("idevent"),rs.getString("nom"),rs.getInt("prix"),rs.getString("lieu"),rs.getDate("datedebut"),rs.getDate("datefin"),rs.getString("description")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    
    
    
}
