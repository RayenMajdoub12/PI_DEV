/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.Programme;
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
public class ProgrammeService implements IService<Programme> {

    private Connection conn;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public ProgrammeService() {
        conn = Datasource.getInstance().getCnx();
    }

    @Override
    public void insert(Programme p) {
        String req = "insert into programme (title, categorie, description) values ('" + p.getTitle()+ "','" + p.getCategorie()+ "','" + p.getDescription()+ "')";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void inserPersonnePst(Programme p) {
        String req = "insert into programme (title, categorie, description) values (?,?,?)";
        try {
            pst = conn.prepareStatement(req);
            pst.setString(1, p.getTitle());
            pst.setString(2, p.getCategorie());
            pst.setString(3, p.getDescription());
            pst.executeUpdate();

        } catch (SQLException ex) {
                  System.out.println(ex);
        }

    }

    @Override
    public void delete(Programme t) {
        String req="DELETE FROM programme WHERE id='"+t.getId()+"'";
        try {
            ste = conn.prepareStatement(req);
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void update(Programme t) {
        String req = "update programme set title='"+t.getTitle()+"', categorie='"+t.getCategorie()+"', description='"+t.getDescription()+"' where id='"+t.getId()+"'";
        try {
            pst = conn.prepareStatement(req);
            pst.executeUpdate();

        } catch (SQLException ex) {
                System.out.println(ex);
        }
    }

    @Override
    public List<Programme> read() {
                    String req="select * from programme";
                    List<Programme> list=new ArrayList<>();
        try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);
            while(rs.next()){
                list.add(new Programme(rs.getInt("id"), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (SQLException ex) {
                    System.out.println(ex);
        }
        return list;
    }
    
    @Override
    public List<Programme> readById(int id) {
        String req="select * from programme where programme.id='"+id+"'";
                    List<Programme> list=new ArrayList<>();
        try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);
            while(rs.next()){
                list.add(new Programme(rs.getInt("id"), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (SQLException ex) {
                    System.out.println(ex);
        }
        return list;
    }
    
    public  ObservableList<Programme> getDataProgramme(){
        String req="select * from programme ";
        ObservableList<Programme> List = FXCollections.observableArrayList();
        try{
            pst = conn.prepareStatement(req);
            rs = pst.executeQuery();
            
            while(rs.next()){
                List.add(new Programme(rs.getInt("id"), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        }catch(Exception e){
                        System.out.println(e);
        }
        return List;
    }
    
    
    

}
