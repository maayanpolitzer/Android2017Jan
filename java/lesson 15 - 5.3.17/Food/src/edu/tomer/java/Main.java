package edu.tomer.java;

public class Main {

    public static void main(String[] args) {

        Dish[] dishes = new Dish[3];
        dishes[0] = new Hamburger(49.9, 1400, "Egg");
        dishes[1] = new PenneAlfredo(32.9, 1200);
        dishes[2] = new Hamburger(56.9, 1600,  "Duck breast");

        for (int i = 0; i < dishes.length; i++){
            if (dishes[i] instanceof Hamburger){
                /*
                Hamburger h = (Hamburger) dishes[i];
                System.out.println(h.getTopping());
                */
                System.out.println(((Hamburger) dishes[i]).getTopping());
            }
        }
    }
}
