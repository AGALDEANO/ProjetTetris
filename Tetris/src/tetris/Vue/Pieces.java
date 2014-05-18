/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris.Vue;

import java.awt.Color;
import tetris.*;

/**
 *
 * @author Dimitri
 */
public class Pieces extends ModeleGrid{
    private Piece[] piece;
    
    
    public Pieces (Piece[] pieces, int length){
        super(length*4,4);
        piece=pieces;
        for (int i=0; i<length; i++){
            createPiece(piece[i],i);
        }
    }
    
    public void createPiece (Piece _piece, int n){
        Vecteur<Integer> points[] = _piece.getForme().getPoints();
        for (int i = n*4; i<n*4+4;i++){
            for (int j=0; j<4;j++){
                this.setValueAt(Color.BLACK, i, j);
            }
        }
        for (Vecteur<Integer> point : points) {
            this.setValueAt(_piece.getFrame(), n*4+3-point.get(1), point.get(0));
        }
    }
    
    public void nouvellePiece(Piece _piece){
        int i;
        for (i=0; i<piece.length-1;i++){
            piece[i]=piece[i+1];
            createPiece(piece[i],i);
        }
        piece[i]=_piece;
        createPiece(piece[i],i);
    }
}
