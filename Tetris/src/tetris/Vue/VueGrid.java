/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris.Vue;

import tetris.Grid;

/**
 *
 * @author Dimitri
 */
public class VueGrid {
    private Grid grid;
    
    public VueGrid(){
        grid = new Grid ();
    }
    
    public VueGrid(int longueur, int largeur, int hzf){
        grid = new Grid(longueur, largeur, hzf);
    }
}
