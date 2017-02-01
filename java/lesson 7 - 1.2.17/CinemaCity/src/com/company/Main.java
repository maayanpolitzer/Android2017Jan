package com.company;

public class Main {

    public static void main(String[] args) {

        Hall mainHall = new Hall("Spy", 22);
        mainHall.buyTicket();
        mainHall.buyTicket();
        mainHall.buyTicket();
        mainHall.buyTicket(5);
        mainHall.buyTicket(6);
        mainHall.buyTicket(10);
        mainHall.buyTicket(12);
        mainHall.buyTicket(13);
        mainHall.buyTicket(15);
        mainHall.buyTicket(16);
        System.out.println(mainHall.buyGroup(5));
        mainHall.print();


    }
}
