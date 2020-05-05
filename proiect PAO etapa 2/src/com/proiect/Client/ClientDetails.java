package com.proiect.Client;

import java.util.Date;

public class ClientDetails {
    private String location;
    private String cnp;
    private String dateOfBirth;
    private String emailAddress;
    private String phoneNumber;
    private String nameclient;
    private String pren;

    public ClientDetails(String location, String cnp, String dateOfBirth, String emailAddress, String phoneNumber, String nameclient, String pren) {
        this.location = location;
        this.cnp = cnp;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress=emailAddress;
        this.phoneNumber=phoneNumber;
        this.nameclient=nameclient;
        this.pren=pren;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNameclient() {
        return nameclient;
    }

    public void setNameclient(String nameclient) {
        this.nameclient = nameclient;
    }

    public String getPren() {
        return pren;
    }

    public void setPren(String pren) {
        this.pren = pren;
    }

    public void afisareInfoClient() {

        System.out.println("Nume: " + nameclient + "\nData nasterii: " + dateOfBirth +  "\nAdresa: " + location +"\nCNP : " + cnp);

    }
}

