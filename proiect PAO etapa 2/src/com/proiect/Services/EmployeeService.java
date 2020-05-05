package com.proiect.Services;

import java.util.List;
import com.proiect.Employee.EmployeeDetails;

public class EmployeeService implements Service {
    private List<EmployeeDetails> angajati;

    public EmployeeService(List<EmployeeDetails> angajati) {
        this.angajati = angajati;
    }
    @Override
    public void display() {
        for (EmployeeDetails angajat : angajati) {
            System.out.println("Nume angajat:");
            System.out.println(angajat.getName());
            System.out.println("CNP:");
            System.out.println(angajat.getCnp());
            System.out.println("Functie:");
            System.out.println(angajat.getFunction());
            System.out.println("Departament:");
            System.out.println(angajat.getDepartment());
            System.out.println("Data nasterii:");
            System.out.println(angajat.getDateOfBirth());
            System.out.println("Salariu:");
            System.out.println(angajat.getSalary());
        }

    }

    @Override
    public void add(Object o) {
        angajati.add((EmployeeDetails) o);

    }
    @Override
    public void display(int i) {}
    @Override
    public void remove(Object o) {angajati.remove(o);

    }

    @Override
    public void remove(int i) {
        angajati.remove(i);
    }


}
