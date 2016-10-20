package lesktimo.oskillaattori.gui.kuuntelijat;

import com.jsyn.scope.AudioScope;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import lesktimo.oskillaattori.aani.apu.Nuotti;
import lesktimo.oskillaattori.aani.Syntetisaattori;

/**
 * Kosketinkuuntelija seuraa koskettimiston soittoa, ja soittaa haluttuja
 * nuotteja.
 */
public class KosketinKuuntelija implements ActionListener {

    private final ButtonModel malli;
    private final JButton kosketin;
    private final Syntetisaattori syntikka;
    private final Nuotti n;
    private final AudioScope aS;

    /**
     * Alustaa KosketinKuuntelijan.
     *
     * @param kosketin Kyseessä oleva koskettimiston yksittäinen kosketin.
     * @param syntikka Käytössä oleva syntetisaattori.
     * @param n Kyseessä olevaa kosketinta kuvaava nuotti, jota käytetään
     * taajuudeen laskemisessa.
     * @param aS Waveform-näkymä.
     */
    public KosketinKuuntelija(JButton kosketin, Syntetisaattori syntikka, Nuotti n, AudioScope aS) {
        this.syntikka = syntikka;
        this.n = n;
        this.kosketin = kosketin;
        malli = this.kosketin.getModel();
        this.aS = aS;
        malli.addChangeListener((ChangeEvent e1) -> {
            if (malli.isPressed()) {

                syntikka.noteOn(n.getI(), 100);

            } else if (malli.isPressed() == false) {
                syntikka.noteOff(n.getI());
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (malli.isPressed()) {
            System.out.println("Syntikka on päällä: " + syntikka.isOn());
            System.out.println("Painat " + n.toString() + " nuottia");
        }
    }
}
