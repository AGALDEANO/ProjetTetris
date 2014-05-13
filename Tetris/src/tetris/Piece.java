/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris;

import tetris.Vue.Case;
import java.awt.Color;

/**
 *
 * @author p1106501
 */
public class Piece {
    private Forme forme;
    private Case frame;
    
    public Piece(int _forme, int _couleur){
        forme= Forme.Forme(_forme);
        frame = new Case();
        switch (_couleur){
            case(1):
                frame.setBackground(Color.RED);
                break;
            case(2):
                frame.setBackground(Color.BLUE);
                break;
            case(3):
                frame.setBackground(Color.YELLOW);
                break;
            case(4):
                frame.setBackground(Color.GREEN);
                break;
            case(5):
                frame.setBackground(Color.ORANGE);
                break;
            case(6):
                frame.setBackground(Color.MAGENTA);
                break;
            case(7):
                frame.setBackground(Color.GRAY);
                break;
            default:
                frame.setBackground(Color.BLACK);
                break;
        }
    }

    public Forme getForme() {
        return forme;
    }

    public void setForme(Forme forme) {
        this.forme = forme;
    }

    public Case getFrame() {
        return frame;
    }

    public void setFrame(Case frame) {
        this.frame = frame;
    }
}
