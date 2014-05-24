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

    private final Plateau plateau;
    private ArrayList<Integer> action;

    public Controleur(Plateau _plateau) {
        action = new ArrayList<Integer>();
        action.add(0);
        plateau = _plateau;
    }

    public void setAction(int _action) {
        this.action.add(_action);
    }

    @Override
    public void run() {
        int size = 0;
        while (true) {
            size = action.size() - 1;
            switch (action.get(size)) {
                case 1:
                    synchronized (plateau) {
                        plateau.rotACW();
                        action.remove(size);
                    }
                    break;
                case 2:
                    synchronized (plateau) {
                        plateau.rotCW();
                        action.remove(size);
                    }
                    break;
                case 3:
                    synchronized (plateau) {
                        plateau.deplacementDroite();
                        action.remove(size);
                    }
                    break;
                case 4:
                    synchronized (plateau) {
                        plateau.deplacementGauche();
                        action.remove(size);
                    }
                    break;
                case 5:
                    synchronized (plateau) {
                        plateau.modifierVitesse(2);
                        action.remove(size);
                    }
                    break;
                case 6:
                    synchronized (plateau) {
                        plateau.modifierVitesse(1 / 2);
                        action.remove(size);
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
