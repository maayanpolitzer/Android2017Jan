package example.com.gettingtoknowwidgets;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int counter;
    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);

        editText = (EditText) findViewById(R.id.text_input);

        RadioGroup group = (RadioGroup) findViewById(R.id.group);

        Button btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(this);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int id) {
                Toast.makeText(MainActivity.this, id + "", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onClick(View view) {
        textView.setText(++counter + "");
        String name = editText.getText().toString();
        if (name.isEmpty()) {
            editText.setError("Cannot be empty");
            return;
        }
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }
}
