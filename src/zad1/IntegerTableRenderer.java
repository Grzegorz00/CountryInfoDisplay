package zad1;

import sun.swing.table.DefaultTableCellHeaderRenderer;

import javax.swing.*;
import java.awt.*;

public class IntegerTableRenderer extends DefaultTableCellHeaderRenderer {


    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        JLabel c = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setOpaque(true);
        c.setHorizontalAlignment(RIGHT);

        Integer population = (Integer) value;
        if(population > 20000000) {
            c.setForeground(Color.RED);
        }

        return c;

    }
}
