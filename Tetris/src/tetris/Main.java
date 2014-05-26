/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import Controleur.Controleur;
import Modele.Plateau;
import Vue.FenetreJeu;

/**
 *
 * @author 4lexandre
 */
public class Main {

    public static void main(String[] args) {
        Plateau plateau = new Plateau();
        Controleur controleur = new Controleur(plateau);
        FenetreJeu fenetre = new FenetreJeu(plateau);
        
        fenetre.addKeyListener(controleur);
        plateau.addObserver(fenetre);
        plateau.run();
    }
}
