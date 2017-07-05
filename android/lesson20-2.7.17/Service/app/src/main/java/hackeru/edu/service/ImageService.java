package hackeru.edu.service;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hackeru on 02/07/2017.
 */

public class ImageService extends Service {

    // MANIFEST !!!

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(intent.getStringExtra(MainActivity.IMAGE_LINK));
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    InputStream in = connection.getInputStream();
                    File file = new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis() + ".jpg");
                    // internal storage path: data/data/APP_PACKAGE/files/image.jpg
                    // external storage path: storage/emulated/0/image.jpg
                    FileOutputStream out = new FileOutputStream(file);
                    byte[] buffer = new byte[1024];
                    int length;
                    while((length = in.read(buffer)) != -1){
                        out.write(buffer, 0, length);
                    }
                    Intent responseIntent = new Intent("99fm");
                    responseIntent.putExtra(MainActivity.IMAGE_LINK, file.getPath());
                    sendBroadcast(responseIntent);

                    SharedPreferences settings = getSharedPreferences("PREFS_NAME", MODE_PRIVATE);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString("FILE_PATH", file.getPath());
                    editor.commit();

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        return START_REDELIVER_INTENT;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
