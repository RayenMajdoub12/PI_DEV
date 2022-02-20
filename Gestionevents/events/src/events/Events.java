/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;
import modele.Evenements ;
import service.EvenementService;
import java.util.Date;
/**
 *
 * @author Mohamed
 */
public class Events {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Date D=new Date (2022,22,1);
         
        // TODO code application logic here
       Evenements e=new Evenements ("gasmi",1200,"gabes",D,D,"cestezsfsdqf"); 
       EvenementService es=new EvenementService ();
       es.insert(e);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
