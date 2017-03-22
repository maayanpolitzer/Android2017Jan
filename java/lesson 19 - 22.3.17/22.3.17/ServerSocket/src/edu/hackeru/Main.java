package edu.hackeru;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

    private static final int PORT = 10123;

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while(true){
                System.out.println("waiting...");
                serverSocket.accept();
                System.out.println("client connected!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
