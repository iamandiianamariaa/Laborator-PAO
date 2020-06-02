package com.proiect.persistance;

import com.proiect.Cities.Cities;
import com.proiect.Hotels.Hotels;
import com.proiect.Promo.Promo;
import com.proiect.connection.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PromoRepository {
    private static PromoRepository instance;

    private static final String INSERT_STATEMENT = "INSERT INTO promo (name,rooms,administrator,phone,levels,stars,city,country,boardtype,price,days) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM promo";
    private static final String SELECT_PRICE = "SELECT * FROM promo WHERE price < ?";
    private static final String UPDATE_STATEMENT = "UPDATE promo SET price = ? WHERE name = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM promo WHERE name= ?";

    private PromoRepository() {
    }

    public static PromoRepository getInstance() {
        if (instance == null) {
            instance = new PromoRepository();
        }

        return instance;
    }

    public void savePromo(Promo promo) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement.setString(1, promo.getName());
            statement.setInt(2, promo.getNumberOfrooms());
            statement.setString(3, promo.getNameAdministrator());
            statement.setString(4, promo.getNumberPhone());
            statement.setInt(5, promo.getLevels());
            statement.setInt(6, promo.getStars());
            statement.setString(7, promo.getCity().getNameCity());
            statement.setString(8, promo.getCity().getCountry());
            statement.setString(9, promo.getBoardTypes());
            statement.setInt(10, promo.getPrice());
            statement.setInt(11, promo.getNumberOfdays());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new promo was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new promo: " + e.getMessage());
        }
    }

    public List<Promo> findPromos() {
        List<Promo> lista = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
                ResultSet result = statement.executeQuery();
                while (result.next()) {
                    Promo promo = new Promo();
                    promo.setName(result.getString("name"));
                    promo.setNumberOfrooms(result.getInt("rooms"));
                    promo.setNameAdministrator(result.getString("administrator"));
                    promo.setNumberPhone(result.getString("phone"));
                    promo.setLevels(result.getInt("levels"));
                    promo.setStars(result.getInt("stars"));
                    Cities city = new Cities();
                    city.setNameCity(result.getString("city"));
                    city.setCountry(result.getString("country"));
                    promo.setCity(city);
                    promo.setBoardTypes(result.getString("boardtype"));
                    promo.setPrice(result.getInt("price"));
                    promo.setNumberOfdays(result.getInt("days"));
                    lista.add(promo);
                }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find user: " + e.getMessage());
        }
        return lista;
    }
    public List<Promo> findPromoPrice(int price) {
        List<Promo> lista = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_PRICE)) {
            statement.setInt(1, price);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Promo promo = new Promo();
                promo.setName(result.getString("name"));
                promo.setNumberOfrooms(result.getInt("rooms"));
                promo.setNameAdministrator(result.getString("administrator"));
                promo.setNumberPhone(result.getString("phone"));
                promo.setLevels(result.getInt("levels"));
                promo.setStars(result.getInt("stars"));
                Cities city = new Cities();
                city.setNameCity(result.getString("city"));
                city.setCountry(result.getString("country"));
                promo.setCity(city);
                promo.setBoardTypes(result.getString("boardtype"));
                promo.setPrice(result.getInt("price"));
                promo.setNumberOfdays(result.getInt("days"));
                lista.add(promo);
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find promo: " + e.getMessage());
        }
        return lista;
    }

    public void updatePromo(int price, String name) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setInt(1, price);
            statement.setString(2, name);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Promo price was updated successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update promo price: " + e.getMessage());
        }
    }

    public void deletePromo(String name) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)) {
            statement.setString(1, name);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Promo was deleted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to delete promo: " + e.getMessage());
        }
    }
}
