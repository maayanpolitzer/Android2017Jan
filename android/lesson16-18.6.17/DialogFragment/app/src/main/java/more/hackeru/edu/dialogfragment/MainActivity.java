package more.hackeru.edu.dialogfragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void display(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("NUMBER", 4);

        MyDialog myDialog = new MyDialog();
        myDialog.setCancelable(false);
        myDialog.setArguments(bundle);
        myDialog.show(getFragmentManager(), null);
        /*
        new AlertDialog.Builder(this)
                .setTitle("Are you sure")
                .setMessage(R.string.dialog_message)
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
                */
    }

    @Override
    public void onNumberSet(int number) {
        Toast.makeText(this, "The numbe is " + number, Toast.LENGTH_SHORT).show();
    }
}
