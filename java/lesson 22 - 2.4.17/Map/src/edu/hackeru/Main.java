package edu.hackeru;

import java.util.HashMap;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        HashMap<String, Double> map = new HashMap<>();

        map.put("Apple", 9.9);
        map.put("Banana", 14.9);
        map.put("Orange", 8.9);

        map.put("Apple", 5.9);

        System.out.println(map.get("Orange"));

        Set<String> keys = map.keySet();

        for (String key : keys){
            System.out.println(key + " : " + map.get(key));
        }

        //System.out.println(map);


    }
}
