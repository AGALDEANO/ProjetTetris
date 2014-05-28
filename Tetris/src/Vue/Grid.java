/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTable;

/**
 *
 * @author Dimitri
 */
public class Grid extends JTable {
    public Grid (int length,int width){
        super (length, width);
        this.setDefaultRenderer(ImageIcon.class, new ImageCellRenderer());
        this.setTableHeader(null);
        this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.WHITE));
        this.setShowVerticalLines(false);
        this.setShowHorizontalLines(false);
        this.setRowHeight(30);
        for (int i=0; i<width;i++){
            this.getColumnModel().getColumn(i).setPreferredWidth(30);
        }
        this.setEnabled(false);
    }
  
    @Override
    public Class getColumnClass(int columnIndex){
	return ImageIcon.class;
    }
}
