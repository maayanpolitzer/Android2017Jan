package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by hackeru on 26/03/2017.
 */
public class GetMessageThread extends Thread {

    private static int numOfMessages = 0;
    private UpdateUiListener listener;

    public GetMessageThread(UpdateUiListener listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        while (true) {
            getMessageFromServer();
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void getMessageFromServer() {
        Socket socket = null;
        try {
            socket = new Socket(SendMessageThread.SERVER_IP, SendMessageThread.SERVER_PORT);
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();
            out.write(2);
            out.write(numOfMessages);
            if (in.read() == 1) {
                System.out.println("get message");
                byte[] buffer = new byte[1024];
                int length;
                StringBuilder sb = new StringBuilder();
                while ((length = in.read(buffer)) > 0) {
                    sb.append(new String(buffer, 0, length));
                }
                String messageFromServer = sb.toString();
                numOfMessages++;
                listener.displayMessage(messageFromServer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
