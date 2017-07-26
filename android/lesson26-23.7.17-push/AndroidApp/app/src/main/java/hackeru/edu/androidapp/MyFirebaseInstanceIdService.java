package hackeru.edu.androidapp;

import android.content.SharedPreferences;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;



/**
 * Created by hackeru on 23/07/2017.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        SharedPreferences settings = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("token", refreshedToken);
        editor.apply();    // DONT_FORGET!!!
        Log.d("TAG", "Refreshed token: " + refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.

        // TODO: 23/07/2017 update token in server!
        //sendRegistrationToServer(refreshedToken);
    }

}
