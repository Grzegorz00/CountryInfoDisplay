package zad1;

import javax.swing.*;

public class Country {

    private final String country;
    private final String capital;
    private final int population;
    private final Icon icon;

    public Country(String country, String capital, int population,Icon icon) {
        this.country = country;
        this.capital = capital;
        this.population = population;
        this.icon = icon;
    }

    public String getCountry() {
        return country;
    }

    public String getCapital() {
        return capital;
    }

    public int getPopulation() {
        return population;
    }

    public Icon getIcon() {
        return icon;
    }
}
