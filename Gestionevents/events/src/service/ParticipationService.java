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
import modele.Evenements;
import modele.Participations;

/**
 *
 * @author Mohamed
 */
public class ParticipationService implements IServicepart<Participations> {
private  Connection conn;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    private String request;

    public ParticipationService() {
        conn = Datasource.getInstance().getCnx();
    }   
    @Override
    public void insert(Participations p) {
        String request = "INSERT INTO participation (idevent,iduser,prix,numpart,categoriepart,description)"
                + " VALUES ('" + p.getIdevent() + "','" + p.getIduser() + "',"
                + "'" + p.getPrix()+ "',"
                + "'" + p.getNumpart()+ "',"
                + "'" + p.getCategoriepart()+ "',"
                + "'" + p.getDescription()+ "' )";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(request );
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Participations p) {
         String req="DELETE FROM particiaption WHERE idevent= '"+p.getIdpart()+"'";
        try {
            ste = conn.createStatement();
             ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ParticipationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Participations p) {
        
     String req = "UPDATE participation SET (idevent ='" + p.getIdevent() + "',iduser ='" + p.getIduser() + "',prix='" + p.getPrix()+ "',numpart='" + p.getNumpart()+ "',categorie = '" + p.getCategoriepart()+ "',description = '" + p.getDescription()+ "') WHERE id_participation = '"+p.getIdpart ()+"'";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Participations> read() {
        
                  String req="select * from participation"; //  SELECT *FROM participation FULL JOIN login ON client.id_client = login.id_user 
                    List<Participations> list=new ArrayList<>();
        try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);
            while(rs.next()){
                list.add(new Participations(rs.getInt("idpart"),rs.getInt("idevent"),rs.getInt("iduser"),rs.getInt("prix"),rs.getInt("numpart"),rs.getString("categoriepart"),rs.getString("description")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Participations readById(int idpart) {
        
      Participations p  =new Participations();
         String req="select * from particiaption WHERE idpart='"+idpart+"'";  //SELECT *FROM evenement FULL JOIN login ON client.id_login = login.id_login
        try {
            ste=conn.createStatement();
             rs= ste.executeQuery(req);
     p= new Participations (rs.getInt("idpart"),rs.getInt("idevent"),rs.getInt("iduser"),rs.getInt("prix"),rs.getInt("numpart"),rs.getString("categoriepart"),rs.getString("description"));
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
}
