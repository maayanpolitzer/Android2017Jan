package hackeru.edu.listviewhw;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener, AdapterView.OnItemLongClickListener {

    private ArrayList<String> names = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ListView listView;

    private final static int ADD_REQUEST_CODE = 1;
    private final static int UPDATE_REQUEST_CODE = 2;

    static final String NAME = "name";

    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.activity_main_list_view);
        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                names
            );
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);

        findViewById(R.id.activity_main_add_button).setOnClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        this.position = position;
        Intent intent = new Intent(this, EditorActivity.class);
        intent.putExtra(NAME, names.get(position));
        startActivityForResult(intent, UPDATE_REQUEST_CODE);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, EditorActivity.class);
        startActivityForResult(intent, ADD_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK){
            String name = data.getStringExtra(NAME);
            switch (requestCode) {
                case ADD_REQUEST_CODE:
                    names.add(name);
                    break;
                case UPDATE_REQUEST_CODE:
                    names.set(position, name);
                    break;
            }
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onItemLongClick(final AdapterView<?> adapterView, View view, final int position, long id) {
        /*
        names.remove(position);
        adapter.notifyDataSetChanged();
        */

        new AlertDialog.Builder(this)
                .setTitle("Are you sure???")
                .setMessage("delete " + names.get(position) + " ?")
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        names.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
        }).show();
        return true;
    }
}
