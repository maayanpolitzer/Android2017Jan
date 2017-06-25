package com.company;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        int[] arr = {2,4,5,8,100,170,200};
        int number = 100;

        //System.out.println(isSum(arr,number));
        //System.out.println(isOrderSum(arr, number));

        System.out.println(isNumber(arr, number));

    }

    public static boolean isNumber(int[] arr, int number){
        int max = arr.length - 1;
        int min = 0;
        int middle;
        while(max >= min){
            middle = (max + min) / 2;
            if (arr[middle] == number){
                return true;
            }else if(arr[middle] > number){
                max = middle - 1;
            }else{
                min = middle + 1;
            }
        }
        return false;
        /*
        for(int i = 0; i < arr.length; i++){
            if (arr[i] == number){
                return true;
            }
        }
        return false;
        */
    }

    public static boolean isOrderSum(int[] arr, int number) {
        int min = 0;
        int max = arr.length - 1;
        while(min < max){
            int sum = arr[min] + arr[max];
            if (sum == number){
                return true;
            }else if(sum > number){
                max--;
            }else{
                min++;
            }
        }
        return false;
    }

    public static boolean isSum(int[] arr, int number){
        /*
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i] + arr[j] == number){
                    return true;
                }
            }
        }
        return false;
        */
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            if (set.contains(arr[i])){
                return true;
            }
            set.add(number - arr[i]);
        }
        return false;
    }

}
