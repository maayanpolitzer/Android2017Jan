package edu.tomer.java;

public class Main {

    public static void main(String[] args) {

        String str = "Maayan";  // immutable
        for (int i = 0; i < 100; i++){
            str += " wow";
        }
        System.out.println(str);

        StringBuilder sb = new StringBuilder();
        sb.append("Maayan");
        for (int i = 0; i < 100; i++){
            sb.append(" wow");
        }
        System.out.println(sb);

    }
}
