package com.proiect.Hotels;

import com.proiect.Cities.Cities;

public class Hotels {
    private String name;
    private int numberOfrooms;
    private String nameAdministrator;
    private String numberPhone;
    private int levels;
    private int stars;
    private Cities city;

    public Hotels(String name, int numberOfrooms, String nameAdministrator, String numberPhone, int levels, int stars, Cities city) {
        this.name = name;
        this.numberOfrooms = numberOfrooms;
        this.nameAdministrator = nameAdministrator;
        this.numberPhone = numberPhone;
        this.levels = levels;
        this.stars = stars;
        this.city = city;
    }

    public Hotels() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfrooms() {
        return numberOfrooms;
    }

    public void setNumberOfrooms(int numberOfrooms) {
        this.numberOfrooms = numberOfrooms;
    }

    public String getNameAdministrator() {
        return nameAdministrator;
    }

    public void setNameAdministrator(String nameAdministrator) {
        this.nameAdministrator = nameAdministrator;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }
}