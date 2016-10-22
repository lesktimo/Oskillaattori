package lesktimo.oskillaattori.gui;

import com.jsyn.instruments.SubtractiveSynthVoice;
import com.jsyn.scope.AudioScope;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import lesktimo.oskillaattori.aani.apu.Nuotti;
import lesktimo.oskillaattori.aani.Syntetisaattori;
import lesktimo.oskillaattori.gui.kuuntelijat.KosketinKuuntelija;

/**
 * Tämä paneeli sisältää koskettimiston, ja niiden kuuntelijat.
 */
public class SoitinPaneeli extends javax.swing.JPanel {

    private final Syntetisaattori syntikka;
    private JButton a4, a5, aSharp4, aSharp5, b4, b5, c4, c5, cSharp4, cSharp5,
            d4, d5, dSharp4, dSharp5, e4, e5, f4, f5, fSharp4, fSharp5, g4, g5,
            gSharp4, gSharp5;
    private AudioScope aS;
    private JPanel paneeli;
    private JSeparator valiviiva;
    private JSlider pitchBendSlider;
    private final Dimension valkoiset;
    private final Dimension mustat;
    private SubtractiveSynthVoice[] voices;
    private JTextArea ohjeet;
    private Color tumma;
    private Color vaalea;
    private SyotePaneeli sP;

    /**
     * Alustaa SoitinPaneelin.
     *
     * @param syntikka Käytössä oleva syntetisaattori.
     * @param nakyma Waveform-näkymä.
     */
    public SoitinPaneeli(Syntetisaattori syntikka, AudioScope nakyma) {
        this.syntikka = syntikka;
        this.aS = nakyma;
        valkoiset = new Dimension(55, 110);
        mustat = new Dimension(65, 90);
        tumma = new Color(46, 46, 46);
        vaalea = new Color(205, 205, 205);
        initComponents();
        lisaaKuuntelijat(c4, cSharp4, d4, dSharp4, e4, f4, fSharp4, g4, gSharp4,
                a4, aSharp4, b4, c5, cSharp5, d5, dSharp5, e5, f5, fSharp5, g5,
                gSharp5, a5, aSharp5, b5, aS);

    }

