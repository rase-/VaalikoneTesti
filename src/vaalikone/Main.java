/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vaalikone;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.FileNotFoundException;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author tonykovanen
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Ehdokasvalitsin eValitsin = new Ehdokasvalitsin();
        eValitsin.alustaTiedostosta("ehdokkaat.txt");

        HashMap<String, Double> mielipiteet = new HashMap<String, Double>();
        mielipiteet.put("Perustulo", 0.5);
        mielipiteet.put("Eläkeikää korotettava", 0.7);
        Vaalikone vaalikone = new Vaalikone(eValitsin);
    }
}
