package space.harbour.java.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivityMovie extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter movieAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        movieAdapter = new MovieListAdapter(new ArrayList<Movie>());
        recyclerView.setAdapter(movieAdapter);

        try {
            URL url = new URL("http://192.168.65.129:4567/movies");
            new MovieMyAsyncTask(url, recyclerView).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showToast(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
