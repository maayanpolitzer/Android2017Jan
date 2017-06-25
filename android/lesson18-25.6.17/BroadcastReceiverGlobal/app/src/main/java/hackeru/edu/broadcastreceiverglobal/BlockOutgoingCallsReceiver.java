package hackeru.edu.broadcastreceiverglobal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.HashSet;

/**
 * Created by hackeru on 25/06/2017.
 */

public class BlockOutgoingCallsReceiver extends BroadcastReceiver {

    //private String[] numbers = {"0522222222", "0544444444"};
    private HashSet<String> numbers = new HashSet<>();

    public BlockOutgoingCallsReceiver(){
        numbers.add("0522222222");
        numbers.add("0544444444");
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String number = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
        if(!checkNumber(number)){
            setResultData(null);
            Toast.makeText(context, "BLOCKED!!!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkNumber(String number){
        /*
        // check in array
        for (String str : numbers){
            if (str.equals(number)){
                return true;
            }
        }
        return false;
        */
        return numbers.contains(number);
    }

}
