package com.maayan;

import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

/**
 * Created by hackeru on 23/07/2017.
 */
@WebServlet(name = "MainServlet", urlPatterns = "/server")
public class MainServlet extends HttpServlet {

    private Vector<String> users = new Vector<>();
    private static final String FIREBASE_CLOUD_MESSAGING_URL = "https://fcm.googleapis.com/fcm/send";
    // the server token (key) to enable cloud messaging to google.
    private static final String AUTH_KEY = "AAAAhaSvG48:APA91bEvv-wQK91NWgtyWd_Ih6x7Ouqx8wg8110y4gQ_-mPBWATrHiKMqp_MN1mYhcnInzf5TjhoZ1no_-W6RTwHbEKC-TbNMo0f4EzWesqLPAGkTrJzfFa-DHEiFf5M4gUtHdu3s_VR";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){
            sb.append(line);
        }

        try {
            JSONObject input = new JSONObject(sb.toString());
            String action = input.getString("action");
            switch(action) {
                case "REGISTER":
                    String token = input.getString("token");
                    if (!users.contains(token)){
                        users.add(token);
                    }
                    response.getWriter().write("ok");
                    break;
                case "PUSH":

                    notifyUsers();
                    break;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void notifyUsers() {
        // http post request to google.
        for(int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
            try {
                URL url = new URL(FIREBASE_CLOUD_MESSAGING_URL);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setUseCaches(false);
                connection.setDoInput(true);            // we expect input
                connection.setDoOutput(true);           // we will send data to google server.
                connection.setRequestMethod("POST");    // post method
                connection.setRequestProperty("Authorization", "key=" + AUTH_KEY);  // our server token
                connection.setRequestProperty("Content-Type","application/json");   // we will send jsonObject.

                JSONObject details = new JSONObject();  // notification title & body
                //details.put("title", "You have a message from god!");
                details.put("score", "your score is: " + 65);

                JSONObject data = new JSONObject(); // data with token & notification details.
                data.put("to", users.get(i));   // user token to receive the push
                data.put("data", details);      // "data" (key) - will NOT show in android as notification. "notification" will...

                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                out.write(data.toString());     // writing the json data to the outputStream
                out.flush();                    // force the data to be sent.

                connection.getInputStream();    // send the http request to google.

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
