package lesktimo.oskillaattori.gui;

import com.jsyn.scope.AudioScope;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import lesktimo.oskillaattori.aani.Syntetisaattori;

/**
 * Tässä GUI:ssa käyttäjälle avautuu koskettimisto, joilla on mahdollista
 * soittaa syntetisaattoria.
 */
public class SoitinGUI implements Runnable {

    private JFrame runko;
    private SoitinPaneeli paneeli;
    private Syntetisaattori syntikka;
    private AudioScope nakyma;

    /**
     * Alustaa soitin-näkymän.
     *
     * @param syntikka Käytössä oleva syntetisaattori
     *
     */
    public SoitinGUI(Syntetisaattori syntikka) {
        this.runko = new JFrame("Masiina");
        this.syntikka = syntikka;
        this.nakyma = new AudioScope(this.syntikka.getMasiina());
        paneeli = new SoitinPaneeli(syntikka, nakyma);
    }

    @Override
    public void run() {
        runko = new JFrame("Masiina");
        runko.setPreferredSize(new Dimension(862, 620));
        runko.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(runko.getContentPane(), nakyma, paneeli);
        runko.pack();
        runko.setVisible(true);
    }

    /**
     * Luo GUI:n sisällön.
     *
     * @param sisalto itseselitteisesti sisältö
     * @param aS Waveform-näkymän sisältö
     * @param paneeli Koskettimisto
     */
    public void luoKomponentit(Container sisalto, AudioScope aS, SoitinPaneeli paneeli) {
        GridLayout layout = new GridLayout(1, 1);
        sisalto.setLayout(layout);
        sisalto.add(paneeli);
    }

}
