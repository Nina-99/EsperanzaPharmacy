package Controller;

import View.frmStarted;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new McWinLookAndFeel());
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                frmStarted Started = new frmStarted();
                StartedController startedController = new StartedController(Started);
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                //obtenemos el tamaño de la ventana  
                Dimension ventana = Started.getSize();
                //para centrar la ventana lo hacemos con el siguiente calculo  
                Started.setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
                Started.setVisible(true);

            }
        });
    }

}
