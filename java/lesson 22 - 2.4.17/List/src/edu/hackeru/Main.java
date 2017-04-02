package edu.hackeru;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Maayan");
        arrayList.add("Yossi");
        arrayList.add("Moshe");
        arrayList.add("Shani");

        arrayList.remove(2);

        arrayList.get(1);

        arrayList.add(1, "Dani");

        /****************************************/

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Maayan");
        linkedList.add("Yossi");
        linkedList.add("Moshe");
        linkedList.add("Shani");

        linkedList.remove(2);

        linkedList.get(1);

        linkedList.add(1, "Dani");

        /***************************************/

        Vector<String> vector = new Vector<>();
        vector.add("Maayan");
        vector.add("Yossi");
        vector.add("Moshe");
        vector.add("Shani");

        vector.remove(2);

        vector.get(1);

        vector.add(1, "Dani");
    }
}
