/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris;

import tetris.Vue.Grid;

/**
 *
 * @author Dimitri
 */
public class Tetris extends Thread {
    
    private int score;
    private Grid grille;
    private Piece[] pieces;
    
    public Tetris (){
        score=0;
        grille=new Grid();
        pieces = new Piece[7];
        for (int i= 1; i<=7; i++){
            pieces[i]=new Piece(i,i);
        }
    }
    
    @Override
    public void run(){
        
    }
}
