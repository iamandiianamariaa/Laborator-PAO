package com.proiect.Dates;

import com.proiect.Cities.Cities;
import com.proiect.Promo.Promo;

import java.util.Date;

public class Dates extends Promo {
    private String season;
    private Date date;
    //private deals offer;

    public Dates(String name, int numberOfrooms, String nameAdministrator, String numberPhone, int levels, int stars, Cities city, String boardTypes, int price, int numberOfdays, String season, Date date) {
        super(name, numberOfrooms, nameAdministrator, numberPhone, levels, stars, city, boardTypes, price, numberOfdays);
        this.season = season;
        this.date = date;
    }

    public Dates(String boardTypes, int price, int numberOfdays, String season, Date date) {
        super(boardTypes, price, numberOfdays);
        this.season = season;
        this.date = date;
    }

    public Dates(String season, Date date) {
        this.season = season;
        this.date = date;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
