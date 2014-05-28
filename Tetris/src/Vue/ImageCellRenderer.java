/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Dimitri
 */
public class ImageCellRenderer extends DefaultTableCellRenderer {
 
    public ImageCellRenderer() {
        super();
    }
 
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        ImageIcon color = (ImageIcon) value;
 
        setText("");
        setIcon(color);
        
 
        return this;
    }
}
