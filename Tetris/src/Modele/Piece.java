/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

import Modele.Forme;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author p1106501
 */
public class Piece {
    private Forme forme;
    private ImageIcon frame;
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

    public ImageIcon getFrame() {
        return frame;
    }
    public int getIdColor() {
        return idColor;
    }

    public void setFrame(ImageIcon frame) {
        this.frame = frame;
    }
    
    public void setFrame (int couleur){
        switch (couleur){
            case 0:
                frame=new ImageIcon (getClass().getResource("/images/Frames/vide.png"));
                break;
            case(Forme._T):
                frame=new ImageIcon (getClass().getResource("/images/Frames/violet.png"));
                break;
            case(Forme._S):
                frame=new ImageIcon (getClass().getResource("/images/Frames/vertFonce.png"));
                break;
            case(Forme._Z):
                frame=new ImageIcon (getClass().getResource("/images/Frames/rouge.png"));
                break;
            case(Forme._L):
                frame=new ImageIcon (getClass().getResource("/images/Frames/orange.png"));
                break;
            case(Forme._J):
                frame=new ImageIcon (getClass().getResource("/images/Frames/bleuFonce.png"));
                break;
            case(Forme._I):
                frame=new ImageIcon (getClass().getResource("/images/Frames/marron.png"));
                break;
            case(Forme._O):
                frame=new ImageIcon (getClass().getResource("/images/Frames/jaune.png"));
                break;
            case(Forme._P):
                frame=new ImageIcon (getClass().getResource("/images/Frames/gris.png"));
                break;
            case(Forme._U):
                frame=new ImageIcon (getClass().getResource("/images/Frames/blanc.png"));
                break;
            default:
                frame=new ImageIcon (getClass().getResource("/images/Frames/vertClair.png"));
                break;
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
