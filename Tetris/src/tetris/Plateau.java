/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 4lexandre
 */
public class Plateau extends Thread {

    private boolean pause = false;
    private int rotation = 0;
    private int deplacement = 0;
    private static final Random rand = new Random();
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
        vitesse = 1f;
        suivantes = new Piece[nombreSuivantes];
        courante = Piece.randPiece();
        int[][] minMax = courante.getForme().minMax();
        int randY;
        randY = rand.nextInt(tailleY - (minMax[1][1] - minMax[1][0]));
        position = new Vecteur(0, randY);
        positionReelle = new Vecteur(position.get(0).floatValue(), position.get(1).floatValue());
        for (int i = 0; i < suivantes.length; i++) {
            suivantes[i] = Piece.randPiece();
        }
    }

    private void nouvellePiece() {
        courante = suivantes[0];
        int i;
        for (i = 0; i < suivantes.length - 1; i++) {
            suivantes[i] = suivantes[i + 1];
        }
        suivantes[i] = Piece.randPiece();
        int[][] minMax = courante.getForme().minMax();
        int randY;
        randY = rand.nextInt(tailleY - (minMax[1][1] - minMax[1][0]));
        position = new Vecteur(0, randY);
        positionReelle = new Vecteur(position.get(0).floatValue(), position.get(1).floatValue());
        vitesse = 1f;
    }

    private boolean testDeplacement(int x, int y) {
        int i;
        Vecteur[] tempVec = courante.getForme().getPoints();
        Vecteur<Integer> temp = new Vecteur();
        for (i = 0; i < tempVec.length; i++) {
            temp.setValue(tempVec[i].get(0).intValue() + position.get(0) + x, tempVec[i].get(1).intValue() + position.get(1) + y);
            if (!isEmpty(temp)) {
                return false;
            }
        }
        return true;
    }

    private void deplacementY() {
        if (testDeplacement(0, deplacement)) {
            positionReelle.setValue(positionReelle.get(0), positionReelle.get(1) + deplacement);
            position.setValue(positionReelle.get(0).intValue(), positionReelle.get(1).intValue());
        }
    }

    private boolean deplacementX() {
        int DX = (int) (positionReelle.get(0) + vitesse) - position.get(0);
        if (testDeplacement(DX, 0)) {
            positionReelle.setValue(positionReelle.get(0) + vitesse, positionReelle.get(1));
            position.setValue((int) (positionReelle.get(0) + vitesse), positionReelle.get(1).intValue());
            return false;
        }
        return true;
    }

    private void rotation() {
        if (rotation == -1) {
            courante.rotACW();
        } else if (rotation == 1) {
            courante.rotCW();
        }
        if (!testDeplacement(0, 0)) {
            if (rotation == -1) {
                courante.rotCW();
            } else if (rotation == 1) {
                courante.rotACW();
            }
        }
    }

    private boolean updatePosition() {
        if (rotation != 0) {
            rotation();
            rotation = 0;
        }
        if (deplacement != 0) {
            deplacementY();
            deplacement = 0;
        }
        return deplacementX();
    }

    private boolean isIn(Vecteur<Integer> Vec) {
        return Vec.get(0) >= 0 && Vec.get(0) < tailleX && Vec.get(1) >= 0 && Vec.get(1) < tailleY;
    }

    private boolean isEmpty(Vecteur<Integer> Vec) {
        return isIn(Vec) && plateau[Vec.get(0)][Vec.get(1)] == 0;
    }

    public void pause() {
        pause = true;
    }

    public void exit() {
        fin = true;
    }

    public void play() {
        pause = false;
        notify();
    }

    public void rotCW() {
        rotation = 1;
    }

    public void rotACW() {
        rotation = -1;
    }

    public void deplacementGauche() {
        deplacement = -1;
    }

    public void deplacementDroite() {
        deplacement = 1;
    }

    public void augmenterVitesse(float c) {
        if (c != 0f) {
            vitesse *= c;
        }
    }

    public void diminuerVitesse(float c) {
        if (c != 0f) {
            vitesse /= c;
        }
    }

    @Override
    public void run() {
        int i = 0;
        while (!fin) {
            drawCourante();
            System.out.println(toString());
            if (pause) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            update();
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (i == 500) {
                fin = true;
            }
            i++;
        }
        drawCourante();
        System.out.println(toString());

    }

    public int[] update() {
        eraseCourante();
        if (updatePosition()) {
            drawCourante();
            int[] lines = checkLines();
            deleteLines(lines);
            nouvellePiece();
            if (testDeplacement(0, 0)) {
                drawCourante();
            } else {
                fin = true;
            }
            return lines;
        } else {
            position.setValue(positionReelle.get(0).intValue(), positionReelle.get(1).intValue());
        }
        drawCourante();
        return null;
    }

    private void eraseCourante() {
        Forme temp = courante.getForme();
        int taille = temp.getPoints().length;
        int x, y;
        for (int i = 0; i < taille; i++) {
            x = getVecteur(i).get(0).intValue();
            y = getVecteur(i).get(1).intValue();
            if (isIn(new Vecteur(x, y))) {
                plateau[x][y] = 0;
            }
        }
    }

    private void drawCourante() {
        Forme temp = courante.getForme();
        int x, y;
        int taille = temp.getPoints().length;
        for (int i = 0; i < taille; i++) {
            x = getVecteur(i).get(0).intValue();
            y = getVecteur(i).get(1).intValue();
            if (isIn(new Vecteur(x, y))) {
                plateau[x][y] = courante.getIdColor();
            }
        }
    }

    private void deleteLine(int i) {
        int j, k;
        if (i == 0) {
            for (j = 0; j < tailleY; j++) {
                plateau[0][j] = 0;
            }
        } else {
            for (j = 0; j < tailleY; j++) {
                for (k = i; k > 0; k--) {
                    plateau[k][j] = plateau[k - 1][j];
                }
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
        for (i = tailleX - 1; i > 0; i--) {
            k = 0;
            for (j = 0; j < tailleY; j++) {
                if (plateau[i][j] != 0) {
                    k++;
                }
            }
            if (k == tailleY) {
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

    private Vecteur getVecteur(int i) {

        return new Vecteur(courante.getForme().getPoints(i).get(0) + position.get(0), courante.getForme().getPoints(i).get(1) + position.get(1));
    }

    @Override
    public String toString() {
        int i, j;
        String str = "  ";
        for (j = 0; j < tailleY; j++) {
            str += j % 10;
        }
        str += "\n .";
        for (j = 0; j < tailleY; j++) {
            str += '-';
        }
        str += ".\n";

        for (i = 0; i < tailleX; i++) {
            str += i % 10;
            str += "|";
            for (j = 0; j < tailleY; j++) {
                if (plateau[i][j] != 0) {
                    //str += '*';
                    str += plateau[i][j];
                } else {
                    str += ' ';
                }
            }
            str += "|\n";
        }
        str += " '";
        for (j = 0; j < tailleY; j++) {
            str += '-';
        }
        str += '\'';
        return str;
    }
}
