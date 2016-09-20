package lesktimo.oskillaattori.logiikka;

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
        GUI g = new GUI(syntikka, syntikka.getOsk1(),syntikka.getOsk2(), syntikka.getOsk3());

        SwingUtilities.invokeLater(g);

    }
}
