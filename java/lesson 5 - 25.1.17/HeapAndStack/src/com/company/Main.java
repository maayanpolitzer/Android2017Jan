package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int k = 1;
        int[] arr = {5,6,7};
        int[] arr2 = {9,9,9,9,9,9,9,9,9,9};
        arr2 = arr;
        int[] moshe = arr2;
        moshe[0] = -40;
        changeArr(arr);
        //int[] arr2 = {8,9,0};
        int[] rr = new int[5];
        System.out.println(rr);
        System.out.println(arr2);

        //sayHi(k);
        //System.out.println("From main(): " + k);
        //System.out.println(arr2[0]);
    }

    public static void changeArr(int[] ofir){
        //System.out.println(ofir[0]);
        ofir[1] = 55555667;
        //System.out.println(ofir);

        //System.out.println(ofir[1]);
    }

    public static void sayHi(int a){
        a = 50;
        wow();
        System.out.println("From sayHi: " + a);
    }

    public static void wow(){
        System.out.println("wow");
    }
}

