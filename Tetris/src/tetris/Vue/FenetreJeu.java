/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris.Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
    private JLabel titre;
    
    public FenetreJeu(Plateau plateau){
        super();
        score = new Score();
        grid = new Grid(plateau.getTailleX(),plateau.getTailleY(),2);
        pieces = new Pieces(plateau.getSuivantes(),plateau.getSuivantes().length);
        
        ImageIcon icon = new ImageIcon(scaleImage(new ImageIcon(getClass().getResource("/images/tetris-logo.png")).getImage(),400,150,50));
        titre = new JLabel(icon);
        titre.setPreferredSize(new Dimension(this.getWidth(), 200));
        
        this.getContentPane().add(titre, BorderLayout.EAST);
        this.getContentPane().add(score, BorderLayout.WEST);
        this.getContentPane().add(grid, BorderLayout.CENTER);
        this.getContentPane().add(pieces, BorderLayout.EAST);
        
        this.setVisible(true);
    }
    
    public void updateGrid (Plateau plateau){
        Color[][] tab = new Color [plateau.getTailleX()][plateau.getTailleY()];
        
        for (int i=0; i<plateau.getTailleX();i++){
            for (int j=0; j<plateau.getTailleY();j++){
                tab[i][j]=Piece.getColor(plateau.getPlateau()[i][j]);
            }
        }
        grid.updateGrid(tab);
        pieces.updatePiece(plateau.getSuivantes());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
