/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue;

import Modele.Vecteur;
import Modele.Piece;
import javax.swing.ImageIcon;

/**
 *
 * @author Dimitri
 */
public class Reserve extends Grid{
    private Piece[] piece;
    
    
    public Reserve (Piece[] pieces, int length){
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
                this.setValueAt(new ImageIcon (getClass().getResource("/images/Frames/vide.png")), i, j);
            }
        }
        for (Vecteur<Integer> point : points) {
            this.setValueAt(_piece.getFrame(), n*4+point.get(0)+2, point.get(1));
        }
    }
    
    public void updatePiece(Piece[] _piece){
        int i;
        piece=_piece;
        for (i=0; i<piece.length;i++){
            createPiece(piece[i],i);
        }
    }
}
