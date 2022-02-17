/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Model.Client;
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
public class ClientServices implements I_SERVICE<Client>{
    private  Connection conn;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public ClientServices() {
        conn = Datasource.getInstance().getCnx();
    }

        @Override
    public void insert(Client c) {
        String req = "INSERT INTO client (nom,prenom,age,taille,email,poids) VALUES ('" + c.getNom() + "','" + c.getPrenom() + "','" + c.getAge()+ "','" + c.getTaille()+ "','" + c.getEmail()+ "','" + c.getPoids()+ "')";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ClientServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Client c) {
        String req="DELETE FROM client WHERE id_client='"+c.getId_client()+"'";
        try {
            ste = conn.createStatement();
             ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ClientServices.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }

    @Override
    public void update(Client c) {
     String req = "UPDATE client SET (nom ='" + c.getNom() + "',prenom ='" + c.getPrenom() + "',pseudo='" + c.getPseudo()+ "',mdp = '" + c.getMdp()+ "',age ='" + c.getAge()+ "',taille = '" + c.getTaille()+ "',email='" + c.getPoids()+ "',poids='" + c.getPoids()+ "') WHERE id = '"+c.getId_client()+"'";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ClientServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Client> read() {
                  String req="select * from client"; //  SELECT *FROM client FULL JOIN login ON client.id_client = login.id_user 
                    List<Client> list=new ArrayList<>();
        try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);
            while(rs.next()){
                list.add(new Client(rs.getInt("id_client"), rs.getString("nom"),rs.getString("prenom"), rs.getInt("age"),rs.getInt("taille"),rs.getString("email"),rs.getInt("poids")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    @Override
    public Client readById(int id) {
      Client C =new Client();
         String req="select * from client WHERE id_client='"+id+"'";  //SELECT *FROM client FULL JOIN login ON client.id_login = login.id_login
        try {
            ste=conn.createStatement();
             rs= ste.executeQuery(req);
     C= new Client(rs.getInt("id_client"), rs.getString("nom"),rs.getString("prenom"), rs.getInt("age"),rs.getInt("taille"),rs.getString("email"),rs.getInt("poids"));
        } catch (SQLException ex) {
            Logger.getLogger(ClientServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return C;
    }
}
