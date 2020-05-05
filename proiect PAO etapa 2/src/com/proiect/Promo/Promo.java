package com.proiect.Promo;

import com.proiect.Cities.Cities;
import com.proiect.Hotels.Hotels;

public class Promo extends Hotels {
    private String boardTypes;
    private int price;
    private int numberOfdays;

    public Promo(String name, int numberOfrooms, String nameAdministrator, String numberPhone, int levels, int stars, Cities city, String boardTypes, int price, int numberOfdays) {
        super(name, numberOfrooms, nameAdministrator, numberPhone, levels, stars, city);
        this.boardTypes = boardTypes;
        this.price = price;
        this.numberOfdays = numberOfdays;
    }

    public Promo(String boardTypes, int price, int numberOfdays) {
        this.boardTypes = boardTypes;
        this.price = price;
        this.numberOfdays = numberOfdays;
    }

    public Promo(){}

    public String getBoardTypes() {
        return boardTypes;
    }

    public void setBoardTypes(String boardTypes) {
        this.boardTypes = boardTypes;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumberOfdays() {
        return numberOfdays;
    }

    public void setNumberOfdays(int numberOfdays) {
        this.numberOfdays = numberOfdays;
    }
}
