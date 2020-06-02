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
    private static Set<Dates> perioade = new HashSet<>();
    private static Set<Country> tari = new HashSet<>();
    private static ArrayList<Cities> orase = new ArrayList<>();


    private static void afiseazaMeniu() {
        System.out.println();

        System.out.println("Meniu:");
        System.out.println("0. Exit");
        System.out.println("1. Afiseaza clientii.");
        System.out.println("2. Adauga client.");
        System.out.println("3. Modifica numele clientului.");
        System.out.println("4. Sterge client.");
        System.out.println("5. Afiseaza sejururi.");
        System.out.println("6. Adauga sejur.");
        System.out.println("7. Afiseaza oferte la un pret mai mic decat N lei.");
        System.out.println("8. Modifica pret sejur.");
        System.out.println("9. Sterge sejur.");
        System.out.println("10. Afisare hoteluri.");
        System.out.println("11. Afisare hoteluri de N stele.");
        System.out.println("12. Adauga hotel.");
        System.out.println("13. Modifica nume administrator hotel.");
        System.out.println("14. Sterge hotel.");
        System.out.println("15. Afisare rezervari pentru client.");
        System.out.println("16. Adauga rezervare.");
        System.out.println("17. Modifica telefon client.");
        System.out.println("18. Sterge rezervare.");
        System.out.println("19. Afiseaza angajatii.");
        System.out.println("20. Afiseaza tarile disponibile si orasele.");
        System.out.println("Alege optiune: ");

    }

    public static void main(String[] args) {
        angajati=ReadService.readEmployees();
        orase=ReadService.readCities();
        perioade=ReadService.readDates();
        tari=ReadService.readCountries();

        ClientService clientService =ClientService.getInstance();
        EmployeeService employeeService = new EmployeeService(angajati);
        PromoService promoService = PromoService.getInstance();
        HotelService hotelService = HotelService.getInstance();
        CountryService countryService = new CountryService(tari);
        ReservationService reservationService = ReservationService.getInstance();

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
                    clientService.display(clientService.getClients());
                    auditService.writeLogLine("Afiseaza Clientii");
                    break;
                }
                case 2:{
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
                    clientService.saveClient(clientnou);
                    auditService.writeLogLine("Adauga Client");
                    break;
                }
                case 3: {
                    System.out.print("Introduceti numele clientului: ");
                    Scanner scan = new Scanner(System.in);
                    String nume = scan.nextLine();
                    System.out.print("Introduceti CNP: ");
                    String cnp = scan.nextLine();
                    clientService.updateClient(nume,cnp);
                    auditService.writeLogLine("Modifica nume client");
                    break;
                }
                case 4: {
                    Scanner scan = new Scanner(System.in);
                    System.out.print("Introduceti CNP: ");
                    String cnp = scan.nextLine();
                    clientService.deleteClient(cnp);
                    auditService.writeLogLine("Sterge client");
                    break;
                }
                case 5: {
                    promoService.display(promoService.findPromos());
                    auditService.writeLogLine("Afiseaza sejururi");
                    break;
                }
                case 6: {
                    System.out.print("Introduceti numele hotelului: ");
                    Scanner scan = new Scanner(System.in);
                    String nume = scan.nextLine();
                    System.out.print("Introduceti numarul de camere: ");
                    int nr = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Introduceti numele administratorului: ");
                    String admin = scan.nextLine();
                    System.out.print("Introduceti numarul de telefon: ");
                    String phone = scan.nextLine();

                    System.out.print("Introduceti nr. de etaje: ");
                    int etaje = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Introduceti nr. de stele: ");
                    int stele = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Introduceti orasul: ");
                    String oras = scan.nextLine();
                    System.out.print("Introduceti tara: ");
                    String tara = scan.nextLine();
                    System.out.print("Introduceti tipul vacantei: ");
                    String tip = scan.nextLine();
                    System.out.print("Introduceti pretul: ");
                    int pret = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Introduceti nr. de zile: ");
                    int zile = scan.nextInt();
                    scan.nextLine();
                    Cities city=new Cities(oras,tara);
                    Promo promo = new Promo(nume,nr,admin,phone,etaje,stele,city,tip,pret,zile);
                    promoService.savePromo(promo);
                    auditService.writeLogLine("Adauga sejur");
                    break;
                }
                case 7: {
                    System.out.println("Tastati pretul in lei ");
                    Scanner sc = new Scanner(System.in);
                    int n = sc.nextInt();
                    promoService.display(promoService.findPromoPrice(n));
                    auditService.writeLogLine("Afiseaza ofertele la un pret mai mic decat N lei");
                    break;
                }
                case 8:{
                    System.out.print("Introduceti pretul sejurului: ");
                    Scanner scan = new Scanner(System.in);
                    int pret = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Introduceti numele hotelului: ");
                    String nume = scan.nextLine();
                    promoService.updatePromo(pret,nume);
                    auditService.writeLogLine("Modifica pret sejur");
                    break;
                }
                case 9:{
                    System.out.print("Introduceti numele hotelului: ");
                    Scanner scan = new Scanner(System.in);
                    String nume = scan.nextLine();
                    promoService.deletePromo(nume);
                    auditService.writeLogLine("Sterge sejur");
                    break;
                }
                case 10:{
                    hotelService.display(hotelService.findHotels());
                    auditService.writeLogLine("Afiseaza hoteluri");
                    break;
                }
                case 11:{
                    System.out.println("Tastati numarul de stele ");
                    Scanner sc = new Scanner(System.in);
                    int n = sc.nextInt();
                    hotelService.display(hotelService.findHotelsStars(n));
                    auditService.writeLogLine("Afiseaza hotelurile de N stele");
                    break;
                }
                case 12:{
                    System.out.print("Introduceti numele hotelului: ");
                    Scanner scan = new Scanner(System.in);
                    String nume = scan.nextLine();
                    System.out.print("Introduceti numarul de camere: ");
                    int nr = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Introduceti numele administratorului: ");
                    String admin = scan.nextLine();
                    System.out.print("Introduceti numarul de telefon: ");
                    String phone = scan.nextLine();

                    System.out.print("Introduceti nr. de etaje: ");
                    int etaje = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Introduceti nr. de stele: ");
                    int stele = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Introduceti orasul: ");
                    String oras = scan.nextLine();
                    System.out.print("Introduceti tara: ");
                    String tara = scan.nextLine();
                    Cities city=new Cities(oras,tara);
                    Hotels hotel = new Hotels(nume,nr,admin,phone,etaje,stele,city);
                    hotelService.saveHotel(hotel);
                    auditService.writeLogLine("Adauga hotel");
                    break;
                }
                case 13:{
                    System.out.print("Introduceti numele hotelului: ");
                    Scanner scan = new Scanner(System.in);
                    String nume = scan.nextLine();
                    System.out.print("Introduceti numele administratorului: ");
                    String admin = scan.nextLine();
                    hotelService.updateHotel(admin,nume);
                    auditService.writeLogLine("Modifica nume administrator hotel");
                    break;
                }
                case 14:{
                    System.out.print("Introduceti numele hotelului: ");
                    Scanner scan = new Scanner(System.in);
                    String nume = scan.nextLine();
                    hotelService.deleteHotel(nume);
                    auditService.writeLogLine("Sterge hotel");
                    break;
                }
                case 15:{
                    System.out.print("Introduceti CNP: ");
                    Scanner scan = new Scanner(System.in);
                    String cnp = scan.nextLine();
                    reservationService.display(reservationService.findReservation(cnp));
                    auditService.writeLogLine("Afiseaza rezervari pentru clientul cu CNP");
                    break;
                }
                case 16:{
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
                    System.out.print("Introduceti numele hotelului: ");
                    String name = scan.nextLine();
                    System.out.print("Introduceti numarul de camere: ");
                    int nr = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Introduceti numele administratorului: ");
                    String admin = scan.nextLine();
                    System.out.print("Introduceti numarul de telefon: ");
                    String phone = scan.nextLine();

                    System.out.print("Introduceti nr. de etaje: ");
                    int etaje = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Introduceti nr. de stele: ");
                    int stele = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Introduceti orasul: ");
                    String oras = scan.nextLine();
                    System.out.print("Introduceti tara: ");
                    String tara = scan.nextLine();
                    Cities city=new Cities(oras,tara);
                    Hotels hotel = new Hotels(name,nr,admin,phone,etaje,stele,city);

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
                    Reservation rezervare = new Reservation(clientnou,hotel,arrival,departure);
                    reservationService.saveReservation(rezervare);
                    auditService.writeLogLine("Adauga Rezervare");
                    break;
                }
                case 17: {
                    System.out.print("Introduceti CNP: ");
                    Scanner scan = new Scanner(System.in);
                    String cnp = scan.nextLine();
                    System.out.print("Introduceti telefon: ");
                    String tel = scan.nextLine();
                    reservationService.updateReservation(tel,cnp);
                    auditService.writeLogLine("Modifica telefon client");
                    break;
                }
                case 18:{
                    System.out.print("Introduceti CNP: ");
                    Scanner scan = new Scanner(System.in);
                    String cnp = scan.nextLine();
                    reservationService.deleteReservation(cnp);
                    auditService.writeLogLine("Sterge rezervare");
                    break;
                }
                case 19: {
                    employeeService.display();
                    auditService.writeLogLine("Afiseaza Angajatii");
                    break;
                }
                case 20: {
                    countryService.display();
                    auditService.writeLogLine("Afiseaza tarile disponibile si orasele");
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
