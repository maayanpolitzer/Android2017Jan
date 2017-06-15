package hackeru.edu.tappinggame;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import hackeru.edu.tappinggame.db.DataSource;
import hackeru.edu.tappinggame.infrastructure.ScoresAdapter;

public class WallOfFameActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall_of_fame);

        SharedPreferences settings = getSharedPreferences(SettingsActivity.FILE_NAME, MODE_PRIVATE);

        ListView listView = (ListView) findViewById(R.id.activity_wall_of_fame_list_view);
        ScoresAdapter adapter = new ScoresAdapter(
                this,
                DataSource.getInstance(this).getCursor(settings.getInt(SettingsActivity.DISPLAY, 10))
        );
        /*
        ArrayAdapter<UserScore> adapter = new ArrayAdapter<UserScore>(
                this,
                android.R.layout.simple_list_item_1,
                DataSource.getInstance(this).getData(settings.getInt(SettingsActivity.DISPLAY, 10))
        );
        */
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
