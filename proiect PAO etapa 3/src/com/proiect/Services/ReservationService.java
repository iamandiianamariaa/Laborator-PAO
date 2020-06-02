package com.proiect.Services;
import com.proiect.Reservation.Reservation;
import com.proiect.persistance.ReservationRepository;

import java.util.List;

public class ReservationService{
    private static ReservationService instance;

    private final ReservationRepository userRepository = ReservationRepository.getInstance();

    private ReservationService() {
    }

    public static ReservationService getInstance() {
        if (instance == null) {
            instance = new ReservationService();
        }

        return instance;
    }

    public void saveReservation(Reservation reservation) {
        userRepository.saveReservation(reservation);
    }

    public List<Reservation> findReservation(String cnp) {
        return userRepository.findReservation(cnp);
    }

    public void updateReservation(String phone, String cnp) {
        userRepository.updateReservation(phone, cnp);
    }

    public void deleteReservation(String cnp) {
        userRepository.deleteReservation(cnp);
    }
    public void display(List<Reservation>l) {
        for (Reservation res : l) {
            System.out.println("Detalii client:");
            System.out.println(res.getClient().getNameclient());
            System.out.println("Detalii hotel:");
            System.out.println(res.getHotel().getName());
            System.out.println("City:");
            System.out.println(res.getHotel().getCity().getNameCity());
            System.out.println("Country:");
            System.out.println(res.getHotel().getCity().getCountry());
        }
    }
}