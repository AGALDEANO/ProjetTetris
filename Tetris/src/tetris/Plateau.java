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
 * @author 4lexandre
 */
public class Plateau implements java.lang.Runnable {

    private boolean pause = false;
    private boolean fin = false;
    private Piece courante;
    private Piece[] suivantes;
    private Vecteur<Integer> position;
    private Float vitesse;
    private Vecteur<Float> positionReelle;
    private int[][] plateau;
    private int tailleX = 10;
    private int tailleY = 20;
    private int nombreSuivantes = 3;

    public Plateau() {
        plateau = new int[tailleY][tailleX];
        position = new Vecteur(3, 12);
        positionReelle = new Vecteur(3f, 12f);
        vitesse = 1f;
        suivantes = new Piece[nombreSuivantes];
        courante = Piece.randPiece();
        for (int i = 0; i < suivantes.length; i++) {
            suivantes[i] = Piece.randPiece();
        }
    }

    public void nouvellePiece() {
        courante = suivantes[0];
        int i;
        for (i = 0; i < suivantes.length - 1; i++) {
            suivantes[i] = suivantes[i + 1];
        }
        suivantes[i] = Piece.randPiece();
        position = new Vecteur(3, 12);
        positionReelle = new Vecteur(3f, 12f);
        vitesse = 1f;
    }

    public boolean updatePosition() {
        boolean colision = false;
        Vecteur<Integer> temp = new Vecteur();
        float y, dy;
        int Y, DY;
        y = positionReelle.get(1);
        dy = -vitesse;
        y += dy;
        Y = (int) y;
        DY = Y - position.get(1);
        if (DY != 0) {
            for (int i = 0; i < courante.getForme().getPoints().length; i++) {
                try {
                    temp.setValue(courante.getForme().getPoints(i).get(0), courante.getForme().getPoints(i).get(1) + DY);
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (!isEmpty(temp)) {
                    colision = true;
                    break;
                }
            }
        }
        if (!colision) {
            positionReelle.set(y, 1);
        }
        return colision;
    }

    public boolean isIn(Vecteur<Integer> Vec) {
        return Vec.get(0) >= 0 && Vec.get(0) < tailleX && Vec.get(1) >= 0 && Vec.get(1) < tailleY;
    }

    public boolean isEmpty(Vecteur<Integer> Vec) {
        return isIn(Vec);
    }

    void pause() {
        pause = true;
    }

    void play() {
        pause = false;
        notify();
    }

    @Override
    public void run() {
        int i=0;
        while (!fin) {
            if (pause) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            update();
            if(i==5) fin = true;
            i++;
        }
    }

    public int[] update() {
        if (updatePosition()) {
            nouvellePiece();
            int[] lines = checkLines();
            deleteLines(lines);
            return lines;
        }
        return null;
    }

    private void eraseCourante() {
        Forme temp = courante.getForme();
        int taille = temp.getPoints().length;
        for (int i = 0; i < taille; i++) {
            try {
                plateau[temp.getPoints(i).get(1)][temp.getPoints(i).get(0)] = 0;
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void drawCourante() {
        Forme temp = courante.getForme();
        int taille = temp.getPoints().length;
        for (int i = 0; i < taille; i++) {
            try {
                plateau[temp.getPoints(i).get(1)][temp.getPoints(i).get(0)] = courante.getIdColor();
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void deleteLine(int i) {
        int j, k;
        for (j = 0; j < tailleX; j++) {
            for (k = i; k < tailleY - 1; k++) {
                plateau[k][j] = plateau[k + 1][j];
            }
        }
    }

    private void deleteLines(int[] indices) {
        if (indices != null) {
            eraseCourante();
            for (int i = 0; i < indices.length; i++) {
                deleteLine(i);
            }
            drawCourante();
        }
    }

    private int[] checkLines() {
        ArrayList<Integer> temp = new ArrayList<>();
        int i, j, k;
        for (i = 0; i < tailleY; i++) {
            k = 0;
            for (j = 0; j < tailleX; j++) {
                if (plateau[i][j] != 0) {
                    k++;
                }
            }
            if (k == tailleX) {
                temp.add(i);
            }
            if (k == 0) {
                break;
            }
        }
        if (temp.isEmpty()) {
            return null;
        }
        int[] lines = new int[temp.size()];
        for (i = 0; i < lines.length; i++) {
            lines[i] = temp.get(i);
        }
        return lines;

    }

    public Piece[] getSuivantes() {
        return suivantes;
    }

    public int[][] getPlateau() {
        return plateau;
    }

    public int getTailleX() {
        return tailleX;
    }

    public int getTailleY() {
        return tailleY;
    }
}
