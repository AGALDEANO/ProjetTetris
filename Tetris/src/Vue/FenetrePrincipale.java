/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author Dimitri
 */
public class FenetrePrincipale extends Vue  {
    private JButton boutonStart;
    private JButton boutonOption;
    private JButton boutonQuit;

    public FenetrePrincipale (){
        super();
        boutonStart = new JButton("Start");
        boutonStart.setPreferredSize(new Dimension(100,50));
        boutonOption = new JButton("Option");
        boutonStart.setPreferredSize(new Dimension(100,50));
        boutonQuit = new JButton("Quitter");
        boutonStart.setPreferredSize(new Dimension(100,50));
        
        JPanel b1 = new JPanel();
        JPanel b2 = new JPanel();
        JPanel b3 = new JPanel();
        JPanel b4 = new JPanel();
        
        b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
        b1.add(boutonStart);
        
        b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
        b2.add(boutonOption);
        
        b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
        b3.add(boutonQuit);
        
        b4.setLayout(new BoxLayout(b4, BoxLayout.PAGE_AXIS));
        b4.add(b1);
        b4.add(b2);
        b4.add(b3);   
        this.getContentPane().add(b4, BorderLayout.CENTER);
        
        this.setVisible(true);
    }
}
