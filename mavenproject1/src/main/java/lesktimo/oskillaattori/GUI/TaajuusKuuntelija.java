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
public class TaajuusKuuntelija implements ChangeListener {

    private Syntetisaattori syntikka;
    private JSlider muokkattava;
//    ObservableValue muutos;

    public TaajuusKuuntelija(Syntetisaattori syntikka, JSlider muutos) {
        this.syntikka = syntikka;
        this.muokkattava = muutos;

    }

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}
