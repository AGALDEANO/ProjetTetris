/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.*;

/**
 *
 * @author Dimitri
 */
public abstract class Vue extends JFrame{
    private JPanel pan;
    public Vue (){
        this.setTitle("Tetris");
        this.setSize(800, 700);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pan = new JPanel();
        pan.setBackground(Color.BLACK);
        this.setContentPane(pan);
    }
    
    public static Image scaleImage(Image source, int width, int height, int gap) {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) img.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(source, 0, 0, width, height + gap, null);
        g.dispose();
    return img;
    }
}
