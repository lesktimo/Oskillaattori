/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesktimo.oskillaattori.gui.kuuntelijat;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import lesktimo.oskillaattori.aani.apu.Tempo;

/**
 *
 * @author lesktimo
 */
public class TempoKuuntelija implements ChangeListener {

    private Tempo tempo;
    private JSpinner tempoKentta;

    public TempoKuuntelija(Tempo tempo, JSpinner tempoKentta) {
        this.tempo = tempo;
        this.tempoKentta = tempoKentta;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int muutos = (int) tempoKentta.getValue();
        tempo.setTempo(muutos);
    }
}
