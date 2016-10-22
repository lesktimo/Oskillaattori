/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesktimo.oskillaattori.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextField;
import lesktimo.oskillaattori.aani.apu.Lukija;

/**
 * Soita-napin kuuntelija.
 *
 * @author lesktimo
 */
public class SoitaKuuntelija implements ActionListener {

    boolean paalla;
    private Lukija lukija;
    private JTextField syoteKentta;
    private JButton soittoNappi;

    /**
     * Alustaa kuuntelijan.
     *
     * @param lukija Käytössä oleva lukija-olio, joka lukee tekstiä.
     * @param syoteKentta Käytössä oleva tekstikenttä.
     * @param soittoNappi Nappi, jolla soitto alkaa.
     */
    public SoitaKuuntelija(Lukija lukija, JTextField syoteKentta, JButton soittoNappi) {
        this.lukija = lukija;
        this.syoteKentta = syoteKentta;
        this.soittoNappi = soittoNappi;
        paalla = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (paalla == false) {
            try {
                paalla = true;
                lukija.lue(syoteKentta.getText(), paalla);
            } catch (InterruptedException ex) {
                Logger.getLogger(SoitaKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (paalla == true) {
            try {
                paalla = false;
                lukija.lue(syoteKentta.getText(), paalla);
            } catch (InterruptedException ex) {
                Logger.getLogger(SoitaKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
