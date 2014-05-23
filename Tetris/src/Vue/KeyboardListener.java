/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Dimitri
 */
public class KeyboardListener implements KeyListener {
    
    @Override
    public void keyTyped(KeyEvent e) {
        switch(e.getKeyChar()){
            case 'l':
                //rotation acw
                break;
            case 'm':
                //rotation cw;
                break;
            case 'd':
                //déplacement vers la droite
                break;
            case 'q':
                //déplacement vers la gauche
                break;
            default :
                //nope
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar()== 's'){
            //deplacement vers le bas
        }       
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar()=='s'){
                //ralentir vers le bas
        }
    }
}
