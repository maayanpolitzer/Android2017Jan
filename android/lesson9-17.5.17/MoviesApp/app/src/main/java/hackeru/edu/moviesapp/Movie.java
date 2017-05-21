package hackeru.edu.moviesapp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hackeru on 14/05/2017.
 */

public class Movie {

    private String title;
    private String year;
    private String poster;
    private String imdbID;

    public Movie(JSONObject obj) throws JSONException {
        title = obj.getString("Title");
        year = obj.getString("Year");
        poster = obj.getString("Poster");
        imdbID = obj.getString("imdbID");
    }

    @Override
    public String toString() {
        return title;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getPoster() {
        return poster;
    }

    public String getImdbID() {
        return imdbID;
    }
}
