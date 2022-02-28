/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;
import modele.Evenements ;
import service.EvenementService;
import java.util.Date;
import modele.Participations ;
import service.ParticipationService;
/**
 *
 * @author Mohamed
 */
public class Events {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
       Date D=new java.sql.Date(2021,5,27);
       Date D1=new java.sql.Date(2022,5,28);

        // TODO code application logic here
       Evenements e=new Evenements ("khali guesmi ",1200,"tt",D,D1,"winek bro comment cava ? "); 
       EvenementService es=new EvenementService ();
     Participations p = new Participations(98, 6, 30, 7, "addd", "addd");
        ParticipationService d= new ParticipationService();
       //es.insert(e);
     //   System.out.println(es.chercher("geus"));
      //  System.out.println(es.tries("prix"));
  // d.insert(p);
      //  es.add();
   //  es.insert(e);
    //es.update(e, 97);
   es.delete(112);
      //  System.out.println(  es.read());
        
        
        
        
        //SUPPRIMER
   // System.out.println("Delete");
    //System.out.println(es.delete(e));
        
        // System.out.println("***********************participations************************");
         // TODO code application logic here

        
        
        
        
        
        
        
    }
    
}
