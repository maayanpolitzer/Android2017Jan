package hackeru.edu.tappinggame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView timerTV;
    private boolean playing;
    private Button startBtn;
    private int counter;
    private int timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        timerTV = (TextView) findViewById(R.id.activity_game_timer_text_view);

        SharedPreferences settings = getSharedPreferences(SettingsActivity.FILE_NAME, MODE_PRIVATE);

        timer = settings.getInt(SettingsActivity.TIMER, 5);

        timerTV.setText("timer: " + timer + " seconds");

        startBtn = (Button) findViewById(R.id.activity_game_btn);
        startBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (!playing){
            playing = true;
            startTimer();
        }else{
            counter++;
        }
        startBtn.setText(counter + " clicks");
    }

    private void startTimer() {
        new CountDownTimer(timer * 1000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timerTV.setText("Timer: " + millisUntilFinished / 1000 + " s");
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(GameActivity.this, EndActivity.class);
                intent.putExtra("SCORE", counter);
                startActivity(intent);
                finish();
            }
        }.start();
    }
}
