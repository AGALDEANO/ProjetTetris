/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris.Vue;

import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import tetris.Grid;

/**
 *
 * @author Dimitri
 */
public class FenetrePrincipale implements Observer {
    
    private VueGrid grid;
    private VueScore score;
    private JFrame fenetre;

    public FenetrePrincipale (){
        grid= new VueGrid();
        score= new VueScore();
        fenetre = new JFrame();
    }
    
    public void initFenetre (){
        //Définit un titre pour notre fenêtre
        fenetre.setTitle("Ma première fenêtre Java");
        //Définit sa taille : 400 pixels de large et 100 pixels de haut
        fenetre.setSize(400, 100);
        //Nous demandons maintenant à notre objet de se positionner au centre
        fenetre.setLocationRelativeTo(null);
        //Termine le processus lorsqu'on clique sur la croix rouge
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Et enfin, la rendre visible        
        fenetre.setVisible(true);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
