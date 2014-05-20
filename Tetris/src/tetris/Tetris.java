/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris;

import tetris.Vue.*;

/**
 *
 * @author Dimitri
 */
public class Tetris extends Thread {
    
    private FenetreJeu fenetre;
    private Piece[] pieces;
    
    public Tetris (){
        Plateau plateau = new Plateau();
        fenetre=new FenetreJeu(plateau);
        pieces = new Piece[7];
        for (int i= 1; i<=7; i++){
            pieces[i-1]=new Piece(i,i);
        }
    }
    
    @Override
    public void run(){
        while (true){
        }
    }
}
