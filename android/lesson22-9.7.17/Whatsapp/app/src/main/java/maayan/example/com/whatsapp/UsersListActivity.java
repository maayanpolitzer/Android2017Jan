package maayan.example.com.whatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UsersListActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private ArrayList<User> users = new ArrayList<>();
    private View progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);

        progressBar = findViewById(R.id.activity_users_list_progress_bar);
        listView = (ListView) findViewById(R.id.activity_user_list_list_view);
        listView.setOnItemClickListener(this);

        JSONObject object = new JSONObject();
        try {
            object.put(ACTION, GET_USERS);
            object.put(USER_ID, settings.getInt(USER_ID, -1));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        new ConnectionThread(this, object).start();

    }

    @Override
    public void onSuccess(JSONObject data) {
        try {
            JSONArray arr = data.getJSONArray("users");
            for (int i = 0; i < arr.length(); i++){
                users.add(new User(arr.getJSONObject(i)));
            }
            ArrayAdapter<User> adapter = new ArrayAdapter<User>(
                    this,
                    android.R.layout.simple_list_item_1,
                    users
            );
            listView.setAdapter(adapter);
            progressBar.setVisibility(View.GONE);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(String error) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, ChatActivity.class);
        intent.putExtra(USER_ID, users.get(position).getId());
        intent.putExtra(EMAIL, users.get(position).getName());
        startActivity(intent);
        finish();
    }
}
