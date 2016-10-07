package lesktimo.oskillaattori.gui;

import com.jsyn.scope.AudioScope;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import lesktimo.oskillaattori.aani.Nuotti;
import lesktimo.oskillaattori.aani.Syntetisaattori;
import lesktimo.oskillaattori.gui.kuuntelijat.KosketinKuuntelija;

/**
 * Tämä paneeli sisältää koskettimiston, ja niiden kuuntelijat.
 */
public class SoitinPaneeli extends javax.swing.JPanel {

    private final Syntetisaattori syntikka;
    private JButton a4;
    private JButton a5;
    private JButton aSharp4;
    private JButton aSharp5;
    private JButton b4;
    private JButton b5;
    private JButton c4;
    private JButton c5;
    private JButton cSharp4;
    private JButton cSharp5;
    private JButton d4;
    private JButton d5;
    private JButton dSharp4;
    private JButton dSharp5;
    private JButton e4;
    private JButton e5;
    private JButton f4;
    private JButton f5;
    private JButton fSharp4;
    private JButton fSharp5;
    private JButton g4;
    private JButton g5;
    private JButton gSharp4;
    private JButton gSharp5;
    private AudioScope aS;
    private JPanel paneeli;
    private JPanel scopePaneeli;
    private JSeparator valiviiva;
    private JSlider pitchBendSlider;
    private final Dimension valkoiset;
    private final Dimension mustat;

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
        initComponents();
        lisaaKuuntelijat(c4, cSharp4, d4, dSharp4, e4, f4, fSharp4, g4, gSharp4, a4, aSharp4, b4, c5, cSharp5, d5, dSharp5, e5, f5, fSharp5, g5, gSharp5, a5, aSharp5, b5);
    }

    private void initComponents() {

        paneeli = new JPanel();
        valiviiva = new JSeparator();

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
        scopePaneeli = new JPanel();

        c5.setText("C5");
        c5.setMaximumSize(valkoiset);
        c5.setMinimumSize(valkoiset);
        c5.setPreferredSize(valkoiset);
        c5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        cSharp5.setBackground(new java.awt.Color(46, 46, 46));
        cSharp5.setForeground(new java.awt.Color(205, 205, 205));
        cSharp5.setText("C#5");
        cSharp5.setMaximumSize(mustat);
        cSharp5.setMinimumSize(mustat);
        cSharp5.setPreferredSize(mustat);
        cSharp5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        d5.setText("D5");
        d5.setMaximumSize(valkoiset);
        d5.setMinimumSize(valkoiset);
        d5.setPreferredSize(valkoiset);
        d5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        dSharp5.setBackground(new java.awt.Color(46, 46, 46));
        dSharp5.setForeground(new java.awt.Color(205, 205, 205));
        dSharp5.setText("D#5");
        dSharp5.setMaximumSize(mustat);
        dSharp5.setMinimumSize(mustat);
        dSharp5.setPreferredSize(mustat);
        dSharp5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        e5.setText("E5");
        e5.setMaximumSize(valkoiset);
        e5.setMinimumSize(valkoiset);
        e5.setPreferredSize(valkoiset);
        e5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        f5.setText("F5");
        f5.setMaximumSize(valkoiset);
        f5.setMinimumSize(valkoiset);
        f5.setPreferredSize(valkoiset);
        f5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        fSharp5.setBackground(new java.awt.Color(46, 46, 46));
        fSharp5.setForeground(new java.awt.Color(205, 205, 205));
        fSharp5.setText("F#5");
        fSharp5.setMaximumSize(mustat);
        fSharp5.setMinimumSize(mustat);
        fSharp5.setPreferredSize(mustat);
        fSharp5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        g5.setText("G5");
        g5.setMaximumSize(valkoiset);
        g5.setMinimumSize(valkoiset);
        g5.setPreferredSize(valkoiset);
        g5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        gSharp5.setBackground(new java.awt.Color(46, 46, 46));
        gSharp5.setForeground(new java.awt.Color(205, 205, 205));
        gSharp5.setText("G#5");
        gSharp5.setMaximumSize(mustat);
        gSharp5.setMinimumSize(mustat);
        gSharp5.setPreferredSize(mustat);
        gSharp5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        a5.setText("A5");
        a5.setMaximumSize(valkoiset);
        a5.setMinimumSize(valkoiset);
        a5.setPreferredSize(valkoiset);
        a5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        aSharp5.setBackground(new java.awt.Color(46, 46, 46));
        aSharp5.setForeground(new java.awt.Color(205, 205, 205));
        aSharp5.setText("A#5");
        aSharp5.setMaximumSize(mustat);
        aSharp5.setMinimumSize(mustat);
        aSharp5.setPreferredSize(mustat);
        aSharp5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        b5.setText("B5");
        b5.setMaximumSize(valkoiset);
        b5.setMinimumSize(valkoiset);
        b5.setPreferredSize(valkoiset);
        b5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        gSharp4.setBackground(new java.awt.Color(46, 46, 46));
        gSharp4.setForeground(new java.awt.Color(205, 205, 205));
        gSharp4.setText("G#4");
        gSharp4.setMaximumSize(mustat);
        gSharp4.setMinimumSize(mustat);
        gSharp4.setPreferredSize(mustat);
        gSharp4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        a4.setText("A4");
        a4.setMaximumSize(valkoiset);
        a4.setMinimumSize(valkoiset);
        a4.setPreferredSize(valkoiset);
        a4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        aSharp4.setBackground(new java.awt.Color(46, 46, 46));
        aSharp4.setForeground(new java.awt.Color(205, 205, 205));
        aSharp4.setText("A#4");
        aSharp4.setMaximumSize(mustat);
        aSharp4.setMinimumSize(mustat);
        aSharp4.setPreferredSize(mustat);
        aSharp4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        b4.setText("B4");
        b4.setMaximumSize(valkoiset);
        b4.setMinimumSize(valkoiset);
        b4.setPreferredSize(valkoiset);
        b4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        f4.setText("F4");
        f4.setMaximumSize(valkoiset);
        f4.setMinimumSize(valkoiset);
        f4.setPreferredSize(valkoiset);
        f4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        c4.setText("C4");
        c4.setMaximumSize(valkoiset);
        c4.setMinimumSize(valkoiset);
        c4.setPreferredSize(valkoiset);
        c4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        cSharp4.setBackground(new java.awt.Color(46, 46, 46));
        cSharp4.setForeground(new java.awt.Color(205, 205, 205));
        cSharp4.setText("C#4");
        cSharp4.setMaximumSize(mustat);
        cSharp4.setMinimumSize(mustat);
        cSharp4.setPreferredSize(mustat);
        cSharp4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        d4.setText("D4");
        d4.setMaximumSize(valkoiset);
        d4.setMinimumSize(valkoiset);
        d4.setPreferredSize(valkoiset);
        d4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        dSharp4.setBackground(new java.awt.Color(46, 46, 46));
        dSharp4.setForeground(new java.awt.Color(205, 205, 205));
        dSharp4.setText("D#4");
        dSharp4.setMaximumSize(mustat);
        dSharp4.setMinimumSize(mustat);
        dSharp4.setPreferredSize(mustat);
        dSharp4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        e4.setText("E4");
        e4.setMaximumSize(valkoiset);
        e4.setMinimumSize(valkoiset);
        e4.setPreferredSize(valkoiset);
        e4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        fSharp4.setBackground(new java.awt.Color(46, 46, 46));
        fSharp4.setForeground(new java.awt.Color(205, 205, 205));
        fSharp4.setText("F#4");
        fSharp4.setMaximumSize(mustat);
        fSharp4.setMinimumSize(mustat);
        fSharp4.setPreferredSize(mustat);
        fSharp4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        g4.setText("G4");
        g4.setMaximumSize(valkoiset);
        g4.setMinimumSize(valkoiset);
        g4.setPreferredSize(valkoiset);
        g4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        pitchBendSlider.setOrientation(javax.swing.JSlider.VERTICAL);

        scopePaneeli.setBackground(new java.awt.Color(254, 254, 254));
        scopePaneeli.setPreferredSize(new java.awt.Dimension(55, 110));

        javax.swing.GroupLayout scopePaneeliLayout = new javax.swing.GroupLayout(scopePaneeli);
        scopePaneeli.setLayout(scopePaneeliLayout);
        scopePaneeli.add(aS.getView());
        scopePaneeliLayout.setHorizontalGroup(
                scopePaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 786, Short.MAX_VALUE)
        );
        scopePaneeliLayout.setVerticalGroup(
                scopePaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE)
        );
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(paneeli);
        paneeli.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(valiviiva)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pitchBendSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(scopePaneeli, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(c5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cSharp5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(d5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dSharp5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(e5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(f5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fSharp5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(g5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(gSharp5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(a5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(aSharp5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cSharp4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(d4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dSharp4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(e4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(f4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fSharp4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(g4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(gSharp4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(a4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(aSharp4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(valiviiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(pitchBendSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(66, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(c5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(d5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(e5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(f5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(g5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(a5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(cSharp5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(dSharp5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(fSharp5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(gSharp5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(aSharp5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(d4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(e4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(f4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(g4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(a4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(cSharp4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(dSharp4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(gSharp4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(aSharp4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(fSharp4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(scopePaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(paneeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(271, Short.MAX_VALUE)
                        .addComponent(paneeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );
    }

    private void lisaaKuuntelijat(JButton c4, JButton cSharp4, JButton d4, JButton dSharp4, JButton e4,
            JButton f4, JButton fSharp4, JButton g4, JButton gSharp4, JButton a4, JButton aSharp4, JButton b4,
            JButton c5, JButton cSharp5, JButton d5, JButton dSharp5, JButton e5, JButton f5, JButton fSharp5,
            JButton g5, JButton gSharp5, JButton a5, JButton aSharp5, JButton b5) {
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
