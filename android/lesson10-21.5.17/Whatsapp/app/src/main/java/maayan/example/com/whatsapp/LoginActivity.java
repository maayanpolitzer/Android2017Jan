package maayan.example.com.whatsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText emailET, passwordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.activity_login_button).setOnClickListener(this);
        emailET = (EditText) findViewById(R.id.activity_login_email_edit_text);
        passwordET = (EditText) findViewById(R.id.activity_login_password_edit_text);

    }

    @Override
    public void onClick(View v) {
        String email = emailET.getText().toString().trim();
        String password = passwordET.getText().toString();
        if(validate(email, password)) {
            JSONObject object = new JSONObject();
            try {
                object.put(ACTION, LOGIN);
                object.put(EMAIL, email);
                object.put(PASSWORD, password);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            new ConnectionThread(this, object).start();
        }
    }

    private boolean validate(String email, String password){
        return true;
    }

    @Override
    public void onSuccess(JSONObject data) {
        try {
            int userID = data.getInt(USER_ID);
            if (userID == -1) {
                onFailure("No such user");
            } else {
                // login completed!!!
                // save email, password, userID.
                editor.putInt(USER_ID, userID);
                editor.commit();
                // go to MainActivity.
                System.out.println("DONE");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
