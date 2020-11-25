package space.harbour.java.myapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter {
    List<Movie> movieList;

    public MovieListAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        public TextView director;
        public TextView title;
        public ImageView poster;
        public TextView releaseDate;
        public TextView genre;

        public MovieViewHolder(View itemView) {
            super(itemView);
            director = itemView.findViewById(R.id.movie_director);
            title = itemView.findViewById(R.id.movie_title);
            genre = itemView.findViewById(R.id.movie_genre);
            releaseDate = itemView.findViewById(R.id.movie_releaseDate);
            poster = itemView.findViewById(R.id.movie_poster);

        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listElement = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_element, parent, false);
        return new MovieViewHolder(listElement);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MovieViewHolder movieViewHolder = (MovieViewHolder) holder;
        Movie movie = movieList.get(position);
        //movieViewHolder.director.setText(movie.director);
        movieViewHolder.title.setText(movie.title);
        movieViewHolder.genre.setText(movie.genre);
        movieViewHolder.releaseDate.setText(movie.releaseDate.toString());
        //movieViewHolder.poster.setImageResource(movie.poster);




    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }


}
