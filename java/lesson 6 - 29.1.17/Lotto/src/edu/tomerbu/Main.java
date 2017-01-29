package edu.tomerbu;

import java.util.Random;

public class Main {

    public static int[] lotto = new int[6];
    public static Random random = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < lotto.length; i++){
            lotto[i] = generateNumber(36, i);
        }

	    print(lotto);
    }

    public static int generateNumber(int max, int index){
        int number = random.nextInt(max) + 1;
        if (isNumberValid(number, index)){
            return number;
        }else{
            return generateNumber(max, index);
        }
    }

    public static void print(int[] arr){
        System.out.print("[");
        for (int i = 0; i < lotto.length; i++){
            System.out.print(lotto[i]);
            if (i < lotto.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static boolean isNumberValid (int number, int bound){
        for(int i = 0; i < bound; i++){
            if (number == lotto[i]){
                return false;
            }
        }
        return true;
    }
}
