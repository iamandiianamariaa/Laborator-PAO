package com.proiect.Services;

import com.proiect.Client.ClientDetails;
import com.proiect.persistance.ClientRepository;

import java.util.List;

public class ClientService{
    private static ClientService instance;

    private final ClientRepository userRepository = ClientRepository.getInstance();

    private ClientService() {
    }

    public static ClientService getInstance() {
        if (instance == null) {
            instance = new ClientService();
        }

        return instance;
    }

    public void saveClient(ClientDetails client) {
        userRepository.saveClient(client);
    }

    public List<ClientDetails> getClients() {
        return userRepository.getClients();
    }

    public void updateClient(String nume, String cnp) {
        userRepository.updateClient(nume,cnp);
    }

    public void deleteClient(String cnp) {
        userRepository.deleteClient(cnp);
    }
    public void display(List<ClientDetails> l){
        for (ClientDetails  client : l) {
            System.out.println("Nume client:");
            System.out.println(client.getPren());
            System.out.println(client.getNameclient());
            System.out.println("CNP:");
            System.out.println(client.getCnp());
            System.out.println("Data nasterii:");
            System.out.println(client.getDateOfBirth());
            System.out.println("Oras:");
            System.out.println(client.getLocation());
            System.out.println("Email:");
            System.out.println(client.getEmailAddress());
            System.out.println("Nr. Telefon:");
            System.out.println(client.getPhoneNumber());

        }
    }
}

