package edu.tomer.java;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final String FILE_NAME = "guests.txt";
    private static ArrayList<String> guests = new ArrayList<>();
    private static int originalLength;    // default == 0;
    private static Scanner scanner = new Scanner(System.in);
    private static boolean delete;  // default is false;

    public static void main(String[] args) {
        readFromFile();
        String name;
        while (true){
            System.out.println("Enter name:");
            name = scanner.nextLine();
            if (name.equals("exit")){
                break;
            }else if(name.length() >= 2 && !name.contains(", ")){
                checkName(name);
            }
        }

        writeToFile();
    }

    public static void checkName(String name){
        if (guests.contains(name)) {
            System.out.println("Already exists");
            System.out.println("Erase ? (y/n)");
            String delete = scanner.nextLine();
            if (delete.equals("y")){
                guests.remove(name);
                Main.delete = true;
                System.out.println(name + " removed!");
            }
        }else{
            guests.add(name);
            System.out.println("new guest added!");
        }
    }

    public static void readFromFile(){
        File file = new File(FILE_NAME);
        if (file.exists()){
            StringBuilder sb = new StringBuilder();
            byte[] buffer = new byte[1024];
            int length;
            try {
                FileInputStream in = new FileInputStream(file);
                while((length = in.read(buffer)) != -1){
                    sb.append(new String(buffer, 0, length));
                }
                extractGuestList(sb.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void extractGuestList(String data) {
        String[] arr = data.split(", ");
        for (int i = 0; i < arr.length; i++){
            guests.add(arr[i]);
        }
        originalLength = arr.length;  // the same as: guests.size();
    }

    public static void writeToFile(){
        try {
            FileOutputStream out = new FileOutputStream(FILE_NAME, !delete);
            for (int i = delete ? 0 : originalLength; i < guests.size(); i++){
                out.write((guests.get(i) + ", ").getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
