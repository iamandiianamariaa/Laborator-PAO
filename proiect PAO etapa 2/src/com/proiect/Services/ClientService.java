package com.proiect.Services;

import java.util.List;
import com.proiect.Client.ClientDetails;

public class ClientService implements Service {
    private List<ClientDetails> clienti;

    public ClientService(List<ClientDetails> clienti) {
        this.clienti = clienti;
    }


    @Override
    public void display() {
        for (ClientDetails  client : clienti) {
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

    @Override
    public void add(Object o) {
        //CustomerDetails client = (CustomerDetails) o;
        clienti.add((ClientDetails) o);


    }
    @Override
    public void display(int i) {}
    @Override
    public void remove(Object o) {
        clienti.remove(o);
    }

    @Override
    public void remove(int i) {
        clienti.remove(i);
    }

}

