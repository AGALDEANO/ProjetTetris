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

    private ArrayList<Vecteur[]> points;
    private Vecteur[] etat;
    private int taille;
    private int origine;
    private int rotation;
    private int nombreRotation;
    private String nom;

        //===========================================================
    public ArrayList<Vecteur[]> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Vecteur[]> value) {
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
    public int NombreRotation

    {
        get {
            return nombreRotation;
        }
        set {
            nombreRotation = (value < 0) ? 0 : value;
        }
    }

    public int Origine

    {
        get {
            return origine;
        }
        set
            {
            origine = value;
            origine %= 4;
        }
    }

    public Forme() {
        this.points = new ArrayList<>() {
        };
        rotation = nombreRotation = origine = 0;
        vecteurs[0, 0] = 0;
            vecteurs[0, 1] = 0;
            vecteurs[1, 0] = 0;
            vecteurs[1, 1] = 0;
            vecteurs[2, 0] = 0;
            vecteurs[2
    

    , 1] = 0;
        }

        public Forme(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.points = new ArrayList<>() {
        };
        rotation = nombreRotation = origine = 0;
        vecteurs[0, 0] = x1;
        vecteurs[0, 1] = y1;
        vecteurs[1, 0] = x2;
        vecteurs[1, 1] = y2;
        vecteurs[2, 0] = x3;
        vecteurs[2, 1] = y3;
        Points = generationPoints(vecteurs, 0);
    }

    public Forme(int x1, int y1, int x2, int y2, int x3, int y3, int nbRot) {
        this.points = new ArrayList<>() {
        };
        rotation = origine = 0;
        nombreRotation = nbRot;
        vecteurs[0, 0] = x1;
        vecteurs[0, 1] = y1;
        vecteurs[1, 0] = x2;
        vecteurs[1, 1] = y2;
        vecteurs[2, 0] = x3;
        vecteurs[2, 1] = y3;
        if (nbRot == 1) {
            Points = new ArrayList<Vecteur[]>(generationPoints(vecteurs, nbRot));
        } else {
            Points = new ArrayList<Vecteur[]>(generationPoints(vecteurs, nbRot / 2));
        }
    }

    public Forme(String nomForme, int x1, int y1, int x2, int y2, int x3, int y3, int nbRot) {
        this.points = new ArrayList<>() {
        };
        nom = nomForme;
        rotation = origine = 0;
        nombreRotation = nbRot;
        vecteurs[0, 0] = x1;
        vecteurs[0, 1] = y1;
        vecteurs[1, 0] = x2;
        vecteurs[1, 1] = y2;
        vecteurs[2, 0] = x3;
        vecteurs[2, 1] = y3;
        if (nbRot == 1) {
            Points = new ArrayList<Vecteur[]>(generationPoints(vecteurs, nbRot));
        } else {
            Points = new ArrayList<Vecteur[]>(generationPoints(vecteurs, nbRot / 2));
        }
    }

        //===========================================================
    private ArrayList<Vecteur[]> generationPoints(Vecteur[] vecteursForme, int typeRot) {
        // rotations : (a;b) (-b;a) (-a;-b) (b;-a)
        int rotation = 0, maxRot, i, j, k, temp;
        Vecteur[] vec = new int[3,
        2];
            vec = vecteursForme;
        ArrayList<Vecteur[]> listePoints = new ArrayList<Vecteur[]>();
        maxRot = (typeRot < 1 ? 1 : 2 * typeRot);
        Vecteur[] ens = new int[4, 2];
            ens[0, 0] = 0;
            ens[0
        , 1] = 0;
            for (rotation = 0; rotation < maxRot; rotation++) {
            for (k = 0; k < 1; k++) {
                if (k == 0) {
                    ens[0, 0] = 0;
                        ens[0
                  , 1] = 0;
                    }
                    else
                    {
                        ens[0, 0] = -vec[k - 1, 0];
                        ens[0, 1] = -vec[k - 1
                
                , 1];
                    }
                    for (i = 0; i < 3; i++) {
                    for (j = 0; j < 2; j++) {
                        ens[i + 1, j] = vec[i, j]+ens[0,j
                    
                
                ];
                        }
                    }
                    listePoints.Add(ens);
                ens = new int[4
            
            , 2];
                }
                    for (i = 0; i < 3; i++) {
                temp = vec[i, 0];
                        vec[i, 0] = -vec[i, 1];
                        vec[i, 1] = temp;
            }

        }

        return listePoints;
    }

    public bool videForme() {
        int i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 2; j++) {
                if (vecteurs[i {
                    
                }, j
                ] != 0) return false;
            }
        }
        return true;
    }

    public static Forme T() {
        return new Forme("T", -1, 0, 0, 1, 1, 0, 4);
    }

    public static Forme L() {
        return new Forme("L", 1, 0, 0, 1, 0, 2, 4);
    }

    public static Forme J() {
        return new Forme("J", -1, 0, 0, 1, 0, 2, 4);
    }

    public static Forme C() {
        return new Forme("C", 1, 0, 1, 1, 0, 1, 4);
    }

    public static Forme S() {
        return new Forme("S", 1, 0, 1, 1, 2, 1, 4);
    }

    public static Forme Z() {
        return new Forme("Z", 1, 0, 1, -1, 2, -1, 4);
    }
}
}
