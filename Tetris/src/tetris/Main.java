/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import Controleur.Controleur;
import Modele.Modele;
import Vue.FenetreJeu;
import java.util.Scanner;

/**
 *
 * @author 4lexandre
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Modele plateau;
        Controleur controleur;
        FenetreJeu fenetre;
        int choix;
        System.out.println("Combien voulez-vous de pièces différentes ? (0 pour quitter)");
        choix = sc.nextInt();
        if (choix > 0) {
            plateau = new Modele(choix);
            controleur = new Controleur(plateau);
            fenetre = new FenetreJeu(plateau);
            fenetre.addKeyListener(controleur);
            plateau.addObserver(fenetre);
            plateau.run();
        }
    }

}
