package maayan.example.com.whatsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText emailET, passwordET;
    private String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.activity_login_button).setOnClickListener(this);
        emailET = (EditText) findViewById(R.id.activity_login_email_edit_text);
        passwordET = (EditText) findViewById(R.id.activity_login_password_edit_text);

        findViewById(R.id.activity_login_register_text_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
            }
        });

    }

    @Override
    public void onClick(View v) {
        email = emailET.getText().toString().trim();
        password = passwordET.getText().toString();
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
                editor.putString(EMAIL, email);
                editor.putString(PASSWORD, password);
                editor.commit();
                // go to MainActivity.
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra(ACTION, LOGIN);
                startActivity(intent);
                finish();
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
