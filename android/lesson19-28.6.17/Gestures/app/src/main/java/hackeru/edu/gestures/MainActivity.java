package hackeru.edu.gestures;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String X = "moshe";
    private static final String Y = "Shuki";
    private ImageView ball;
    private boolean dragging;
    private float fixX, fixY;
    private View view;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(200, 200);
        RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
        view = findViewById(R.id.dropZone);
        handler = new Handler();


        ball = new ImageView(this);
        ball.setImageResource(R.drawable.football);
        ball.setLayoutParams(params);
        mainLayout.addView(ball);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putFloat(X, ball.getX());
        outState.putFloat(Y, ball.getY());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        ball.setX(savedInstanceState.getFloat(X));
        ball.setY(savedInstanceState.getFloat(Y));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(
                        event.getX() >= ball.getX() &&
                        event.getX() <= (ball.getX() + ball.getWidth()) &&
                        event.getY() >= ball.getY() &&
                        event.getY() <= (ball.getY() + ball.getHeight())
                        ){
                    dragging = true;
                    fixX = event.getX() - ball.getX();
                    fixY = event.getY() - ball.getY();
                }
                break;

            case MotionEvent.ACTION_MOVE:
                if (dragging){
                    ball.setX(event.getX() - fixX);
                    ball.setY(event.getY() - fixY);
                }
                break;

            case MotionEvent.ACTION_UP:
                if (
                        event.getX() < view.getX() ||
                        event.getX() > (view.getX() + view.getWidth()) ||
                        event.getY() < view.getY() ||
                        event.getY() > (view.getY() + view.getHeight())
                        ){
                    moveToPoint(0,0);
                }
                dragging = false;
                break;
        }
        return true;
    }

    private void moveToPoint(final float x, final float y){
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        float tempX = ball.getX();
                        float tempY = ball.getY();
                        while(ball.getX() != x || ball.getY() != y){
                            final float xx = tempX *= 0.95;
                            final float yy = tempY *= 0.95;
                            if (tempX < x + 2){
                                tempX = x;
                            }
                            if (tempY < y + 2){
                                tempY = y;
                            }

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    ball.setX(xx);
                                    ball.setY(yy);
                                }
                            });

                            try {
                                Thread.sleep(16);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        ).start();
    }

}










