/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class ClientServices implements I_SERVICE<User>{
    private  Connection conn;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    
    public ClientServices() {
        conn = Datasource.getInstance().getCnx();
    }

        @Override
    public void insert(User c) {
        GeneralServices gs =new GeneralServices();
       String mdp= gs.EncryptMdp(c.getMdp());
        String req = "INSERT INTO user (nom,prenom,email,pseudo,mdp,tel,age,role,salaire,tokenmdp)"
                + " VALUES ('" + c.getNom() + "','" + c.getPrenom() + "',"
                + "'" + c.getEmail()+ "',"
                + "'" + c.getPseudo()+ "',"
                + "'" + mdp+ "',"
                + "'" + c.getTel()+ "',"
                + "'" + c.getAge()+ "',"
                + "'" + c.getRole()+ "',0,0)";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ClientServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(User c) {
        String req="DELETE FROM user WHERE id_user='"+c.getId_user()+"'";
        try {
            ste = conn.createStatement();
             ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ClientServices.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }

    @Override
    public void update(User c) {
     String req = "UPDATE user SET nom ='" + c.getNom() + "',prenom ='" + c.getPrenom() + "',email='" + c.getEmail()+ "',pseudo='" + c.getPseudo()+ "',mdp = '" + c.getMdp()+ "',tel = '" + c.getTel()+ "',age ='" + c.getAge()+ "',role='" + c.getRole()+ "' WHERE id_user = '"+c.getId_user()+"'";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ClientServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<User> read() {
                  String req="select * from user WHERE role ='client'"; //  SELECT *FROM client FULL JOIN login ON client.id_client = login.id_user 
                    List<User> list=new ArrayList<>();
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
    
    @Override
    public User readById(int id) {
      User C =new User();
         String req="select * from user WHERE id_user='"+id+"'";  //SELECT *FROM client FULL JOIN login ON client.id_login = login.id_login
        try {
            ste=conn.createStatement();
             rs= ste.executeQuery(req);
             rs.next();
     C= new User(rs.getInt("id_user"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("pseudo"),rs.getString("mdp"),rs.getInt("tel"),rs.getInt("age"),rs.getString("role"),rs.getString("specialite"),rs.getInt("salaire"));
        } catch (SQLException ex) {
            Logger.getLogger(ClientServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return C;
    }
    
    public boolean test_used_pseudo_or_email(User c1)
            {
             int a;
         String req="select id_user from user WHERE pseudo='"+c1.getPseudo()+"' OR email = '"+c1.getEmail()+"'"; 
        try {
            ste=conn.createStatement();
             rs= ste.executeQuery(req);
             rs.next();
             a = rs.getInt("id_user");
        return false;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return true;
            }
    public void update_mdp(String new_mdp,String pseudo_ou_mail)
    {
        GeneralServices gs = new GeneralServices (); 
        String  mdp_enc =  gs.EncryptMdp(new_mdp) ;
         String req = "UPDATE user SET mdp ='"+mdp_enc+"'WHERE   email ='"+pseudo_ou_mail+"'";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("succes mdp ");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public List<User> recherche_c(String rech)
    {
          List<User> list=new ArrayList<>();
        String req = " SELECT * FROM user WHERE (nom LIKE '%"+rech+"%' OR prenom LIKE '%"+rech+"%'OR email LIKE '%"+rech+"%'OR pseudo LIKE '%"+rech+"%' OR tel LIKE '%"+rech+"%' OR age LIKE '%"+rech+"%')AND role ='client'";
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
