/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesktimo.oskillaattori.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author lesktimo
 */
public class TyhjennaKuuntelija implements ActionListener {
    
    JTextField syoteKentta;
    
    public TyhjennaKuuntelija(JTextField syoteKentta) {
        this.syoteKentta = syoteKentta;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        syoteKentta.setText("");
    }
    
}
