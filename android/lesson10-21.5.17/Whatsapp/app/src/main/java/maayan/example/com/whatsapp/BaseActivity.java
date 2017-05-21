package maayan.example.com.whatsapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hackeru on 21/05/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements OnResponseListener {

    protected static final String ACTION = "action";
    protected static final String EMAIL = "email";
    protected static final String PASSWORD = "password";
    protected static final String USER_ID = "userID";
    protected static final String LOGIN = "LOGIN";
    protected static final String REGISTER = "REGISTER";
    protected static final String SEND_MESSAGE = "SEND_MESSAGE";

    private static final String SHARED_PREFS_FILE_NAME = "myPrefs";

    protected SharedPreferences settings;           // get data from file.
    protected SharedPreferences.Editor editor;      // change data in the file.

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        settings = getSharedPreferences(SHARED_PREFS_FILE_NAME, MODE_PRIVATE);
        editor = settings.edit();

    }
}
