package edu.tomer;

/**
 * Created by hackeru on 08/02/2017.
 */
public class Cage {

    private static final int MAX_CAPACITY = 5;

    private boolean aquatic;
    private boolean predator;
    private int animalsInside;
    private Animal[] animals;

    public Cage(boolean aquatic){
        this.aquatic = aquatic;
        animalsInside = 0;
        animals = new Animal[MAX_CAPACITY];
    }

    public void addAnimal(Animal animal){
        if (animalsInside == 0){
            predator = animal.isPredator();
        }
        animals[animalsInside++] = animal;
    }

    public Animal getFirstAnimal(){
        return animals[0];
    }

    public void print(){
        System.out.print("Cage aquatic: " + aquatic + ", predator: " + predator + " [");
        for (int i = 0; i < animalsInside; i++){
            System.out.print(animals[i].getName());
            if (i < animalsInside - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public boolean isAquatic() {
        return aquatic;
    }

    public boolean isPredator() {
        return predator;
    }

    public boolean isEmpty(){
        return animalsInside == 0;
    }

    public boolean isFull(){
        return animalsInside == MAX_CAPACITY;
    }
}
