package space.harbour.java.myapp;

import android.os.AsyncTask;
import androidx.recyclerview.widget.RecyclerView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MovieMyAsyncTask extends AsyncTask<String, Integer, List<Movie>> {
    private URL url;
    private RecyclerView v;

    public MovieMyAsyncTask(URL s, RecyclerView view) throws MalformedURLException {
        url = s;
        v = view;
    }

    @Override
    protected List<Movie> doInBackground(String[] objects) {
        List<Movie> movies = new ArrayList<>();
        try {
            HttpURLConnection c = (HttpURLConnection)  url.openConnection();
            c.setRequestProperty("Accept", "application/json");

            StringBuilder response = new StringBuilder();
            try {
                InputStreamReader in = new InputStreamReader(c.getInputStream(), "UTF-8");
                BufferedReader br = new BufferedReader(in);
                String inputLine;
                while ((inputLine = br.readLine()) != null)
                    response.append(inputLine);
            } finally {
                c.disconnect();
            }
            JSONArray array = new JSONArray(response.toString());

            int n = array.length();
            for (int i = 0; i < n; i++) {
                movies.add(Movie.fromJsonObject(array.getJSONObject(i)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return movies;
    }

    @Override
    protected void onPostExecute(List<Movie> movies) {
        super.onPostExecute(movies);
        MovieListAdapter movieAdapter = new MovieListAdapter(movies);
        v.setAdapter(movieAdapter);
    }
}
