package nreinas;

import Ventanas.VentanaInicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author luisb
 */
public class NReinas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(NReinas.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        VentanaInicio ventanaInicio = new VentanaInicio();
        ventanaInicio.setVisible(true);
    }
}
