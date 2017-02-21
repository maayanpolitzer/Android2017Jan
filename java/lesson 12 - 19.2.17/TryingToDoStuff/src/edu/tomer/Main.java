package edu.tomer;

public class Main {

    public static void main(String[] args) {

        String[] arr = null;

        try {
            arr[76] = "WOW";
            arr[2] = "WIIIIII";
        }catch (ArrayIndexOutOfBoundsException error){
            System.out.println(error);
        }catch (NullPointerException error){
            System.out.println(error);
        }
        System.out.println("DONE!");
    }
}
