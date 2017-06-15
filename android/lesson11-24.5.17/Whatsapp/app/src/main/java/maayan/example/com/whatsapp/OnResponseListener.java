package maayan.example.com.whatsapp;

import org.json.JSONObject;

/**
 * Created by hackeru on 21/05/2017.
 */

public interface OnResponseListener {

    void onSuccess(JSONObject data);
    void onFailure(String error);

}
