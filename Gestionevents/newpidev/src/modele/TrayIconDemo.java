/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohamed
 */
public class TrayIconDemo {
    public void trynotif ()
    {
               if (SystemTray.isSupported()) {
            TrayIconDemo td = new TrayIconDemo();
                   try {
                       td.displayTray();
                   } catch (AWTException ex) {
                       Logger.getLogger(TrayIconDemo.class.getName()).log(Level.SEVERE, null, ex);
                   }
        } else {
            System.err.println("System tray not supported!");
        }
    }
    public void displayTray() throws AWTException {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        //Alternative (if the icon is on the classpath):
        //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

        TrayIcon trayIcon = new TrayIcon(image, "new event");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("evenement");
        tray.add(trayIcon);

        trayIcon.displayMessage("new event has been add", "event", TrayIcon.MessageType.INFO);
    }
}
