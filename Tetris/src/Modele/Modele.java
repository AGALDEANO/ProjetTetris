/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import javax.swing.ImageIcon;

/**
 *
 * @author Dimitri
 */
public class Modele extends Observable implements Runnable {

    private boolean pause;
    private boolean fin;
    private float vitesseBase;
    private float vitesse;
    private Plateau plateau;
    private Timer timer;
    private int score;
    private int nbLignes;

    public Modele() {
        pause = false;
        fin = false;
        vitesseBase = 0.5f;
        vitesse = vitesseBase;
        plateau = new Plateau();
        timer = new Timer();
        score = 0;
        nbLignes=0;
    }
    public Modele(int i) {
        pause = false;
        fin = false;
        vitesseBase = 0.5f;
        vitesse = vitesseBase;
        plateau = new Plateau(i);
        timer = new Timer();
        score = 0;
        nbLignes=0;
    }

    public int getNbLignes() {
        return nbLignes;
    }

    public boolean getFin() {
        return fin;
    }

    public boolean getPause() {
        return pause;
    }

    public int getTailleX() {
        return plateau.getTailleX();
    }

    public int getTailleY() {
        return plateau.getTailleY();
    }

    public ImageIcon[][] getColorGrid() {
        Piece piece;
        ImageIcon[][] tab = new ImageIcon[plateau.getTailleX()][plateau.getTailleY()];
        for (int i = 0; i < plateau.getTailleX(); i++) {
            for (int j = 0; j < plateau.getTailleY(); j++) {
                piece=new Piece(plateau.getPlateau()[i][j]);
                tab[i][j] =piece.getFrame();
            }
        }
        return tab;
    }

    public Piece[] getSuivantes() {
        return plateau.getSuivantes();
    }

    public int getScore() {
        return score;
    }

    public void resetVitesse() {
        vitesse = vitesseBase;
    }

    public void pause() {
        pause = true;
        timer.cancel();
        timer.purge();
    }

    public void play() {
        pause = false;

        timer = new Timer();
        timer.scheduleAtFixedRate(new Timing(this), 0, (int) (50.0f / vitesseBase));
    }

    public void rotCW() {
        if (!pause) {
            plateau.updatePosition(0, 1);
            updateObservers();
        }
    }

    public void rotACW() {
        if (!pause) {
            plateau.updatePosition(0, -1);
            updateObservers();
        }
    }

    public void deplacementGauche() {
        if (!pause) {
            plateau.updatePosition(-1, 0);
            updateObservers();
        }
    }

    public void deplacementDroite() {
        if (!pause) {
            plateau.updatePosition(1, 0);
            updateObservers();
        }
    }

    public float getVitesseBase() {
        return vitesseBase;
    }

    public void modifierVitesse(float c) {
        if (c != vitesse) {
            vitesse = c;
            timer.cancel();
            timer.purge();
            timer = new Timer();
            timer.scheduleAtFixedRate(new Timing(this), 0, (int) (50.0f / vitesseBase));
        }

    }
    
    private void quitter()
    {
        timer.cancel();
        timer.purge();
        
    }

    public void update() {
        int i;
        plateau.eraseCourante();
        boolean colision = plateau.descendre(vitesse);
        if (colision) {
            plateau.drawCourante();
            plateau.nouvellePiece();
            int[] lines = plateau.checkLines();
            plateau.deleteLines(lines);
            if (lines != null) {
                nbLignes+=lines.length;
                score +=Math.ceil(vitesseBase + 1)*lines.length ;
                vitesseBase = (float) Math.log(Math.log(score)+1)/4 + 0.4f;
                resetVitesse();
            }
            for (i = 0; i < plateau.getTailleY(); i++) {
                if (plateau.getPlateau()[plateau.limite][i] != 0) {
                    fin = true;
                    quitter();
                }
            }
        } else {
            plateau.updatePosition(0, 0);
        }
        plateau.drawCourante();
        updateObservers();

    }

    private void updateObservers() {
        setChanged();
        notifyObservers();
    }

    @Override
    public void run() {
        timer.scheduleAtFixedRate(new Timing(this), 1000, 100);
    }
    
    @Override
    public void addObserver(Observer o)
    {
        super.addObserver(o);
    }
}
