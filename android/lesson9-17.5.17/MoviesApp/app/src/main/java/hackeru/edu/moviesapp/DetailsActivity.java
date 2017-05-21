package hackeru.edu.moviesapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String imdbID = getIntent().getStringExtra("imdbID");
        Toast.makeText(this, "id:" + imdbID, Toast.LENGTH_SHORT).show();

        new DownloadTask().execute(imdbID);

    }

    class DownloadTask extends AsyncTask<String, Void, JSONObject> {

        public DownloadTask(){

        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected JSONObject doInBackground(String... params) {
            try {
                URL url = new URL("http://www.omdbapi.com/?i=" + params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream in = connection.getInputStream();

                StringBuilder sb = new StringBuilder();
                String line;
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                while((line = reader.readLine()) != null){
                    sb.append(line);
                    //publishProgress();
                }

                return new JSONObject(sb.toString());

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            System.out.println(jsonObject);
        }

        @Override
        protected void onProgressUpdate(Void... values) {

        }
    }

}













