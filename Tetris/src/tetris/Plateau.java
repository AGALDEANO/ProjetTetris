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
    private int tailleX = 20;
    private int tailleY = 10;
    private int nombreSuivantes = 3;

    public Plateau() {
        plateau = new int[tailleX][tailleY];
        position = new Vecteur(3, 0);
        positionReelle = new Vecteur(3f, 0f);
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
        position = new Vecteur(3, 0);
        positionReelle = new Vecteur(3f, 0f);
        vitesse = 1f;
    }

    public boolean updatePosition() {
        boolean colision = false;
        Vecteur<Integer> temp = new Vecteur();
        int DX;
        DX = (int) (positionReelle.get(0)+vitesse) - position.get(0);
        if (DX != 0) {
            for (int i = 0; i < courante.getForme().getPoints().length; i++) {
                temp.setValue(getVecteur(i).get(0).intValue()+DX, getVecteur(i).get(1).intValue());
                if (!isEmpty(temp)) {
                    colision = true;
                    break;
                }
            }
        }
        if (!colision) {
            positionReelle.set(positionReelle.get(0)+vitesse, 0);
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
        int i = 0;
        while (!fin) {
            if (pause) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            update();
            if (i == 5) {
                fin = true;
            }
            i++;
        }
        System.out.println(toString());

    }

    public int[] update() {
        eraseCourante();
        if (updatePosition()) {
            drawCourante();
            int[] lines = checkLines();
            deleteLines(lines);
            nouvellePiece();
            drawCourante();
            return lines;
        }
        drawCourante();
        return null;
    }

    private void eraseCourante() {
        Forme temp = courante.getForme();
        int taille = temp.getPoints().length;
        for (int i = 0; i < taille; i++) {
            plateau[getVecteur(i).get(0).intValue()][getVecteur(i).get(1).intValue()] = 0;
        }
    }

    private void drawCourante() {
        Forme temp = courante.getForme();
        int taille = temp.getPoints().length;
        for (int i = 0; i < taille; i++) {
            plateau[getVecteur(i).get(0).intValue()][getVecteur(i).get(1).intValue()] = courante.getIdColor();
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

    public Piece getCourante() {
        return courante;
    }

    public Vecteur getVecteur(int i) {

        return new Vecteur(courante.getForme().getPoints(i).get(0) + position.get(0), courante.getForme().getPoints(i).get(1) + position.get(1));
    }

    @Override
    public String toString() {
        int i, j;
        String str = "";
        for (i = 0; i < tailleX; i++) {
            for (j = 0; j < tailleY; j++) {
                if (plateau[i][tailleY - j - 1] != 0) {
                    str += '*';
                } else {
                    str += ' ';
                }
            }
            str += '\n';
        }
        return str;
    }
}
