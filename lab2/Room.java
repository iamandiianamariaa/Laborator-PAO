package com.lab2;

public class Room {
    String number;
    String type;
    int floor;
    public Room(String number,String type,int floor){
        this.number=number;
        this.type=type;
        this.floor=floor;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
    public void afis(){
        System.out.println(number+" "+type+" "+floor);
    }
}
