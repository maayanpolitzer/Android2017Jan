package hackeru.edu.threadvsasynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et;
    private TextView tv;
    private ProgressBar pb;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.et);
        tv = (TextView) findViewById(R.id.tv);
        pb = (ProgressBar) findViewById(R.id.pb);

        handler = new Handler();

        findViewById(R.id.btn).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        final String link = et.getText().toString().trim();
        //new GetDataTask().execute(link);

        pb.setVisibility(View.VISIBLE);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d("TAG", link);
                    URL url = new URL(link);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    InputStream in = connection.getInputStream();
                    final StringBuilder sb = new StringBuilder();
                    int actuallyRead;
                    final byte[] buffer = new byte[50000];
                    while((actuallyRead = in.read(buffer)) != -1){
                        final int read = actuallyRead;
                        //sb.append(new String(buffer, 0, actuallyRead));
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                tv.append(new String(buffer, 0, read));
                                pb.setVisibility(View.INVISIBLE);
                            }
                        });
                    }
                    Log.d("TAG", sb.toString());
                    /*
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            tv.setText(sb.toString());
                            pb.setVisibility(View.INVISIBLE);
                        }
                    });
                    */
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    private class GetDataTask extends AsyncTask<String, String, Void>{

        @Override
        protected void onPreExecute() {
            pb.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(String... params) {
            // new thread.
            try {
                URL url = new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream in = connection.getInputStream();
                int actuallyRead;
                byte[] buffer = new byte[1024];
                while((actuallyRead = in.read(buffer)) != -1){
                    publishProgress(new String(buffer, 0, actuallyRead));
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            // works on main thread!
            tv.append(values[0]);
            pb.setVisibility(View.INVISIBLE);
        }

        @Override
        protected void onPostExecute(Void s) {
            // main thread.
        }
    }

}
