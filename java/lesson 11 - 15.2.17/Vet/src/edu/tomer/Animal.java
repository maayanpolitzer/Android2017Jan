package edu.tomer;

/**
 * Created by hackeru on 15/02/2017.
 */
public class Animal {

    private static int counter = 0;

    private int id;

    public Animal(){
        id = ++counter;
    }

}
