package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by hackeru on 26/03/2017.
 */
public class ClientThread extends Thread {

    private Socket clientSocket;
    private static final int ACTION_SEND = 1;
    private static final int ACTION_GET = 2;


    public ClientThread(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            InputStream in = clientSocket.getInputStream();
            OutputStream out = clientSocket.getOutputStream();
            int action = in.read();
            switch(action) {
                case ACTION_SEND:
                    StringBuilder sb = new StringBuilder();
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = in.read(buffer)) > 0) {
                        sb.append(new String(buffer, 0, length));
                    }
                    Main.addMessage(sb.toString());
                    break;
                case ACTION_GET:
                    int clientMessages = in.read();
                    int serverMessages = Main.getMessagesSize();
                    System.out.println("clientMessage : " + clientMessages + ", serverMessages: " + serverMessages);
                    if (serverMessages == clientMessages){
                        // client has all the messages.
                        out.write(0);
                    }else{
                        // server will send a message!
                        System.out.println("server will send a message: " + Main.getMessage(clientMessages));
                        out.write(1);
                        out.write(Main.getMessage(clientMessages).getBytes());
                        System.out.println("done");
                    }
                    break;
            }

        } catch(IOException e){

        }finally {
            if (clientSocket != null){
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
