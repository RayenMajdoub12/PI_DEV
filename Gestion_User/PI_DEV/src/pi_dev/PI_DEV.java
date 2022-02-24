/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi_dev;
import Model.User ;
import Services.ClientServices ;

import Services.CoachServices ;
import Services.GeneralServices ;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Rayen
 */
public class PI_DEV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   
   
        ClientServices s =new ClientServices();
        CoachServices s1=new CoachServices();
 
  
        s.read();
        GeneralServices GS =new GeneralServices();
        GS.Token_Mdp_Oublie("aa");
//        try {
//            
//            GS.sendMail("raybahta12@gmail.com",GS. Token_Mdp_Oublie ("raybahta12@gmail.com"));
//        } catch (Exception ex) {
//            Logger.getLogger(PI_DEV.class.getName()).log(Level.SEVERE, null, ex);
//        }
//         Random rand = new Random();
//       int token = rand.nextInt(99999);
//        System.out.println(token);

    
}
}
