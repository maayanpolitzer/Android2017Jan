package hackeru.edu.privatefiles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private String fileName = "myFile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //createFile();
        //writeToFile("maayan");
        //readBytesFromFile();
        readStringFromFile();
    }

    private void readStringFromFile(){
        File f = new File(getFilesDir(), fileName);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String line;
            StringBuilder sb = new StringBuilder();
            while((line = reader.readLine()) != null){
                sb.append(line);
            }
            Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void readBytesFromFile(){
        File f = new File(getFilesDir(), fileName);
        try {
            FileInputStream in = new FileInputStream(f);
            byte[] buffer = new byte[1024];
            StringBuilder sb = new StringBuilder();
            int actuallyRead;
            while((actuallyRead = in.read(buffer)) != -1){
                sb.append(new String(buffer, 0, actuallyRead));
            }
            Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile(String content) {
        File f = new File(getFilesDir(), fileName);
        try {
            FileOutputStream out = new FileOutputStream(f);
            out.write(content.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createFile() {
        File f = new File(getFilesDir(), fileName);
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
