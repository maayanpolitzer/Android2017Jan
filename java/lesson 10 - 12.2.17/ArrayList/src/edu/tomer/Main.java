package edu.tomer;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String[] names = new String[4];
        int length = names.length;  // array length...
        names[1] = "Maayan";
        //System.out.println(names[3]);

        ArrayList<String> list = new ArrayList<>();
        list.add("Moshe");
        list.add("Shani");
        list.add("Roni");
        list.add("Omri");
        list.set(1, "Shawn");
        System.out.println(list.size());
        System.out.println(list.get(1));
        System.out.println(list);
        System.out.println(list.isEmpty());
        list.add(2, "Gabriel");
        System.out.println(list);
        //list.clear();
        //System.out.println(list.isEmpty());
        list.remove(1);
        list.add("Moshe");
        list.remove("Moshe");
        System.out.println(list);

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
