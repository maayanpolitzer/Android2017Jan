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
        if (animalsInside < MAX_CAPACITY) {
            if (animalsInside == 0){
                predator = animal.isPredator();
            }
            animals[animalsInside++] = animal;
        }


    }

    public void print(){
        System.out.println("animalsInside = " + animalsInside);
        for (int i = 0; i < animals.length; i++){
            System.out.println(animals[i]);
        }
    }

}
