package edu.tomer.java;

/**
 * Created by hackeru on 05/03/2017.
 */
public abstract class Dish {

    private String name;
    private boolean dairy;
    private double price;
    private int calories;
    private int timeToPrepare;

    public abstract void setTimeToPrepare(int seconds);

    public Dish(String name, boolean dairy, double price, int calories) {
        this.name = name;
        this.dairy = dairy;
        this.price = price;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCalories() {
        return calories;
    }

    public boolean isDairy() {
        return dairy;
    }

    @Override
    public String toString() {
        return name + ", cals: " + calories + ", dairy: " + dairy + ", price: " + price;
    }
}
