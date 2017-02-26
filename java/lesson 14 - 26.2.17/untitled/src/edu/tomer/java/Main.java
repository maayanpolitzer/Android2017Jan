package edu.tomer.java;

public class Main {

    public static void main(String[] args) {
	    String str = "sagiv, oren, shani madar, ";
        String[] arr = str.split(", ");
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
