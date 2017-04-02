package edu.hackeru;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        HashSet<Person> names = new HashSet<>();
        names.add(new Person("Maayan"));    // 6
        names.add(new Person("Yossi"));     // -400005
        names.add(new Person("Gabriel"));   // 7
        names.add(new Person("Dani"));      // 4
        names.add(new Person("Ofira"));     // 1500
        names.add(new Person("Maayan"));    // 6
        names.add(new Person("Shani"));     // 5
        names.add(new Person("Shanj"));     // 5

        System.out.println(names);

    }
}
