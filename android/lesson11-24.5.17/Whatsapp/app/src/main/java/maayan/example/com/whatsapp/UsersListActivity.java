package maayan.example.com.whatsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

public class UsersListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);

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
        System.out.println(data);
    }

    @Override
    public void onFailure(String error) {

    }
}
