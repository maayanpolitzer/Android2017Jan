package com.company;

/**
 * Created by hackeru on 29/01/2017.
 */
public class Car {

    private String color;
    private int year;
    private int hand;
    private Person owner;

    public Car(String newColor, int newYear, int newHand, Person newOwner){
        color = newColor;
        year = newYear;
        hand = newHand;
        owner = newOwner;
    }

    public String getDetails(){
        return color + ", " + year + ", " + hand + ", " + owner.getDetails();
    }

    public void switchOwner(Person buyer){
        //if (owner != buyer){
        if (owner.getId() != buyer.getId()){
            owner = buyer;
            hand++;
        }else{
            System.out.println("You are drunk!!! go home");
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String newColor){
        color = newColor;
    }

    public int getYear() {
        return year;
    }

    public int getHand() {
        return hand;
    }

    public Person getOwner() {
        return new Person(owner);   // anti-aliasing...
    }
}
