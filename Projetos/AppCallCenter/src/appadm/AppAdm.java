/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appadm;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author MC System Work's
 */

public class AppAdm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  try {
            // TODO code application logic here
      
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AppAdm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AppAdm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AppAdm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AppAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      /** try {
    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
} catch (Exception e) {
    // If Nimbus is not available, you can set the GUI to another look and feel.
}
       */
        ConectaGeral abrir=new ConectaGeral();
        //abrir.setUndecorated(false);
        abrir.setVisible(true);
    }
}
