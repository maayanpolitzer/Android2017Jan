package hackeru.edu.xo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Handler handler;
    private EditText et;
    private SharedPreferences settings;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            startActivity(new Intent(MainActivity.this, GameActivity.class));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();
        et = (EditText) findViewById(R.id.et);
        settings = getSharedPreferences("prefs", MODE_PRIVATE);

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, new IntentFilter("99fm"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    public void start(View view) {
        final String data = "name=" + settings.getString("TOKEN", null);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://10.0.15.49:8081/server?" + data);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    InputStream in = connection.getInputStream();
                    byte[] buffer = new byte[1];
                    in.read(buffer);
                    final String response = new String(buffer);
                    Log.d("TAG", response);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (response.equals("1")){
                                Toast.makeText(MainActivity.this, "Waiting for user", Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(MainActivity.this, "good luck", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(MainActivity.this, GameActivity.class));
                            }
                        }
                    });
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
