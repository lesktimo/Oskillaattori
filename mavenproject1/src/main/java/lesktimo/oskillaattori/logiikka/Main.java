package lesktimo.oskillaattori.logiikka;

import javax.swing.SwingUtilities;
import lesktimo.oskillaattori.GUI.GUI;
import lesktimo.oskillaattori.GUI.MiniGUI;
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

        mG.run();

//        o1 = mG.getO1();
//        o2 = mG.getO2();
//        o3 = mG.getO3();

//        Syntetisaattori syntikka = new Syntetisaattori(44100, o1, o2, o3);
//
//        GUI g = new GUI(syntikka, syntikka.getOsk1(), syntikka.getOsk2(), syntikka.getOsk3());

//        SwingUtilities.invokeLater(g);

    }
}
