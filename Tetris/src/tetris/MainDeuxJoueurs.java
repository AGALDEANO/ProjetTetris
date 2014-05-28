/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import Controleur.ControleurDeuxJoueurs;
import Modele.Modele;
import Modele.ModeleDeuxJoueurs;
import Vue.FenetreJeuDeuxJoueurs;
import java.util.Scanner;

/**
 *
 * @author 4lexandre
 */
public class MainDeuxJoueurs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ModeleDeuxJoueurs plateaux;
        Modele plateau1, plateau2;
        ControleurDeuxJoueurs controleur;
        FenetreJeuDeuxJoueurs fenetre;
        int choix;
        System.out.println("Combien voulez-vous de pièces différentes ? (0 pour quitter)");
        choix = sc.nextInt();
        if (choix > 0) {
            plateau1 = new Modele(choix);
            plateau2 = new Modele(choix);
            plateaux = new ModeleDeuxJoueurs(plateau1, plateau2);
            controleur = new ControleurDeuxJoueurs(plateaux);
            fenetre = new FenetreJeuDeuxJoueurs(plateaux);
            fenetre.addKeyListener(controleur);
            plateaux.addObserver(fenetre);
            plateaux.run();
        }
    }
}
