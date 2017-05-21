package hackeru.edu.moviesapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

public class ResultsActivity extends AppCompatActivity implements ConnectionCompletedListener, AdapterView.OnItemClickListener {

    static final String LINK = "http://www.omdbapi.com/?";
    private ListView listView;
    private Handler handler;
    private ArrayList<Movie> movies;

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

    @Override
    public void updateList(ArrayList<Movie> movies){
        this.movies = movies;
        MoviesAdapter adapter = new MoviesAdapter(this, movies);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("imdbID", movies.get(position).getImdbID());
        startActivity(intent);
    }
}
