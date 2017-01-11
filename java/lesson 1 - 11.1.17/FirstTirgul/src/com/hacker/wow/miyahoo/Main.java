package com.hacker.wow.miyahoo;

public class Main {

    public static void main(String[] args) {

        int firstNumber = 1;
        int secondNumber = 3;

        //sum(firstNumber,secondNumber);
        System.out.println(multi(firstNumber, secondNumber));
        System.out.println(quatient(firstNumber, secondNumber));
        System.out.println(reminder(firstNumber, secondNumber));

    }

    public static int multi(int x, int y){
        return x * y;
    }

    public static int quatient(int x, int y){
        return x / y;
    }

    public static int reminder(int x, int y){
        return x % y;
    }

    public static int sum(int x, int y){
        return x+y;
    }

    public static int distance(int x, int y){
        int result = 0;
        int small = x;
        int large = y;
        if (small > large){
            small = y;
            large = x;
        }
        for (int i = small; i < large; i++){
            result++;
        }

        return result;
    }

}
