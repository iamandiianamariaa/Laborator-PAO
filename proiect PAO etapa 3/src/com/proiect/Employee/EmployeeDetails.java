package com.proiect.Employee;


public class EmployeeDetails {
    private int Salary;
    private String function;
    private String department;
    private String cnp;
    private String DateOfBirth;
    private String name;


    public EmployeeDetails(int Salary, String function, String department, String cnp, String DateOfBirth, String name) {
        this.Salary = Salary;
        this.function = function;
        this.cnp = cnp;
        this.department = department;
        this.DateOfBirth = DateOfBirth;
        this.name=name;

    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void afisareInfo() {

        System.out.println("Nume: " + name + "\nData: " + DateOfBirth + "\nSalariu: " + Salary + "\nDepartament: " + department + "\nFunctie: " + function);

    }
}