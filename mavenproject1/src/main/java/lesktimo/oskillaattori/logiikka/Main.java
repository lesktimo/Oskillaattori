package lesktimo.oskillaattori.logiikka;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import lesktimo.oskillaattori.GUI.GUI;
import lesktimo.oskillaattori.aani.Syntetisaattori;

/**
 *
 * @author lesktimo
 */
public class Main {

    public static void main(String[] args) {

        Syntetisaattori syntikka = new Syntetisaattori(44100);
        GUI g = new GUI(syntikka);

        SwingUtilities.invokeLater(g);

    }
}
