/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris.Vue;

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
    private int hauteurZoneFantome;
    
    public Grid (int _ligne, int _colonne,int hzf){
        super();
        ligne=_ligne;
        colonne=_colonne;
        hauteurZoneFantome=hzf;
        tableau = new Case[ligne][colonne];
        GridLayout layout = new GridLayout (ligne, colonne);
        this.setLayout(layout);
        for (int i=0; i<ligne;i++){
            for (int j=0;j<colonne; j++){
                tableau[i][j]=new Case();
                tableau[i][j].setBackground(Color.BLACK);
                if (i>hauteurZoneFantome){
                    this.add(tableau[i][j]);
                }
            }
        }
    }
    
    public Grid (){
        super();
        ligne=20;
        colonne=10;
        hauteurZoneFantome=4;
        tableau = new Case[ligne][colonne];
        GridLayout layout = new GridLayout (ligne, colonne);
        this.setLayout(layout);
        for (int i=0; i<ligne;i++){
            for (int j=0;j<colonne; j++){
                tableau[i][j]=new Case();
                tableau[i][j].setBackground(Color.BLACK);
                if (i>hauteurZoneFantome){
                    this.add(tableau[i][j]);
                }
            }
        }
    }
    
    public String ToString (){
        String res="";
        for (int i=0; i<ligne;i++){
            for (int j=0;j<colonne; j++){
                res+=tableau[i][j].ToString()+' ';
            }
            res+='\n';
        }
        return res;
    }
}
