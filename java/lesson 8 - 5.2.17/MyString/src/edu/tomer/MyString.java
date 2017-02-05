package edu.tomer;

/**
 * Created by hackeru on 05/02/2017.
 */
public class MyString {

    private char[] chars;

    public MyString(char[] letters){
        chars = letters;
    }

    public MyString(byte[] bytes){
        chars = new char[bytes.length];
        for (int i = 0; i < chars.length; i++){
            chars[i] = (char) bytes[i];
        }

    }

    public int length(){
        return chars.length;
    }

    public void print(){
        for (int i = 0; i < chars.length; i++){
            System.out.print(chars[i]);
        }
        System.out.println();
    }

    public int indexOf(char c){
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == c){
                return i;
            }
        }
        return -1;
    }

    public char charAt(int index){
        if (index >= 0 && index < chars.length){
            return chars[index];
        }
        return '#';
    }

    public int sameCharsCount(char c) {
        int counter = 0;
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == c){
                counter++;
            }
        }
        return counter;
    }

    public boolean isEmpty(){
        return chars.length == 0;
        /*
        if (chars.length > 0){
            return false;
        }else{
            return true;
        }
        */
    }

    public boolean contains(char c){
        return indexOf(c) != -1;
        /*
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == c){
                return true;
            }
        }
        return false;
        */
    }

    public MyString subString(int start, int end){
        if (start < 0 || end < start || end > chars.length){
            return null;
        }
        char[] c = new char[end - start];
        /*
        int counter = 0;
        for (int i = start; i < end; i++){
            c[counter++] = chars[i];
        }
        */
        for (int i = start; i < end; i++){
            c[i - start] = chars[i];
        }
        return new MyString(c);
    }

    public MyString replace(char oldChar, char newChar){
        char[] c = new char[chars.length];
        for (int i = 0; i < c.length; i++){
            if (oldChar == chars[i]){
                c[i] = newChar;
            }else{
                c[i] = chars[i];
            }
        }
        return new MyString(c);
    }

    public MyString toUpperCase(){
        char[] c = new char[chars.length];
        for (int i = 0; i < chars.length; i++){
            if (chars[i] >= 97 && chars[i] <= 122){
                c[i] = (char)(chars[i] - 32);
            }else{
                c[i] = chars[i];
            }
        }
        return new MyString(c);
    }

    public MyString subString(int start) {
        return subString(start, chars.length);
    }

}
