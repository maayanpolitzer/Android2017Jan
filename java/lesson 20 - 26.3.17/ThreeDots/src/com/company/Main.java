package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println(sum());

    }

    public static int sum(int... grades){
        int sum = 0;
        for (int i = 0; i < grades.length; i++){
            sum += grades[i];
        }
        return sum / grades.length;
    }
    /*
    public static int sum(int x, int y){
        return (x + y)/2;
    }

    public static int sum(int[] grades){
        int sum = 0;
        for (int i = 0; i < grades.length; i++){
            sum += grades[i];
        }
        return sum / grades.length;
    }
    */

}
