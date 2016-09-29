package lesktimo.oskillaattori.logiikka;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import lesktimo.oskillaattori.aani.Hallintapiiri;
import lesktimo.oskillaattori.gui.GUI;
import lesktimo.oskillaattori.gui.MiniGUI;
import lesktimo.oskillaattori.aani.Syntetisaattori;


/**
 *
 * @author lesktimo
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Syntetisaattori syntikka = null;
        GUI g = null;

        MiniGUI mG = new MiniGUI(syntikka, g);

        SwingUtilities.invokeLater(mG);


    }
}
