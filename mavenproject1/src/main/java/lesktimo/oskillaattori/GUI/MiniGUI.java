package lesktimo.oskillaattori.GUI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;
import lesktimo.oskillaattori.aani.Syntetisaattori;

/**
 *
 * @author lesktimo
 */
public class MiniGUI implements Runnable {

    private JFrame runko;
    private int o1, o2, o3;
    private Syntetisaattori syntikka;
    private GUI g;

    public MiniGUI(Syntetisaattori syntikka, GUI g) {

        this.g = g;
        this.syntikka = syntikka;

        o1 = 1;
        o2 = 2;
        o3 = 3;
    }

    @Override
    public void run() {

        runko = new JFrame("Masiina");
        runko.setPreferredSize(new Dimension(400, 600));
        runko.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(runko.getContentPane());
        runko.pack();
        runko.setVisible(true);

    }

    public void luoKomponentit(Container sisalto) {

        GridLayout layout = new GridLayout(5, 1);
        sisalto.setLayout(layout);

        JLabel otsake = new JLabel("Valitse Oskillaattoreiden muodot: ");
        JLabel jL1 = new JLabel("1. Oskallaattorin muoto: ");
        JLabel jL2 = new JLabel("2. Oskallaattorin muoto: ");
        JLabel jL3 = new JLabel("3. Oskallaattorin muoto: ");

        JRadioButton sini1, saha1, nelio1, sini2, saha2, nelio2, sini3, saha3, nelio3;

        sini1 = new JRadioButton("Sini", true);
        sini1.setMnemonic(1);
        nelio1 = new JRadioButton("Neliö");
        nelio1.setMnemonic(2);
        saha1 = new JRadioButton("Saha");
        saha1.setMnemonic(3);

        sini2 = new JRadioButton("Sini");
        sini2.setMnemonic(1);
        nelio2 = new JRadioButton("Neliö", true);
        nelio2.setMnemonic(2);
        saha2 = new JRadioButton("Saha");
        saha2.setMnemonic(3);

        sini3 = new JRadioButton("Sini");
        sini3.setMnemonic(1);
        nelio3 = new JRadioButton("Neliö");
        nelio3.setMnemonic(2);
        saha3 = new JRadioButton("Saha", true);
        saha3.setMnemonic(3);

        ButtonGroup oR1 = new ButtonGroup();
        oR1.add(sini1);
        oR1.add(nelio1);
        oR1.add(saha1);

        ButtonGroup oR2 = new ButtonGroup();
        oR2.add(sini2);
        oR2.add(nelio2);
        oR2.add(saha2);

        ButtonGroup oR3 = new ButtonGroup();
        oR3.add(sini3);
        oR3.add(nelio3);
        oR3.add(saha3);

        JButton jatka = new JButton("Jatka");
        jatka.addActionListener(new JatkaKuuntelija(jatka, syntikka, g, o1, o2, o3, oR1, oR2, oR3));

        sisalto.add(otsake);

        sisalto.add(luoValikko(jL1, sini1, nelio1, saha1));
        sisalto.add(luoValikko(jL2, sini2, nelio2, saha2));
        sisalto.add(luoValikko(jL3, sini3, nelio3, saha3));

        sisalto.add(jatka);

    }

    public JPanel luoValikko(JLabel jL, JRadioButton b1, JRadioButton b2, JRadioButton b3) {
        JPanel jP1 = new JPanel(new GridLayout(2, 1));
        JPanel jP2 = new JPanel(new GridLayout(1, 3));
        jP1.add(jL);
        jP2.add(b1);
        jP2.add(b2);
        jP2.add(b3);
        jP1.add(jP2);
        return jP1;
    }

    public JFrame getFrame() {
        return runko;
    }

    public int getO1() {
        return o1;
    }

    public int getO2() {
        return o2;
    }

    public int getO3() {
        return o3;
    }

    public void setO1(int o1) {
        this.o1 = o1;
    }

    public void setO2(int o2) {
        this.o2 = o2;
    }

    public void setO3(int o3) {
        this.o3 = o3;
    }

}
