package zad1;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountryTable {

    List<Country> countryList;
    List<String> columnNamesList = new ArrayList<>();

    String countriesFileName;

    String regex = "([^\\t]*)\\t([^\\t]*)\\t([^\\t]*)\\t([^\\t]*)[\\t ]*\\n";
    JTable countryTable;

    public CountryTable(String countriesFileName) {
        this.countriesFileName = countriesFileName;
        countryList = new ArrayList<Country>();
    }

    public JTable create() {

        String text = fileReader();
        createCountryList(text);

        MyTableModel model = new MyTableModel(countryList,columnNamesList);
        countryTable = new JTable(model);
        countryTable.setDefaultRenderer(Integer.class, new IntegerTableRenderer());
        countryTable.setRowHeight(countryList.get(0).getIcon().getIconHeight() + 20);

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
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            reader.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    private void createCountryList(String text){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if(matcher.find()) {
            columnNamesList.add(matcher.group(1));
            columnNamesList.add(matcher.group(2));
            columnNamesList.add(matcher.group(3));
            columnNamesList.add(matcher.group(4));

            Icon flag = null;
            while (matcher.find()) {
                Country country = new Country(
                        matcher.group(1),
                        matcher.group(2),
                        Integer.parseInt(matcher.group(3)),
                        flag = new ImageIcon("data/flags/" + matcher.group(4))
                );
                countryList.add(country);
            }
        }


    }
}
