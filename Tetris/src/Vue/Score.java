
package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author Dimitri
 */
public class Score extends JLabel{
    
    public Score(int score, int nbLigne){
        super("<html>Nombre Lignes : "+nbLigne+" <br><br>Score : "+score+" </html>");
        Font police = new Font("Arial", Font.BOLD, 20);
        this.setFont(police);
        this.setPreferredSize(new Dimension(200, 70));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setForeground(Color.WHITE);
    }
    
    public Score(){
        super("<html>Nombre Lignes : 0 <br><br>Score : 0 </html>");
        Font police = new Font("Arial", Font.BOLD, 20);
        this.setFont(police);
        this.setPreferredSize(new Dimension(250, 70));
        this.setHorizontalAlignment(JLabel.RIGHT);
        this.setForeground(Color.WHITE);
    }
    
    public void setScore(int score, int nbLigne){
        this.setText("<html>Nombre Lignes : "+nbLigne+" <br><br>Score : "+score+" </html>");
    }
}
