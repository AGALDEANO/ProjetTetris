/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue;

import java.awt.Color;

/**
 *
 * @author Dimitri
 */
public class GrilleTetris extends Grid{
    private Color[][] tableau;
    private int hauteurZoneFantome;
    
    public GrilleTetris (int _ligne, int _colonne,int hzf){
        super(_ligne-hzf,_colonne);
        hauteurZoneFantome=hzf;
        tableau = new Color[_ligne][_colonne];
        resetTableau();
    }
    
    public GrilleTetris (){
        super(16,10);
        hauteurZoneFantome=4;
        tableau = new Color[20][10];
        resetTableau();
    }
    
    public void resetTableau (){
        for (int i=0; i<this.getRowCount()+hauteurZoneFantome;i++){
            for (int j=0;j<this.getColumnCount(); j++){
                tableau[i][j]=Color.BLACK;
                if (i>=hauteurZoneFantome){
                    this.setValueAt(tableau[i][j], i-hauteurZoneFantome, j);
                }
            }
        }
    }
    
    public String ToString (){
        String res="";
        for (int i=0; i<this.getRowCount();i++){
            for (int j=0;j<this.getColumnCount(); j++){
                res+=tableau[i][j].toString()+' ';
            }
            res+='\n';
        }
        return res;
    }
    
    public void updateGrid(Color[][]plateau){
        tableau=plateau;
        for (int i=0; i<this.getRowCount()+hauteurZoneFantome;i++){
            for (int j=0;j<this.getColumnCount(); j++){
                if (i>=hauteurZoneFantome){
                    this.setValueAt(tableau[i][j], i-hauteurZoneFantome, j);
                }
            }
        }
    }
}

