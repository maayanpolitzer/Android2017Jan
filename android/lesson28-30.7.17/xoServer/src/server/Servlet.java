package server;

import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hackeru on 30/07/2017.
 */
@WebServlet(name = "Servlet",urlPatterns = "/server")
public class Servlet extends HttpServlet {

    private Game game = new Game();
    private static final String FIREBASE_CLOUD_MESSAGING_URL = "https://fcm.googleapis.com/fcm/send";
    // the server token (key) to enable cloud messaging to google.
    private static final String AUTH_KEY = "AAAA5PCvd-s:APA91bGBAmzWY9ofuXGi2V58fnyPCibb1gyY6H9Vsp7xfzmYJ0h1yqi5Sh-bDob44Y-ywz8X5N83lY1L-nURElEeZX36xTJXjPmbwenxUq0c62wS5yEZecHGhqrJC17YIJhtY1gmuvr4";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getParameter("name");
        System.out.println(token);
        String players = null;
        if(game.getConnectedPlayers() == 0){
            game.setFirstPlayerToken(token);
            players = "1";
        }else if(game.getConnectedPlayers() == 1){
            game.setSecondPlayerToken(token);
            notifyPlayer(game.getFirstPlayerToken());
            players = "2";
        }else{
            players = "-1";
        }
        response.getWriter().write(players);
    }

    private void notifyPlayer(String token) {
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
            details.put("data", "start");

            JSONObject data = new JSONObject(); // data with token & notification details.
            data.put("to", token);   // user token to receive the push
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
