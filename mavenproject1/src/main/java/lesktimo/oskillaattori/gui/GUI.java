package lesktimo.oskillaattori.gui;

import lesktimo.oskillaattori.gui.kuuntelijat.TaajuusSliderKuuntelija;
import lesktimo.oskillaattori.gui.kuuntelijat.VoimakkuusSliderKuuntelija;
import lesktimo.oskillaattori.gui.kuuntelijat.ButtonKuuntelija;
import com.jsyn.scope.AudioScope;
import com.jsyn.unitgen.UnitOscillator;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import lesktimo.oskillaattori.aani.Syntetisaattori;

/**
 * Tässä GUI:ssa käyttäjä muokkaa oskillaattoreiden ominaisuuksia, kuten
 * taajuutta.
 */
public class GUI implements Runnable {

    private JFrame runko;
    private Syntetisaattori syntikka;
    private AudioScope nakyma;
    private UnitOscillator osk1;
    private UnitOscillator osk2;
    private UnitOscillator osk3;
    private double taajuus1, voimakkuus1, taajuus2, voimakkuus2, taajuus3, voimakkuus3;
    private SoitinGUI sG;

    /**
     * Alustaa muokkaus-gui:n.
     *
     * @param syntikka Syntetisaattori, joka on käytössä.
     * @param osk1 Ensimmäinen oskillaattori.
     * @param osk2 Toinen oskillaattori.
     * @param osk3 Kolmas oskillaattori.
     */
    public GUI(Syntetisaattori syntikka, UnitOscillator osk1, UnitOscillator osk2, UnitOscillator osk3) {
        this.syntikka = syntikka;
        nakyma = new AudioScope(syntikka.getMasiina());
        this.osk1 = osk1;
        this.osk2 = osk2;
        this.osk3 = osk3;
        taajuus1 = osk1.frequency.get();
        voimakkuus1 = osk1.amplitude.get();
        taajuus2 = osk2.frequency.get();
        voimakkuus2 = osk2.amplitude.get();
        taajuus3 = osk3.frequency.get();
        voimakkuus3 = osk3.amplitude.get();
        sG = null;
    }

    @Override
    public void run() {
        runko = new JFrame("Masiina");
        runko.setPreferredSize(new Dimension(1200, 600));
        runko.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(runko.getContentPane(), nakyma);
        runko.pack();
        runko.setVisible(true);
    }

