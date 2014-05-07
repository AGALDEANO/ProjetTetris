/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris;

/**
 *
 * @author p1106501
 */
public class Piece {
    private Forme forme;
    private Case frame;
    
    public Piece(int _forme, int _couleur){
        forme= Forme.Forme(_forme);
        frame = new Case();
    }

    public Forme getForme() {
        return forme;
    }

    public void setForme(Forme forme) {
        this.forme = forme;
    }

    public Case getFrame() {
        return frame;
    }

    public void setFrame(Case frame) {
        this.frame = frame;
    }
}
