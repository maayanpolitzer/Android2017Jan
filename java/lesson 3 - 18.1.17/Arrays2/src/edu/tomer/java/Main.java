package edu.tomer.java;

public class Main {

    /*int a = 90 - 80;
    boolean b = false;
    char c = 'r';
    String str = "wow!!!";*/

    public static void main(String[] args) {

        int[] classA = {90, 80, 50, 50, 91};
        int[] classB = new int[]{95, -76};
        int[] classC = {-5,-4,-3,-2,-1,-10}; // -4
        int[] classD = new int[4];
        classD[0] = 7;
        classD[1] = 15;
        classD[2] = -8;
        classD[3] = 3;

        //printArray(classA);
        //printWithFactor(classA, 30);
        //System.out.println(getMaxValue(classA));
        //System.out.println(isLastNumberPositive(classA));
        //System.out.println(average(classC));

        //printArray(classD);

        int[] theReverseArray = reverse(classD);
        System.out.println("-----------");
        //printArray(theReverseArray);
        // HOMEWORK!
        /*
        System.out.println(isNumberInArray(classA, 34));    //boolean - true/false
        System.out.println(sumOfOddsIndex(classC));  // int
        System.out.println(isOrdered(classA));  // boolean
        int[] myLargeArray = doubleMyArray(classA);
        printArray(myLargeArray);
        */

        System.out.println(sqrt(9));    // 3
        System.out.println(sqrt(8));    // 2
        System.out.println(sqrt(10));    // 3

    }

    public static int sqrt(int number){
        /*
        int result = 0;
        for (int i = 0; i * i <= number; i++){
            result = i;
        }
        return result;
        */
        int result = 0;
        for (int i = 0; i * i < number - 2 * i; i++){
            result++;
        }
        return result;
    }

    public static int[] reverse(int[] arr){
        int[] myReversedArr = new int[arr.length];
        int length = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            myReversedArr[length - i] = arr[i];
        }
        return myReversedArr;
    }

    public static int average(int[] arr){
        int sum = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++){
            sum += arr[i];
        }
        return sum / length;
    }

    public static boolean isLastNumberPositive(int[] arr){
        /*
        boolean p = false;
        int length = arr.length;
        if (arr[length - 1] > 0){
            p = true;
        }
        return p;
        */
        return arr[arr.length - 1] > 0;
    }

    // {-5, -6, -40, -2}
    public static int getMaxValue(int[] arr){
        int maxForNow = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > maxForNow){
                maxForNow = arr[i];
            }
        }
        return maxForNow;
    }

    public static void printArray(int[] arr) {
        //System.out.println("The length of the array is: " + arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }



    public static void printWithFactor(int[] arr, int factorAmount) {
        for (int i = 0; i < arr.length; i++) {
            int grade = arr[i] + factorAmount;
            if (grade > 100) {
                grade = 100;
            }
            System.out.println(grade);
                /*
                System.out.println(100);
            }else{
                System.out.println(grade);
                */

        }


    }




/*

    public static void main(String[] moshe) {
    int student1 = 90;
        int student2 = 80;
        int student3 = 99;
	    wow(45, true);

	    //studentsGrades[2] = 44;
        // student3 = 44


        System.out.println(studentsGrades[0]);
        System.out.println(studentsGrades[1]);
        System.out.println(studentsGrades[2]);
        System.out.println(studentsGrades[3]);
        System.out.println(studentsGrades[4]);


    }

    public static void wow(int a56lkmefglknmlknmrg, boolean mosheYossi){
        System.out.println("*****************************************");
    }
    */
}
