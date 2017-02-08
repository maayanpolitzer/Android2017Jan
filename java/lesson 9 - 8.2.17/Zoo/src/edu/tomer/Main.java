package edu.tomer;

public class Main {

    public static void main(String[] args) {

        Animal a1 = new Animal("Tiger", true, false);
        Cage c1 = new Cage(false);
        c1.addAnimal(a1);
        c1.addAnimal(a1);
        c1.addAnimal(a1);
        c1.addAnimal(a1);
        c1.addAnimal(a1);
        c1.addAnimal(a1);
        c1.addAnimal(a1);
        c1.addAnimal(a1);
        c1.addAnimal(a1);
        c1.print();

        zoo.insertNewAnimal(new Animal("Sheep", false, false));


    }
}
