/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import javax.swing.UIManager;
import javax.swing.JFrame;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author Ghost
 */
public class Agenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{
       
        //  UIManager.setLookAndFeel("net.sourceforge.napkinlaf.NapkinLookAndFeel");//napkin
       // UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");//liquid
        //UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        JFrame.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.MagmaSkin");
       // SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessSkin");
    }
      catch(Exception e){
      //e.printStackTrace();
      }
   
      Login log = new Login();
//Login.mostrar();
        
          

    }
    
}
