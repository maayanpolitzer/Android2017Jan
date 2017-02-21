package edu.tomer;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        //createFile();
        //deleteFile();
        //writeToFile("Shani: what a great lesson!!!");
        readDataFromFile();

    }

    public static void readDataFromFile(){
        File file = new File("C:\\Users\\hackeru\\Desktop\\babyImages", "maayan.txt");
        byte[] buffer = new byte[1024];
        try {
            FileInputStream in = new FileInputStream(file);
            int actuallyRead = in.read(buffer);
            String data = new String(buffer, 0, actuallyRead);
            System.out.println(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeToFile(String content){
        byte[] buffer = content.getBytes();
        File file = new File("C:\\Users\\hackeru\\Desktop\\babyImages", "maayan.txt");
        try {
            FileOutputStream out = new FileOutputStream(file, true);
            out.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFile() {
        File file = new File("C:\\Users\\hackeru\\Desktop\\babyImages", "maayan.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(){
        File file = new File("C:\\Users\\hackeru\\Desktop\\babyImages", "maayan.txt");
        file.delete();
    }
}
