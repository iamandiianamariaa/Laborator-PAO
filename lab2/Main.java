package com.lab2;

public class Main {

    public static void main(String[] args) {
        Person p1 = new Person ();
        p1.setName ("John");
        p1.setSurname ("Doe");
        p1.setAge (24);
        p1.setIdNo ("1123444");
        p1.setType ("student");

        Person p2 = new Person ();
        p2.setName ("Jane");
        p2.setSurname ("Roe");
        p2.setAge (56);
        p2.setIdNo ("22333444");
        p2.setType ("teacher");

        System.out.println (p1.getName () + " " + p1.getSurname () + " " + p1.getAge () + " " + p1.getIdNo () + " " + p1.getType ());
        System.out.println (p2.getName () + " " + p2.getSurname () + " " + p2.getAge () + " " + p2.getIdNo () + " " + p2.getType ());

        //System.out.println (p2.getType ());
        //p2.changeType ();

        Room r1=new Room("12A","normal",3);
        Room r2=new Room("12B","tech",7);
        System.out.println (r1.getNumber () + " " + r1.getType () + " " + r1.getFloor () );
        System.out.println (r2.getNumber () + " " + r2.getType() + " " + r2.getFloor() );

        Subject s1=new Subject(r1,20,p1);
        Subject s2=new Subject(r2,30,p2);

        s1.afis();
        s2.afis();
    }
}
