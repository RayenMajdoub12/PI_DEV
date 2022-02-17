/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi_dev;
import Model.Client ;
import Services.ClientServices ;


/**
 *
 * @author Rayen
 */
public class PI_DEV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Client C = new Client("sdq", "dsqd", 854, 8541, 174, "@sqdqs");
        ClientServices s =new ClientServices();
        s.insert(C);
        s.read();
    }
    
}
