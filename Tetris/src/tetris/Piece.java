/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris;

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
    private static final int nombrePieces = 7;
    
    public Piece(int _forme, int _couleur){
        forme= Forme.Forme(_forme);
        idColor=_couleur;
        switch (_forme){
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
            default:
                frame=Color.YELLOW;
                break;
        }
    }

    public Piece(int _forme){
        forme= Forme.Forme(_forme);
        idColor=_forme;
        switch (_forme){
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
            default:
                frame=Color.YELLOW;
                break;
        }
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
