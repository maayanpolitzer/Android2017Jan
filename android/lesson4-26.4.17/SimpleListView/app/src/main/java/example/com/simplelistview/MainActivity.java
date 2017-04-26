package example.com.simplelistview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] names = {"a", "b", "c", "d", "e","a", "b", "c", "d", "e","a", "d", "e","a", "b", "c", "d", "d", "e","a", "b", "c", "d",};
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.activity_main_list_view);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, names[position], Toast.LENGTH_LONG).show();
                view.setBackgroundColor(Color.parseColor("#00ff00"));
            }
        });
    }


    public void add(View view) {
        names[1] = "moshe";
        adapter.notifyDataSetChanged();
    }
}
