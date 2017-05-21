package hackeru.edu.moviesapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hackeru on 17/05/2017.
 */

public class DownloadImageThread extends Thread {

    private String link;
    private ImageView imageView;
    private Handler handler;

    public DownloadImageThread(String link, ImageView imageView, Handler handler){
        this.link = link;
        this.imageView = imageView;
        this.handler = handler;
    }

    @Override
    public void run() {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(link);
            connection = (HttpURLConnection) url.openConnection();
            InputStream in = connection.getInputStream();
            final Bitmap image = BitmapFactory.decodeStream(in);
            handler.post(new Runnable() {
                @Override
                public void run() {
                    imageView.setImageBitmap(image);
                }
            });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
