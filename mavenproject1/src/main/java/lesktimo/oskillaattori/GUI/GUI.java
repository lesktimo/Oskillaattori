package lesktimo.oskillaattori.GUI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
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
    Syntetisaattori syntikka;

    public GUI(Syntetisaattori syntikka) {
        this.syntikka = syntikka;
    }

    public void run(Syntetisaattori syntikka) {

        this.syntikka = syntikka;
        runko = new JFrame("Masiina");
        runko.setPreferredSize(new Dimension(800, 200));
        runko.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(runko.getContentPane());
        runko.pack();
        runko.setVisible(true);

    }

    private void luoKomponentit(Container sisalto) {

        GridLayout layout = new GridLayout(5, 2);
        sisalto.setLayout(layout);

        JButton aloita, lopeta;
        aloita = new JButton("Aloita");
        lopeta = new JButton("Lopeta");

        ButtonKuuntelija kuuntelija = new ButtonKuuntelija(syntikka, aloita, lopeta);
        aloita.addActionListener(kuuntelija);
        lopeta.addActionListener(kuuntelija);

        JLabel taajuusOsk1 = new JLabel("Oskillaattori1 Taajuus: ");
        JSlider taajuusSlider1 = new JSlider(JSlider.HORIZONTAL, 1635, 790213, 44000);
        JLabel voimakkuusOsk1 = new JLabel("Oskillaattori1 Voimakkuus: ");
        JSlider voimakkuusSlider1 = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);

        JLabel taajuusOsk2 = new JLabel("Oskillaattori2 Taajuus: ");
        JSlider taajuusSlider2 = new JSlider(JSlider.HORIZONTAL, 1635, 790213, 44000);
        JLabel voimakkuusOsk2 = new JLabel("Oskillaattori2 Voimakkuus: ");
        JSlider voimakkuusSlider2 = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);

//        Elikkäs, tuli vähän ongelmia aluksi ChangeListenerin kanssa
//        joten kokeilen aluksi luoda toiminnallisuuden tähän jonka jälkeen
//        vasta ulkoistan sen omiin luokkiin/metodeihin
//        TaajuusKuuntelija tK = new TaajuusKuuntelija(syntikka, taajuusSlider);
//        VoimakkuusKuuntelija vK = new VoimakkuusKuuntelija(syntikka, voimakkuusSlider);
//      
        taajuusSlider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double muutos = taajuusSlider1.getValue()/100;
                syntikka.getOsk1().setTaajuus(muutos);
            }
        });

        voimakkuusSlider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double muutos = voimakkuusSlider1.getValue()/100;
                syntikka.getOsk1().setVoimakkuus(muutos);
            }
        });

        taajuusSlider2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double muutos = taajuusSlider2.getValue()/100;
                syntikka.getOsk2().setTaajuus(muutos);
            }
        });

        voimakkuusSlider2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double muutos = voimakkuusSlider2.getValue()/100;
                syntikka.getOsk2().setVoimakkuus(muutos);
            }
        });

        sisalto.add(aloita);
        sisalto.add(lopeta);
        sisalto.add(taajuusOsk1);
        sisalto.add(taajuusSlider1);
        sisalto.add(voimakkuusOsk1);
        sisalto.add(voimakkuusSlider1);
        sisalto.add(taajuusOsk2);
        sisalto.add(taajuusSlider2);
        sisalto.add(voimakkuusOsk2);
        sisalto.add(voimakkuusSlider2);
    }

    public JFrame getFrame() {
        return runko;
    }

    @Override
    public void run() {
        run(syntikka);
    }

}
