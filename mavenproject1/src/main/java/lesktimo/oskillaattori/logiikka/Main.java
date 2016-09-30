package lesktimo.oskillaattori.logiikka;

import javax.swing.SwingUtilities;
import lesktimo.oskillaattori.gui.GUI;
import lesktimo.oskillaattori.gui.MiniGUI;
import lesktimo.oskillaattori.aani.Syntetisaattori;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Syntetisaattori syntikka = null;
        GUI g = null;
        MiniGUI mG = new MiniGUI(syntikka, g);
        SwingUtilities.invokeLater(mG);
    }
}
