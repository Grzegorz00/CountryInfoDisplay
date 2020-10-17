package zad1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountryTable {

    List<Country> countryList;

    String [] tableNames = new String[3];
    String [][] tableStr = null;
    Integer [] tableInt = null;
    String countriesFileName;
    int row = -1;

    String regex = "([^\\t]*)\\t([^\\t]*)\\t([^\\t]*)[\\t ]*\\n";
    JTable countryTable;

    public CountryTable(String countriesFileName) {
        this.countriesFileName = countriesFileName;
        countryList = new ArrayList<Country>();
    }

    public JTable create() {

        String text = fileReader();
        createTable(text);

        /*DefaultTableModel model = new DefaultTableModel();
        model.addColumn(tableNames[0],tableStr[0]);
        model.addColumn(tableNames[1],tableStr[1]);
        model.addColumn(tableNames[2],tableInt);*/

        MyTableModel model = new MyTableModel(countryList);

        countryTable = new JTable(model);
        //countryTable.setForeground();
        //countryTable.setDefaultRenderer(Integer.class, new CustomTableRenderer());

        return countryTable;
    }

    private String fileReader (){

        File txtFile = new File(countriesFileName);
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(txtFile));
            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
                row++;
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            reader.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    private void createTable(String text){

        /*tableStr = new String[2][row - 1]; // name,capital
        tableInt = new Integer[row - 1]; // population*/
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        matcher.find();
        /*tableNames[0] = matcher.group(1);
        tableNames[1] = matcher.group(2);
        tableNames[2] = matcher.group(3);*/

        //int i = 0;
        while (matcher.find()){

            Country country = new Country(
                    matcher.group(1),
                    matcher.group(2),
                    Integer.parseInt(matcher.group(3))
            );
            countryList.add(country);
            /*tableStr[0][i] = matcher.group(1);
            tableStr[1][i] = matcher.group(2);
            tableInt[i] = Integer.parseInt(matcher.group(3));
            i++;*/
        }

    }
}
