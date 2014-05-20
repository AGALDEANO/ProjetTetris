/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author p1106501
 */
public class Forme {

    private Vecteur<Integer>[] etat;
    private String nom;
    private final byte videChar = ' ';
    private final byte pleinChar = (byte) 0xDB;
    public static final int _I = 1;
    public static final int _O = 2;
    public static final int _T = 3;
    public static final int _L = 4;
    public static final int _J = 5;
    public static final int _Z = 6;
    public static final int _S = 7;

    //===========================================================
    public void rotCW() {
        // Rotations : (a;b) (b;-a) (-a;-b) (-b;a)
        for (int i = 0; i < etat.length; i++) {
            etat[i].setValue(etat[i].get(1), -etat[i].get(0));
        }
    }

    public void rotACW() {
        // Rotations : (a;b) (-b;a) (-a;-b) (b;-a)
        for (int i = 0; i < etat.length; i++) {
            etat[i].setValue(-etat[i].get(1), etat[i].get(0));
        }
    }

    public Vecteur<Integer>[] getPoints() {
        Vecteur<Integer>[] temp = new Vecteur[etat.length];
        for(int i = 0;i< etat.length;i++) temp[i] = new Vecteur(etat[i]);
        return temp;
    }

    public Vecteur<Integer> getPoints(int i) {
        return new Vecteur(etat[i]);
    }

    public void setPoints(Vecteur<Integer>[] value) {
        etat = value;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String value) {
        nom = value;
    }

    public Forme() {
    }

    public Forme(Forme copy) {
        etat = copy.getPoints();
        nom = copy.getNom();

    }

    public Forme(ArrayList<Vecteur> values) {
        int taille = values.size();
        etat = new Vecteur[taille];
        for (int i = 0; i < taille; i++) {
            etat[i] = values.get(i);
        }
    }

    public Forme(String nomValue, ArrayList<Vecteur> values) {
        int taille = values.size();
        etat = new Vecteur[taille];
        for (int i = 0; i < taille; i++) {
            etat[i] = values.get(i);
        }
        nom = nomValue;
    }

    public static Forme Forme(int i) {
        switch (i) {
            case _T:
                return Forme.T();
            case _L:
                return Forme.L();
            case _J:
                return Forme.J();
            case _S:
                return Forme.S();
            case _Z:
                return Forme.Z();
            case _I:
                return Forme.I();
            case _O:
                return Forme.O();
            default:
                return Forme.O();
        }
    }

    public static Forme T() {
        ArrayList<Vecteur> liste = new ArrayList<>();
        liste.add(new Vecteur(1, 0));
        liste.add(new Vecteur(1, 1));
        liste.add(new Vecteur(1, 2));
        liste.add(new Vecteur(0, 1));

        return new Forme("T", liste);
    }

    public static Forme I() {
        ArrayList<Vecteur> liste = new ArrayList<>();
        liste.add(new Vecteur(0, 0));
        liste.add(new Vecteur(0, 1));
        liste.add(new Vecteur(0, 2));
        liste.add(new Vecteur(0, 3));

        return new Forme("I", liste);
    }

    public static Forme L() {
        ArrayList<Vecteur> liste = new ArrayList<>();
        liste.add(new Vecteur(1, 0));
        liste.add(new Vecteur(1, 1));
        liste.add(new Vecteur(1, 2));
        liste.add(new Vecteur(0, 2));

        return new Forme("L", liste);
    }

    public static Forme J() {
        ArrayList<Vecteur> liste = new ArrayList<>();
        liste.add(new Vecteur(1, 0));
        liste.add(new Vecteur(1, 1));
        liste.add(new Vecteur(1, 2));
        liste.add(new Vecteur(0, 0));

        return new Forme("J", liste);
    }

    public static Forme O() {
        ArrayList<Vecteur> liste = new ArrayList<>();
        liste.add(new Vecteur(0, 0));
        liste.add(new Vecteur(0, 1));
        liste.add(new Vecteur(1, 0));
        liste.add(new Vecteur(1, 1));

        return new Forme("O", liste);
    }

    public static Forme S() {
        ArrayList<Vecteur> liste = new ArrayList<>();
        liste.add(new Vecteur(1, 0));
        liste.add(new Vecteur(1, 1));
        liste.add(new Vecteur(0, 1));
        liste.add(new Vecteur(0, 2));

        return new Forme("S", liste);
    }

    public static Forme Z() {
        ArrayList<Vecteur> liste = new ArrayList<>();
        liste.add(new Vecteur(0, 0));
        liste.add(new Vecteur(1, 1));
        liste.add(new Vecteur(0, 1));
        liste.add(new Vecteur(1, 2));

        return new Forme("Z", liste);
    }

    public int[][] minMax() {
        int minMaxValues[][] = new int[2][2], j; // [X/Y][Min/Max]
        Vecteur<Integer>[] tempTabVec;
        tempTabVec = getPoints();
        j = 0;
        minMaxValues[0][0] = minMaxValues[0][1] = tempTabVec[j].get(0);
        minMaxValues[1][0] = minMaxValues[1][1] = tempTabVec[j].get(1);
        for (j = 1; j < tempTabVec.length; j++) {
            minMaxValues[0][0] = (minMaxValues[0][0] > tempTabVec[j].get(0) ? tempTabVec[j].get(0) : minMaxValues[0][0]);
            minMaxValues[0][1] = (minMaxValues[0][1] < tempTabVec[j].get(0) ? tempTabVec[j].get(0) : minMaxValues[0][1]);
            minMaxValues[1][0] = (minMaxValues[1][0] > tempTabVec[j].get(1) ? tempTabVec[j].get(1) : minMaxValues[1][0]);
            minMaxValues[1][1] = (minMaxValues[1][1] < tempTabVec[j].get(1) ? tempTabVec[j].get(1) : minMaxValues[1][1]);
        }
        return minMaxValues;
    }

    @Override
    public String toString() {
        String str = "";
        byte[][] dataStr;
        int minX, maxX, minY, maxY, i, j;
        Vecteur<Integer>[] tempTabVec;
        tempTabVec = getPoints();
        int minMaxValues[][] = minMax();
        minX = minMaxValues[0][0];
        maxX = minMaxValues[0][1];
        minY = minMaxValues[1][0];
        maxY = minMaxValues[1][1];
        dataStr = new byte[maxY - minY + 1][maxX - minX + 1];
        for (i = 0; i < dataStr.length; i++) {
            for (j = 0; j < dataStr[i].length; j++) {
                dataStr[i][j] = videChar;
            }
        }
        for (j = 0; j < tempTabVec.length; j++) {
            dataStr[tempTabVec[j].get(1) - minY][tempTabVec[j].get(0) - minX] = pleinChar;
        }

        for (i = dataStr.length - 1; i > 0; i--) {
            for (j = 0; j < dataStr[i].length; j++) {
                str += (char) dataStr[i][j];
            }
            str += '\n';
        }
        for (j = 0; j < dataStr[i].length; j++) {
            str += (char) dataStr[i][j];
        }
        return str;
    }
}
