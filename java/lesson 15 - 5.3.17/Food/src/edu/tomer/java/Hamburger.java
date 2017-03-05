package edu.tomer.java;

/**
 * Created by hackeru on 05/03/2017.
 */
public class Hamburger extends Dish {

    private String topping;

    public Hamburger(double price, int calories, String topping){
        super("Hamburger", false, price, calories);
        this.topping = topping;
    }

    public String getTopping() {
        return topping;
    }

    @Override
    public void setTimeToPrepare(int seconds) {

    }

    @Override
    public String toString() {
        return "HAMBURGER!!!";
    }
}
