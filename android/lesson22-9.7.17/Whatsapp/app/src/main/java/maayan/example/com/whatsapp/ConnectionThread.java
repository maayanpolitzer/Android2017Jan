package maayan.example.com.whatsapp;

import android.os.Handler;

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

    private OnResponseListener listener;
    private JSONObject data;
    private Handler handler;

    public ConnectionThread(OnResponseListener listener, JSONObject data){
        this.listener = listener;
        this.data = data;
        handler = new Handler();
    }

    @Override
    public void run() {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(SERVER_IP);   // check that the URL is valid.
            connection = (HttpURLConnection) url.openConnection();  // check if the device is connected to the internet.
            connection.setRequestProperty("Content-Type", "application/json");  // tells to server that you will send json object.
            connection.setRequestMethod("POST");    // the method that we connect to the server.
            connection.setDoOutput(true);   // tells the server that we are going to send data.
            connection.setDoInput(true);    // tells the server that we are waiting to receive data.

            OutputStream out = connection.getOutputStream();
            out.write(data.toString().getBytes());

            InputStream in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null){
                sb.append(line);
            }

            updateSuccess(new JSONObject(sb.toString()));

        } catch (MalformedURLException e) {
            updateFailure("Bad url.");
        } catch (IOException e) {
            updateFailure("No internet connection / server is down, please try again later.");
        } catch (JSONException e) {
            updateFailure("error while parsing the json.");
        } finally {
            if(connection != null){
                connection.disconnect();
            }
        }
    }

    private void updateSuccess(final JSONObject object){
        handler.post(new Runnable() {
            @Override
            public void run() {
                listener.onSuccess(object);
            }
        });
    }

    private void updateFailure(final String error){
        handler.post(new Runnable() {
            @Override
            public void run() {
                listener.onFailure(error);
            }
        });
    }

}
