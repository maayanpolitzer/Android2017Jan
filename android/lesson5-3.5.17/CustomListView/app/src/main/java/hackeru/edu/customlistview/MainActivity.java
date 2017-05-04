package hackeru.edu.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private Action[] actions = {
            new Action("1", android.R.drawable.btn_radio),
            new Action("2", android.R.drawable.ic_dialog_email),
            new Action("3", android.R.drawable.btn_radio),
            new Action("4", android.R.drawable.ic_dialog_email),
            new Action("5", android.R.drawable.btn_radio),
            new Action("6", android.R.drawable.ic_dialog_email),
            new Action("7", android.R.drawable.btn_radio),
            new Action("8", android.R.drawable.ic_dialog_email),
            new Action("9", android.R.drawable.btn_radio),
            new Action("10", android.R.drawable.ic_dialog_email),
            new Action("11", android.R.drawable.btn_radio),
            new Action("12", android.R.drawable.ic_dialog_email),
            new Action("13", android.R.drawable.btn_radio),
            new Action("14", android.R.drawable.ic_dialog_email),
            new Action("15", android.R.drawable.btn_radio),
            new Action("16", android.R.drawable.ic_dialog_email),
            new Action("17", android.R.drawable.btn_radio),
            new Action("18", android.R.drawable.ic_dialog_email),
            new Action("19", android.R.drawable.ic_menu_save)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listView = (ListView) findViewById(R.id.activity_main_list_view);
        /*
        ArrayAdapter<Action> adapter = new ArrayAdapter<Action>(
                this,
                android.R.layout.simple_list_item_1,
                actions
        );
        */

        MyAdapter adapter = new MyAdapter(this, actions);
        listView.setAdapter(adapter);


    }
}
