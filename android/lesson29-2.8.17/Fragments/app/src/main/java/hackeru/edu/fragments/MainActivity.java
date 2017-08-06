package hackeru.edu.fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements RowClickListener {

    private EditText nameET;
    private boolean edit;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FirstFragment firstFragment = new FirstFragment();

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.list_container, firstFragment)
                .commit();


        nameET = (EditText) findViewById(R.id.nameET);

        findViewById(R.id.activity_main_add_name_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameET.getText().toString().trim();
                if (name.isEmpty()){
                    nameET.setError("Why like this");
                }else{
                    if (edit){
                        firstFragment.editName(name, position);
                    }else{
                        firstFragment.addName(name);
                    }
                    nameET.setText("");
                    edit = false;
                }
            }
        });
    }

    public void editName(String name, int position){
        edit = true;
        this.position = position;
        nameET.setText(name);
    }

    @Override
    public void onRowClicked(String name) {
        DetailsFragment detailsFragment = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("NAME", name);
        detailsFragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.details_container, detailsFragment)
                .commit();
    }
}
