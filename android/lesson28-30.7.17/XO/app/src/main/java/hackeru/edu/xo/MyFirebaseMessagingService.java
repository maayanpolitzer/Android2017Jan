package hackeru.edu.xo;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by hackeru on 30/07/2017.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d("TAG", remoteMessage.getData().toString());
        String data = remoteMessage.getData().get("data");
        if(data.equals("start")){
            Intent intent = new Intent("99fm");
            sendBroadcast(intent);
        }

    }
}
