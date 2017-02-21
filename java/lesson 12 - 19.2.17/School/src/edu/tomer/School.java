package edu.tomer;

import java.util.ArrayList;

/**
 * Created by hackeru on 19/02/2017.
 */
public class School {

    private ArrayList<Person> people;

    public School(){
        people = new ArrayList<>();
    }

    public void addPerson(Person p){
        people.add(p);
    }

    public void staffMeeting(){
        int counter = 0;
        for (int i = 0; i < people.size(); i++){
            if (people.get(i) instanceof Employee){
                Employee e = (Employee) people.get(i);
                System.out.println(e.getPhone());
                counter++;
            }
        }
        System.out.println(counter);
    }

    public void displayNames(){
        for (int i = 0; i < people.size(); i++){
            System.out.println(people.get(i).getName());
        }
    }

    public void teachersMeeting(){
        int counter = 0;
        for (int i = 0; i < people.size(); i++){
            if (people.get(i) instanceof Teacher){
                counter++;
            }
        }
        System.out.println(counter);
    }

}
