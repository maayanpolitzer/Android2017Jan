package edu.tomer;

import java.util.ArrayList;

public class Main {

    public static ArrayList<Fruit> fruits = new ArrayList<Fruit>();
    public static ArrayList<Product> products = new ArrayList<Product>();

    public static void main(String[] args) {

	    fruits.add(new Fruit("Apple", 12.9));
	    fruits.add(new Fruit("Banana", 14.9));
	    fruits.add(new Fruit("Pineapple", 32.9));
	    fruits.add(new Fruit("Pear", 8.9));
	    fruits.add(new Fruit("Kiwi", 20.9));
	    fruits.add(new Fruit("Mango", 9.9));

        products.add(new Product("Mango", 2.0));
        products.add(new Product("Banana", 1.5));

        double price = getTotalPrice();
        System.out.printf("You need to pay %.2f", price);
    }

    public static double getTotalPrice(){
        double price = 0;
        for (int i = 0; i < products.size(); i++){
            for (int j = 0; j < fruits.size(); j++){
                if (products.get(i).getName() == fruits.get(j).getName()){
                    price += products.get(i).getWeight() * fruits.get(j).getPrice();
                }
            }
        }
        return price;
    }

}
