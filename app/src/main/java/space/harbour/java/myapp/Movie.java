package space.harbour.java.myapp;

import org.json.JSONException;
import org.json.JSONObject;

public class Movie {

    //public String director;
    public String title;
    public String genre;
    public Integer releaseDate;
    public String poster;

    public Movie(String title, String genre, Integer releaseDate, String poster) {
        //this.director = director;
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.poster = poster;

    }

    public JSONObject toJsonObject() throws JSONException {
        JSONObject object = new JSONObject();
        //object.put("director", director);
        object.put("title", title);
        object.put("genre", genre);
        object.put("releaseDate", releaseDate);
        object.put("poster", poster);
        return null;
    }

    public static Movie fromJsonObject(JSONObject object) throws JSONException {
        //String director = object.getString("director");
        String title = object.getString("title");
        String genre = object.getString("genre");
        int releaseDate = object.getInt("releaseDate");
        String poster = object.getString("poster");

        return new Movie(title, genre, releaseDate, poster);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Integer getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Integer releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public String getPoster() {
        return poster;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
