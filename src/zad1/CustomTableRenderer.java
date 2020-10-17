package zad1;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class CustomTableRenderer implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setForeground(Color.RED);
        c.setFont(new Font("Dialog", Font.BOLD, 12));
        return c;
    }
}
