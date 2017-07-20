package com.maayan;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hackeru on 19/07/2017.
 */
public class Message {

    private int from;
    private int to;
    private String content;
    private boolean read;

    public Message(JSONObject input) throws JSONException {
        from = input.getInt("from");
        to = input.getInt("to");
        content = input.getString("content");
    }

    public JSONObject toJson() throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("content", content);
        obj.put("from", from);
        read = true;
        return obj;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public String getContent() {
        return content;
    }

    public boolean isRead() {
        return read;
    }
}
