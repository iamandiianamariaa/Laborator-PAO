package com.proiect.Services;
import com.proiect.Hotels.Hotels;
import com.proiect.persistance.HotelRepository;

import java.util.List;

public class HotelService{
    private static HotelService instance;

    private final HotelRepository hotelRepository = HotelRepository.getInstance();

    private HotelService() {
    }

    public static HotelService getInstance() {
        if (instance == null) {
            instance = new HotelService();
        }
        return instance;
    }

    public void saveHotel(Hotels hotel) {
        hotelRepository.saveHotel(hotel);
    }

    public List<Hotels> findHotels() {
        return hotelRepository.findHotels();
    }

    public List<Hotels> findHotelsStars(int stars) {
        return hotelRepository.findHotelsStars(stars);
    }

    public void updateHotel(String administrator, String nume) {
        hotelRepository.updateHotel(administrator, nume);
    }

    public void deleteHotel(String nume) {
        hotelRepository.deleteHotel(nume);
    }
    public void display(List<Hotels> l) {
        for (Hotels hotel : l) {
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
}
