package lesktimo.oskillaattori.gui.kuuntelijat;

import com.jsyn.unitgen.UnitOscillator;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * VoimakkuusSliderKuuntelija muuttaa oskillaattoreiden voimakkuuksia
 * muokkausvalikossa (GUI).
 *
 */
public class VoimakkuusSliderKuuntelija implements ChangeListener {

    double muutos;
    int oskillaattorinNumero;
    JLabel voimakkuusTeksti;
    JSlider slider;
    UnitOscillator osk;

    public VoimakkuusSliderKuuntelija(int oskillaattorinNumero, JLabel voimakkuusTeksti, JSlider slider, UnitOscillator osk) {
        this.muutos = 0;
        this.oskillaattorinNumero = oskillaattorinNumero;
        this.voimakkuusTeksti = voimakkuusTeksti;
        this.slider = slider;
        this.osk = osk;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        muutos = slider.getValue();
        osk.amplitude.set(muutos / 100);
        voimakkuusTeksti.setText(oskillaattorinNumero + " Oskillaattorin Voimakkuus: " + muutos);
    }
}
