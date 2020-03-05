package com.lab2;

public class Person {
    private String name;
    private String surname;
    private int age;
    private String idNo;
    private String type;

    public Person() {
        type = "student";
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getIdNo() {
        return idNo;
    }

    public String getType() {
        return type;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean changeType() {
        boolean changed = false;
        if (type.equals("teacher")) {
            type = "doctor";
            changed = true;
        }
        return changed;
    }
    public void afis(){
        System.out.println(name+" "+surname+" "+age+" "+idNo+" "+type);
    }
}
