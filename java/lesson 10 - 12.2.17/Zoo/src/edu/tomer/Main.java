package edu.tomer;

import java.util.Random;

public class Main {

    public static Animal[] animals = {
            new Animal("Lion", true, false),
            new Animal("Shark", true, true),
            new Animal("Sheep", false, false),
            new Animal("Tiger", true, false),
            new Animal("Giraffe", false, false),
            new Animal("Gold fish", false, true),
            new Animal("Monkey", false, false)
    };

    public static Random random = new Random();

    public static void main(String[] args) {

        Zoo zoo = new Zoo("Maayan", 3, 2);

        for (int i = 0; i < 15; i++){
            zoo.insertAnimal(animals[random.nextInt(animals.length)]);
        }

        zoo.printZoo();
    }
}
