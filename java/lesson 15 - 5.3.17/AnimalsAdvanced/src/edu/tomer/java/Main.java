package edu.tomer.java;

public class Main {

    public static void main(String[] args) {

        Animal[] animals = {
                new Giraffe(),
                new Lion(),
                new Lizard()
        };

        for (int i = 0; i < animals.length; i++){
            if (animals[i] instanceof Predator){
                ((Predator)animals[i]).searchForMeat();
            }
        }


    }
}
