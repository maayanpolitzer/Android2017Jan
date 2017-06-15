package maayan.example.com.whatsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private EditText emailET, passwordET, confirmPasswordET;
    private String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailET = (EditText) findViewById(R.id.activity_register_email_edit_text);
        passwordET = (EditText) findViewById(R.id.activity_register_password_edit_text);
        confirmPasswordET = (EditText) findViewById(R.id.activity_register_confirm_password_edit_text);

        findViewById(R.id.activity_register_button).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        email = emailET.getText().toString().trim();
        password = passwordET.getText().toString();
        String confirmPassword = confirmPasswordET.getText().toString();
        if (validate(email, password, confirmPassword)) {
            JSONObject object = new JSONObject();
            try {
                object.put(ACTION, REGISTER);
                object.put(EMAIL, email);
                object.put(PASSWORD, password);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            new ConnectionThread(this, object).start();
        }

    }

    private boolean validate(String email, String password, String confirmPassword){
        return true;
    }

    @Override
    public void onSuccess(JSONObject data) {
        try {
            int userID = data.getInt(USER_ID);
            if (userID == -1){
                onFailure("Email already in use...");
            }else{
                // register completed!!!
                // save email, password, userID.
                editor.putInt(USER_ID, userID);
                editor.putString(EMAIL, email);
                editor.putString(PASSWORD, password);
                editor.commit();
                // go to MainActivity.
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra(ACTION, REGISTER);
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
