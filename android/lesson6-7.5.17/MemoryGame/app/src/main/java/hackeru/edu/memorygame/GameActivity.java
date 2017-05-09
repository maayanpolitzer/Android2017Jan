package hackeru.edu.memorygame;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
                    // index:   0      1      2
    private int[][] levels = {{3,2}, {4,3}, {6,4}};
    private int level;      // 0 1    0 1    0 1

    private LinearLayout mainLayout;
    private LinearLayout.LayoutParams rowParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1);
    private LinearLayout.LayoutParams colParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1);

    private int[] images = {R.drawable.one, R.drawable.one, R.drawable.two, R.drawable.two, R.drawable.three, R.drawable.three};

    private int counter;
    private ImageView firstCard;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        level = getIntent().getIntExtra(MainActivity.LEVEL, -1);
        mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        handler = new Handler();
        init();
    }

    private void init() {
        int counter = 0;
        for(int i = 0; i < levels[level][0]; i++) {    // number of rows
            LinearLayout row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);    // default
            row.setLayoutParams(rowParams);
            for (int j = 0; j < levels[level][1]; j++) {   // number of cards each row.
                ImageView card = new ImageView(this);
                card.setTag(counter++);
                card.setImageResource(R.drawable.card);
                card.setOnClickListener(this);
                card.setLayoutParams(colParams);
                row.addView(card);
            }
            mainLayout.addView(row);
        }
    }

    @Override
    public void onClick(View view) {
        counter++;
        int clickedCardTag = (int) view.getTag();
        final ImageView currentCard = (ImageView) view;
        currentCard.setImageResource(images[clickedCardTag]);
        if (counter % 2 == 0){
            // even card.
            if(images[(int)firstCard.getTag()] == images[clickedCardTag]){
                // the two cards are the same
                Toast.makeText(this, "Two cards", Toast.LENGTH_SHORT).show();
            }else{
                // not the same.
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        firstCard.setImageResource(R.drawable.card);
                        currentCard.setImageResource(R.drawable.card);
                    }
                }, 1000);

            }
        }else{
            // odd card
            firstCard = currentCard;
        }
    }
}