    private void initComponents() {

        paneeli = new JPanel();
        valiviiva = new JSeparator();

        ohjeet = new JTextArea();
        ohjeet.setText("Voit soittaa syntetisaattoria alla olevalla koskettimistolla tai kirjoittaa tekstikenttään"
                + "\n" + "nuotteja ja niiden pituuksia kaksoispisteellä erotettuina, ja eri nuotit pilkuilla erotettuina, "
                + "\n" + "esim. 'C4 : 1/4, DSharp4 : 1/8, F5:1/4'."
                + "\n" + "Käytettävissä on kaikki nuotit C4-B5, ja pituudet kokonuotista 1/32 nuottiin."
                + "\n" + "Välilyönneillä tai kirjainkoolla ei ole merkitystä, kunhan nuotin ja sen pituuden välissä on kaksoispiste (:),"
                + "\n" + "ja eri nuottien välissä pilkku (,). 'Soita' -nappi soittaa kirjoitetut nuotit kerran ja 'tyhjennä' -nappi tyhjentää kentän.");
        ohjeet.disable();
        ohjeet.setDisabledTextColor(tumma);

        c5 = new JButton();
        cSharp5 = new JButton();
        d5 = new JButton();
        dSharp5 = new JButton();
        e5 = new JButton();
        f5 = new JButton();
        fSharp5 = new JButton();
        g5 = new JButton();
        gSharp5 = new JButton();
        a5 = new JButton();
        aSharp5 = new JButton();
        b5 = new JButton();

        c4 = new JButton();
        cSharp4 = new JButton();
        d4 = new JButton();
        dSharp4 = new JButton();
        e4 = new JButton();
        f4 = new JButton();
        fSharp4 = new JButton();
        g4 = new JButton();
        gSharp4 = new JButton();
        a4 = new JButton();
        aSharp4 = new JButton();
        b4 = new JButton();

        pitchBendSlider = new JSlider();
        sP = new SyotePaneeli(syntikka);

        c5.setText("C5");
        c5.setMaximumSize(valkoiset);
        c5.setMinimumSize(valkoiset);
        c5.setPreferredSize(valkoiset);
        c5.setVerticalTextPosition(SwingConstants.TOP);

        cSharp5.setBackground(tumma);
        cSharp5.setForeground(vaalea);
        cSharp5.setText("C#5");
        cSharp5.setMaximumSize(mustat);
        cSharp5.setMinimumSize(mustat);
        cSharp5.setPreferredSize(mustat);
        cSharp5.setVerticalTextPosition(SwingConstants.TOP);

        d5.setText("D5");
        d5.setMaximumSize(valkoiset);
        d5.setMinimumSize(valkoiset);
        d5.setPreferredSize(valkoiset);
        d5.setVerticalTextPosition(SwingConstants.TOP);

        dSharp5.setBackground(tumma);
        dSharp5.setForeground(vaalea);
        dSharp5.setText("D#5");
        dSharp5.setMaximumSize(mustat);
        dSharp5.setMinimumSize(mustat);
        dSharp5.setPreferredSize(mustat);
        dSharp5.setVerticalTextPosition(SwingConstants.TOP);

        e5.setText("E5");
        e5.setMaximumSize(valkoiset);
        e5.setMinimumSize(valkoiset);
        e5.setPreferredSize(valkoiset);
        e5.setVerticalTextPosition(SwingConstants.TOP);

        f5.setText("F5");
        f5.setMaximumSize(valkoiset);
        f5.setMinimumSize(valkoiset);
        f5.setPreferredSize(valkoiset);
        f5.setVerticalTextPosition(SwingConstants.TOP);

        fSharp5.setBackground(tumma);
        fSharp5.setForeground(vaalea);
        fSharp5.setText("F#5");
        fSharp5.setMaximumSize(mustat);
        fSharp5.setMinimumSize(mustat);
        fSharp5.setPreferredSize(mustat);
        fSharp5.setVerticalTextPosition(SwingConstants.TOP);

        g5.setText("G5");
        g5.setMaximumSize(valkoiset);
        g5.setMinimumSize(valkoiset);
        g5.setPreferredSize(valkoiset);
        g5.setVerticalTextPosition(SwingConstants.TOP);

        gSharp5.setBackground(tumma);
        gSharp5.setForeground(vaalea);
        gSharp5.setText("G#5");
        gSharp5.setMaximumSize(mustat);
        gSharp5.setMinimumSize(mustat);
        gSharp5.setPreferredSize(mustat);
        gSharp5.setVerticalTextPosition(SwingConstants.TOP);

        a5.setText("A5");
        a5.setMaximumSize(valkoiset);
        a5.setMinimumSize(valkoiset);
        a5.setPreferredSize(valkoiset);
        a5.setVerticalTextPosition(SwingConstants.TOP);

        aSharp5.setBackground(tumma);
        aSharp5.setForeground(vaalea);
        aSharp5.setText("A#5");
        aSharp5.setMaximumSize(mustat);
        aSharp5.setMinimumSize(mustat);
        aSharp5.setPreferredSize(mustat);
        aSharp5.setVerticalTextPosition(SwingConstants.TOP);

        b5.setText("B5");
        b5.setMaximumSize(valkoiset);
        b5.setMinimumSize(valkoiset);
        b5.setPreferredSize(valkoiset);
        b5.setVerticalTextPosition(SwingConstants.TOP);

        gSharp4.setBackground(tumma);
        gSharp4.setForeground(vaalea);
        gSharp4.setText("G#4");
        gSharp4.setMaximumSize(mustat);
        gSharp4.setMinimumSize(mustat);
        gSharp4.setPreferredSize(mustat);
        gSharp4.setVerticalTextPosition(SwingConstants.TOP);

        a4.setText("A4");
        a4.setMaximumSize(valkoiset);
        a4.setMinimumSize(valkoiset);
        a4.setPreferredSize(valkoiset);
        a4.setVerticalTextPosition(SwingConstants.TOP);

        aSharp4.setBackground(tumma);
        aSharp4.setForeground(vaalea);
        aSharp4.setText("A#4");
        aSharp4.setMaximumSize(mustat);
        aSharp4.setMinimumSize(mustat);
        aSharp4.setPreferredSize(mustat);
        aSharp4.setVerticalTextPosition(SwingConstants.TOP);

        b4.setText("B4");
        b4.setMaximumSize(valkoiset);
        b4.setMinimumSize(valkoiset);
        b4.setPreferredSize(valkoiset);
        b4.setVerticalTextPosition(SwingConstants.TOP);

        f4.setText("F4");
        f4.setMaximumSize(valkoiset);
        f4.setMinimumSize(valkoiset);
        f4.setPreferredSize(valkoiset);
        f4.setVerticalTextPosition(SwingConstants.TOP);

        c4.setText("C4");
        c4.setMaximumSize(valkoiset);
        c4.setMinimumSize(valkoiset);
        c4.setPreferredSize(valkoiset);
        c4.setVerticalTextPosition(SwingConstants.TOP);

        cSharp4.setBackground(tumma);
        cSharp4.setForeground(vaalea);
        cSharp4.setText("C#4");
        cSharp4.setMaximumSize(mustat);
        cSharp4.setMinimumSize(mustat);
        cSharp4.setPreferredSize(mustat);
        cSharp4.setVerticalTextPosition(SwingConstants.TOP);

        d4.setText("D4");
        d4.setMaximumSize(valkoiset);
        d4.setMinimumSize(valkoiset);
        d4.setPreferredSize(valkoiset);
        d4.setVerticalTextPosition(SwingConstants.TOP);

        dSharp4.setBackground(tumma);
        dSharp4.setForeground(vaalea);
        dSharp4.setText("D#4");
        dSharp4.setMaximumSize(mustat);
        dSharp4.setMinimumSize(mustat);
        dSharp4.setPreferredSize(mustat);
        dSharp4.setVerticalTextPosition(SwingConstants.TOP);

        e4.setText("E4");
        e4.setMaximumSize(valkoiset);
        e4.setMinimumSize(valkoiset);
        e4.setPreferredSize(valkoiset);
        e4.setVerticalTextPosition(SwingConstants.TOP);

        fSharp4.setBackground(tumma);
        fSharp4.setForeground(vaalea);
        fSharp4.setText("F#4");
        fSharp4.setMaximumSize(mustat);
        fSharp4.setMinimumSize(mustat);
        fSharp4.setPreferredSize(mustat);
        fSharp4.setVerticalTextPosition(SwingConstants.TOP);

        g4.setText("G4");
        g4.setMaximumSize(valkoiset);
        g4.setMinimumSize(valkoiset);
        g4.setPreferredSize(valkoiset);
        g4.setVerticalTextPosition(SwingConstants.TOP);

        pitchBendSlider.setOrientation(JSlider.VERTICAL);

        GroupLayout jPanel1Layout = new GroupLayout(paneeli);
        paneeli.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(valiviiva)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pitchBendSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(sP, GroupLayout.PREFERRED_SIZE, 786, GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(c5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cSharp5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(d5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dSharp5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(e5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(f5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fSharp5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(g5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(gSharp5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(a5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(aSharp5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(b5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(c4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cSharp4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(d4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dSharp4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(e4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(f4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fSharp4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(g4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(gSharp4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(a4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(aSharp4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(b4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(valiviiva, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(pitchBendSlider, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(66, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(c5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(d5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(e5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(f5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(g5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(a5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(b5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addComponent(cSharp5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(dSharp5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(fSharp5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(gSharp5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(aSharp5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(c4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(d4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(e4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(f4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(g4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(a4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(b4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addComponent(cSharp4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(dSharp4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(gSharp4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(aSharp4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(fSharp4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sP, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(ohjeet)
                .addComponent(paneeli, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ohjeet)
                        .addContainerGap(271, Short.MAX_VALUE)
                        .addComponent(paneeli, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );
    }

    private void lisaaKuuntelijat(JButton c4, JButton cSharp4, JButton d4, JButton dSharp4, JButton e4,
            JButton f4, JButton fSharp4, JButton g4, JButton gSharp4, JButton a4, JButton aSharp4, JButton b4,
            JButton c5, JButton cSharp5, JButton d5, JButton dSharp5, JButton e5, JButton f5, JButton fSharp5,
            JButton g5, JButton gSharp5, JButton a5, JButton aSharp5, JButton b5, AudioScope aS) {
        c4.addActionListener(new KosketinKuuntelija(c4, syntikka, Nuotti.C4, aS));
        cSharp4.addActionListener(new KosketinKuuntelija(cSharp4, syntikka, Nuotti.CSHARP4, aS));
        d4.addActionListener(new KosketinKuuntelija(d4, syntikka, Nuotti.D4, aS));
        dSharp4.addActionListener(new KosketinKuuntelija(dSharp4, syntikka, Nuotti.DSHARP4, aS));
        e4.addActionListener(new KosketinKuuntelija(e4, syntikka, Nuotti.E4, aS));
        f4.addActionListener(new KosketinKuuntelija(f4, syntikka, Nuotti.F4, aS));
        fSharp4.addActionListener(new KosketinKuuntelija(fSharp4, syntikka, Nuotti.FSHARP4, aS));
        g4.addActionListener(new KosketinKuuntelija(g4, syntikka, Nuotti.G4, aS));
        gSharp4.addActionListener(new KosketinKuuntelija(gSharp4, syntikka, Nuotti.GSHARP4, aS));
        a4.addActionListener(new KosketinKuuntelija(a4, syntikka, Nuotti.A4, aS));
        aSharp4.addActionListener(new KosketinKuuntelija(aSharp4, syntikka, Nuotti.ASHARP4, aS));
        b4.addActionListener(new KosketinKuuntelija(b4, syntikka, Nuotti.B4, aS));
        c5.addActionListener(new KosketinKuuntelija(c5, syntikka, Nuotti.C5, aS));
        cSharp5.addActionListener(new KosketinKuuntelija(cSharp5, syntikka, Nuotti.CSHARP5, aS));
        d5.addActionListener(new KosketinKuuntelija(d5, syntikka, Nuotti.D5, aS));
        dSharp5.addActionListener(new KosketinKuuntelija(dSharp5, syntikka, Nuotti.DSHARP5, aS));
        e5.addActionListener(new KosketinKuuntelija(e5, syntikka, Nuotti.E5, aS));
        f5.addActionListener(new KosketinKuuntelija(f5, syntikka, Nuotti.F5, aS));
        fSharp5.addActionListener(new KosketinKuuntelija(fSharp5, syntikka, Nuotti.FSHARP5, aS));
        g5.addActionListener(new KosketinKuuntelija(g5, syntikka, Nuotti.G5, aS));
        gSharp5.addActionListener(new KosketinKuuntelija(gSharp5, syntikka, Nuotti.GSHARP5, aS));
        a5.addActionListener(new KosketinKuuntelija(a5, syntikka, Nuotti.A5, aS));
        aSharp5.addActionListener(new KosketinKuuntelija(aSharp5, syntikka, Nuotti.ASHARP5, aS));
        b5.addActionListener(new KosketinKuuntelija(b5, syntikka, Nuotti.B5, aS));
    }
}
