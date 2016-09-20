/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesktimo.oskillaattori.GUI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javax.swing.JSlider;
import lesktimo.oskillaattori.aani.Syntetisaattori;

/**
 *
 * @author lesktimo
 */
public class VoimakkuusKuuntelija implements ChangeListener {

    private Syntetisaattori syntikka;
    private JSlider muokattava;

    public VoimakkuusKuuntelija(Syntetisaattori syntikka, JSlider muutos) {
        this.syntikka = syntikka;
        this.muokattava = muutos;

    }

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        double muutos = (double) newValue / 100;
        syntikka.getOsk1().setVoimakkuus(muutos);
    }

}
