/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris.Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.*;

/**
 *
 * @author Dimitri
 */
public class FenetrePrincipale extends JFrame implements ActionListener {
    private JPanel pan;
    private JButton boutonStart;
    private JButton boutonOption;
    private JButton boutonQuit;
    private JLabel titre;

    public FenetrePrincipale (){
        super();
        pan = new JPanel();
        boutonStart = new JButton("Start");
        boutonStart.setPreferredSize(new Dimension(100,50));
        boutonOption = new JButton("Option");
        boutonStart.setPreferredSize(new Dimension(100,50));
        boutonQuit = new JButton("Quitter");
        boutonStart.setPreferredSize(new Dimension(100,50));
        titre = new JLabel("Tetris");
        this.initFenetre();
    }
    
    public void initFenetre (){
        this.setTitle("Tetris");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        pan.setBackground(Color.BLACK);
        this.setContentPane(pan);
        
        Font police = new Font("Arial", Font.BOLD, 100);
        titre.setFont(police);
        titre.setPreferredSize(new Dimension(800, 100));
        titre.setHorizontalAlignment(JLabel.CENTER);
        this.getContentPane().add(titre, BorderLayout.NORTH);
        
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
    
    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
