/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesktimo.oskillaattori.GUI;

import com.jsyn.scope.AudioScope;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import lesktimo.oskillaattori.aani.Syntetisaattori;

/**
 *
 * @author lesktimo
 */
public class ButtonKuuntelija implements ActionListener {

    private Syntetisaattori syntikka;
    private AudioScope aS;
    private JButton aloita;
    private JButton lopeta;

    public ButtonKuuntelija(Syntetisaattori syntikka, JButton aloita, JButton lopeta, AudioScope aS) {
        this.syntikka = syntikka;
        this.aloita = aloita;
        this.lopeta = lopeta;
        this.aS = aS;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(aloita)) {
            try {
                syntikka.aloita();
                aS.start();
            } catch (InterruptedException ex) {
                Logger.getLogger(ButtonKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource().equals(lopeta)) {
            syntikka.lopeta();
            aS.stop();
        }
    }

}
