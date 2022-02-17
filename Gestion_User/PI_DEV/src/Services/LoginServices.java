package Services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rayen
 */package Services;
import Model.Login;
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


public class LoginServices implements I_SERVICE<Login>{
    
    
     private  Connection conn;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public LoginServices() {
        conn = Datasource.getInstance().getCnx();
    } 
    
}
