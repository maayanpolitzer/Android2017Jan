package hackeru.edu.tappinggame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View startBtn;
    private View winnersBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = findViewById(R.id.activity_main_start_button);
        winnersBtn = findViewById(R.id.activity_main_winners_button);

        startBtn.setOnClickListener(this);
        winnersBtn.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings){
            startActivity(new Intent(this, SettingsActivity.class));
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, v == startBtn ? GameActivity.class : WallOfFameActivity.class));
    }
}
