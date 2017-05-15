package hackeru.edu.moviesapp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

public class ResultsActivity extends AppCompatActivity {

    static final String LINK = "http://www.omdbapi.com/?";
    private ListView listView;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // INTERNET PERMISSION !!!
        // INTERNET in new Thread!!!

        final String search = getIntent().getStringExtra(MainActivity.SEARCH);

        handler = new Handler();

        new DownloadThread(this, handler, LINK + "s=" + search).start();

        listView = (ListView) findViewById(R.id.activity_results_list_view);

    }

    void updateList(ArrayList<Movie> movies){
        ArrayAdapter<Movie> adapter = new ArrayAdapter<Movie>(
                this,
                android.R.layout.simple_list_item_1,
                movies
        );
        listView.setAdapter(adapter);
    }

}
