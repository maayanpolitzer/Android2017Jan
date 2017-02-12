package edu.tomer;

/**
 * Created by hackeru on 08/02/2017.
 */
public class Zoo {

    private String managerName;
    private Cage[] cages;

    public Zoo(String managerName, int landCages, int aquariums){
        this.managerName = managerName;
        cages = new Cage[landCages + aquariums]; //   {null,null,null,null,null}
        for (int i = 0; i < cages.length; i++){
            cages[i] = new Cage(i >= landCages);
            /*
            if (i < landCages) {
                cages[i] = new Cage(false);
            }else{
                cages[i] = new Cage(true);
            }
            */
        }
    }

    public boolean insertAnimal(Animal animal){
        for (int i = 0; i < cages.length; i++){
            if (!cages[i].isFull() && (animal.isAquatic() == cages[i].isAquatic()) &&
                    (cages[i].isEmpty() || !cages[i].isPredator() && !animal.isPredator() ||
                    animal.isPredator() && animal.getName().equals(cages[i].getFirstAnimal().getName()))
            ){
                cages[i].addAnimal(animal);
                return true;
            }
        }
        System.out.println("There is no free space to " + animal.getName());
        return false;
    }

    public void printZoo(){
        for (int i = 0; i < cages.length; i++){
            cages[i].print();
        }
    }

}
