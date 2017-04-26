package example.com.multipleactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditorActivity extends AppCompatActivity {

    static final String NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        String word = getIntent().getStringExtra(MainActivity.KEY);

        Toast.makeText(this, word, Toast.LENGTH_SHORT).show();

        Button saveBtn = (Button) findViewById(R.id.activity_editor_save_button);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameET = (EditText) findViewById(R.id.activity_editor_name_edit_text);
                String name = nameET.getText().toString();
                if (!name.isEmpty()){
                    Intent intent = new Intent();
                    intent.putExtra(NAME, name);
                    setResult(RESULT_OK, intent);
                    finish();
                }else{
                    nameET.setError("Why why why?");
                }
            }
        });

    }
}
