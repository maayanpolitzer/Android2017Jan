package edu.tomer;

/**
 * Created by hackeru on 15/02/2017.
 */
public class Animal {

    private static int counter = 0;

    private int id;
    private String type;
    private String name;

    public Animal(String type, String name){
        this.type = type;
        this.name = name;
        id = ++counter;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return name + " the " + type;
    }
}
