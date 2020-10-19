package zad1;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class IntegerTableRenderer extends DefaultTableCellRenderer {


    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        JLabel c = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setOpaque(true);
        c.setHorizontalAlignment(RIGHT);

        Integer population = (Integer) value;
        if(population > 20000) {
            c.setForeground(Color.RED);
        } else {
            c.setForeground(Color.BLACK);
        }

        return c;

    }
}
