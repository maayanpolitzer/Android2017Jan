package more.hackeru.edu.dialogfragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void show(View view) {
        new AlertDialog.Builder(this)
                .setTitle("title")
                .setMessage("message")
                .setPositiveButton("Positive", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "wow", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Negative", null)
                .setNeutralButton("Neutral", null)
                .setCancelable(false)
                .show();
    }
}
