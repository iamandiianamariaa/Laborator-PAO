package com.proiect.Reservation;

import com.proiect.Client.ClientDetails;
import com.proiect.Hotels.Hotels;
import com.proiect.Dates.Dates;

public class Reservation {
    private ClientDetails client;
    private Hotels hotel;
    private Dates arrival;
    private Dates departure;

    public Reservation() {
    }

    public Reservation(ClientDetails client, Hotels hotel, Dates arrival, Dates departure) {
        this.client = client;
        this.hotel = hotel;
        this.arrival = arrival;
        this.departure = departure;
    }

    public ClientDetails getClient() {
        return client;
    }

    public void setClient(ClientDetails client) {
        this.client = client;
    }

    public Hotels getHotel() {
        return hotel;
    }

    public void setHotel(Hotels hotel) {
        this.hotel = hotel;
    }

    public Dates getArrival() {
        return arrival;
    }

    public void setArrival(Dates arrival) {
        this.arrival = arrival;
    }

    public Dates getDeparture() {
        return departure;
    }

    public void setDeparture(Dates departure) {
        this.departure = departure;
    }
}
