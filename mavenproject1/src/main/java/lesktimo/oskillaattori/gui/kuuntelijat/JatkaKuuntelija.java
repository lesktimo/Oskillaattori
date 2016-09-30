package lesktimo.oskillaattori.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import lesktimo.oskillaattori.aani.Syntetisaattori;
import lesktimo.oskillaattori.gui.GUI;

/**
 * Tämä kuuntelija seuraa aloitusvalikon jatka-nappia ja sen jälkeen käskee
 * alustaa oskillaatorit ja alustaa seuraavan GUI:n.
 *
 */
public class JatkaKuuntelija implements ActionListener {

    private JButton b;
    private GUI g;
    private Syntetisaattori s;
    int o1, o2, o3;
    ButtonGroup oR1, oR2, oR3;
    private JFrame runko;

    public JatkaKuuntelija(JButton b, Syntetisaattori s, GUI g, int o1, int o2, int o3, ButtonGroup oR1, ButtonGroup oR2, ButtonGroup oR3, JFrame runko) {
        this.g = g;
        this.s = s;
        this.b = b;
        this.o1 = o1;
        this.o2 = o2;
        this.o3 = o3;
        this.oR1 = oR1;
        this.oR2 = oR2;
        this.oR3 = oR3;
        this.runko = runko;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (oR1.getSelection().getMnemonic()) {
            case 1:
                o1 = 1;
                break;
            case 2:
                o1 = 2;
                break;
            case 3:
                o1 = 3;
                break;
            default:
                o1 = 1;
                break;
        }
        switch (oR2.getSelection().getMnemonic()) {
            case 1:
                o2 = 1;
                break;
            case 2:
                o2 = 2;
                break;
            case 3:
                o2 = 3;
                break;
            default:
                o2 = 1;
                break;
        }
        switch (oR3.getSelection().getMnemonic()) {
            case 1:
                o3 = 1;
                break;
            case 2:
                o3 = 2;
                break;
            case 3:
                o3 = 3;
                break;
            default:
                o3 = 1;
                break;
        }
        s = new Syntetisaattori(44100, o1, o2, o3);
        g = new GUI(s, s.getOsk1(), s.getOsk2(), s.getOsk3());
        g.run();
        runko.hide();
    }
}
