package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Main {

    private static Vector<String> messages = new Vector<String>();

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(10124);
            while (true) {
                System.out.println("waiting...");
                Socket clientSocket = serverSocket.accept();  // blocking method, waits until a client connect to the server.
                System.out.println("Client connected!");
                new ClientThread(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getMessage(int index) {
        return messages.get(index);
    }

    public static void addMessage(String message) {
        System.out.println(message);
        messages.add(message);
    }

    public static int getMessagesSize(){
        return messages.size();
    }

}
