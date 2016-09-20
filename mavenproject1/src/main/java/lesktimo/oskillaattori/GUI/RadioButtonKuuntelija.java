/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesktimo.oskillaattori.GUI;

import com.jsyn.unitgen.UnitOscillator;
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
    private UnitOscillator osk;
    private double dT;
    private double dV;
    private int oI;

    public RadioButtonKuuntelija(Syntetisaattori syntikka, UnitOscillator osk, JRadioButton sini, JRadioButton nelio, JRadioButton saha, int i) {
        this.syntikka = syntikka;
        this.osk = osk;
        this.sini = sini;
        this.nelio = nelio;
        this.saha = saha;
        this.dT = 0;
        this.dV = 0;
        this.oI = i;

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource().equals(sini)) {

            syntikka.vaihdaOsc(osk, 1, oI, dT, dV);

//            sini.setSelected(true);
        } else if (e.getSource().equals(saha)) {

            syntikka.vaihdaOsc(osk, 2, oI, dT, dV);

//            saha.setSelected(true);
        } else if (e.getSource().equals(nelio)) {

            syntikka.vaihdaOsc(osk, 3, oI, dT, dV);

//            nelio.setSelected(true);
        }
    }

}
