package edu.tomer.java;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        File desktop = new File("C:\\Users\\hackeru\\Desktop");
        File src = new File(desktop, "img");
        File target = new File(desktop, "newImg");
        copyFolder(src, target);
    }

    private static void copyFolder(File originalFolder, File targetFolder){
        if (!targetFolder.exists()){
            targetFolder.mkdir();
        }
        File[] files = originalFolder.listFiles();
        for (int i = 0; i < files.length; i++){
            if (files[i].isFile()){
                copyFile(files[i], targetFolder);
            }else{
                // is folder...
                copyFolder(files[i], new File(targetFolder, "c_" + files[i].getName()));
            }
        }
    }

    private static void copyFile(File original, File targetFolder) {
        try {
            FileInputStream in = new FileInputStream(original);
            FileOutputStream out = new FileOutputStream(new File(targetFolder, "copy_" + original.getName()));
            byte[] buffer = new byte[1024];
            int length;
            while((length = in.read(buffer)) != -1){
                out.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
