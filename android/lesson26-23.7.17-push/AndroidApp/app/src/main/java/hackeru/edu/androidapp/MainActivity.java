package hackeru.edu.androidapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private String token = "maayanToken";
    private SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settings = getSharedPreferences("prefs", MODE_PRIVATE);

    }

    public void register(View view) {
        final JSONObject data = new JSONObject();
        try {
            data.put("action", "REGISTER");
            data.put("token", settings.getString("token", "will not work!"));
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        URL url = new URL("http://10.0.15.49:8081/server");
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("POST");
                        connection.setRequestProperty("Content-Type", "application/json");
                        connection.setDoOutput(true);
                        connection.setDoInput(true);

                        OutputStream out = connection.getOutputStream();
                        out.write(data.toString().getBytes());

                        InputStream in = connection.getInputStream();
                        byte[] buffer = new byte[1024];
                        int actuallyRead = in.read(buffer);
                        String response = new String(buffer, 0, actuallyRead);
                        Log.d("TAG", "server response: " + response);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
