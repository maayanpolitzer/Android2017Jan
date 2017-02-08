package edu.tomer;

/**
 * Created by hackeru on 08/02/2017.
 */
public class Animal {

    private String name;
    private boolean predator;
    private boolean aquatic;

    public Animal(String name, boolean predator, boolean aquatic){
        this.name = name;
        this.predator = predator;
        this.aquatic = aquatic;
    }

    public String getDetails(){
        return name + ", predator: " + predator + ", aqua: " + aquatic;
    }

}
