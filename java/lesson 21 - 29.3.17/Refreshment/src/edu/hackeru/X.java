package edu.hackeru;

/**
 * Created by hackeru on 29/03/2017.
 */
public class X implements J {

    private int number;
    private String name = "maayan";
    private static int c;

    public X(int number){
        this.number = number;
        c++;
        System.out.println("int");
    }



    public X(boolean isWorking) {
        this(50);
    }

    public X(long l){
        System.out.println("long");
    }

    public int getNumber(){
        return number;
    }

    public int wow(String s, int i){
        return 0;
    }

    public int getC(){
        return c;
    }

    public void setC(int c){
        X.c = c;
    }

    @Override
    public int sum() {
        return 0;
    }

    @Override
    public boolean isOdd(int number) {
        return false;
    }
}
