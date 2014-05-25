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
    private boolean fin=false;

    public Controleur(Plateau _plateau) {
        action = new ArrayList<>();
        action.add(0);
        plateau = _plateau;
    }

    public void setAction(int _action) {
        this.action.add(_action);
    }

    @Override
    public void run() {
        plateau.start();
        int size = 0;
        do {
            size = action.size() - 1;
            synchronized (plateau) {
            fin = plateau.getFin();
                switch (action.get(size)) {
                    case 1:
                        plateau.rotACW();
                        action.remove(size);

                        break;
                    case 2:
                        plateau.rotCW();
                        action.remove(size);

                        break;
                    case 3:
                        plateau.deplacementDroite();
                        action.remove(size);

                        break;
                    case 4:
                        plateau.deplacementGauche();
                        action.remove(size);

                        break;
                    case 5:
                        plateau.modifierVitesse(2);
                        action.remove(size);

                        break;
                    case 6:
                        plateau.modifierVitesse(1 / 2);
                        action.remove(size);

                        break;
                    case 7:
                        if (plateau.getPause()) {
                            plateau.play();
                        } else {
                            plateau.pause();
                        }
                        action.remove(size);

                        break;
                    default:
                        break;
                }
            }
        }while(fin);
    }
}
