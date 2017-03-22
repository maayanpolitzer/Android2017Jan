package edu.hackeru;

import java.io.IOException;
import java.net.Socket;

public class Main {

    private static final String SERVER_IP = "10.0.15.49";
    private static final int SERVER_PORT = 10123;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
