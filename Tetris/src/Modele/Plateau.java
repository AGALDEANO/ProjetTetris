/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author 4lexandre
 */
public class Plateau {

    private static final Random rand = new Random();
    private Piece courante;
    private Piece[] suivantes;
    private Vecteur<Integer> position;
    private Vecteur<Float> positionReelle;
    private int[][] plateau;
    private final int tailleX;
    private final int tailleY;
    private final int nombreSuivantes;

    public Plateau() {
        tailleX = 20;
        tailleY = 10;
        nombreSuivantes = 3;
        plateau = new int[tailleX][tailleY];
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

    public void nouvellePiece() {
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
    }

    public void updatePosition(int deplacement, int rotation) {
        eraseCourante();
        rotation(rotation);
        deplacement(deplacement);
        position.setValue(positionReelle.get(0).intValue(), positionReelle.get(1).intValue());
        drawCourante();
    }

    public boolean descendre(float vitesse) {
        boolean colision = false;
        int DX = (int) (positionReelle.get(0) + vitesse/4) - position.get(0), max;
        Forme tempForme = new Forme(courante.getForme());
        Vecteur<Integer> temp = new Vecteur();
        
        for (max=1; max <=DX; max++){
            for (int i = 0; i < tempForme.getPoints().length; i++) {
                temp.setValue(getVecteur(i).get(0).intValue() + max, getVecteur(i).get(1).intValue());
                if (!isEmpty(temp)) {
                    colision = true;
                    break;
                }
            }
            if (colision) {
                break;
            }
        }
        max--;
        if (max==0&&colision)return true;
        if (DX==max){
                positionReelle.setValue(positionReelle.get(0) + vitesse/4, positionReelle.get(1));
        }
        else {
            positionReelle.setValue(positionReelle.get(0) + max, positionReelle.get(1));
        }
        return false;
    }

    private boolean deplacement(int deplacement) {
        boolean colision = false;
        Vecteur<Integer> temp = new Vecteur();
        if (deplacement != 0) {
            Forme tempForme = new Forme(courante.getForme());

            for (int i = 0; i < tempForme.getPoints().length; i++) {
                temp.setValue(getVecteur(i).get(0).intValue(), getVecteur(i).get(1).intValue() + deplacement);
                if (!isEmpty(temp)) {
                    colision = true;
                    break;
                }
            }
            if (!colision) {
                positionReelle.setValue(positionReelle.get(0), positionReelle.get(1) + deplacement);
            }
        }
        return colision;
    }

    private boolean rotation(int rotation) {
        boolean colision = false;
        Vecteur<Integer> temp = new Vecteur();

        if (rotation != 0) {
            Forme tempForme = new Forme(courante.getForme());
            if (rotation == -1) {
                tempForme.rotCW();
            } else if (rotation == 1) {
                tempForme.rotACW();
            }
            for (int i = 0; i < tempForme.getPoints().length; i++) {
                temp.setValue(getVecteur(i).get(0).intValue(), getVecteur(i).get(1).intValue());
                if (!isEmpty(temp)) {
                    colision = true;
                    break;
                }
            }
            if (!colision) {
                positionReelle.setValue(positionReelle.get(0), positionReelle.get(1));
                if (rotation == -1) {
                    courante.rotACW();
                } else if (rotation == 1) {
                    courante.rotCW();
                }
            }
        }
        return colision;
    }

    private boolean isIn(Vecteur<Integer> Vec) {
        return Vec.get(0) >= 0 && Vec.get(0) < tailleX && Vec.get(1) >= 0 && Vec.get(1) < tailleY;
    }

    private boolean isEmpty(Vecteur<Integer> Vec) {
        if (isIn(Vec)) {
            return plateau[Vec.get(0)][Vec.get(1)] == 0;
        } else {
            return false;
        }
    }

    public void eraseCourante() {
        Forme temp = courante.getForme();
        int taille = temp.getPoints().length;
        int x, y;
        for (int i = 0; i < taille; i++) {
            x = getVecteur(i).get(0).intValue();
            y = getVecteur(i).get(1).intValue();
            plateau[x][y] = 0;
        }
    }

    public void drawCourante() {
        Forme temp = courante.getForme();
        int x, y;
        int taille = temp.getPoints().length;
        for (int i = 0; i < taille; i++) {
            x = getVecteur(i).get(0).intValue();
            y = getVecteur(i).get(1).intValue();
            plateau[x][y] = courante.getIdColor();
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

    public void deleteLines(int[] indices) {
        if (indices != null) {
            for (int i = 0; i < indices.length; i++) {
                deleteLine(i);
            }
            drawCourante();
        }
    }

    public int checkLine(int[] line) {
        int i;
        boolean test = (line[0] == 0);
        for (i = 1; i < line.length; i++) {
            if ((line[i] == 0) != test) {
                break;
            }
        }
        if (i >= line.length) {
            return 0; // Ligne incomplète
        } else if (test) {
            return 1; //Ligne vide
        }
        return -1;//Ligne pleine
    }

    public int[] checkLines() {
        ArrayList<Integer> temp = new ArrayList<>();
        int i, j, k;
        for (i = tailleX - 1; i > 0; i--) {
            k = 0;
            for (j = 0; j < tailleY; j++) {
                if (plateau[i][j] == 0) {
                    break;
                }
                k++;
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
                    str += '*';
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
