package example.com.multipleactivies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private EditText nameET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nameET = (EditText) findViewById(R.id.activity_second_name_edit_text);
        Intent nir = getIntent();
        String name = nir.getStringExtra("Name");
        nameET.setText(name);

        Button btn = (Button) findViewById(R.id.activity_second_back_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("Name", nameET.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }


}
