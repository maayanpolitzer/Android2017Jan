package com.company;

/**
 * Created by hackeru on 22/01/2017.
 */
public class Vehicle {

    public static String name = "Maayan's car factory";
    public static int employeeAmount = 40;
    public static String manager = "Maayan";

    public int year;
    public String brand;
    public String color;

    // constructor!
    public Vehicle(String myColor, String myBrand, int myYear){
        year = myYear;
        color = myColor;
        brand = myBrand;
    }

    public String getDetails(){
        return "Year: " + year + ", brand: " + brand + ", color: " + color;
    }

}
