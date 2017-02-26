package edu.tomer;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        //createFile();
        //deleteFile();
        //writeToFile("Shani madar the coolest");
        //readDataFromFile();
        copyFile();
    }

    public static void copyFile() {
        File original = new File("C:\\Users\\hackeru\\Desktop", "image.jpg");
        File copy = new File("C:\\Users\\hackeru\\Desktop","copy_image.jpg");
        try {
            FileInputStream in = new FileInputStream(original);
            FileOutputStream out = new FileOutputStream(copy);
            byte[] buffer = new byte[1024];
            int actuallyRead;
            while ((actuallyRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, actuallyRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void readDataFromFile() {
        File file = new File("C:\\Users\\hackeru\\Desktop", "maayan.txt");
        byte[] buffer = new byte[1024];
        try {
            FileInputStream in = new FileInputStream(file);
            /*
            // read one time from file.
            int actuallyRead = in.read(buffer);
            String data = new String(buffer, 0, actuallyRead);
            System.out.println(data);
            */
            int actuallyRead;
            StringBuilder sb = new StringBuilder();
            while ((actuallyRead = in.read(buffer)) != -1) {  // -1 = end of file!
                //while((actuallyRead = in.read(buffer)) > 0){
                String data = new String(buffer, 0, actuallyRead);
                sb.append(data);
            }
            System.out.println(sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String content) {
        byte[] buffer = content.getBytes();
        File file = new File("C:\\Users\\hackeru\\Desktop", "maayan.txt");
        try {
            FileOutputStream out = new FileOutputStream(file);
            out.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFile() {
        File file = new File("C:\\Users\\hackeru\\Desktop", "maayan.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile() {
        File file = new File("C:\\Users\\hackeru\\Desktop\\babyImages", "maayan.txt");
        file.delete();
    }
}
