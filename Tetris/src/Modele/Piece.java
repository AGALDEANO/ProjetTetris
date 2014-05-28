/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

import Modele.Forme;
import java.awt.Color;
import java.util.Random;

/**
 *
 * @author p1106501
 */
public class Piece {
    private Forme forme;
    private Color frame;
    private int idColor;
    private static final Random rand = new Random();
    private static final int nombrePieces = 9;
    
    public Piece(int _forme, int _couleur){
        forme= Forme.Forme(_forme);
        idColor=_couleur;
        setFrame(_couleur);
    }

    public Piece(int _forme){
        forme= Forme.Forme(_forme);
        idColor=_forme;
        setFrame(_forme);
    }
    
    public Forme getForme() {
        return forme;
    }

    public void setForme(Forme forme) {
        this.forme = forme;
    }

    public Color getFrame() {
        return frame;
    }
    public int getIdColor() {
        return idColor;
    }

    public void setFrame(Color frame) {
        this.frame = frame;
    }
    
    public void setFrame (int couleur){
        switch (couleur){
            case(Forme._T):
                frame=Color.MAGENTA;
                break;
            case(Forme._S):
                frame=Color.GREEN;
                break;
            case(Forme._Z):
                frame=Color.RED;
                break;
            case(Forme._L):
                frame=Color.ORANGE;
                break;
            case(Forme._J):
                frame=Color.BLUE;
                break;
            case(Forme._I):
                frame=Color.CYAN;
                break;
            case(Forme._O):
                frame=Color.YELLOW;
                break;
            case(Forme._P):
                frame=Color.GRAY;
                break;
            case(Forme._U):
                frame=Color.WHITE;
                break;
            default:
                frame=Color.YELLOW;
                break;
        }
    }
    
    public static Color getColor(int couleur){
        switch (couleur){
            case(Forme._T):
                return Color.MAGENTA;
            case(Forme._S):
                return Color.GREEN;
            case(Forme._Z):
                return Color.RED;
            case(Forme._L):
                return Color.ORANGE;
            case(Forme._J):
                return Color.BLUE;
            case(Forme._I):
                return Color.CYAN;
            case(Forme._O):
                return Color.YELLOW;
            case(Forme._P):
                return Color.GRAY;
            case(Forme._U):
                return Color.WHITE;
            default:
                return Color.BLACK;
        }
    }
    
    public static Piece randPiece()
    {
        return new Piece(rand.nextInt(nombrePieces)+1);
    }
   
    public void rotCW()
    {
        forme.rotCW();
    }
    public void rotACW()
    {
        forme.rotACW();
    }
    
    @Override
    public String toString() {
        String str = "========== "
                +forme.getNom()
                +" ==========\n"
                +frame.toString()
                +'\n'
                +forme.toString();
        return str;
    }
}
