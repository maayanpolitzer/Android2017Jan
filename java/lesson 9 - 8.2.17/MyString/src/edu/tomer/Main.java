package edu.tomer;

public class Main {

    public static void main(String[] args) {

        char[] c = {'H','a','v','e',' ','a',' ','g','r','e','a','t',' ','h','o','l','i','d','a','y'};
        MyString ms = new MyString(c);
/*
        char[] c2 = {'E','l','i'};
        MyString ms2 = new MyString(c2);
*/
        //System.out.println(ms.length());    // 11;
        //ms.print();
        //System.out.println(ms.indexOf('r'));    // 8;
        //System.out.println(ms.charAt(9));  // l
        //System.out.println(ms.sameCharsCount('l')); // 3
        //System.out.println(ms.isEmpty());   // false.
        //System.out.println(ms.contains('W'));   // true;
        /*MyString m1 = ms.subString(4,9);
        if (m1 != null){
            m1.print();
        }*/
        /*
        MyString m2 = ms.replace('l', '*');
        m2.print();
        */
        //MyString m3 = ms.toUpperCase();
        //m3.print();

        /*
        int i = 'a';
        i--;
        char cc = (char) i;  // casting...
        System.out.println(cc);
        System.out.println(i);

        char e = 'c';
        e -= 2;
        System.out.println(e);
        */
        /*
        byte[] arr = {77, 97,97,121,97,110};
        MyString m4 = new MyString(arr);
        m4.print();
        */

        MyString m5 = ms.subString(5);
        m5.print();

        MyString[] arr = ms.split(' ');
        for (int i = 0; i < arr.length; i++){
            arr[i].print();
        }

    }
}
