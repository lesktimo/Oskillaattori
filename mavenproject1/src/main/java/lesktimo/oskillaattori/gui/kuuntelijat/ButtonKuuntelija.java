package lesktimo.oskillaattori.gui.kuuntelijat;

import com.jsyn.scope.AudioScope;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import lesktimo.oskillaattori.aani.Syntetisaattori;
import lesktimo.oskillaattori.gui.SoitinGUI;

/**
 * ButtonKuuntelija kuuntelee GUI:n nappeja.
 */
public class ButtonKuuntelija implements ActionListener {

    private Syntetisaattori syntikka;
    private AudioScope aS;
    private JButton aloita;
    private JButton jatka;
    private SoitinGUI sG;
    private JFrame vanhaRunko;

    /**
     * Alustaa ButtonKuuntelijan.
     *
     * @param syntikka Käytössä oleva syntetisaattori
     * @param aloita JButton, joka aloittaa ja keskeyttää soiton.
     * @param jatka JButton, joka siirtyy koskettimiston sisältävään näkymään.
     * @param aS Waveform-näkymä
     * @param sG SoitinGUI, jonka nappi luo.
     * @param runko Vanha JFrame-runko, joka piilotetaan uusi luodessa.
     */
    public ButtonKuuntelija(Syntetisaattori syntikka, JButton aloita, JButton jatka, AudioScope aS, SoitinGUI sG, JFrame runko) {
        this.syntikka = syntikka;
        this.aloita = aloita;
        this.jatka = jatka;
        this.aS = aS;
        this.sG = sG;
        this.vanhaRunko = runko;
    }

    /**
     * Mikäli käyttäjä painaa aloita, alkavat oskillaatorit soida, ja nappi
     * vaihtuu pysäytä -napiksi, joka puolestaan pysäyttää oskillaarit.
     * Jatka-nappi siirtyy SoitinGUI:hin.
     *
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(aloita)) {
            if (syntikka.isOn() == false) {
                try {
                    syntikka.aloita();
                    aS.start();
                    aloita.setText("Pysäytä");
                } catch (InterruptedException ex) {
                    Logger.getLogger(ButtonKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                syntikka.lopeta();
                aS.stop();
                aloita.setText("Aloita");
            }
        } else if (e.getSource().equals(jatka)) {
//            if (syntikka.isOn() == true) {
//                syntikka.lopeta();

//            }
            try {
                syntikka.yhdistaAanet();
                sG = new SoitinGUI(syntikka, aS);
                sG.run();
                vanhaRunko.hide();
            } catch (InterruptedException ex) {
                Logger.getLogger(ButtonKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
