package edu.tomer.java;

/**
 * Created by hackeru on 05/03/2017.
 */
public class PenneAlfredo extends Dish{

    public PenneAlfredo(double price, int calories){
        super("Penne alfredo", true, price, calories);
    }

    @Override
    public String toString() {
        return "DAIRY PENNE ALFREDO";
    }
}
