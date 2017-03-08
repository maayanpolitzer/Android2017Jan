package edu.tomer.java;

public class Main {

    public static void main(String[] args) {

        Animal a1 = new Dog();
        Animal a2 = new Animal(){
            public void makeSound(){
                System.out.println("Anonymous animal sound");
            }
        };

        Predator p1 = new Lion();
        Predator p2 = new Predator(){
            @Override
            public void searchForMeat(){

            }
        };

    }
}
