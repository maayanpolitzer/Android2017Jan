package hackeru.edu.tappinggame;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import hackeru.edu.tappinggame.db.DataSource;

public class EndActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameET;
    private int score;
    private int seconds;
    private SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        score = getIntent().getIntExtra("SCORE", -1);
        if (score == -1){
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        TextView tv = (TextView) findViewById(R.id.activity_end_score);
        nameET = (EditText) findViewById(R.id.activity_end_name_edit_text);

        tv.setText("You clicked " + score + " times!!! well done");

        findViewById(R.id.activity_end_save_button).setOnClickListener(this);

        settings = getSharedPreferences(SettingsActivity.FILE_NAME, MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        String name = nameET.getText().toString().trim();
        if (name.isEmpty()){
            nameET.setError("Please enter your name...");
            return;
        }
        double time = settings.getInt(SettingsActivity.TIMER, 5);

        DataSource.getInstance(this).insertData(name, 10*score/time);

        finish();
    }
}
