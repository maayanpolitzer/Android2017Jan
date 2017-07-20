package com.maayan;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by hackeru on 19/07/2017.
 */
@WebServlet(name = "MainServlet", urlPatterns = "/tal")
public class MainServlet extends HttpServlet {

    private Vector<User> users = new Vector<>();
    private Vector<Message> messages = new Vector<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        StringBuffer sb = new StringBuffer();
        String line;
        while((line = reader.readLine()) != null){
            sb.append(line);
        }
        try {
            JSONObject input = new JSONObject(sb.toString());
            JSONObject output = new JSONObject();
            String action = input.getString("action");
            switch(action){
                case "REGISTER":
                    output.put("userID", register(input));
                    break;
                case "LOGIN":
                    output.put("userID", login(input));
                    break;
                case "GET_USERS":
                    output.put("users", getUsers(input));
                    break;
                case "SEND_MESSAGE":
                    output.put("response", sendMessage(input));
                    break;
                case "GET_MESSAGE":
                    output.put("message", getMessage(input));
                    break;
            }
            String str = output.toString();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private JSONObject getMessage(JSONObject input) throws JSONException{
        for (Message m : messages){
            if (!m.isRead() && m.getTo() == input.getInt("userID")){
                return m.toJson();
            }
        }
        return null;
    }

    private boolean sendMessage(JSONObject input) throws JSONException {
        return messages.add(new Message(input));
    }

    private JSONArray getUsers(JSONObject input) throws JSONException {
        JSONArray arr = new JSONArray();
        for (User u : users){
            if (u.getId() != input.getInt("userID")){
                arr.put(u.toJson());
            }
        }
        return arr;
    }

    private int login(JSONObject input) throws JSONException {
        String email = input.getString("email");
        String password = input.getString("password");
        for (User u : users){
            if (u.getEmail().equals(email) && u.getPassword().equals(password)){
                return u.getId();
            }
        }
        return -1;
    }

    private int register(JSONObject input) throws JSONException {
        String email = input.getString("email");
        for (User u : users){
            if (u.getEmail().equals(email)){
                // NOT GOOD.
                return -1;
            }
        }
        User user = new User(email, input.getString("password"));
        users.add(user);
        return user.getId();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet()");
    }
}
