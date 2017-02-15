package edu.tomer;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Animal> animals = new ArrayList<>();

        Animal a1 = new Cat();
        animals.add(a1);


        Animal d1 = new Dog();
        animals.add(d1);


        for (int i = 0; i < animals.size(); i++){
            Animal a = animals.get(i);
            a.makeSound();
            if (a instanceof Dog) {
                Dog d = (Dog) a;
                System.out.println(d.getOwner());
            }
        }


    }
}
