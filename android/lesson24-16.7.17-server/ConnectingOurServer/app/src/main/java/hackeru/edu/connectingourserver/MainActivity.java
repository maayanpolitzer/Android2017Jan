package hackeru.edu.connectingourserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private EditText nameET, ageET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameET = (EditText) findViewById(R.id.name_et);
        ageET = (EditText) findViewById(R.id.age_et);

    }

    /*
    public void send(View view) {
        //get
        final String name = nameET.getText().toString().trim();
        final String age = ageET.getText().toString();
        if (validate()){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        URL url = new URL("http://10.0.15.49:8081/MyServer?name=" + name + "&age=" + age);
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        String line;
                        StringBuilder sb = new StringBuilder();
                        while((line = reader.readLine()) != null){
                            sb.append(line);
                        }
                        Log.d("TAG", sb.toString());
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
    */

    public void send(View view) {
        //get
        final String name = nameET.getText().toString().trim();
        final String age = ageET.getText().toString();
        if (validate()){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        URL url = new URL("http://10.0.15.49:8081/MyServer");
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("POST");
                        connection.setDoOutput(true);
                        connection.setDoInput(true);

                        OutputStream out = connection.getOutputStream();
                        String data = "wow=" + name;
                        out.write(data.getBytes());

                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        String line;
                        StringBuilder sb = new StringBuilder();
                        while((line = reader.readLine()) != null){
                            sb.append(line);
                        }
                        Log.d("TAG", sb.toString());
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    private boolean validate(){
        return true;
    }
}
