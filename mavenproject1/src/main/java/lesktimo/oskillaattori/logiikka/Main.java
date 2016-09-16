package lesktimo.oskillaattori.logiikka;

import java.util.logging.Level;
import java.util.logging.Logger;
import lesktimo.oskillaattori.aani.Syntetisaattori;

/**
 *
 * @author lesktimo
 */
public class Main {

    public static void main(String[] args) {

        Syntetisaattori syntikka = new Syntetisaattori(44100);

        try {

            syntikka.aloita();

        } catch (InterruptedException ex) {

            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
}
