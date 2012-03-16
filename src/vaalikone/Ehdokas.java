/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vaalikone;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author tonykova
 */
public class Ehdokas {
    private String ehdokas;
    private HashMap<String, Double> mielipiteet;
    private ArrayList<String> avaimet;

    public Ehdokas(String ehdokas) {
        this.ehdokas = ehdokas;
        mielipiteet = new HashMap<String, Double>();
        avaimet = new ArrayList<String>();
    }
    public void lisaaMielipide(String mielipide, double arvo) {
        mielipiteet.put(mielipide, arvo);
        avaimet.add(mielipide);
    }
    public String toString() {
        String stringina = "";
        for (int i = 0; i < avaimet.size(); i++) {
            stringina += avaimet.get(i) + ": " + mielipiteet.get(avaimet.get(i)) + "\n";
        }
        return ehdokas + "\n" + stringina;
    }
    public double getMielipide(String i) {
        return mielipiteet.get(i);
    }
    public int mielipiteetKoko() {
        return mielipiteet.size();
    }
    public String getAvain(int i) {
        return avaimet.get(i);
    }
    public String getNimi() {
        return ehdokas;
    }
}
