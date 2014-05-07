/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author Dimitri
 */
public class Grid extends JPanel{
    private int ligne;
    private int colonne;
    private Case[][] tableau;
    
    public Grid (int _ligne, int _colonne){
        super();
        ligne=_ligne;
        colonne=_colonne;
        tableau = new Case[ligne][colonne];
        GridLayout layout = new GridLayout (ligne, colonne);
        this.setLayout(layout);
        for (int i=0; i<ligne;i++){
            for (int j=0;j<colonne; j++){
                tableau[i][j]=new Case();
                tableau[i][j].setBackground(Color.BLACK);
                this.add(tableau[i][j]);
            }
        }
    }
}
