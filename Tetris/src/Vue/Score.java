
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
    
    private int score;
    private int nbLigne;
    
    public Score(int _score, int _nbLigne){
        super("<html>Nombre Lignes : "+_nbLigne+" <br><br>Score : "+_score+" </html>");
        score=_score;
        nbLigne=_nbLigne;
        Font police = new Font("Arial", Font.BOLD, 20);
        this.setFont(police);
        this.setPreferredSize(new Dimension(200, 70));
        this.setHorizontalAlignment(JLabel.LEFT);
        this.setForeground(Color.WHITE);
    }
    
    public Score(){
        super("<html>Nombre Lignes : 0 <br><br>Score : 0 </html>");
        score=0;
        nbLigne=0;
        Font police = new Font("Arial", Font.BOLD, 20);
        this.setFont(police);
        this.setPreferredSize(new Dimension(250, 70));
        this.setHorizontalAlignment(JLabel.LEFT);
        this.setForeground(Color.WHITE);
    }
    
    public void setScore(int score, int nbLigne){
        this.setText("<html>Nombre Lignes : "+nbLigne+" <br><br>Score : "+score+" </html>");
    }

    public int getScore() {
        return score;
    }

    public int getNbLigne() {
        return nbLigne;
    }
}
