package com.proiect.persistance;

import com.proiect.Cities.Cities;
import com.proiect.Client.ClientDetails;
import com.proiect.Hotels.Hotels;
import com.proiect.connection.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelRepository {
    private static HotelRepository instance;

    private static final String INSERT_STATEMENT = "INSERT INTO hotel (name,rooms,administrator,phone,levels,stars,city,country) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM hotel";
    private static final String SELECT_STARS = "SELECT * FROM hotel WHERE stars = ?";
    private static final String UPDATE_STATEMENT = "UPDATE hotel SET administrator = ? WHERE name = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM hotel WHERE name= ?";

    private HotelRepository() {
    }

    public static HotelRepository getInstance() {
        if (instance == null) {
            instance = new HotelRepository();
        }

        return instance;
    }

    public void saveHotel(Hotels hotel) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement.setString(1, hotel.getName());
            statement.setInt(2, hotel.getNumberOfrooms());
            statement.setString(3, hotel.getNameAdministrator());
            statement.setString(4, hotel.getNumberPhone());
            statement.setInt(5, hotel.getLevels());
            statement.setInt(6, hotel.getStars());
            statement.setString(7, hotel.getCity().getNameCity());
            statement.setString(8, hotel.getCity().getCountry());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new hotel was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new Hotel: " + e.getMessage());
        }
    }

    public List<Hotels> findHotels() {
        List<Hotels> lista = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Hotels hotel = new Hotels();
                hotel.setName(result.getString("name"));
                hotel.setNumberOfrooms(result.getInt("rooms"));
                hotel.setNameAdministrator(result.getString("administrator"));
                hotel.setNumberPhone(result.getString("phone"));
                hotel.setLevels(result.getInt("levels"));
                hotel.setStars(result.getInt("stars"));
                Cities city = new Cities();
                city.setNameCity(result.getString("city"));
                city.setCountry(result.getString("country"));
                hotel.setCity(city);
                lista.add(hotel);
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find hotel: " + e.getMessage());
        }
        return lista;
    }

    public List<Hotels> findHotelsStars(int stars) {
        List<Hotels> lista = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STARS)) {
            statement.setInt(1, stars);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Hotels hotel = new Hotels();
                hotel.setName(result.getString("name"));
                hotel.setNumberOfrooms(result.getInt("rooms"));
                hotel.setNameAdministrator(result.getString("administrator"));
                hotel.setNumberPhone(result.getString("phone"));
                hotel.setLevels(result.getInt("levels"));
                hotel.setStars(result.getInt("stars"));
                Cities city = new Cities();
                city.setNameCity(result.getString("city"));
                city.setCountry(result.getString("country"));
                hotel.setCity(city);
                lista.add(hotel);
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find hotel: " + e.getMessage());
        }
        return lista;
    }

    public void updateHotel(String administrator, String nume) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setString(1, administrator);
            statement.setString(2, nume);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Hotel administrator was updated successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update hotel administrator: " + e.getMessage());
        }
    }

    public void deleteHotel(String nume) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)) {
            statement.setString(1, nume);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Hotel was deleted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to delete hotel: " + e.getMessage());
        }
    }
}
