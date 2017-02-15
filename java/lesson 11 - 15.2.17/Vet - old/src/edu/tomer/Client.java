package edu.tomer;

import java.util.ArrayList;

/**
 * Created by hackeru on 15/02/2017.
 */
public class Client {

    private static int counter = 0;

    private int id;
    private String name;
    private String phone;
    private boolean ads;
    private ArrayList<Animal> pets;

    public Client(String name, String phone){
        this.name = name;
        this.phone = phone;
        ads = true;
        pets = new ArrayList<>();
        id = ++counter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isAds() {
        return ads;
    }

    public void removeAds(){
        ads = false;
    }

    public void addNewPet(Animal newAnimal){
        pets.add(newAnimal);
    }

    public boolean hasType(String type){
        for (int i = 0; i < pets.size(); i++){
            if (pets.get(i).getType().equals(type)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "[" + id + ":" + name + ", " + phone + ", " + ads + ", " + pets + "]";
    }
}
