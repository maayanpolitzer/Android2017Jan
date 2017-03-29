package com.company;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by hackeru on 26/03/2017.
 */
public class SendMessageThread extends Thread {

    private String message;
    public static final String SERVER_IP = "10.0.15.49";
    public static final int SERVER_PORT = 10124;

    public SendMessageThread(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        Socket socket = null;
        try {
            // connect the server.
            socket = new Socket(SERVER_IP, SERVER_PORT);
            // send message to server.
            OutputStream out = socket.getOutputStream();
            out.write(1);
            out.write(message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
