
package tetris.Vue;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author Dimitri
 */
public class Score extends JPanel{
    private JLabel text;
    
    public Score(int score){
        text= new JLabel("Score : "+score);
        Font police = new Font("Arial", Font.BOLD, 30);
        text.setFont(police);
        this.add(text);
    }
    
    public Score(){
        text= new JLabel("Score : 0");
        Font police = new Font("Arial", Font.BOLD, 20);
        text.setFont(police);
        text.setPreferredSize(new Dimension(100, 20));
        text.setHorizontalAlignment(JLabel.CENTER);
        this.add(text);
    }
    
    public void setScore(int score){
        text = new JLabel("Score : "+ score);
    }
}
