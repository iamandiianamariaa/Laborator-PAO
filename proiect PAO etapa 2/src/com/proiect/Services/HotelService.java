package com.proiect.Services;

import java.util.List;
import com.proiect.Hotels.Hotels;

public class HotelService implements Service {
    private List<Hotels> hoteluri;

    public HotelService(List<Hotels> hoteluri) {
        this.hoteluri= hoteluri;

    }
    @Override
    public void display() {
        for (Hotels hotel : hoteluri) {
            System.out.println("Nume hotel:");
            System.out.println(hotel.getName());
            System.out.println("Nr. stele:");
            System.out.println(hotel.getStars());
            System.out.println("Oras:");
            System.out.println(hotel.getCity().getNameCity());
            System.out.println("Tara:");
            System.out.println(hotel.getCity().getCountry());
            System.out.println("Nume administrator:");
            System.out.println(hotel.getNameAdministrator());
            System.out.println("Nr. telefon:");
            System.out.println(hotel.getNumberPhone());
            System.out.println("Nr. etaje:");
            System.out.println(hotel.getLevels());
            System.out.println("Nr. de camere:");
            System.out.println(hotel.getNumberOfrooms());

        }
    }
    @Override
    public void display(int i) {
            System.out.println("Nume hotel:");
            System.out.println(hoteluri.get(i).getName());
            System.out.println("Nr. stele:");
            System.out.println(hoteluri.get(i).getStars());
            System.out.println("Oras:");
            System.out.println(hoteluri.get(i).getCity().getNameCity());
            System.out.println("Tara:");
            System.out.println(hoteluri.get(i).getCity().getCountry());
            System.out.println("Nume administrator:");
            System.out.println(hoteluri.get(i).getNameAdministrator());
            System.out.println("Nr. telefon:");
            System.out.println(hoteluri.get(i).getNumberPhone());
            System.out.println("Nr. etaje:");
            System.out.println(hoteluri.get(i).getLevels());
            System.out.println("Nr. de camere:");
            System.out.println(hoteluri.get(i).getNumberOfrooms());

        }

    @Override
    public void add(Object o) {
        hoteluri.add((Hotels) o);

    }

    @Override
    public void remove(Object o) {hoteluri.remove(o);

    }

    @Override
    public void remove(int i) {
        hoteluri.remove(i);
    }
}
