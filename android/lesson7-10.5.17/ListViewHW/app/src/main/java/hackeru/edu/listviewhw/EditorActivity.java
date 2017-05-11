package hackeru.edu.listviewhw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditorActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        nameET = (EditText) findViewById(R.id.activity_editor_edit_text);
        Button btn = (Button) findViewById(R.id.activity_editor_button);
        btn.setOnClickListener(this);

        String name = getIntent().getStringExtra(MainActivity.NAME);
        if (name != null){
            // update!
            nameET.setText(name);
            btn.setText("UPDATE");
        }

    }

    @Override
    public void onClick(View view) {
        String name = nameET.getText().toString().trim();
        if (!name.isEmpty()) {
            Intent intent = new Intent();
            intent.putExtra(MainActivity.NAME, name);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
