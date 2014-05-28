/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue;

import javax.swing.ImageIcon;

/**
 *
 * @author Dimitri
 */
public class GrilleTetris extends Grid{
    private ImageIcon[][] images;
    private final ImageIcon frame ;
    private int hauteurZoneFantome;
    
    public GrilleTetris (int _ligne, int _colonne,int hzf){
        super(_ligne-hzf,_colonne);
        hauteurZoneFantome=hzf;
        images = new ImageIcon[_ligne][_colonne];
        frame = new ImageIcon (getClass().getResource("/images/frames/vide.png"));
        resetTableau();
    }
    
    public GrilleTetris (){
        super(16,10);
        hauteurZoneFantome=4;
        images = new ImageIcon[20][10];
        frame = new ImageIcon (getClass().getResource("/images/frames/vide.png"));
        resetTableau();
    }
    
    public void resetTableau (){
        for (int i=0; i<this.getRowCount()+hauteurZoneFantome;i++){
            for (int j=0;j<this.getColumnCount(); j++){
                images[i][j]=frame;
                if (i>=hauteurZoneFantome){
                    this.setValueAt(images[i][j], i-hauteurZoneFantome, j);
                }
            }
        }
    }
    
    public String ToString (){
        String res="";
        for (int i=0; i<this.getRowCount();i++){
            for (int j=0;j<this.getColumnCount(); j++){
                res+=images[i][j].toString()+' ';
            }
            res+='\n';
        }
        return res;
    }
    
    public void updateGrid(ImageIcon[][]plateau){
        images=plateau;
        for (int i=0; i<this.getRowCount()+hauteurZoneFantome;i++){
            for (int j=0;j<this.getColumnCount(); j++){
                if (i>=hauteurZoneFantome){
                    this.setValueAt(images[i][j], i-hauteurZoneFantome, j);
                }
            }
        }
    }
}

