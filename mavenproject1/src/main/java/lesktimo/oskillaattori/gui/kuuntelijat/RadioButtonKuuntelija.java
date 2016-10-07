package lesktimo.oskillaattori.gui.kuuntelijat;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JRadioButton;
import lesktimo.oskillaattori.aani.Syntetisaattori;

/**
 * Tämä kuuntelija seuraa käyttäjän tekemiä valintoja oskillaattoreita koskien
 * alkuvalikossa.
 *
 * @author lesktimo
 */
public class RadioButtonKuuntelija implements ItemListener {

    private Syntetisaattori syntikka;
    private JRadioButton sini;
    private JRadioButton nelio;
    private JRadioButton saha;
    private int valinta;

    /**
     * Alustaa RadioButtonKuuntelijan.
     *
     * @param syntikka Käytössä oleva syntetisaattori.
     * @param sini Valinta, jota seuraa sini-muotoinen oskillaatori.
     * @param nelio Valinta, jota seuraa nelikulman muotoinen oskillaatori.
     * @param saha Valinta, jota seuraa sahan muotoinen oskillaatori.
     * @param i Muuttuja joka antaa eteenpäin käyttäjän valinnan.
     */
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
