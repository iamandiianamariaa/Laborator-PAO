package com.proiect;

import com.proiect.Dates.Dates;
import com.proiect.Hotels.Hotels;
import com.proiect.Cities.Cities;
import com.proiect.Employee.EmployeeDetails;
import com.proiect.Reservation.Reservation;
import com.proiect.Promo.Promo;
import com.proiect.Countries.Country;
import com.proiect.Services.*;
import com.proiect.Client.ClientDetails;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    private static List<EmployeeDetails> angajati = new ArrayList<>();
    private static List<ClientDetails> clienti = new ArrayList<>();
    private static List<Promo> sejururi = new ArrayList<>();
    private static List<Hotels> hoteluri = new ArrayList<>();
    private static Set<Dates> perioade = new HashSet<>();
    private static List<Reservation> rezervari = new ArrayList<>();
    private static Set<Country> tari = new HashSet<>();
    private static ArrayList<Cities> orase = new ArrayList<>();


    private static void afiseazaMeniu() {
        System.out.println();

        System.out.println("Meniu:");
        System.out.println("0. Exit");
        System.out.println("1. Afiseaza clientii.");
        System.out.println("2. Afiseaza angajatii.");
        System.out.println("3. Afiseaza hoteluri.");
        System.out.println("4. Afiseaza sejururi.");
        System.out.println("5. Afiseaza hoteluri de N stele.");
        System.out.println("6. Afiseaza tarile disponibile si orasele.");
        System.out.println("7. Afiseaza oferte la un pret mai mic decat N lei.");
        System.out.println("8. Adauga rezervare.");
        System.out.println("9. Modifica rezervare.");
        System.out.println("10. Sterge rezervare.");
        System.out.println("11. Adauga client.");
        System.out.println("Alege optiune: ");

    }

    public static void main(String[] args) {
        clienti=ReadService.readClients();
        angajati=ReadService.readEmployees();
        sejururi=ReadService.readPromos();
        hoteluri=ReadService.readHotels();
        orase=ReadService.readCities();
        perioade=ReadService.readDates();
        tari=ReadService.readCountries();
        perioade=ReadService.readDates();
        rezervari=ReadService.readReservations();

        ClientService clientService = new ClientService(clienti);
        EmployeeService employeeService = new EmployeeService(angajati);
        PromoService promoService = new PromoService(sejururi);
        HotelService hotelService = new HotelService(hoteluri);
        CountryService countryService = new CountryService(tari);
        ReservationService reservationService = new ReservationService(rezervari);

        AuditService auditService = AuditService.getInstance();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int optiune = 0;
        afiseazaMeniu();
        try {
            optiune = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            System.err.println("Eroare la citire/deschidere de fisier!");
        }
        while (optiune != 0) {
            switch (optiune) {
                case 1: {
                    clientService.display();
                    auditService.writeLogLine("Afiseaza Clientii");
                    break;
                }
                case 2: {
                    employeeService.display();
                    auditService.writeLogLine("Afiseaza Angajatii");
                    break;
                }
                case 3: {
                    hotelService.display();
                    auditService.writeLogLine("Afiseaza Hotelurile");
                    break;
                }
                case 4: {
                    promoService.display();
                    auditService.writeLogLine("Afiseaza Sejururile");
                    break;
                }
                case 5: {
                    int i;
                    System.out.println("Numarul de stele dorit:");
                    Scanner sc = new Scanner(System.in);
                    int n = sc.nextInt();
                    for (i = 0; i < hoteluri.size(); i++)
                        if (hoteluri.get(i).getStars() == n)
                            hotelService.display(i);
                    auditService.writeLogLine("Afiseaza hoteluri de n stele");
                    break;
                }
                case 6: {
                    countryService.display();
                    auditService.writeLogLine("Afiseaza tarile disponibile si orasele");
                    break;
                }
                case 7: {
                    int i;
                    System.out.println("Tastati pretul in lei ");
                    Scanner sc = new Scanner(System.in);
                    int n = sc.nextInt();
                    for (i = 0; i < sejururi.size(); i++)
                        if (sejururi.get(i).getPrice() <= n)
                            promoService.display(i);
                    auditService.writeLogLine("Afiseaza ofertele la un pret mai mic decat N lei");
                    break;
                }
                case 8: {
                    System.out.print("Introduceti numele clientului: ");
                    Scanner scan = new Scanner(System.in);
                    String nume = scan.nextLine();
                    System.out.print("Introduceti prenumele clientului: ");
                    String prenume = scan.nextLine();
                    System.out.print("Introduceti CNP: ");
                    String cnp = scan.nextLine();
                    System.out.print("Introduceti data nasterii: ");
                    String datan = scan.nextLine();

                    System.out.print("Introduceti locatie: ");
                    String locatie = scan.nextLine();
                    System.out.print("Introduceti adresa de email: ");
                    String adresaemail = scan.nextLine();
                    System.out.print("Introduceti numar de telefon: ");
                    String nrtelefon = scan.nextLine();

                    ClientDetails clientnou = new ClientDetails(locatie, cnp, datan, adresaemail, nrtelefon, nume, prenume);
                    hotelService.display();
                    System.out.print("Alegeti hotelul din lista si introduceti nr.: ");
                    int n = scan.nextInt();
                    scan.nextLine();

                    System.out.print("Introduceti sezonul in care mergeti si data de sosire ");
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    String sezon = scan.nextLine();
                    String dataa = scan.nextLine();
                    Date sosire = new Date();
                    try {

                        sosire = formatter.parse(dataa);


                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    Dates arrival = new Dates(sezon,sosire);
                    System.out.print("Introduceti sezonul in care va intoarceti si data de plecare: ");
                    String sezonPlecare = scan.nextLine();
                    String data = scan.nextLine();
                    Date plecare = new Date();
                    try {

                        plecare = formatter.parse(data);


                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Dates departure = new Dates(sezonPlecare,plecare);
                    Reservation rezervare = new Reservation(clientnou,hoteluri.get(n-1),arrival,departure);
                    rezervari.add(rezervare);
                    reservationService.display();
                    WriteService.scrieCsv("src/files/reservations.csv",new String[]{nume,prenume,cnp,datan,locatie,adresaemail,nrtelefon,hoteluri.get(n-1).getName(),
                            String.valueOf(hoteluri.get(n-1).getNumberOfrooms()),hoteluri.get(n-1).getNameAdministrator(),hoteluri.get(n-1).getNumberPhone(),String.valueOf(hoteluri.get(n-1).getLevels()),
                            String.valueOf(hoteluri.get(n-1).getStars()),hoteluri.get(n-1).getCity().getNameCity(),hoteluri.get(n-1).getCity().getCountry(),sezon,dataa,sezonPlecare,data});
                    auditService.writeLogLine("Adauga Rezervare");
                    break;
                }
                case 9: {
                    System.out.print("Introduceti CNP: ");
                    Scanner scan = new Scanner(System.in);
                    String cnp = scan.nextLine();
                    int i,index=0;
                    for (i = 0; i < rezervari.size(); i++)
                        if (rezervari.get(i).getClient().getCnp().equals(cnp))
                            index=i;
                    System.out.print("Introduceti sezonul in care mergeti si data de sosire ");
                    String sezon = scan.nextLine();
                    String dataa = scan.nextLine();
                    Date sosire = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    try {

                        sosire = formatter.parse(dataa);


                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    Dates arrival = new Dates(sezon,sosire);
                    System.out.print("Introduceti sezonul in care va intoarceti si data de plecare: ");
                    sezon = scan.nextLine();
                    dataa = scan.nextLine();
                    Date plecare = new Date();
                    try {

                        plecare = formatter.parse(dataa);


                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Dates departure = new Dates(sezon,plecare);
                    rezervari.get(index).setArrival(arrival);
                    rezervari.get(index).setDeparture(departure);
                    reservationService.display();
                    auditService.writeLogLine("Modifica Rezervare");
                    break;
                }
                case 10: {
                    System.out.print("Introduceti CNP: ");
                    Scanner scan = new Scanner(System.in);
                    String cnp = scan.nextLine();
                    int i,index=0;
                    for (i = 0; i < rezervari.size(); i++)
                        if (rezervari.get(i).getClient().getCnp().equals(cnp))
                            index=i;
                    rezervari.remove(index);
                    reservationService.display();
                    auditService.writeLogLine("Sterge Rezervare");
                    break;
                }
                case 11:{
                    System.out.print("Introduceti numele clientului: ");
                    Scanner scan = new Scanner(System.in);
                    String nume = scan.nextLine();
                    System.out.print("Introduceti prenumele clientului: ");
                    String prenume = scan.nextLine();
                    System.out.print("Introduceti CNP: ");
                    String cnp = scan.nextLine();
                    System.out.print("Introduceti data nasterii: ");
                    String data = scan.nextLine();

                    System.out.print("Introduceti locatie: ");
                    String locatie = scan.nextLine();
                    System.out.print("Introduceti adresa de email: ");
                    String adresaemail = scan.nextLine();
                    System.out.print("Introduceti numar de telefon: ");
                    String nrtelefon = scan.nextLine();

                    ClientDetails clientnou = new ClientDetails(locatie, cnp, data, adresaemail, nrtelefon, nume, prenume);
                    clienti.add(clientnou);
                    WriteService.scrieCsv("src/files/clients.csv",new String[]{locatie,cnp,data,adresaemail,nrtelefon,nume,prenume});
                    auditService.writeLogLine("Adauga Client");
                    break;
                }

                default: {
                    System.out.println("Ati ales o optiune care exista in meniu");
                    break;
                }
            }
            try {
                System.out.println();
                System.out.println("Apasati enter pentru a continua");
                bufferedReader.readLine();
            } catch (IOException e) {
                System.err.println("Eroare la citire/deschidere de fisier!");
            }


            try {
                afiseazaMeniu();
                optiune = Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                System.err.println("Eroare la citire/deschidere de fisier!");
            }
        }
    }
}
