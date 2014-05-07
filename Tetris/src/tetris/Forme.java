/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.ArrayList;

/**
 *
 * @author p1106501
 */
public class Forme {

    private ArrayList<Vecteur<Integer>[]> points;
    private Vecteur<Integer>[] etat;
    private int taille;
    private int origine;
    private int rotation;
    private int nombreRotation;
    private String nom;

    //===========================================================
    public int getTaille() {
        return taille;
    }

    public void rotCW()
    {
        setRotation(rotation+1);
    }
    public void rotACW()
    {
        setRotation(rotation-1);
    }
    
    public void setTaille(int taille) {
        taille = (taille < 1 ? 1 : taille);
        this.taille = taille;
    }

    public ArrayList<Vecteur<Integer>[]> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Vecteur<Integer>[]> value) {
        points = value;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String value) {
        nom = value;
    }

    public Vecteur[] getEtat() {
        return etat;
    }

    public Vecteur[] getVecteurs() {
        return points.get(rotation);
    }

    public void setEtat(Vecteur[] value) {
        etat = value;
    }

    public int getRotation() {
        return rotation;

    }

    public void setRotation(int value) {
        rotation = value;
        rotation %= nombreRotation;
    }

    public int getNombreRotation() {
        return nombreRotation;
    }

    public void setNombreRotation(int value) {
        nombreRotation = (value < 0) ? 0 : value;
    }

    public int getOrigine() {
        return origine;
    }

    public void setOrigine(int value) {

        origine = value;
        origine %= 4;
    }

    public Forme() {
        taille = 3;
        etat = new Vecteur[taille];

        rotation = nombreRotation = origine = 0;
        for (int i = 0; i < taille; i++) {
            etat[i].set(0, i);
        }
    }

    public Forme(ArrayList<Vecteur> values) {
        taille = values.size();
        etat = new Vecteur[taille];
        rotation = nombreRotation = origine = 0;
        for (int i = 0; i < taille; i++) {
            etat[i] = values.get(i);
        }
        points = generationPoints(etat, 0);
    }

    public Forme(ArrayList<Vecteur> values, int nbRot) {
        taille = values.size();
        etat = new Vecteur[taille];
        rotation = origine = 0;
        nombreRotation = nbRot;
        for (int i = 0; i < taille; i++) {
            etat[i] = values.get(i);
        }
        if (nbRot == 1) {
            points = generationPoints(etat, nbRot);
        } else {
            points = generationPoints(etat, nbRot / 2);
        }
    }

    public Forme(String nomForme, ArrayList<Vecteur> values, int nbRot) {
        taille = values.size();
        nom = nomForme;
        etat = new Vecteur[taille];
        rotation = origine = 0;
        nombreRotation = nbRot;
        for (int i = 0; i < taille; i++) {
            etat[i] = values.get(i);
        }
        if (nbRot == 1 || nbRot == 0) {
            points = generationPoints(etat, nbRot);
        } else {
            points = generationPoints(etat, 2);
        }
    }

    //===========================================================
    private ArrayList<Vecteur<Integer>[]> generationPoints(Vecteur<Integer>[] vecteursForme, int typeRot) {
        // Rotations : (a;b) (-b;a) (-a;-b) (b;-a)
        int i, j, k;
        Vecteur<Integer>[] vec = new Vecteur[vecteursForme.length];
        vec = vecteursForme.clone();
        ArrayList<Vecteur<Integer>[]> listePoints = new ArrayList<>();
        Vecteur[] ens = new Vecteur[vecteursForme.length + 1];
        switch (typeRot) {
            case 0:
                for (k = 0; k < ens.length; k++) {
                    if (k == 0) {
                        ens[0].setValue(0, 0);
                    } else {
                        ens[0].setValue(vec[k - 1].get(0), vec[k - 1].get(1));
                    }
                }
                listePoints.add(ens);
                break;
            case 1:
                for (i = 0; i < 2; i++) {
                    for (k = 0; k < ens.length; k++) {
                        if (k == 0) {
                            ens[0].setValue(0, 0);
                        } else {
                            ens[0].setValue(vec[k - 1].get(0), vec[k - 1].get(1));
                        }
                    }
                    listePoints.add(ens);
                    for (j = 0; j < vec.length; j++) {
                        vec[j].setValue(-vec[j].get(0), -vec[j].get(1));
                    }
                }
                break;
            case 2:
                for (i = 0; i < 4; i++) {
                    for (k = 0; k < ens.length; k++) {
                        if (k == 0) {
                            ens[0].setValue(0, 0);
                        } else {
                            ens[0].setValue(vec[k - 1].get(0), vec[k - 1].get(1));
                        }
                    }
                    listePoints.add(ens);
                    for (j = 0; j < vec.length; j++) {
                        vec[j].setValue(-vec[j].get(1), vec[j].get(0));
                    }
                }
                break;
        }
        return listePoints;
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
            default:
                return Forme.C();
        }
    }

    public static Forme T() {
        ArrayList<Vecteur> liste = new ArrayList<>();
        liste.add(new Vecteur(-1, 0));
        liste.add(new Vecteur(1, 0));
        liste.add(new Vecteur(0, 1));

        return new Forme("T", liste, 4);
    }

    public static Forme L() {
        ArrayList<Vecteur> liste = new ArrayList<>();
        liste.add(new Vecteur(0, 0));
        liste.add(new Vecteur(0, 2));
        liste.add(new Vecteur(0, 1));

        return new Forme("L", liste, 4);
    }

    public static Forme J() {
        ArrayList<Vecteur> liste = new ArrayList<>();
        liste.add(new Vecteur(-1, 0));
        liste.add(new Vecteur(0, 2));
        liste.add(new Vecteur(0, 1));

        return new Forme("J", liste, 4);
    }

    public static Forme C() {
        ArrayList<Vecteur> liste = new ArrayList<>();
        liste.add(new Vecteur(0, 1));
        liste.add(new Vecteur(1, 0));
        liste.add(new Vecteur(1, 1));

        return new Forme("C", liste, 4);
    }

    public static Forme S() {
        ArrayList<Vecteur> liste = new ArrayList<>();
        liste.add(new Vecteur(1, 0));
        liste.add(new Vecteur(1, 1));
        liste.add(new Vecteur(2, 1));

        return new Forme("S", liste, 4);
    }

    public static Forme Z() {
        ArrayList<Vecteur> liste = new ArrayList<>();
        liste.add(new Vecteur(1, 0));
        liste.add(new Vecteur(1, -1));
        liste.add(new Vecteur(2, -1));

        return new Forme("Z", liste, 4);
    }
}
