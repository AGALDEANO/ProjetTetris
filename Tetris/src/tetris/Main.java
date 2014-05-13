/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 4lexandre
 */
public class Main {

    public static void main(String[] args) {
        Forme temp;
        String str;
        temp = Forme.C();
        str = temp.toString();
        System.out.println(str);
    }
}
