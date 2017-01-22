package edu.tomer.java;


import java.util.Random;

public class Main {

    public static int[] myLotto = {16, 6, 19, 2, 14, 3};
    public static int myExtra = 6;

    public static int MAX_LOTTO = 36;
    public static int MAX_EXTRA = 8;

    public static int[] generatedLotto = new int[6];
    public static int generatedExtra;

    public static void main(String[] args) {

        lottoTime();    // change generatedLotto array numbers to random, change generatedExtra to random too.
        print(generatedLotto);
        generatedExtra = generateNumber(MAX_EXTRA);
        System.out.println("Extra is " + generatedExtra);
        int rightGuesses = checkLotto();
        System.out.println("Right guesses: " + rightGuesses);
        System.out.println("Extra " + (myExtra == generatedExtra));

        //System.out.println(random.nextInt(100));
        //System.out.println("From : " + Integer.MIN_VALUE + ", to : " + Integer.MAX_VALUE);
        //System.out.println(generateNumber(MAX_LOTTO));  // 1-36.
        //System.out.println(generateNumber(MAX_EXTRA));  // 1-8.
    }

    public static int checkLotto(){
        int counter = 0;
        for (int i = 0; i < myLotto.length; i++){
            if (isNumberInGeneratedArray(myLotto[i])){
                counter++;
            }
        }
        return counter;
    }

    public static void lottoTime(){
        for (int i = 0; i < generatedLotto.length; i++){
            generatedLotto[i] = generateNumber(MAX_LOTTO);
        }
    }

    public static boolean isNumberInGeneratedArray(int x){
        for (int i = 0; i < generatedLotto.length; i++){
            if (generatedLotto[i] == x){
                return true;
            }
        }
        return false;
    }

    public static void print(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if (i < arr.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int generateNumber(int max){
        Random random = new Random();
        return random.nextInt(max) + 1;
    }
}
