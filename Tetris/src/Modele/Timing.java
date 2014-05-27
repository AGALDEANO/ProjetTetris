/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

import java.util.TimerTask;

/**
 *
 * @author Dimitri
 */
public class Timing extends TimerTask{
    private Modele model;
    
    public Timing (Modele _model){
        model = _model;
    }
    
    @Override
    public void run() {
        model.update();
    }
}
