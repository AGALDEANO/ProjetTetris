/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author 4lexandre
 */
public class ModeleDeuxJoueurs extends Observable implements Runnable  {
    private final Modele plateau1;
    private final Modele plateau2;

    public ModeleDeuxJoueurs(Modele plateau1, Modele plateau2) {
        this.plateau1 = plateau1;
        this.plateau2 = plateau2;
    }

    public Modele getPlateau1() {
        return plateau1;
    }

    public Modele getPlateau2() {
        return plateau2;
    }
    
    
    
    @Override
    public void run()
    {
        plateau1.run();
        plateau2.run();
    }
    
    @Override
    public void addObserver(Observer o)
    {
        plateau1.addObserver(o);
        plateau2.addObserver(o);
    }
    
    
}
