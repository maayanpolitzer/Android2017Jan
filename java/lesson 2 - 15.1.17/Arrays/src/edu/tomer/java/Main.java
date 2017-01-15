package edu.tomer.java;

public class Main {

    public static void main(String[] args) {

        int[] arr = {8, -70, 314, -4, 0};
        int[] arr2 = new int[]{8,7,6,5,4,3,2,1};
        int[] arr3 = new int[5];

        //arr = new int[]{6,7,8};
        int[] newArr = changeArrNumbers(arr, 8);

        //arr[2] = 987654;
        int myNumber = arr[2];
        System.out.println(myNumber); // 314
        System.out.println("The length of arr: " + arr2.length);
        printArr(newArr);

        System.out.println(sum(arr));   // {1,5,10} -> 16;
        System.out.print(average(arr)); // {1,5,6) -> 4;

        int[] reverseArr = reverse(arr);    // {1,3,5) -> {5,3,1}.
        printArr(reverseArr);
    }

    public static int[] changeArrNumbers(int[] x, int number){
        for (int i = 0; i < x.length; i++){
            x[i] = number;
        }
        return x;
    }

    public static void printArr(int[] x){
        System.out.print("[");
        for (int i = 0; i < x.length; i++){
            System.out.print(x[i]);
            if (i < x.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }


}
