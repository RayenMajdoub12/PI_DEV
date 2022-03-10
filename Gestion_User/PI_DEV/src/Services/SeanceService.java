/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.Programme;
import Model.Seance;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Conn.Datasource;

/**
 *
 * @author wiemhjiri
 */
public class SeanceService implements IService<Seance> {

    private Connection conn;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public SeanceService() {
        conn = Datasource.getInstance().getCnx();
    }

    @Override
    public void insert(Seance p) {
        String req = "insert into seance (nom,date,heure,description) values ('" + p.getNom() + "','" + p.getDate()+ "','" + p.getHeure()+ "','" + p.getDescription()+ "')";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(SeanceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inserPersonnePst(Seance p) {
        String req = "insert into seance (nom,date,heure,description) values (?,?)";
        try {
            pst = conn.prepareStatement(req);
            pst.setString(1, p.getNom());
            pst.setDate(2, p.getDate());
            pst.setString(3, p.getHeure());
            pst.setString(4, p.getDescription());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SeanceService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(Seance t) {
        String req="DELETE FROM seance WHERE id='"+t.getId()+"'";
        try {
            ste = conn.prepareStatement(req);
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(SeanceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Seance t) {
        String req = "update seance set nom='"+t.getNom()+"', date='"+t.getDate()+"', heure='"+t.getHeure()+"', description='"+t.getDescription()+"' where id='"+t.getId()+"'";
        try {
            pst = conn.prepareStatement(req);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SeanceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Seance> read() {
                    String req="select * from seance";
                    List<Seance> list=new ArrayList<>();
        try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);
            while(rs.next()){
                list.add(new Seance(rs.getInt("id"), rs.getString(2), rs.getDate("date"), rs.getString("heure"), rs.getString("description")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SeanceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    @Override
    public List<Seance> readById(int id) {
        String req="select * from seance where seance.id='"+id+"'";
                    List<Seance> list=new ArrayList<>();
        try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);
            while(rs.next()){
                list.add(new Seance(rs.getInt("id"), rs.getString(2), rs.getDate("date"), rs.getString("heure"), rs.getString("description")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SeanceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public  ObservableList<Integer> getDataProgramme_id(){
        String req="select id from programme ";
        ObservableList<Integer> List = FXCollections.observableArrayList();
        try{
            pst = conn.prepareStatement(req);
            rs = pst.executeQuery();
            
            while(rs.next()){
                List.add(new Integer(rs.getInt("id")));
            }
        }catch(Exception e){
        }
        return List;
    }
    
    public  ObservableList<Seance> getDataSeance(){
        String req="select * from seance ";
        ObservableList<Seance> List = FXCollections.observableArrayList();
        try{
            pst = conn.prepareStatement(req);
            rs = pst.executeQuery();
            
            while(rs.next()){
                List.add(new Seance(rs.getInt("id"), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5)));
            }
        }catch(Exception e){
        }
        return List;
    }
    
    public int nbreSeance(int progid){
        int i=0;
        
        List<Seance> list = new ArrayList<>();
        String req ="select programme_id from seance where programme_id ="+progid;
        try{
            ste= conn.createStatement();
            rs = ste.executeQuery(req);
            while(rs.next()){
                i++;
            }
            
        }catch(SQLException  e){
             Logger.getLogger(SeanceService.class.getName()).log(Level.SEVERE, null, e);
            
        }
        return i;
    }

}
