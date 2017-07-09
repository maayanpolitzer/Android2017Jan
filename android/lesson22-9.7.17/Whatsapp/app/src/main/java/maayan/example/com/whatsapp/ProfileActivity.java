package maayan.example.com.whatsapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.soundcloud.android.crop.Crop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int GALLERY_REQUEST_CODE = 1;
    private static final int CAMERA_REQUEST_CODE = 3;
    private ImageView imageView;
    private File tempImageFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageView = (ImageView) findViewById(R.id.activity_profile_image_view);
        imageView.setOnClickListener(this);

        tempImageFile = new File(getFilesDir(), "temp.jpg");
        if (!tempImageFile.exists()){
            try {
                tempImageFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onClick(View v) {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
        }else {
            /*
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, GALLERY_REQUEST_CODE);
            */
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, CAMERA_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            onClick(null);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == GALLERY_REQUEST_CODE){
                Log.d("TAG", "wow");
                Crop.of(data.getData(), Uri.fromFile(tempImageFile)).asSquare().start(this);
            }else if(requestCode == Crop.REQUEST_CROP){
                imageView.setImageURI(Uri.fromFile(tempImageFile));
            }else if(requestCode == CAMERA_REQUEST_CODE){
                Bundle b = data.getExtras();
                Bitmap bitmap = (Bitmap) b.get("data");
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(tempImageFile));
                    Crop.of(Uri.fromFile(tempImageFile), Uri.fromFile(tempImageFile)).asSquare().start(this);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
