package lesktimo.oskillaattori.GUI;

import com.jsyn.scope.AudioScope;
import com.jsyn.unitgen.UnitOscillator;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import lesktimo.oskillaattori.aani.Syntetisaattori;

/**
 *
 * @author lesktimo
 */
public class GUI implements Runnable {

    private JFrame runko;
    private Syntetisaattori syntikka;
    private AudioScope nakyma;
    private UnitOscillator osk1;
    private UnitOscillator osk2;
    private UnitOscillator osk3;
    private double t1;
    private double v1;
    private double t2;
    private double v2;
    private double t3;
    private double v3;

    public GUI(Syntetisaattori syntikka, UnitOscillator osk1, UnitOscillator osk2, UnitOscillator osk3) {

        this.syntikka = syntikka;
        nakyma = new AudioScope(syntikka.getMasiina());
        this.osk1 = osk1;
        this.osk2 = osk2;
        this.osk3 = osk3;
        t1 = osk1.frequency.get();
        v1 = osk1.amplitude.get();
        t2 = osk2.frequency.get();
        v2 = osk2.amplitude.get();
        t3 = osk3.frequency.get();
        v3 = osk3.amplitude.get();

    }

    public void run(Syntetisaattori syntikka) {

        this.syntikka = syntikka;
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
        aS.setTriggerMode(AudioScope.TriggerMode.NORMAL);
        aS.getView().setControlsVisible(false);

        JButton aloita, lopeta;
        aloita = new JButton("Aloita");
        lopeta = new JButton("Lopeta");

        ButtonKuuntelija kuuntelija = new ButtonKuuntelija(syntikka, aloita, lopeta, aS);
        aloita.addActionListener(kuuntelija);
        lopeta.addActionListener(kuuntelija);

        SpinnerNumberModel model1 = new SpinnerNumberModel(44000, 0, 792013, 1);
        SpinnerNumberModel model2 = new SpinnerNumberModel(44000, 0, 792013, 1);
        SpinnerNumberModel model3 = new SpinnerNumberModel(44000, 0, 792013, 1);

        JLabel taajuusOsk1 = new JLabel("1. Oskillaattorin Taajuus: " + t1 + " Hz");
        JSpinner taajuusSpinner1 = new JSpinner(model1);
        JSlider taajuusSlider1 = new JSlider(JSlider.HORIZONTAL, 0, 790213, 44000);
        JLabel voimakkuusOsk1 = new JLabel("1. Oskillaattorin Voimakkuus: " + v1);
        JSlider voimakkuusSlider1 = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);

        JLabel taajuusOsk2 = new JLabel("2. Oskillaattorin Taajuus: " + t2 + " Hz");
        JSpinner taajuusSpinner2 = new JSpinner(model2);
        JSlider taajuusSlider2 = new JSlider(JSlider.HORIZONTAL, 0, 790213, 44000);
        JLabel voimakkuusOsk2 = new JLabel("2. Oskillaattorin Voimakkuus: " + v2);
        JSlider voimakkuusSlider2 = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);

        JLabel taajuusOsk3 = new JLabel("3. Oskillaattori Taajuus: " + t3 + " Hz");
        JSpinner taajuusSpinner3 = new JSpinner(model3);
        JSlider taajuusSlider3 = new JSlider(JSlider.HORIZONTAL, 0, 790213, 44000);
        JLabel voimakkuusOsk3 = new JLabel("3. Oskillaattorin Voimakkuus: " + v3);
        JSlider voimakkuusSlider3 = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);

//      Elikkäs, tuli vähän ongelmia aluksi ChangeListenerin kanssa
//      joten kokeilen aluksi luoda toiminnallisuuden tähän jonka jälkeen
//      vasta ulkoistan sen omiin luokkiin/metodeihin
//      TaajuusKuuntelija tK = new TaajuusKuuntelija(syntikka, taajuusSlider);
//      VoimakkuusKuuntelija vK = new VoimakkuusKuuntelija(syntikka, voimakkuusSlider);
        taajuusSlider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double muutos = taajuusSlider1.getValue() / 100;
                syntikka.getOsk1().frequency.set(muutos);
                t1 = muutos;
                taajuusOsk1.setText("1. Oskillaattorin Taajuus: " + t1 + " Hz");
            }
        });

        voimakkuusSlider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double muutos = voimakkuusSlider1.getValue();
                syntikka.getOsk1().amplitude.set(muutos / 100);
                v1 = muutos;
                voimakkuusOsk1.setText("1. Oskillaattorin Voimakkuus: " + v1);
            }
        });

        taajuusSlider2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double muutos = taajuusSlider2.getValue() / 100;
                syntikka.getOsk2().frequency.set(muutos);
                t2 = muutos;
                taajuusOsk2.setText("2. Oskillaattorin Taajuus: " + t2 + " Hz");
            }
        });

        voimakkuusSlider2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double muutos = voimakkuusSlider2.getValue();
                syntikka.getOsk2().amplitude.set(muutos / 100);
                v2 = muutos;
                voimakkuusOsk2.setText("2. Oskillaattorin Voimakkuus: " + v2);
            }
        });

        taajuusSlider3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double muutos = taajuusSlider3.getValue() / 100;
                syntikka.getOsk3().frequency.set(muutos);
                t3 = muutos;
                taajuusOsk3.setText("3. Oskillaattorin Taajuus: " + t3 + " Hz");
            }
        });

        voimakkuusSlider3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double muutos = voimakkuusSlider3.getValue();
                syntikka.getOsk3().amplitude.set(muutos / 100);
                v3 = muutos;
                voimakkuusOsk3.setText("3. Oskillaattorin Voimakkuus: " + v3);
            }
        });

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

//    private JPanel valitseOskValikko(){
//        JPanel paneeli = new JPanel(new GridLayout(2, 3));
//        
//        
//        return paneeli;
//    }
    public JFrame getFrame() {
        return runko;
    }

    @Override
    public void run() {
        run(syntikka);
    }

}
