package example.com.multipleactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static final String KEY = "keyWord";

    private static final int EDITOR_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.activity_main_set_name_button);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, EditorActivity.class);
        intent.putExtra(KEY, "wow");
        //startActivity(intent);
        startActivityForResult(intent, EDITOR_ACTIVITY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == EDITOR_ACTIVITY_REQUEST_CODE){
            // back from editorActivity.
            if(resultCode == RESULT_OK) {
                String name = data.getStringExtra(EditorActivity.NAME);
                TextView nameTV = (TextView) findViewById(R.id.activity_main_name_text_view);
                nameTV.setText("Your name is " + name);
            }else{
                Toast.makeText(this, "why like this", Toast.LENGTH_LONG).show();
            }
        }
    }
}
