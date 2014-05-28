/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Dimitri
 */
public class GameOver extends Vue {

    private Score score;
    private JLabel titre;
    private JLabel sousTitre;

    public GameOver(int _score, int nbLignes) {
        super();
        score = new Score(_score,nbLignes);
        ImageIcon icon = new ImageIcon(scaleImage(new ImageIcon(getClass().getResource("/images/tetris-logo.png")).getImage(), 400, 150, 50));
        titre = new JLabel(icon);
        titre.setPreferredSize(new Dimension(this.getWidth(), 200));
        sousTitre.setPreferredSize(new Dimension(this.getWidth(), 100));
        sousTitre.setForeground (Color.RED);
        this.getContentPane().add(titre, BorderLayout.NORTH);
        this.getContentPane().add(sousTitre, BorderLayout.CENTER);
        this.getContentPane().add(score, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
