package com.company;

public class Main {

    public static void main(String[] args) {

        Person p1 = new Person("Maayan", "Herzeliya");
        Person p2 = new Person("Irit", "Ramat hasharon");
        Person p3 = new Person("Itay", "Tzur yitzhak");

        Car c1 = new Car("Pink", 2004, 2, p1);

        //System.out.println(c1.getOwner().getAddress());
        p1.setAddress("Eilat");
        c1.getOwner().setAddress("Tel aviv");   // won't change anything...
        //System.out.println(c1.getOwner().getAddress());

        System.out.println(c1.getDetails());
        c1.switchOwner(p1);
        System.out.println(c1.getDetails());
        //System.out.println(p1.getDetails());
        //System.out.println(p2.getDetails());

        /*
        System.out.println(p1.getName());
        p1.setName("Eli");
        System.out.println(p1.getName());
        System.out.println(p2.getName());
        System.out.println(p3.getName());
        */

    }
}
