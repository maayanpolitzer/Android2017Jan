package com.company;

/**
 * Created by hackeru on 22/01/2017.
 */
public class Main {

    public static void main(String[] args){

        Vehicle v1 = new Vehicle("Pink", "BMW", 1999);
        Vehicle v2 = new Vehicle("Green", "FIAT", 2004);

        System.out.println(v1.getDetails());
        System.out.println(v2.getDetails());

        Vehicle.manager = "Shani";
        System.out.println(Vehicle.manager);

        v1.color = "Yellow";
        System.out.println(v1.getDetails());

    }

}