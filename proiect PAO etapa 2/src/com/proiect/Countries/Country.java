package com.proiect.Countries;


import com.proiect.Cities.Cities;
import java.util.ArrayList;

public class Country {
    private String name;
    private String capital;
    private String climate;
    private ArrayList<Cities> listCities;
    public Country(String name,String capital,String climate,ArrayList<Cities> listCities)
    {   this.name=name;
        this.capital=capital;
        this.climate=climate;
        this.listCities=new ArrayList<Cities>();}
    public Country(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public ArrayList<Cities> getListCities() {
        return listCities;
    }

    public void setListCities(ArrayList<Cities> listCities) {
        this.listCities = listCities;
    }
}
