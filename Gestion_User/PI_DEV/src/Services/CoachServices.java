

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
        String req = "INSERT INTO user (nom,prenom,email,pseudo,mdp,tel,age,role,specialite,salaire)"
                + " VALUES ('" + c.getNom() + "','" + c.getPrenom() + "',"
                + "'" + c.getEmail()+ "',"
                + "'" + c.getPseudo()+ "',"
                + "'" + c.getMdp()+ "',"
                + "'" + c.getTel()+ "',"
                + "'" + c.getAge()+ "',"
                + "'" + c.getRole()+ "',"
                + "'" + c.getSpecialite()+ "',"
                + "'" + c.getSalaire()+ "')";
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
     String req = "UPDATE user SET (nom ='" + c.getNom() + "',prenom ='" + c.getPrenom() + "',email='" + c.getEmail()+ "',pseudo='" + c.getPseudo()+ "',mdp = '" + c.getMdp()+ "',tel = '" + c.getTel()+ "',age ='" + c.getAge()+ "',role='" + c.getRole()+ "',specialite='" + c.getSpecialite()+ "',salaire='" + c.getSalaire()+ "') WHERE id_user = '"+c.getId_user()+"'";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(CoachServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<User> read() {
                  String req="select * from user WHERE role ='coach'"; //  SELECT *FROM client FULL JOIN login ON client.id_client = login.id_user 
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
         String req="select * from user WHERE id_user='"+id+"'";  //SELECT *FROM client FULL JOIN login ON client.id_login = login.id_login
        try {
            ste=conn.createStatement();
             rs= ste.executeQuery(req);
     C= new User(rs.getInt("id_user"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("pseudo"),rs.getString("mdp"),rs.getInt("tel"),rs.getInt("age"),rs.getString("role"),rs.getString("specialite"),rs.getInt("salaire"));
        } catch (SQLException ex) {
            Logger.getLogger(CoachServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return C;
    }

}


