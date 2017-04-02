package edu.hackeru;

/**
 * Created by hackeru on 02/04/2017.
 */
public class Person {

    private String name;
    private double price;
    private int weight;
    private boolean b;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof Person) {
            Person p = (Person) obj;
            return name.equals(p.name) &&
                    price == p.price &&
                    weight == p.weight &&
                    b == p.b;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = name.hashCode();
        hash += 17 * (int)price;
        hash += 29 ^ weight;
        hash += b ? 31 : -19;
        System.out.println(name + " hash: " + hash);
        return hash;
    }
}
