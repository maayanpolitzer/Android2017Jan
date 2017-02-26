package edu.tomer.java;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        File mainFolder = new File("C:\\Users\\hackeru\\Desktop\\maayan");
        File[] files = mainFolder.listFiles();
        for (int i = 0; i < files.length; i++){
            //if (files[i].isFile() && files[i].getName().contains("z_")) {
            if (files[i].isFile() && !files[i].isHidden()){
                copy(files[i]);
            }
        }
    }

    private static void copy(File original){
        File copy = new File(original.getParent(), original.getName());
        try {
            FileInputStream in = new FileInputStream(original);
            OutputStream out = new FileOutputStream(copy);
            byte[] buffer = new byte[1024];
            int actuallyRead;
            while((actuallyRead = in.read(buffer)) != -1) {
                for (int i = 0; i < actuallyRead; i++){
                    buffer[i] = (byte) (buffer[i] ^ 11);    // bit-wise XOR;
                }
                out.write(buffer, 0, actuallyRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
