package hackeru.edu.autoanswer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.KeyEvent;

/**
 * Created by hackeru on 30/07/2017.
 */

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("TAG", "onReceive()");
        String extraState = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        if(extraState.equals(TelephonyManager.EXTRA_STATE_RINGING)){
            Log.d("TAG", "incoming call()");
            String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            if (incomingNumber.equals("0521234567")){
                Log.d("TAG", "from 1234");
                Intent i = new Intent(Intent.ACTION_MEDIA_BUTTON);
                i.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_HEADSETHOOK));
                context.sendOrderedBroadcast(i,null);
            }
        }
    }
}
