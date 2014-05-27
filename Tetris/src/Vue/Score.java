
package Vue;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author Dimitri
 */
public class Score extends JLabel{
    
    public Score(int score){
        super("Score : "+score);
        Font police = new Font("Arial", Font.BOLD, 30);
        this.setFont(police);
        this.setPreferredSize(new Dimension(100, 20));
        this.setHorizontalAlignment(JLabel.CENTER);
    }
    
    public Score(){
        super("Score : 0");
        Font police = new Font("Arial", Font.BOLD, 20);
        this.setFont(police);
        this.setPreferredSize(new Dimension(150, 20));
        this.setHorizontalAlignment(JLabel.RIGHT);
    }
    
    public void setScore(int score){
        this.setText("Score : "+ score);
    }
}
