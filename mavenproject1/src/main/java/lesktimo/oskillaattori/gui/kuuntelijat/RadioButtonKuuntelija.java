package lesktimo.oskillaattori.gui.kuuntelijat;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JRadioButton;
import lesktimo.oskillaattori.aani.Syntetisaattori;

public class RadioButtonKuuntelija implements ItemListener {

    private Syntetisaattori syntikka;
    private JRadioButton sini;
    private JRadioButton nelio;
    private JRadioButton saha;
    private int valinta;

    public RadioButtonKuuntelija(Syntetisaattori syntikka, JRadioButton sini, JRadioButton nelio, JRadioButton saha, int i) {
        this.syntikka = syntikka;
        this.sini = sini;
        this.nelio = nelio;
        this.saha = saha;
        this.valinta = i;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource().equals(sini)) {
            valinta = 1;
        } else if (e.getSource().equals(saha)) {
            valinta = 2;
        } else if (e.getSource().equals(nelio)) {
            valinta = 3;
        }
    }
}
