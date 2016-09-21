/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesktimo.oskillaattori.GUI;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JRadioButton;
import lesktimo.oskillaattori.aani.Syntetisaattori;

/**
 *
 * @author lesktimo
 */
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
