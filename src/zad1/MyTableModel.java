package zad1;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MyTableModel extends AbstractTableModel {

    private final List<Country> countryList;

    private final List<String> columnNames;

    private final Class[] columnClass = new Class[] {
            String.class, String.class, Integer.class
    };

    public MyTableModel(List<Country> countryList, List<String> columnNames) {
        this.countryList = countryList;
        this.columnNames = columnNames;
    }

    @Override
    public String getColumnName(int column)
    {
        return columnNames.get(column);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }

    @Override
    public int getRowCount() {
        return countryList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Country row = countryList.get(rowIndex);
        if(0 == columnIndex) {
            return row.getCountry();
        }
        else if(1 == columnIndex) {
            return row.getCapital();
        }
        else if(2 == columnIndex) {
            return row.getPopulation();
        }
        return null;
    }
}