    private void luoKomponentit(Container sisalto, AudioScope aS) {
        GridLayout layout = new GridLayout(8, 1);
        sisalto.setLayout(layout);
        aS.addProbe(syntikka.getOsk1().output);
        aS.addProbe(syntikka.getOsk2().output);
        aS.addProbe(syntikka.getOsk3().output);
        aS.setViewMode(AudioScope.ViewMode.SPECTRUM);
        aS.setTriggerMode(AudioScope.TriggerMode.AUTO);
        aS.setTriggerLevel(Double.MIN_VALUE);
        aS.getView().setControlsVisible(false);
        JButton aloita, lopeta;
        aloita = new JButton("Aloita");
        lopeta = new JButton("Jatka");
        ButtonKuuntelija kuuntelija = new ButtonKuuntelija(syntikka, aloita, lopeta, aS, sG, runko);
        aloita.addActionListener(kuuntelija);
        lopeta.addActionListener(kuuntelija);
        SpinnerNumberModel model1 = new SpinnerNumberModel(440.0, 0.00, 8000.00, 0.01);
        SpinnerNumberModel model2 = new SpinnerNumberModel(440.0, 0.00, 8000.00, 0.01);
        SpinnerNumberModel model3 = new SpinnerNumberModel(440.0, 0.00, 8000.00, 0.01);
        JLabel taajuusOsk1 = new JLabel("1. Oskillaattorin Taajuus: " + taajuus1 + " Hz");
        //spinnerit ei toimi vielä, tarkoitus olisi hienosäätää taajuutta
        JSpinner taajuusSpinner1 = new JSpinner(model1);
        JSlider taajuusSlider1 = new JSlider(JSlider.HORIZONTAL, 0, 790213, 44000);
        JLabel voimakkuusOsk1 = new JLabel("1. Oskillaattorin Voimakkuus: " + voimakkuus1);
        JSlider voimakkuusSlider1 = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        JLabel taajuusOsk2 = new JLabel("2. Oskillaattorin Taajuus: " + taajuus2 + " Hz");
        JSpinner taajuusSpinner2 = new JSpinner(model2);
        JSlider taajuusSlider2 = new JSlider(JSlider.HORIZONTAL, 0, 790213, 44000);
        JLabel voimakkuusOsk2 = new JLabel("2. Oskillaattorin Voimakkuus: " + voimakkuus2);
        JSlider voimakkuusSlider2 = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        JLabel taajuusOsk3 = new JLabel("3. Oskillaattori Taajuus: " + taajuus3 + " Hz");
        JSpinner taajuusSpinner3 = new JSpinner(model3);
        JSlider taajuusSlider3 = new JSlider(JSlider.HORIZONTAL, 0, 790213, 44000);
        JLabel voimakkuusOsk3 = new JLabel("3. Oskillaattorin Voimakkuus: " + voimakkuus3);
        JSlider voimakkuusSlider3 = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        TaajuusSliderKuuntelija tSK1 = new TaajuusSliderKuuntelija(1, taajuusOsk1, taajuusSlider1, osk1);
        taajuusSlider1.addChangeListener(tSK1);
        TaajuusSliderKuuntelija tSK2 = new TaajuusSliderKuuntelija(2, taajuusOsk2, taajuusSlider2, osk2);
        taajuusSlider2.addChangeListener(tSK2);
        TaajuusSliderKuuntelija tSK3 = new TaajuusSliderKuuntelija(3, taajuusOsk3, taajuusSlider3, osk3);
        taajuusSlider3.addChangeListener(tSK3);
        VoimakkuusSliderKuuntelija vSK1 = new VoimakkuusSliderKuuntelija(1, voimakkuusOsk1, voimakkuusSlider1, osk1);
        voimakkuusSlider1.addChangeListener(vSK1);
        VoimakkuusSliderKuuntelija vSK2 = new VoimakkuusSliderKuuntelija(2, voimakkuusOsk2, voimakkuusSlider2, osk2);
        voimakkuusSlider2.addChangeListener(vSK2);
        VoimakkuusSliderKuuntelija vSK3 = new VoimakkuusSliderKuuntelija(3, voimakkuusOsk3, voimakkuusSlider3, osk3);
        voimakkuusSlider3.addChangeListener(vSK3);

        sisalto.add(luoValikko1(aloita, lopeta));
        sisalto.add(luoValikko2(taajuusOsk1, taajuusSlider1, taajuusSpinner1));
        sisalto.add(luoValikko3(voimakkuusOsk1, voimakkuusSlider1));
        sisalto.add(luoValikko2(taajuusOsk2, taajuusSlider2, taajuusSpinner2));
        sisalto.add(luoValikko3(voimakkuusOsk2, voimakkuusSlider2));
        sisalto.add(luoValikko2(taajuusOsk3, taajuusSlider3, taajuusSpinner3));
        sisalto.add(luoValikko3(voimakkuusOsk3, voimakkuusSlider3));
        sisalto.add(aS.getView());
    }

    private JPanel luoValikko1(JButton b1, JButton b2) {
        JPanel paneeli = new JPanel(new GridLayout(2, 1));
        JPanel paneeli2 = new JPanel(new GridLayout(1, 2));
        JTextField text = new JTextField("1. Säädä tietokoneen volyymi mahdollisimman pienelle!"
                + " 2. Paina aloita"
                + " 3. Säädä oskillaattoreiden voimakkuutta/taajuutta");
        text.disable();
        paneeli2.add(b1);
        paneeli2.add(b2);
        paneeli.add(text);
        paneeli.add(paneeli2);
        return paneeli;
    }

    private JPanel luoValikko2(JLabel j, JSlider jS, JSpinner jSpin) {
        JPanel paneeli = new JPanel(new GridLayout(1, 2));
        JPanel paneeli2 = new JPanel(new GridLayout(1, 2));
        JPanel paneeli3 = new JPanel(new GridLayout(4, 1));
        JLabel label = new JLabel("Lisää ominaisuuksia tähän");
        paneeli2.add(j);
        paneeli3.add(jSpin);
        paneeli3.add(label);
        paneeli3.add(label);
        paneeli3.add(label);
        paneeli2.add(paneeli3);
        paneeli.add(paneeli2);
        paneeli.add(jS);
        return paneeli;
    }

    private JPanel luoValikko3(JLabel j, JSlider jS) {
        JPanel paneeli = new JPanel(new GridLayout(1, 2));
        paneeli.add(j);
        paneeli.add(jS);
        return paneeli;
    }

    public JFrame getFrame() {
        return runko;
    }
}
