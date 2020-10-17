package zad1;

public class Country {

    private String country;
    private String capital;
    private int population;

    public Country(String country, String capital, int population) {
        this.country = country;
        this.capital = capital;
        this.population = population;
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
}
