/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Modele;
import Modele.ModeleDeuxJoueurs;
import java.awt.BorderLayout;
import java.util.Observable;
import javax.swing.SwingUtilities;

/**
 *
 * @author 4lexandre
 */
public class FenetreJeuDeuxJoueurs extends FenetreJeu {

    private Score score2;
    private GrilleTetris grid2;
    private Reserve pieces2;

    public FenetreJeuDeuxJoueurs(ModeleDeuxJoueurs _plateaux) {
        super(_plateaux.getPlateau1());
        
        score2 = new Score();
        grid2 = new GrilleTetris(_plateaux.getPlateau2().getTailleX(), _plateaux.getPlateau2().getTailleY(), 2);
        pieces2 = new Reserve(_plateaux.getPlateau2().getSuivantes(), _plateaux.getPlateau2().getSuivantes().length);
        this.getContentPane().add(grid2, BorderLayout.CENTER);

    }

    public void updateGrid(final Modele plateau1, final Modele plateau2) {
        if (!plateau1.getFin() || !plateau2.getFin()) {
            if (!SwingUtilities.isEventDispatchThread()) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        updateGrid(plateau1, plateau2);
                    }
                });

                return;
            }
            super.getGrid().updateGrid(plateau1.getColorGrid());
            super.getPieces().updatePiece(plateau1.getSuivantes());
        }
        grid2.updateGrid(plateau2.getColorGrid());
        pieces2.updatePiece(plateau2.getSuivantes());
    }
    
    @Override
    public void update(final Observable o, final Object arg) {
        if (!SwingUtilities.isEventDispatchThread()) {
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    update(o, arg);
                }
            });
            return;
        }
        if (o instanceof Modele) {
            super.getContentPane().remove(super.getScore());
            super.getContentPane().remove(super.getGrid());
            super.getContentPane().remove(super.getPieces());
            super.getContentPane().remove(score2);
            super.getContentPane().remove(grid2);
            super.getContentPane().remove(pieces2);
            Modele _plateau1 = (Modele) o;
            Modele _plateau2 = (Modele) o;
            updateGrid(_plateau1, _plateau2);
            super.getScore().setScore(_plateau1.getScore(), _plateau1.getNbLignes());
            score2.setScore(_plateau2.getScore(), _plateau2.getNbLignes());

        }
        super.getContentPane().add(super.getScore(), BorderLayout.WEST);
        super.getContentPane().add(super.getPieces(), BorderLayout.WEST);
        super.getContentPane().add(super.getGrid(), BorderLayout.CENTER);
        getContentPane().add(grid2, BorderLayout.CENTER);
        getContentPane().add(pieces2, BorderLayout.EAST);
        getContentPane().add(score2, BorderLayout.EAST);
        super.getContentPane().repaint();
    }

}
