/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

import java.awt.Color;
import java.util.Observable;
import java.util.Timer;

/**
 *
 * @author Dimitri
 */
public class Modele extends Observable implements Runnable{
    private boolean pause;
    private boolean fin;
    private float vitesse;
    private Plateau plateau;
    private Timer timer;
    private int score;
    
    public Modele (){
        pause = false;
        fin = false;
        vitesse = 1f;
        plateau = new Plateau();
        timer = new Timer();
        score = 0;
    }
    
    public boolean getFin()
    {
        return fin;
    }
    
    public boolean getPause()
    {
        return pause;
    }
    
    public int getTailleX(){
        return plateau.getTailleX();
    }
    
    public int getTailleY(){
        return plateau.getTailleY();
    }
    
    public Color[][] getColorGrid(){
        Color[][] tab = new Color[plateau.getTailleX()][plateau.getTailleY()];
        for (int i = 0; i < plateau.getTailleX(); i++) {
            for (int j = 0; j < plateau.getTailleY(); j++) {
                Color color = Piece.getColor(plateau.getPlateau()[i][j]);
                tab[i][j] = color;
            }
        }
        return tab;
    }
    
    public Piece[] getSuivantes (){
        return plateau.getSuivantes();
    }
    
    public int getScore (){
        return score;
    }
    
    public void pause() {
        pause = true;
        try {
            timer.wait();
        } catch (InterruptedException ex) {
            System.out.println("Erreur Timer");
        }
    }
    public void play() {
        pause = false;
        timer.notify();
    }
    
    public void rotCW() {
        plateau.updatePosition(0,1);
        updateObservers();
    }

    public void rotACW() {
        plateau.updatePosition(0,-1);
        updateObservers();
    }

    public void deplacementGauche() {
        plateau.updatePosition(-1,0);
        updateObservers();
    }

    public void deplacementDroite() {
        plateau.updatePosition(1,0);
        updateObservers();
    }

    public void modifierVitesse(float c) {
        if (c!=vitesse){
            vitesse = c;
            timer.cancel();
            timer.purge();
            timer=new Timer();
            timer.scheduleAtFixedRate(new Timing(this), 0, 1000);
        }
        
    }

    public void update() {
        plateau.eraseCourante();
        int i;
        boolean colision = plateau.descendre(vitesse);
        if (colision) {
            plateau.drawCourante();
            int[] lines = plateau.checkLines();
            plateau.deleteLines(lines);
            if (lines!=null){
                score+=lines.length;
            }
            plateau.nouvellePiece();
            for(i=0;i<plateau.getTailleY();i++) if(plateau.getPlateau()[0][i]!=0) fin= true;
        } else {
            plateau.updatePosition(0, 0);
        }
        plateau.drawCourante();
        updateObservers();
    }
    
    private void updateObservers(){
        setChanged();
        notifyObservers();
    }
    
    @Override
    public void run() {
        timer.scheduleAtFixedRate(new Timing(this), 1000, 1000);
        while (!fin) {
        }
    }
}
