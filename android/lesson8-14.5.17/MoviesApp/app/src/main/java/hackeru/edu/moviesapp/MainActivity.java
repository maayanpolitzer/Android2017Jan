package hackeru.edu.moviesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText searchEditText;

    static final String SEARCH = "search";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.activity_main_search_button).setOnClickListener(this);
        searchEditText = (EditText) findViewById(R.id.activity_main_movie_edit_text);

    }

    @Override
    public void onClick(View view) {
        String search = searchEditText.getText().toString().trim();
        if(search.isEmpty()){
            searchEditText.setError("Enter a longer name.(:");
        }else{
            Intent intent = new Intent(this, ResultsActivity.class);
            intent.putExtra(SEARCH, search);
            startActivity(intent);
        }
    }
}
