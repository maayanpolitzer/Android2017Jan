package hackeru.edu.memorygame;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
                    // index:   0      1      2
    private int[][] levels = {{3,2}, {4,3}, {6,4}};
    private int level;      // 0 1    0 1    0 1

    private LinearLayout mainLayout;
    private LinearLayout.LayoutParams rowParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1);
    private LinearLayout.LayoutParams colParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1);

    private int[] images;

    private int counter;
    private ImageView firstCard;

    private Handler handler;
    private int rightGuesses;
    private boolean inProcess;

    private long start, end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        level = getIntent().getIntExtra(MainActivity.LEVEL, -1);
        mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        handler = new Handler();
        init();

        int length = levels[level][0] * levels[level][1];
        images = new int[length];

        Field[] drawables = R.drawable.class.getFields();
        int counter = 0;
        for(Field f : drawables){
            if (f.getName().contains("monster_")){
                images[counter++] = getResources().getIdentifier(f.getName(), "drawable", getPackageName());
                images[counter++] = getResources().getIdentifier(f.getName(), "drawable", getPackageName());
            }
            if (counter == images.length){
                break;
            }
        }

        shuffle();

        start = System.currentTimeMillis();


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

    private void shuffle(){
        Random random = new Random();
        int randomIndex;
        int temp;
        for (int i = 0; i < images.length; i++) {
            randomIndex = random.nextInt(images.length);
            temp = images[i];
            images[i] = images[randomIndex];
            images[randomIndex] = temp;
        }
    }

    @Override
    public void onClick(View view) {
        if(!inProcess) {
            counter++;
            int clickedCardTag = (int) view.getTag();
            final ImageView currentCard = (ImageView) view;
            currentCard.setImageResource(images[clickedCardTag]);
            if (counter % 2 == 0) {
                // even card.
                inProcess = true;
                if (images[(int) firstCard.getTag()] == images[clickedCardTag]) {
                    // the monster_two cards are the same
                    currentCard.setOnClickListener(null);
                    rightGuesses++;
                    inProcess = false;
                    if (rightGuesses == images.length / 2) {
                        end = System.currentTimeMillis();
                        System.out.println(end + ", " + start);
                        Toast.makeText(this, "Game over " + (end - start)/1000 + " seconds", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // not the same.
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            firstCard.setOnClickListener(GameActivity.this);
                            firstCard.setImageResource(R.drawable.card);
                            currentCard.setImageResource(R.drawable.card);
                            inProcess = false;
                        }
                    }, 1000);

                }
            } else {
                // odd card
                firstCard = currentCard;
                firstCard.setOnClickListener(null);
            }
        }

    }
}
