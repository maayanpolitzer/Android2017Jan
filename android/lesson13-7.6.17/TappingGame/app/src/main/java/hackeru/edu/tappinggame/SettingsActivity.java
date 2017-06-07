package hackeru.edu.tappinggame;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText timerET;
    private EditText wallET;

    private SharedPreferences settings;
    private SharedPreferences.Editor editor;

    public static final String FILE_NAME = "prefsFile";
    public static final String DISPLAY = "DISPLAY";
    public static final String TIMER = "TIMER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        timerET = (EditText) findViewById(R.id.activity_settings_timer_edit_text);
        wallET = (EditText) findViewById(R.id.activity_wall_display_edit_text);

        settings = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        editor = settings.edit();

        int timer = settings.getInt(TIMER, 5);
        int display = settings.getInt(DISPLAY, 10);

        timerET.setText(timer + "");
        wallET.setText(display + "");

        findViewById(R.id.activity_settings_save_button).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String t = timerET.getText().toString();
        String w = wallET.getText().toString();
        if (t.isEmpty()){
            timerET.setError("empty...");
            return;
        }
        if (w.isEmpty()){
            wallET.setError("empty...");
            return;
        }
        int timer = 0;
        int display = 0;
        try{
            timer = Integer.parseInt(t);
            display = Integer.parseInt(w);
        }catch(NumberFormatException e){
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
            return;
        }
        // save data...
        editor.putInt(TIMER, timer);
        editor.putInt(DISPLAY, display);
        editor.commit();
        finish();
    }
}
