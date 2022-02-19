/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi_dev;
import Model.Client ;
import Services.ClientServices ;
import Model.Coach ;
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
        Client C = new Client("sdq", "dsqd", "qjskd", "ajqsn", "@sqdqs",85,54,"client");
        Coach C1 = new Coach("sdq", "dsqd", "qjskd", "ajqsn", "@sqdqs",85,54,"coach","yoga",2500);
        ClientServices s =new ClientServices();
        CoachServices s1=new CoachServices();
        s.insert(C);
        s1.insert(C1);
        s.read();
        GeneralServices GS =new GeneralServices();
        try {
            ;
            GS.sendMail("raybahta12@gmail.com",GS. Token_Mdp_Oublie ("raybahta12@gmail.com"));
        } catch (Exception ex) {
            Logger.getLogger(PI_DEV.class.getName()).log(Level.SEVERE, null, ex);
        }
//         Random rand = new Random();
//       int token = rand.nextInt(99999);
//        System.out.println(token);

    
}
}
