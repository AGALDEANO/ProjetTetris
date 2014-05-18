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
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Dimitri
 */
public abstract class Vue extends JFrame implements ActionListener{
    private JPanel pan;
    private JLabel titre;
    
    public Vue (){
        this.setTitle("Tetris");
        this.setSize(800, 600);
        this.setBackground(Color.BLACK);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pan = new JPanel();
        pan.setBackground(Color.BLACK);
        this.setContentPane(pan);
        
        titre = new JLabel("Tetris");
        Font police = new Font("Arial", Font.BOLD, 100);
        titre.setFont(police);
        titre.setPreferredSize(new Dimension(800, 100));
        titre.setHorizontalAlignment(JLabel.CENTER);
        this.getContentPane().add(titre, BorderLayout.NORTH);
    }
}
