/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris.Vue;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import tetris.*;

/**
 *
 * @author Dimitri
 */
public class FenetreJeu extends Vue{
    private Score score;
    private Grid grid;
    private Pieces pieces;
    private Plateau tab;
    
    public FenetreJeu(){
        super();
        score = new Score();
        tab = new Plateau();
        grid = new Grid(tab.getTailleY(),tab.getTailleX(),4);
        pieces = new Pieces(tab.getSuivantes(),tab.getSuivantes().length);
        
        this.getContentPane().add(score, BorderLayout.WEST);
        this.getContentPane().add(grid, BorderLayout.CENTER);
        this.getContentPane().add(pieces, BorderLayout.EAST);
        
        this.setVisible(true);
    }
    
    public void updateGrid (){
        Piece _piece = tab.nouvellePiece();
        pieces.nouvellePiece(_piece);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
