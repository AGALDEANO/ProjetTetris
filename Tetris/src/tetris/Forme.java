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
        return etat.clone();
    }

    public Vecteur<Integer> getPoints(int i) throws CloneNotSupportedException {
        return etat[i].clone();
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
            case 0:
                return Forme.C();
            case 1:
                return Forme.T();
            case 2:
                return Forme.L();
            case 3:
                return Forme.J();
            case 4:
                return Forme.S();
            case 5:
                return Forme.Z();
            case 6:
                return Forme.Li();
            default:
                return Forme.C();
        }
    }

    public static Forme T() {
        ArrayList<Vecteur> liste = new ArrayList<>();
        liste.add(new Vecteur(0, 0));
        liste.add(new Vecteur(-1, 0));
        liste.add(new Vecteur(1, 0));
        liste.add(new Vecteur(0, 1));

        return new Forme("T", liste);
    }
    public static Forme Li() {
        ArrayList<Vecteur> liste = new ArrayList<>();
        liste.add(new Vecteur(0, 0));
        liste.add(new Vecteur(1, 0));
        liste.add(new Vecteur(2, 0));
        liste.add(new Vecteur(3, 0));

        return new Forme("Li", liste);
    }

    public static Forme L() {
        ArrayList<Vecteur> liste = new ArrayList<>();
        liste.add(new Vecteur(0, 0));
        liste.add(new Vecteur(1, 0));
        liste.add(new Vecteur(0, 2));
        liste.add(new Vecteur(0, 1));

        return new Forme("L", liste);
    }

    public static Forme J() {
        ArrayList<Vecteur> liste = new ArrayList<>();
        liste.add(new Vecteur(0, 0));
        liste.add(new Vecteur(-1, 0));
        liste.add(new Vecteur(0, 2));
        liste.add(new Vecteur(0, 1));

        return new Forme("J", liste);
    }

    public static Forme C() {
        ArrayList<Vecteur> liste = new ArrayList<>();
        liste.add(new Vecteur(0, 0));
        liste.add(new Vecteur(0, 1));
        liste.add(new Vecteur(1, 0));
        liste.add(new Vecteur(1, 1));

        return new Forme("C", liste);
    }

    public static Forme S() {
        ArrayList<Vecteur> liste = new ArrayList<>();
        liste.add(new Vecteur(0, 0));
        liste.add(new Vecteur(1, 0));
        liste.add(new Vecteur(1, 1));
        liste.add(new Vecteur(2, 1));

        return new Forme("S", liste);
    }

    public static Forme Z() {
        ArrayList<Vecteur> liste = new ArrayList<>();
        liste.add(new Vecteur(0, 0));
        liste.add(new Vecteur(1, 0));
        liste.add(new Vecteur(1, -1));
        liste.add(new Vecteur(2, -1));

        return new Forme("Z", liste);
    }

    @Override
    public String toString() {
        String str = "";
        byte[][] dataStr;
        int minX, maxX, minY, maxY, i, j;
        Vecteur<Integer>[] tempTabVec;
        tempTabVec = getPoints();
        j = 0;
        maxX = minX = tempTabVec[j].get(0);
        maxY = minY = tempTabVec[j].get(1);
        for (j = 1; j < tempTabVec.length; j++) {
            minX = (minX > tempTabVec[j].get(0) ? tempTabVec[j].get(0) : minX);
            maxX = (maxX < tempTabVec[j].get(0) ? tempTabVec[j].get(0) : maxX);
            minY = (minY > tempTabVec[j].get(1) ? tempTabVec[j].get(1) : minY);
            maxY = (maxY < tempTabVec[j].get(1) ? tempTabVec[j].get(1) : maxY);
        }
        dataStr = new byte[maxY-minY+1][maxX-minX+1];
        for (i = 0; i < dataStr.length; i++) {
            for (j = 0; j < dataStr[i].length; j++) {
                dataStr[i][j] = (byte) 0;
            }
        }
        for (j = 0; j < tempTabVec.length; j++) {
            dataStr[tempTabVec[j].get(1) - minY][tempTabVec[j].get(0) - minX] = (byte) 10;
        }
        
        for (i = dataStr.length-1; i >0 ; i--) {
            for (j = 0; j < dataStr[i].length; j++) {
                str += (char) (dataStr[i][j] + ' ');
            }
            str += '\n';
        }
        for (j = 0; j < dataStr[i].length; j++) {
                str += (char) (dataStr[i][j] + ' ');
            }
        return str;
    }
}
