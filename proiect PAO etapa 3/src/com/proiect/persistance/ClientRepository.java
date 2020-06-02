package com.proiect.persistance;

import com.proiect.Client.ClientDetails;
import com.proiect.connection.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    private static ClientRepository instance;

    private static final String INSERT_STATEMENT = "INSERT INTO client (location,cnp,birthdate,email,phone,nume,prenume) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM client";
    private static final String UPDATE_STATEMENT = "UPDATE client SET nume = ? WHERE cnp = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM client WHERE cnp=?";

    private ClientRepository() {
    }

    public static ClientRepository getInstance() {
        if (instance == null) {
            instance = new ClientRepository();
        }

        return instance;
    }

    public void saveClient(ClientDetails client) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement.setString(1, client.getLocation());
            statement.setString(2, client.getCnp());
            statement.setString(3, client.getDateOfBirth());
            statement.setString(4, client.getEmailAddress());
            statement.setString(5, client.getPhoneNumber());
            statement.setString(6, client.getNameclient());
            statement.setString(7, client.getPren());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Client was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new client: " + e.getMessage());
        }
    }

    public List<ClientDetails> getClients() {
        List<ClientDetails> lista = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
                ResultSet result = statement.executeQuery();
                while (result.next()) {
                    ClientDetails client = new ClientDetails();
                    client.setLocation(result.getString("location"));
                    client.setCnp(result.getString("cnp"));
                    client.setDateOfBirth(result.getString("birthdate"));
                    client.setEmailAddress(result.getString("email"));
                    client.setPhoneNumber(result.getString("phone"));
                    client.setNameclient(result.getString("nume"));
                    client.setPren(result.getString("prenume"));
                    lista.add(client);
                }
            }
        catch (SQLException e) {
            System.out.println("Something went wrong when trying to find user: " + e.getMessage());
        }
        return lista;
    }

    public void updateClient(String nume, String cnp) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setString(1, nume);
            statement.setString(2, cnp);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Client was updated successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update client: " + e.getMessage());
        }
    }

    public void deleteClient(String cnp) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)) {
            statement.setString(1, cnp);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Client was deleted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to delete client: " + e.getMessage());
        }
    }
}
