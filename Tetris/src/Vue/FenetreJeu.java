/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Modele;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Dimitri
 */
public class FenetreJeu extends Vue implements Observer {

    private Score score;
    private GrilleTetris grid;
    private Reserve pieces;
    private JLabel titre;

    public FenetreJeu(Modele plateau) {
        super();

        score = new Score();
        grid = new GrilleTetris(plateau.getTailleX(), plateau.getTailleY(), 2);
        pieces = new Reserve(plateau.getSuivantes(), plateau.getSuivantes().length);

        ImageIcon icon = new ImageIcon(scaleImage(new ImageIcon(getClass().getResource("/images/tetris-logo.png")).getImage(), 400, 150, 50));
        titre = new JLabel(icon);
        titre.setPreferredSize(new Dimension(this.getWidth(), 200));

        this.getContentPane().add(titre, BorderLayout.NORTH);
        this.getContentPane().add(score, BorderLayout.WEST);
        this.getContentPane().add(grid, BorderLayout.CENTER);
        this.getContentPane().add(pieces, BorderLayout.EAST);

        this.setVisible(true);
    }

    public void updateGrid(Modele plateau) {
        grid.updateGrid(plateau.getColorGrid());
        pieces.updatePiece(plateau.getSuivantes());
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Modele) {
            this.getContentPane().remove(score);
            this.getContentPane().remove(grid);
            this.getContentPane().remove(pieces);
            Modele plateau = (Modele) o;
            updateGrid(plateau);
            score.setScore(plateau.getScore());

        }
        this.getContentPane().add(score, BorderLayout.WEST);
        this.getContentPane().add(grid, BorderLayout.CENTER);
        this.getContentPane().add(pieces, BorderLayout.EAST);
        this.getContentPane().repaint();
    }
}
