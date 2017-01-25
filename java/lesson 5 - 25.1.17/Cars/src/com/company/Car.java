package com.company;

/**
 * Created by hackeru on 25/01/2017.
 */
public class Car {

    private int wheels;
    private String color;

    public Car(int carWheels, String carColor){
        wheels = carWheels;
        color = carColor;
    }

    public int getWheels(){
        return wheels;
    }

    public void setWheels(int x){
        if (x < 1 || x > 40){
            return;
        }
        wheels = x;
    }

    public String getColor() {
        return color;
    }

}
