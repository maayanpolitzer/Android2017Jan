package maayan.example.com.whatsapp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hackeru on 17/05/2017.
 */

public class ConnectionThread extends Thread {

    private static final String SERVER_IP = "http://104.199.43.149/project/server/";
    private static final String ACTION = "action";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String LOGIN = "LOGIN";
    private static final String REGISTER = "REGISTER";

    @Override
    public void run() {
        JSONObject data = new JSONObject();
        try {
            data.put(ACTION, REGISTER);
            data.put(EMAIL, "moshe");
            data.put(PASSWORD, "128");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            URL url = new URL(SERVER_IP);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);

            OutputStream out = connection.getOutputStream();
            out.write(data.toString().getBytes());

            InputStream in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null){
                sb.append(line);
            }
            System.out.println(sb.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
