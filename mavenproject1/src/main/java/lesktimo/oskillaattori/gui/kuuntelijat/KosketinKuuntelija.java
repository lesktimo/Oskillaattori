package lesktimo.oskillaattori.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.JButton;

import lesktimo.oskillaattori.aani.Nuotti;
import lesktimo.oskillaattori.aani.Syntetisaattori;

/**
 * Kosketinkuuntelija seuraa koskettimiston soittoa, ja soittaa haluttuja
 * nuotteja.
 *
 * //KESKEN!!
 */
public class KosketinKuuntelija implements ActionListener {

    private final JButton kosketin;
    private final ButtonModel malli;
    private final Syntetisaattori syntikka;
    private final Nuotti n;

    public KosketinKuuntelija(JButton kosketin, Syntetisaattori syntikka, Nuotti n) {
        this.syntikka = syntikka;
        this.kosketin = kosketin;
        this.n = n;
        malli = kosketin.getModel();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            syntikka.aloita();
        } catch (InterruptedException ex) {
            Logger.getLogger(KosketinKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (malli.isPressed() == true) {
            syntikka.noteOn(syntikka.getAllokaattori1(), 1, n.getI(), 100);
            syntikka.noteOn(syntikka.getAllokaattori2(), 1, n.getI(), 100);
            syntikka.noteOn(syntikka.getAllokaattori3(), 1, n.getI(), 100);
        }
        syntikka.noteOff(syntikka.getAllokaattori1(), 1, n.getI(), 100);
        syntikka.noteOff(syntikka.getAllokaattori2(), 1, n.getI(), 100);
        syntikka.noteOff(syntikka.getAllokaattori3(), 1, n.getI(), 100);
        syntikka.lopeta();
    }
}
