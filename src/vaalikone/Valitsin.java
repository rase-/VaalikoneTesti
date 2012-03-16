/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vaalikone;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Valitsin extends JPanel {
    private static Scanner lukija = new Scanner(System.in);
    private String mielipide;
    private JSlider slider;
    private JLabel label;

    /* Konstruktori luo JSliderin sekä JLabelin ja asettelee ne perittyyn JPaneliin. */
    public Valitsin(String viesti) {
        super(new BorderLayout());
        slider = new JSlider();
        label = new JLabel(viesti);

        add(slider, BorderLayout.NORTH);
        add(label, BorderLayout.SOUTH);

        mielipide = viesti;

    }

    /* Metodi palauttaa JSliderin arvon normalisoituna se välille 0..1. */
    public double arvo() {
        return slider.getValue()/100.0;
    }
    public String kysyMielipiteet() {
        System.out.println("Mielipide: ");
        String mielipide = lukija.nextLine();
        this.mielipide = mielipide;
        return this.mielipide;
}
    public String mielipide() {
        return mielipide;
    }
}