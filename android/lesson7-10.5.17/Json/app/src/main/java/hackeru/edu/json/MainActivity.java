package hackeru.edu.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private String json1 = "{firstName:\"Maayan\", lastName:\"Politzer\"}";
    private String arr = "[{age:30},{age:50},{age:117}]";
    private String third = "{name:\"Maayan\", family:[{year:1986}, {year:2014}, {year:2012}]}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        try {
            JSONObject json = new JSONObject(json1);
            String first = json.getString("firstName");
            String last = json.getString("lastName");
            System.out.println(first + " " + last);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        */

        /*
        try {
            JSONArray jsonArray = new JSONArray(arr);
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                int age = obj.getInt("age");
                System.out.println(age);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        */

        try {
            JSONObject obj = new JSONObject(third);
            String name = obj.getString("name");
            JSONArray arr = obj.getJSONArray("family");
            for (int i = 0; i < arr.length(); i++){
                JSONObject object = arr.getJSONObject(i);
                int year = object.getInt("year");
                System.out.println(name + " " + year);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
