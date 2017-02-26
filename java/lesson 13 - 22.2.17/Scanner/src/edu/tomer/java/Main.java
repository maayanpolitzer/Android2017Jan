package edu.tomer.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Enter your name:");
            String str = scanner.nextLine();    // blocking method!
            if (str.equals("exit")){
                break;
            }
            System.out.println("thank you " + str);
        }
    }
}
