package hackeru.edu.tappinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        int score = getIntent().getIntExtra("SCORE", -1);
        if (score == -1){
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
            finish();
        }

        Toast.makeText(this, "score " + score, Toast.LENGTH_SHORT).show();

    }
}
