/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesktimo.oskillaattori.gui.kuuntelijat;

import com.jsyn.scope.AudioScope;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.JButton;

import lesktimo.oskillaattori.aani.Nuotti;
import lesktimo.oskillaattori.aani.Syntetisaattori;

/**
 *
 * @author lesktimo
 */
public class KosketinKuuntelija implements ActionListener {

    private final ButtonModel malli;
    private final Syntetisaattori syntikka;
    private final Nuotti n;
    private final AudioScope aS;

    public KosketinKuuntelija(JButton kosketin, Syntetisaattori syntikka, Nuotti n, AudioScope aS) {
        this.syntikka = syntikka;
        this.n = n;
        malli = kosketin.getModel();
        this.aS = aS;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            syntikka.aloita();
            aS.start();
        } catch (InterruptedException ex) {
            Logger.getLogger(KosketinKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (malli.isPressed()) {
            syntikka.noteOn(n.getI(), 100);

        }
        syntikka.noteOff(n.getI(), 100);

        syntikka.lopeta();
        aS.stop();
    }
}
