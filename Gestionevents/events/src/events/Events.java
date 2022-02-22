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
       // Date D=new Date (2022,22,1);
         
        // TODO code application logic here
       Evenements e=new Evenements ("gasmi",1200,"gabes","cestezsfsdqf","salut les gars","oui"); 
       EvenementService es=new EvenementService ();
       es.insert(e);
        
        
        
        
        //SUPPRIMER
   // System.out.println("Delete");
    //System.out.println(es.delete(e));
        
        System.out.println("***********************participations************************");
         // TODO code application logic here
       Participations p=new Participations (2,12,6,300,100,"junior","les plus fort et musclé"); 
       ParticipationService ps=new ParticipationService ();
       ps.insert(p);
        
        
        
        
        
        
        
        
    }
    
}
