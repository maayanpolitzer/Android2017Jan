package hackeru.edu.tappinggame;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import hackeru.edu.tappinggame.db.DataSource;
import hackeru.edu.tappinggame.infrastructure.UserScore;

public class WallOfFameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall_of_fame);

        SharedPreferences settings = getSharedPreferences(SettingsActivity.FILE_NAME, MODE_PRIVATE);

        ListView listView = (ListView) findViewById(R.id.activity_wall_of_fame_list_view);
        ArrayAdapter<UserScore> adapter = new ArrayAdapter<UserScore>(
                this,
                android.R.layout.simple_list_item_1,
                DataSource.getInstance(this).getData(settings.getInt(SettingsActivity.DISPLAY, 10))
        );
        listView.setAdapter(adapter);

    }
}
