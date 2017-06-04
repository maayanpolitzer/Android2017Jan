package hackeru.edu.publicfileandpermissions;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private final String EXTERNAL_PERMISSION = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    private final int EXTERNAL_REQUEST_CODE = 1;

    private String fileName = "myFile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(ContextCompat.checkSelfPermission(this, EXTERNAL_PERMISSION) != PackageManager.PERMISSION_GRANTED){
            // display message.
            ActivityCompat.requestPermissions(this, new String[]{EXTERNAL_PERMISSION}, EXTERNAL_REQUEST_CODE);
        }else{
            // PERMISSION GRANTED previously!!!
            start();
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == EXTERNAL_REQUEST_CODE){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                // Yey!!!
                start();
            }
        }
    }

    private void start(){
        File f = new File(Environment.getExternalStorageDirectory(), fileName);
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
