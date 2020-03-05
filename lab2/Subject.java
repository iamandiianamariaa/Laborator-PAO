package com.lab2;

public class Subject {
    Room room;
    int noOfStudents;
    Person teacher;

    public Subject(Room r,int n,Person p){
        room=r;
        noOfStudents=n;
        teacher=p;
    }
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }
    public void afis(){
        room.afis();
        System.out.println(noOfStudents+" ");
        teacher.afis();
    }
}
