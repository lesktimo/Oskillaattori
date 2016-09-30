package lesktimo.oskillaattori.gui.kuuntelijat;

import com.jsyn.unitgen.UnitOscillator;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * TaajuusSliderKuuntelija muuttaa oskillaattoreiden taajuuksia
 * muokkausvalikossa (GUI).
 *
 */
public class TaajuusSliderKuuntelija implements ChangeListener {

    double muutos;
    int oskillaattorinNumero;
    JLabel taajuusTeksti;
    JSlider slider;
    UnitOscillator osk;

    public TaajuusSliderKuuntelija(int oskillaattorinNumero, JLabel taajuusTeksti, JSlider slider, UnitOscillator osk) {
        this.muutos = 0;
        this.oskillaattorinNumero = oskillaattorinNumero;
        this.taajuusTeksti = taajuusTeksti;
        this.slider = slider;
        this.osk = osk;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        muutos = slider.getValue() / 100;
        osk.frequency.set(muutos);
        taajuusTeksti.setText(oskillaattorinNumero + " Oskillaattorin Taajuus: " + muutos + " Hz");
    }
}
