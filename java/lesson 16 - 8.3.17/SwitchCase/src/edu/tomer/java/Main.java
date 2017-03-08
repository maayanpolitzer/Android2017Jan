package edu.tomer.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int age = getAgeFromUser();
        //System.out.println(age);
        switch (age){
            case 0:
                System.out.println("WHATTTTT???????");
                break;
            case 1:
                System.out.println("WHATTTTT???????");
                break;
            case 2:
                System.out.println("baby");
                break;
            case 3:
                System.out.println("baby");
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                System.out.println("child");
                break;
            default:
                System.out.println("boy/man/old man...");
                break;
        }
        /*
        if (age < 1){
            System.out.println("WHATTTTT???????");
        }else if(age < 4){
            System.out.println("Baby");
        }else if(age < 9){
            System.out.println("child");
        }else if(age < 15){
            System.out.println("boy");
        }else if(age < 121){
            System.out.println("MAN");
        }else{
            System.out.println("old man...");
        }
        */


    }

    private static int getAgeFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your age:");
        String number = scanner.nextLine();
        if (number.isEmpty()){
            return 0;
        }else{
            int age = 0;
            try {
                age = Integer.parseInt(number);
            }catch (NumberFormatException e){
                age = 0;
            }
            return age;
        }
    }
}
