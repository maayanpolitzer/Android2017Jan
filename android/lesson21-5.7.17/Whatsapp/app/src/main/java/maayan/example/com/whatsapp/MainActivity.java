package maayan.example.com.whatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getIntent().getStringExtra(ACTION) == null) {
            int userID = settings.getInt(USER_ID, -1);
            if (userID == -1) {
                startActivity(new Intent(this, LoginActivity.class));
                finish();
            }else{
                JSONObject object = new JSONObject();
                String email = settings.getString(EMAIL, "");
                String password = settings.getString(PASSWORD, "");
                try {
                    object.put(ACTION, LOGIN);
                    object.put(EMAIL, email);
                    object.put(PASSWORD, password);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                new ConnectionThread(this, object).start();
                findViewById(R.id.activity_main_new_chat_floating_action_button).setOnClickListener(this);
            }
        }

    }

    @Override
    public void onSuccess(JSONObject data) {
        try {
            int id = data.getInt(USER_ID);
            if (id == -1){
                onFailure("good job gabriel");
            }else{
                // WOW!!!

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(String error) {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_main_action_logout:
                //editor.clear(); // erase data from file.
                editor.remove(USER_ID);
                editor.commit();
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        //startActivity(new Intent(this, UsersListActivity.class));
        startActivity(new Intent(this, ChatActivity.class));
        System.out.println("WOW");
    }
}
