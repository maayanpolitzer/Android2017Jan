package com.company;

/**
 * Created by hackeru on 29/01/2017.
 */

public class Person {

    private static int counter; // default is 0;

    private int id; // default is 0;
    private String name;    // default is null;
    private String address; // default is null;

    /*
    public Person(){
        // default constructor;
    }
    */

    public Person(String newName, String newAddress){
        name = newName; // setName(newName);
        address = newAddress;
        id = ++counter;
    }

    // copy constructor.
    public Person(Person p){
        name = p.getName();
        address = p.getAddress();
        id = p.getId();
    }

    public String getDetails(){
        return id + ", " + name + ", " + address;
    }

    public static void setCounter(int newCounter){
        counter = newCounter;
    }

    public static int getCounter(){
        return counter;
    }

    public void setName(String newName){
        name = newName;
    }

    public void setAddress(String newAddress){
        address = newAddress;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public int getId(){
        return id;
    }

}
