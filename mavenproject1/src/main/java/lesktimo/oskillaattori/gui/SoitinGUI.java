package lesktimo.oskillaattori.gui;

import com.jsyn.scope.AudioScope;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import lesktimo.oskillaattori.aani.Syntetisaattori;

public class SoitinGUI implements Runnable {

    private JFrame runko;
    private PaneeliTesti paneeli;
    private Syntetisaattori syntikka;
    private AudioScope nakyma;

    public SoitinGUI(Syntetisaattori syntikka, AudioScope nakyma) {
        this.runko = new JFrame("Masiina");
        this.syntikka = syntikka;
        this.nakyma = nakyma;
        paneeli = new PaneeliTesti(syntikka, nakyma);
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

    public void luoKomponentit(Container sisalto, AudioScope aS, PaneeliTesti paneeli) {
        GridLayout layout = new GridLayout(1, 1);
        sisalto.setLayout(layout);
        sisalto.add(paneeli);
    }

    
}
