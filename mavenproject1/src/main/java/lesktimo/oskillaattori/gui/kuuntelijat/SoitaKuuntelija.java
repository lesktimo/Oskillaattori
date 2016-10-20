/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesktimo.oskillaattori.gui.kuuntelijat;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import lesktimo.oskillaattori.aani.apu.Lukija;

/**
 *
 * @author lesktimo
 */
public class SoitaKuuntelija implements ChangeListener {

    boolean paalla;
    private Lukija lukija;
    private JTextField syoteKentta;
    private JButton soittoNappi;

    public SoitaKuuntelija(Lukija lukija, JTextField syoteKentta, JButton soittoNappi) {
        this.lukija = lukija;
        this.syoteKentta = syoteKentta;
        this.soittoNappi = soittoNappi;
        paalla = false;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (paalla == false) {
            try {
                paalla = true;
                soittoNappi.setText("Pysäytä");
                lukija.lue(syoteKentta.getText(), paalla);
            } catch (InterruptedException ex) {
                Logger.getLogger(SoitaKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (paalla == true) {
            try {
                paalla = false;
                soittoNappi.setText("Soita");
                lukija.lue(syoteKentta.getText(), paalla);
            } catch (InterruptedException ex) {
                Logger.getLogger(SoitaKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
