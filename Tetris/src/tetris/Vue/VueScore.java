
package tetris.Vue;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

/**
 *
 * @author Dimitri
 */
public class VueScore extends JPanel{
    private int score;
    
    public void paintComponent(Graphics g){
    g.setColor(Color.DARK_GRAY);
    g.fillRoundRect(55, 65, 55, 30, 5, 5);
  } 
    
    public VueScore(){
        score=0;
    }
}
