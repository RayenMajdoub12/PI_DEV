/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymgeeks;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ASUS
 */
public class mail {
    
    public static void sendmail(String recepient  ) throws Exception {
    System.out.println("preparing") ; 
    Properties p=new Properties();
        p.put("mail.smtp.auth","true");
        p.put("mail.smtp.starttls.enable","true");
        p.put("mail.smtp.host","smtp.gmail.com");
        p.put("mail.smtp.port","587");
        
       String myAccountEmail = "siwar.dhrif5@gmail.com"  ; 
       String password = "fatmafaker1234" ; 
       
       Session session = Session.getInstance(p, new  Authenticator ()  {
           @Override
           protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication (myAccountEmail,password) ; 
           }
       }); 
       Message  message = prepareMessage(session,myAccountEmail,recepient) ; 
       Transport.send(message) ; 
       System.out.println("message sent");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
       try {
           Message message = new MimeMessage(session) ; 
           message.setFrom( new InternetAddress(myAccountEmail)) ; 
           message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
           message.setSubject("[GymGeeks] Commande prete "); 
           message.setText("Commande prete");
           return message ; 
           
           
       } catch (Exception ex) {
           
       }
       return null ; 
    }
}
