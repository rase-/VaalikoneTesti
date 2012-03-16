/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vaalikone;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author tonykovanen
 */
public class Ehdokasvalitsin {

    private ArrayList<Ehdokas> ehdokaslista = new ArrayList<Ehdokas>();
    private static String[] ehdokkaat = {};
    

    public String annaEhdokas(double arvo) {
        int ehdokas = (int) (Math.random() * ehdokkaat.length);
        return ehdokkaat[ehdokas] + " " + arvo;
    }

    public void lisaaEhdokas(Ehdokas e) {
        ehdokaslista.add(e);
    }

    public Ehdokas annaEhdokas(HashMap<String, Double> hashmap) {
        double arvo = 0;
        double edellinenArvo = 1000;
        int indeksi = 0;
        int asd = ehdokaslista.size();
        for (int i = 0; i < ehdokaslista.size(); i++) {
            arvo = 0;
            for (int j = 0; j < ehdokaslista.get(i).mielipiteetKoko(); j++) {
                String avain = ehdokaslista.get(i).getAvain(j);
                arvo += Math.abs(hashmap.get(avain) - ehdokaslista.get(i).getMielipide(avain));
            }
            if (arvo < edellinenArvo) {
                indeksi = i;
                edellinenArvo = arvo;
            }
        }
        return ehdokaslista.get(indeksi);
    }

    public int getEhdokasmaara() {
        return ehdokaslista.size();
    }

    public ArrayList<Ehdokas> getEhdokaslista() {
        return ehdokaslista;
    }

    public void alustaTiedostosta(String tiedostonNimi) throws FileNotFoundException {
        Scanner lukija = new Scanner(new File(tiedostonNimi));
        int i = 0;
        while (lukija.hasNextLine()) {
            String nimi = lukija.nextLine();
            if (nimi.equals("")) {
                break;
            }
            ehdokaslista.add(new Ehdokas(nimi));
            while (lukija.hasNextLine()) {
                String mielipide = lukija.nextLine();
                if (mielipide.equals("")) {
                    break;
                }
                double arvo = Double.parseDouble(lukija.nextLine());
                ehdokaslista.get(i).lisaaMielipide(mielipide, arvo);
            }
                    i++;
        }
    }
    public TreeSet<String> mielipiteet() {
        TreeSet<String> mielipidelista = new TreeSet<String>();
        for (int i = 0; i < ehdokaslista.size(); i++) {
            for (int j = 0; j < ehdokaslista.get(i).mielipiteetKoko(); j++) {
                mielipidelista.add(ehdokaslista.get(i).getAvain(j));
            }
        }
        return mielipidelista;
    }
}

