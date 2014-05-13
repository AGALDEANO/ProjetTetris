/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris.Vue;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

/**
 *
 * @author Dimitri
 */
public class FenetrePrincipale implements Observer {
    
    private Grid grid;
    private VueScore score;
    private JFrame fenetre;
    private JPanel pan;

    public FenetrePrincipale (){
        grid= new Grid();
        score= new VueScore();
        fenetre = new JFrame();
        pan = new JPanel();
        this.initFenetre();
    }
    
    public FenetrePrincipale (int _ligne, int _colonne,int hzf){
        grid= new Grid(_ligne, _colonne, hzf);
        score= new VueScore();
        fenetre = new JFrame();
        pan = new JPanel();
        this.initFenetre();
    }
    
    public void initFenetre (){
        pan.setBackground(Color.BLACK);
        fenetre.setContentPane(pan);
        fenetre.setTitle("Tetris");
        fenetre.setSize(400, 100);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        fenetre.setVisible(true);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
