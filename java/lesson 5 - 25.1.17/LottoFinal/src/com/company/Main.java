package com.company;

import java.util.Random;

public class Main {

    public static int[] myLotto = {1, 2, 3, 4, 5, 6};
    public static int myExtra = 1;

    public static int[] lotto = new int[6];
    public static int extra;

    public static Random random = new Random();

    public static void main(String[] args) {

        createLottery();
        printArray(lotto);

        int rightGuesses = checkNumbers();
        boolean rightExtra = extra == myExtra;

        System.out.println("You guessed " + rightGuesses + " from 6 numbers");
        System.out.println("Extra : " + rightExtra);

    }

    public static int checkNumbers() {
        int counter = 0;
        for (int i = 0; i < myLotto.length; i++) {
            if (isNumberInArray(myLotto[i])) {
                counter++;
            }
        }
        return counter;
    }

    public static boolean isNumberInArray(int number) {
        for (int i = 0; i < lotto.length; i++) {
            if (number == lotto[i]) {
                return true;
            }
        }
        return false;
    }

    public static void createLottery() {
        for (int i = 0; i < lotto.length; i++) {
            int numberToInsert = generateRandomNumber(6);
            if (isNumberValid(numberToInsert, i)) {
                lotto[i] = numberToInsert;
            } else {
                i--;
                System.out.println("DUPLICATE!!!");
            }
            /*
            while(!isNumberValid(numberToInsert, i)){
                numberToInsert = generateRandomNumber(36);
            }
            lotto[i] = numberToInsert;
            */
        }
        extra = generateRandomNumber(8);
        System.out.println("extra is: " + extra);
    }

    public static boolean isNumberValid(int number, int bound) {
        for (int i = 0; i < bound; i++) {
            if (number == lotto[i]) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }


    public static int generateRandomNumber(int bound) {
        return random.nextInt(bound) + 1;
    }
}
