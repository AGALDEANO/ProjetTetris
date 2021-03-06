/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

import java.util.ArrayList;

/**
 *
 * @author p1106501
 * @param <T>
 */
public class Vecteur<T extends Number> {
    private ArrayList<T> coordonnees = new ArrayList<>();
    
    public Vecteur(T x, T y)
    {
        coordonnees.add(x);
        coordonnees.add(y);
    }
    public Vecteur(Vecteur Vec)
    {
        coordonnees.add((T)Vec.coordonnees.get(0));
        coordonnees.add((T)Vec.coordonnees.get(1));
    }
    public Vecteur()
    {
        T x = (T) Integer.valueOf(0), y = (T) Integer.valueOf(0);
        coordonnees.add(x);
        coordonnees.add(y);
    }
    public void setValue(T x, T y)
    {
        coordonnees.set(0, x);
        coordonnees.set(1, y);
    }
    
    public T get(int i)
    {
        return coordonnees.get(i&1);
    }
    public void set(T value, int i)
    {
        coordonnees.set(i&1, value);
    }
}
