package edu.hackeru;

public class Main {
/*
    private static String[] names;

    static {
        names = new String[]{"Maayan", "Yossi", "Roni"};
    }
*/
    public static void main(String[] args) {

        Person p1 = new Person.Builder("Maayan", "maayanp163@gmail.com")
                .setAge(30)
                .setAddress("Nahal alexander")
                .setPhone("050-0000000")
                .build();

        MySingleton s3 = MySingleton.getInstance();
        MySingleton s4 = MySingleton.getInstance();

        //System.out.println(s3);
        //System.out.println(s4);
        /*
        for (String name : names){
            System.out.println(name);
        }
        */
    }

}
