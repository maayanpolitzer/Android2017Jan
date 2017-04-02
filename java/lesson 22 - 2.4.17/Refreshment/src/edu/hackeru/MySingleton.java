package edu.hackeru;

/**
 * Created by hackeru on 02/04/2017.
 */
public class MySingleton {

    private static MySingleton instance;    // our only one object.
    private String level;
    private int speed;

    private MySingleton(){

    }

    public static MySingleton getInstance(){
        if (instance == null){
            instance = new MySingleton();
        }
        return instance;
    }



}
