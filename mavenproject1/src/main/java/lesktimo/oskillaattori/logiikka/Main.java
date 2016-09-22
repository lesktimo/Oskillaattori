package lesktimo.oskillaattori.logiikka;

import javax.swing.SwingUtilities;
import lesktimo.oskillaattori.gui.GUI;
import lesktimo.oskillaattori.gui.MiniGUI;
import lesktimo.oskillaattori.aani.Syntetisaattori;

/**
 *
 * @author lesktimo
 */
public class Main {

    private static int o1, o2, o3;

    public static void main(String[] args) {

        Syntetisaattori syntikka = null;
        GUI g = null;

        MiniGUI mG = new MiniGUI(syntikka, g);

        SwingUtilities.invokeLater(mG);

    }
}
