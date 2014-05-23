/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur;

import Modele.Plateau;
import java.util.ArrayList;

/**
 *
 * @author Dimitri
 */
public class Controleur extends Thread {
    
    private Plateau plateau;
    private ArrayList<Integer> action;
    
    public Controleur (Plateau _plateau){
        action = new ArrayList<Integer>();
        action.add(0);
        plateau = _plateau;
    }

    public void setAction(int _action) {
        //this.action.= _action;
    }
     
    @Override
    public void run(){
        while (true){
            switch(action.get(action.size()-1)){
                case 1:
                    plateau.rotACW();
                    break;
                case 2:
                    plateau.rotCW();
                    break;
                case 3:
                    plateau.deplacementDroite();
                    break;
                case 4:
                    plateau.deplacementGauche();
                    break;
                case 5:
                    plateau.modifierVitesse(2);
                    break;
                case 6:
                    plateau.modifierVitesse(1/2);
                    break;
                default:
                    break;
            }
        }
    }
}
