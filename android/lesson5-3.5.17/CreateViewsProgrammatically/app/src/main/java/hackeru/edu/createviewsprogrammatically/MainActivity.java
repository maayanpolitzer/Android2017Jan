package hackeru.edu.createviewsprogrammatically;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView textView = new TextView(this);
        textView.setText("wow!!! great work!");
        textView.setLayoutParams(params);

        textView.setBackgroundColor(Color.parseColor("#ff0000"));

        LinearLayout layout = (LinearLayout) findViewById(R.id.mainLayout);

        layout.addView(textView);

    }
}
