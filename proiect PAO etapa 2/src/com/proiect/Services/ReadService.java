package com.proiect.Services;

import com.proiect.Cities.Cities;
import com.proiect.Client.ClientDetails;
import com.proiect.Countries.Country;
import com.proiect.Dates.Dates;
import com.proiect.Employee.EmployeeDetails;
import com.proiect.Hotels.Hotels;
import com.proiect.Promo.Promo;
import com.proiect.Reservation.Reservation;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReadService<T> {
    private static final ReadService<?> instance = new ReadService<Object>();
    private static final ArrayList<String> csvList = new ArrayList<>(Arrays.asList(
            "src/files/cities.csv",
            "src/files/clients.csv",
            "src/files/countries.csv",
            "src/files/dates.csv",
            "src/files/employees.csv",
            "src/files/hotels.csv",
            "src/files/promo.csv",
            "src/files/reservations.csv"
    ));
    private ReadService(){}

    public static ReadService<?> getInstance(){
        return instance;
    }

    public static ArrayList<Cities> readCities(){
        String path = csvList.get(0);
        ArrayList<Cities> cities = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(path))) {
            String line = buffer.readLine();
            while (line != null){
                String[] data = line.split(",");
                cities.add(new Cities(data[0], data[1]));
                line=buffer.readLine();
            }
        }
        catch (FileNotFoundException notFound){
            System.out.println("Eroare: FileNotFound");
            notFound.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return cities;
    }

    public static ArrayList<ClientDetails> readClients(){
        String path = csvList.get(1);
        ArrayList<ClientDetails> clients = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(path))) {
            String line = buffer.readLine();
            while (line != null){
                String[] data = line.split(",");
                clients.add(new ClientDetails(data[0], data[1], data[2], data[3],data[4],data[5],data[6]));
                line=buffer.readLine();
            }
        }
        catch (FileNotFoundException notFound){
            System.out.println("Eroare: FileNotFound");
            notFound.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return clients;
    }

    public static Set<Country> readCountries(){
        String path = csvList.get(2);
        Set<Country> countries = new HashSet<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(path))) {
            String line = buffer.readLine();
            while (line != null){
                String[] data = line.split(",");
                ArrayList<Cities> city=new ArrayList<>();
                city.add(new Cities(data[0],data[1]));
                city.add(new Cities(data[0],data[3]));
                countries.add(new Country(data[0], data[1], data[2],city));
                line=buffer.readLine();
            }
        }
        catch (FileNotFoundException notFound){
            System.out.println("Eroare: FileNotFound");
            notFound.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return countries;
    }

    public static Set<Dates> readDates(){
        String path = csvList.get(3);
        Set<Dates> dates = new HashSet<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(path))) {
            String line = buffer.readLine();
            while (line != null){
                String[] data = line.split(",");
                Cities city=new Cities(data[6],data[7]);
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Date databirth = new Date();
                try {

                    databirth = formatter.parse(data[12]);


                } catch (ParseException e) {
                    e.printStackTrace();
                }
                dates.add(new Dates(data[0], Integer.parseInt(data[1]), data[2], data[3],Integer.parseInt(data[4]),Integer.parseInt(data[5]),city,data[8],Integer.parseInt(data[9]),Integer.parseInt(data[10]),data[11],databirth));
                line=buffer.readLine();
            }
        }
        catch (FileNotFoundException notFound){
            System.out.println("Eroare: FileNotFound");
            notFound.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return dates;
    }

    public static ArrayList<EmployeeDetails> readEmployees(){
        String path = csvList.get(4);
        ArrayList<EmployeeDetails> employees = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(path))) {
            String line = buffer.readLine();
            while (line != null){
                String[] data = line.split(",");
                employees.add(new EmployeeDetails(Integer.parseInt(data[0]), data[1], data[2], data[3],data[4],data[5]));
                line=buffer.readLine();
            }
        }
        catch (FileNotFoundException notFound){
            System.out.println("Eroare: FileNotFound");
            notFound.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return employees;
    }

    public static ArrayList<Hotels> readHotels(){
        String path = csvList.get(5);
        ArrayList<Hotels> hotels = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(path))) {
            String line = buffer.readLine();
            while (line != null){
                String[] data = line.split(",");
                Cities city=new Cities(data[6],data[7]);
                hotels.add(new Hotels(data[0], Integer.parseInt(data[1]), data[2], data[3],Integer.parseInt(data[4]),Integer.parseInt(data[5]),city));
                line=buffer.readLine();
            }
        }
        catch (FileNotFoundException notFound){
            System.out.println("Eroare: FileNotFound");
            notFound.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return hotels;
    }

    public static ArrayList<Promo> readPromos(){
        String path = csvList.get(6);
        ArrayList<Promo> promos = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(path))) {
            String line = buffer.readLine();
            while (line != null){
                String[] data = line.split(",");
                Cities city=new Cities(data[6],data[7]);
                promos.add(new Promo(data[0], Integer.parseInt(data[1]), data[2], data[3],Integer.parseInt(data[4]),Integer.parseInt(data[5]),city,data[8],Integer.parseInt(data[9]),Integer.parseInt(data[10])));
                line=buffer.readLine();
            }
        }
        catch (FileNotFoundException notFound){
            System.out.println("Eroare: FileNotFound");
            notFound.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return promos;
    }
    public static ArrayList<Reservation> readReservations(){
        String path = csvList.get(7);
        ArrayList<Reservation> reservations = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(path))) {
            String line = buffer.readLine();
            while (line != null){
                String[] data = line.split(",");
                ClientDetails client=new ClientDetails(data[0],data[1],data[2],data[3],data[4],data[5],data[6]);
                Cities city=new Cities(data[13],data[14]);
                Hotels hotel=new Hotels(data[7],Integer.parseInt(data[8]),data[9],data[10],Integer.parseInt(data[11]),Integer.parseInt(data[12]),city);
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Date dataPlecare = new Date();
                try {

                    dataPlecare = formatter.parse(data[16]);


                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Dates data1=new Dates(data[15],dataPlecare);
                try {

                    dataPlecare = formatter.parse(data[18]);


                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Dates data2=new Dates(data[17],dataPlecare);
                reservations.add(new Reservation(client,hotel,data1,data2));
                line=buffer.readLine();
            }
        }
        catch (FileNotFoundException notFound){
            System.out.println("Eroare: FileNotFound");
            notFound.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return reservations;
    }
}