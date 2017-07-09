package maayan.example.com.whatsapp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hackeru on 09/07/2017.
 */

public class User {

    private String name;
    private int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public User(JSONObject object) throws JSONException {
        name = object.getString("email");
        id = object.getInt("userID");
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getId() {
        return id;
    }
}
