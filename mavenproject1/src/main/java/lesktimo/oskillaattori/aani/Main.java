package lesktimo.oskillaattori.aani;

import java.util.logging.Level;
import java.util.logging.Logger;
import lesktimo.oskillaattori.aani.Syntetisaattori;

/**
 *
 * @author lesktimo
 */
public class Main {

    public static void main(String[] args) {

        Syntetisaattori syntikka = new Syntetisaattori();

        try {

            syntikka.aloita();

        } catch (InterruptedException ex) {

            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
}
