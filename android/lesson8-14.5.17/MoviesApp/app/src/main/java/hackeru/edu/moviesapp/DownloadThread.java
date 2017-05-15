package hackeru.edu.moviesapp;

import android.os.Handler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by hackeru on 14/05/2017.
 */

public class DownloadThread extends Thread {

    private ResultsActivity activity;
    private Handler handler;
    private String link;

    public DownloadThread(ResultsActivity activity, Handler handler, String link){
        this.activity = activity;
        this.handler = handler;
        this.link = link;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream in = connection.getInputStream();

            StringBuilder sb = new StringBuilder();

            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while((line = reader.readLine()) != null){
                sb.append(line);
            }

            /*
            byte[] buffer = new byte[1024];
            int actuallyRead;
            while((actuallyRead = in.read(buffer)) != -1){
                sb.append(new String(buffer, 0, actuallyRead));
            }
            */

            final ArrayList<Movie> movies = new ArrayList<>();

            JSONObject jsonObject = new JSONObject(sb.toString());
            boolean response = jsonObject.getBoolean("Response");
            if (response) {
                JSONArray arr = jsonObject.getJSONArray("Search");
                for (int i = 0; i < arr.length(); i++) {
                    movies.add(new Movie(arr.getJSONObject(i)));
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        activity.updateList(movies);
                    }
                });
            }else{
                String error = jsonObject.getString("Error");
                // display the error to the user.
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
