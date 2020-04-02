package com.proiect.Services;

import com.proiect.Countries.Country;

import java.util.Set;

public class CountryService implements Service{
    private Set<Country> tari;

    public CountryService(Set<Country> tari) {
        this.tari = tari;
    }
    @Override
    public void display() {
        for (Country tara : tari) {
            System.out.println("Nume tara:");
            System.out.println(tara.getName());
            System.out.println("Capitala:");
            System.out.println(tara.getCapital());
            System.out.println("Climat:");
            System.out.println(tara.getClimate());
            System.out.println("Orase:");
            System.out.println(tara.getListCities());
        }

    }

    @Override
    public void add(Object o) {
        tari.add((Country) o);

    }
    @Override
    public void display(int i) {}
    @Override
    public void remove(Object o) {tari.remove(o);

    }

    @Override
    public void remove(int i) {
        tari.remove(i);
    }
}
