/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris.Vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
    private JLabel titre;
    
    public FenetreJeu(){
        super();
        score = new Score();
        tab = new Plateau();
        grid = new Grid(tab.getTailleX(),tab.getTailleY(),2);
        pieces = new Pieces(tab.getSuivantes(),tab.getSuivantes().length);
        
        Icon icon = new ImageIcon(getClass().getResource("/images/tetris-logo.png"));
        titre = new JLabel(icon);
        titre.setPreferredSize(new Dimension(800, 150));
        
        this.getContentPane().add(titre, BorderLayout.EAST);
        this.getContentPane().add(score, BorderLayout.WEST);
        this.getContentPane().add(grid, BorderLayout.CENTER);
        this.getContentPane().add(pieces, BorderLayout.EAST);
        
        this.setVisible(true);
    }
    
    public void updateGrid (){
        tab.nouvellePiece();
        Piece _piece = tab.getCourante();
        pieces.nouvellePiece(_piece);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
