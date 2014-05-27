/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Modele;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Dimitri
 */
public class Controleur implements KeyListener{

    private final Modele plateau;

    public Controleur(Modele _plateau) {
        plateau = _plateau;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'l':
                plateau.rotACW();
                break;
            case 'm':
                plateau.rotCW();
                break;
            case 'd':
                plateau.deplacementDroite();
                break;
            case 'q':
                plateau.deplacementGauche();
                break;
            case 's':
                plateau.modifierVitesse(4);
                break;
            default:
                //nope
                break;
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (plateau.getPause()) {
                plateau.play();
            } else {
                plateau.pause();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {  
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 's') {
            plateau.modifierVitesse(0.5f);
        } 
    }
}
