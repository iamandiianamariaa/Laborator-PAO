package com.proiect.persistance;

import com.proiect.Cities.Cities;
import com.proiect.Client.ClientDetails;
import com.proiect.Hotels.Hotels;
import com.proiect.Reservation.Reservation;
import com.proiect.connection.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {
    private static ReservationRepository instance;

    private static final String INSERT_STATEMENT = "INSERT INTO reservation (location,cnp,datebirth,email,clientphone,nume,prenume,name,rooms,administrator,phone,levels,stars,city,country,seasona,datea,seasond,dated) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM reservation WHERE cnp = ?";
    private static final String UPDATE_STATEMENT = "UPDATE reservation SET clientphone = ? WHERE cnp = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM reservation WHERE cnp= ?";

    private ReservationRepository() {
    }

    public static ReservationRepository getInstance() {
        if (instance == null) {
            instance = new ReservationRepository();
        }

        return instance;
    }

    public void saveReservation(Reservation reservation) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement.setString(1, reservation.getClient().getLocation());
            statement.setString(2, reservation.getClient().getCnp());
            statement.setString(3, reservation.getClient().getDateOfBirth());
            statement.setString(4, reservation.getClient().getEmailAddress());
            statement.setString(5, reservation.getClient().getPhoneNumber());
            statement.setString(6, reservation.getClient().getNameclient());
            statement.setString(7, reservation.getClient().getPren());
            statement.setString(8, reservation.getHotel().getName());
            statement.setInt(9, reservation.getHotel().getNumberOfrooms());
            statement.setString(10, reservation.getHotel().getNameAdministrator());
            statement.setString(11, reservation.getHotel().getNumberPhone());
            statement.setInt(12, reservation.getHotel().getLevels());
            statement.setInt(13, reservation.getHotel().getStars());
            statement.setString(14, reservation.getHotel().getCity().getNameCity());
            statement.setString(15, reservation.getHotel().getCity().getCountry());
            statement.setString(16, reservation.getArrival().getSeason());
            statement.setString(17, String.valueOf(reservation.getArrival().getDate()));
            statement.setString(18, reservation.getDeparture().getSeason());
            statement.setString(19, String.valueOf(reservation.getDeparture().getDate()));

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new reservation was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new Reservation: " + e.getMessage());
        }
    }

    public List<Reservation> findReservation(String cnp) {
        List<Reservation> lista = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setString(1, cnp);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Reservation reservation = new Reservation();
                ClientDetails client = new ClientDetails();
                client.setLocation(result.getString("location"));
                client.setCnp(result.getString("cnp"));
                client.setDateOfBirth(result.getString("datebirth"));
                client.setEmailAddress(result.getString("email"));
                client.setPhoneNumber(result.getString("clientphone"));
                client.setNameclient(result.getString("nume"));
                client.setPren(result.getString("prenume"));
                Hotels hotel = new Hotels();
                hotel.setName(result.getString("name"));
                hotel.setNumberOfrooms(result.getInt("rooms"));
                hotel.setNameAdministrator(result.getString("administrator"));
                hotel.setNumberPhone(result.getString("phone"));
                hotel.setLevels(result.getInt("levels"));
                hotel.setStars(result.getInt("stars"));
                Cities city=new Cities();
                city.setNameCity(result.getString("city"));
                city.setCountry(result.getString("country"));
                hotel.setCity(city);
                reservation.setHotel(hotel);
                reservation.setClient(client);
                lista.add(reservation);
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find reservation: " + e.getMessage());
        }
        return lista;
    }

    public void updateReservation(String phone, String cnp) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setString(1, phone);
            statement.setString(2, cnp);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Phone number was updated successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update phone number: " + e.getMessage());
        }
    }

    public void deleteReservation(String cnp) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)) {
            statement.setString(1, cnp);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Reservation was deleted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to delete reservation: " + e.getMessage());
        }
    }
}
