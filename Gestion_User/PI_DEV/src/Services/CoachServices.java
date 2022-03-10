

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rayen
 */


package Services;
import Model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Conn.Datasource;
/**
 *
 * @author Rayen
 */
public class CoachServices implements I_SERVICE<User>{
    private  Connection conn;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public CoachServices() {
        conn = Datasource.getInstance().getCnx();
    }



        @Override
    public void insert(User c) {
            GeneralServices gs=new GeneralServices();
    String mdp=gs.EncryptMdp(c.getMdp());
        String req = "INSERT INTO user (nom,prenom,email,pseudo,mdp,tel,age,role,specialite,salaire,tokenmdp)"
                + " VALUES ('" + c.getNom() + "','" + c.getPrenom() + "',"
                + "'" + c.getEmail()+ "',"
                + "'" + c.getPseudo()+ "',"
                + "'" + mdp+ "',"
                + "'" + c.getTel()+ "',"
                + "'" + c.getAge()+ "',"
                + "'" + c.getRole()+ "',"
                + "'" + c.getSpecialite()+ "',"
                + "'" + c.getSalaire()+ "',0)";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(CoachServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(User c) {
        String req="DELETE FROM user WHERE id_user='"+c.getId_user()+"'";
        try {
            ste = conn.createStatement();
             ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(CoachServices.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }

    @Override
    public void update(User c) {
        GeneralServices gs=new GeneralServices();
    String mdp=gs.EncryptMdp(c.getMdp());
     String req = "UPDATE user SET nom ='" + c.getNom() + "',prenom ='" + c.getPrenom() + "',email='" + c.getEmail()+ "',pseudo='" + c.getPseudo()+ "',mdp = '" +mdp+ "',tel = '" + c.getTel()+ "',age ='" + c.getAge()+ "',specialite='" + c.getSpecialite()+ "',salaire='" + c.getSalaire()+ "' WHERE id_user = '"+c.getId_user()+"'";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(CoachServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<User> read() {
                  String req="select * from user WHERE role ='coach'";
                    List<User> list=new ArrayList<>();
        try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);
            while(rs.next()){
                list.add(new User(rs.getInt("id_user"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("pseudo"),rs.getString("mdp"),rs.getInt("tel"),rs.getInt("age"),rs.getString("role"),rs.getString("specialite"),rs.getInt("salaire")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoachServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    @Override
    public User readById(int id) {
      User C =new User();
         String req="select * from user WHERE id_user='"+id+"'";
        try {
            ste=conn.createStatement();
             rs= ste.executeQuery(req);
     C= new User(rs.getInt("id_user"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("pseudo"),rs.getString("mdp"),rs.getInt("tel"),rs.getInt("age"),rs.getString("role"),rs.getString("specialite"),rs.getInt("salaire"));
        } catch (SQLException ex) {
            Logger.getLogger(CoachServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return C;
    }
     public List<User> recherche_coach(String rech)
    {
          List<User> list=new ArrayList<>();
        String req = " SELECT * FROM user WHERE (nom LIKE '%"+rech+"%' OR prenom LIKE '%"+rech+"%'OR email LIKE '%"+rech+"%'OR pseudo LIKE '%"+rech+"%' OR tel LIKE '%"+rech+"%' OR age LIKE '%"+rech+"%' OR specialite LIKE '%"+rech+"%'OR salaire LIKE '%"+rech+"%')AND role ='coach'";
       try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);
            while(rs.next()){
                list.add(new User(rs.getInt("id_user"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("pseudo"),rs.getString("mdp"),rs.getInt("tel"),rs.getInt("age"),rs.getString("role"),rs.getString("specialite"),rs.getInt("salaire")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}


