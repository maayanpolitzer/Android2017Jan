package com.company;



public class Main {

    public static void main(String[] args) {

        Car c1; // null;
        c1 = new Car(4, "PINK");
        Car c2 = new Car(6, "grey");

        System.out.println(c1.getWheels());
        System.out.println(c1.getColor());

        c1.setWheels(32);
        System.out.println(c1.getWheels());


    }
}
