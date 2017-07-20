package com.maayan;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hackeru on 19/07/2017.
 */
public class User {

    private final String email;
    private final String password;
    private int id;
    private static int counter;

    public User(String email, String password){
        this.email = email;
        this.password = password;
        id = ++counter;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("email", email);
        obj.put("userID", id);
        return obj;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }
}
