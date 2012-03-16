/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vaalikone;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author tonykovanen
 */
public class Vaalikone extends JFrame implements ActionListener {
    private Valitsin valitsin;
    private JLabel ehdokas;
    private Ehdokasvalitsin logiikka;
    private ArrayList<Valitsin> valitsimet = new ArrayList<Valitsin>();
    private Ehdokas malliehdokas;
    private ArrayList<Ehdokas> ehdokkaat = new ArrayList<Ehdokas>();

    public Vaalikone(Ehdokasvalitsin eValitsin) {
        super("Vaalikone");


        logiikka = eValitsin;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ehdokas = new JLabel("----");
        JButton nappula = new JButton("Anna ehdokas");
        nappula.addActionListener(this);
        // Konstruktorissa pitää asettaa käytössä oleva säiliö BoxLayoutille:
        Container pane = getContentPane();
        BoxLayout boxlayout = new BoxLayout(pane, BoxLayout.Y_AXIS);
        pane.setLayout(boxlayout);

        // Lisättäessä objekteja ne voidaan tasata seuraavasti
        ehdokas.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(ehdokas);
        ehdokkaat = logiikka.getEhdokaslista();
        int koko = ehdokkaat.size();
        int asd = ehdokkaat.get(0).mielipiteetKoko();
        for (int i = 0; i < ehdokkaat.get(0).mielipiteetKoko(); i++) {
            Valitsin temp = new Valitsin(ehdokkaat.get(0).getAvain(i));
            temp.setAlignmentX(Component.CENTER_ALIGNMENT);
            pane.add(temp);
            valitsimet.add(temp);
        }
        nappula.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(nappula);
        pack();

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        ehdokas.setText(palautettavaEhdokas());
    }
    public String palautettavaEhdokas() {
        String mielipide = "";
        double arvo = 0.0;
        HashMap<String, Double> valitsinArvot = new HashMap<String, Double>();
        for (int i = 0; i < valitsimet.size(); i++) {
            mielipide = valitsimet.get(i).mielipide();
            arvo = valitsimet.get(i).arvo();
            valitsinArvot.put(mielipide, arvo);
        }
        String palautettava = "";
        return logiikka.annaEhdokas(valitsinArvot).getNimi();
    }
}

