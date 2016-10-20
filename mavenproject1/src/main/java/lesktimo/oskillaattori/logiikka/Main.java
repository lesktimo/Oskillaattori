package lesktimo.oskillaattori.logiikka;

import javax.swing.SwingUtilities;
import lesktimo.oskillaattori.gui.GUI;
import lesktimo.oskillaattori.gui.MiniGUI;
import lesktimo.oskillaattori.aani.Syntetisaattori;
import lesktimo.oskillaattori.aani.apu.Nuotti;

public class Main {

    /**
     * Luo syntetisaattorin ja GUI:n ja heittää ne eteenpäin MiniGUI:lle
     * alustettavaksi käyttäjän preferenssien mukaan.
     *
     * @param args args.
     * @throws InterruptedException Mikäli ohjelman juoksu keskeytyy.
     */
    public static void main(String[] args) throws InterruptedException {
        Syntetisaattori syntikka = null;
        GUI g = null;
        MiniGUI mG = new MiniGUI(syntikka, g);
        SwingUtilities.invokeLater(mG);
    }
}
