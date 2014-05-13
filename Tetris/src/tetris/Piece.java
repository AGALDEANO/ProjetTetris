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
    private Color frame;
    
    public Piece(int _forme, int _couleur){
        forme= Forme.Forme(_forme);
        switch (_couleur){
            case(1):
                frame=Color.RED;
                break;
            case(2):
                frame=Color.BLUE;
                break;
            case(3):
                frame=Color.YELLOW;
                break;
            case(4):
                frame=Color.GREEN;
                break;
            case(5):
                frame=Color.ORANGE;
                break;
            case(6):
                frame=Color.MAGENTA;
                break;
            case(7):
                frame=Color.GRAY;
                break;
            default:
                frame=Color.BLACK;
                break;
        }
    }

    public Forme getForme() {
        return forme;
    }

    public void setForme(Forme forme) {
        this.forme = forme;
    }

    public Color getFrame() {
        return frame;
    }

    public void setFrame(Color frame) {
        this.frame = frame;
    }
}
