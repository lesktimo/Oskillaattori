package lesktimo.oskillaattori.gui;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import lesktimo.oskillaattori.aani.Syntetisaattori;
import lesktimo.oskillaattori.gui.kuuntelijat.SoitaKuuntelija;
import lesktimo.oskillaattori.gui.kuuntelijat.TempoKuuntelija;
import lesktimo.oskillaattori.gui.kuuntelijat.TyhjennaKuuntelija;

/**
 *
 * @author lesktimo
 */
public class SyotePaneeli extends javax.swing.JPanel {

    private JLabel tempoTeksti;
    private JTextField syote;
    private JSpinner tempoKentta;
    private JProgressBar soitonSeuranta;
    private JButton soittoNappi;
    private JButton tyhjennaNappi;
    private Syntetisaattori syntikka;

    public SyotePaneeli(Syntetisaattori s) {
        this.syntikka = s;
        luoKomponentit();
    }

    private void luoKomponentit() {

        syote = new JTextField();
        soittoNappi = new JButton();
        tyhjennaNappi = new JButton();
        SpinnerNumberModel malli = new SpinnerNumberModel(120, 1, 999, 1);
        tempoKentta = new JSpinner(malli);
        tempoTeksti = new JLabel();
        soitonSeuranta = new JProgressBar();

        syote.setText("Paina ensin tyhjennä ja kirjoita sitten tähän nuotteja ja niiden pituuksia");

        soittoNappi.setText("Soita");
        tyhjennaNappi.setText("Tyhjennä");

        TempoKuuntelija tempK = new TempoKuuntelija(syntikka.getTempo(), tempoKentta);
        tempoKentta.addChangeListener(tempK);
        
        TyhjennaKuuntelija tyhjK = new TyhjennaKuuntelija(syote);
        tyhjennaNappi.addActionListener(tyhjK);
        
        SoitaKuuntelija soitaK = new SoitaKuuntelija(syntikka.getLukija(), syote, soittoNappi);
        soittoNappi.addActionListener(soitaK);

        tempoTeksti.setText("Tempo:");

        javax.swing.GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(syote, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(tempoTeksti)
                        .addGap(0, 0, 0)
                        .addComponent(tempoKentta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(soitonSeuranta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(soittoNappi, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tyhjennaNappi, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(syote, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(tempoKentta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tempoTeksti)
                                        .addComponent(soitonSeuranta, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(soittoNappi)
                                        .addComponent(tyhjennaNappi)))
                        .addContainerGap())
        );
    }
}
