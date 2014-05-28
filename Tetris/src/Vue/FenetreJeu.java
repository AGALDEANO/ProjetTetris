/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Modele;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Dimitri
 */
public class FenetreJeu extends Vue implements Observer {

    private Score score;
    private GrilleTetris grid;
    private Reserve pieces;
    private JLabel titre;
    private JLabel gameOver;

    public FenetreJeu(Modele plateau) {
        super();

        score = new Score();
        grid = new GrilleTetris(plateau.getTailleX(), plateau.getTailleY(), 2);
        pieces = new Reserve(plateau.getSuivantes(), plateau.getSuivantes().length);

        ImageIcon icon = new ImageIcon(scaleImage(new ImageIcon(getClass().getResource("/images/tetris-logo.png")).getImage(), 400, 100, 0));
        titre = new JLabel(icon);
        titre.setPreferredSize(new Dimension(this.getWidth(), 100));
        
        gameOver = new JLabel("Game Over");
        gameOver.setPreferredSize(new Dimension(this.getWidth(), 200));
        Font police = new Font("Arial", Font.BOLD, 100);
        gameOver.setHorizontalAlignment(JLabel.CENTER);
        gameOver.setFont(police);
        gameOver.setForeground(Color.RED);
        
        this.getContentPane().add(titre, BorderLayout.NORTH);
        this.getContentPane().add(score, BorderLayout.WEST);
        this.getContentPane().add(grid, BorderLayout.CENTER);
        this.getContentPane().add(pieces, BorderLayout.EAST);

        this.setVisible(true);
    }

    public void updateGrid(final Modele plateau) {
        if(!SwingUtilities.isEventDispatchThread()){
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    updateGrid(plateau);
                }
            });
            
            return;
        }
        grid.updateGrid(plateau.getColorGrid());
        pieces.updatePiece(plateau.getSuivantes());
    }

    @Override
    public void update(final Observable o, final Object arg) {
        if(!SwingUtilities.isEventDispatchThread()){
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    update(o, arg);
                }
            });
            return;
        }
        if (o instanceof Modele) {
            this.getContentPane().remove(score);
            this.getContentPane().remove(grid);
            this.getContentPane().remove(pieces);
            Modele plateau = (Modele) o;
            updateGrid(plateau);
            score.setScore(plateau.getScore(),plateau.getNbLignes());
            if (plateau.getFin()){
                
                this.getContentPane().add(gameOver,BorderLayout.CENTER);
                this.getContentPane().add(score, BorderLayout.SOUTH);
                this.setVisible(true);
                this.getContentPane().repaint();
            }
            else {
                this.getContentPane().add(score, BorderLayout.WEST);
                this.getContentPane().add(grid, BorderLayout.CENTER);
                this.getContentPane().add(pieces, BorderLayout.EAST);
                this.getContentPane().repaint();
            }
        }
    }
}
