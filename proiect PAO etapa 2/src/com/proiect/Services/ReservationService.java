package com.proiect.Services;

import java.util.List;
import com.proiect.Reservation.Reservation;

public class ReservationService implements Service{
    private List<Reservation> reservation;

    public ReservationService(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    @Override
    public void display() {
        for (Reservation res : reservation) {
            System.out.println("Detalii client:");
            System.out.println(res.getClient().getNameclient());
            System.out.println("Detalii hotel:");
            System.out.println(res.getHotel().getName());
            System.out.println("Arrival date:");
            System.out.println(res.getArrival().getDate());
            System.out.println("Departure date:");
            System.out.println(res.getDeparture().getDate());
        }

    }

    @Override
    public void add(Object o) {
        reservation.add((Reservation) o);

    }
    @Override
    public void display(int i) {}
    @Override
    public void remove(Object o) {reservation.remove(o);

    }

    @Override
    public void remove(int i) {
        reservation.remove(i);
    }
}