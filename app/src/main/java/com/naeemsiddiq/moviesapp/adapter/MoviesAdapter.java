package com.naeemsiddiq.moviesapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.naeemsiddiq.moviesapp.R;
import com.naeemsiddiq.moviesapp.activity.MovieDetailActivity;
import com.naeemsiddiq.moviesapp.modal.Movies;
import com.squareup.picasso.Picasso;

import java.util.List;
import static android.content.ContentValues.TAG;

/**
 * Created by Sakhi on 6/21/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesHolder> {

    private List<Movies> moviesList;
    private Context context;


    public class MoviesHolder extends RecyclerView.ViewHolder {
        public TextView title, rating, genre, releaseYear;
        public ImageView picassoImageView;

        public MoviesHolder(final View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            rating = (TextView) itemView.findViewById(R.id.rating);
            genre = (TextView) itemView.findViewById(R.id.genre);
            releaseYear = (TextView) itemView.findViewById(R.id.releaseyear);
            picassoImageView=(ImageView)itemView.findViewById(R.id.movies_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();

                    if( pos != RecyclerView.NO_POSITION)
                    {
                        //send to detail activity with data
                        Movies clickedItem = moviesList.get(pos);

                        String title = clickedItem.getTitle();
                        double rating = clickedItem.getRating();
                        String genreStr = "";
                        for (String str : clickedItem.getGenre()) {
                            genreStr += str + ", ";
                        }
                        genreStr = genreStr.length() > 0 ? genreStr.substring(0,
                                genreStr.length() - 2) : genreStr;
                        int year=clickedItem.getYear();
                        String image_url=clickedItem.getMovies_image();
                        Intent intent = new Intent(context, MovieDetailActivity.class);
                        intent.putExtra("title",title);
                        intent.putExtra("rating",rating);
                        intent.putExtra("genreStr",genreStr);
                        intent.putExtra("year",year);
                        intent.putExtra("image_url",image_url);
                        context.startActivity(intent);

                    }
                }
            });

        }
    }

    public MoviesAdapter(List<Movies> moviesList,Context context) {
        this.moviesList = moviesList;
        this.context=context;
    }

    @Override
    public MoviesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movies_row_list, parent, false);
        return new MoviesHolder(view);
    }

    @Override
    public void onBindViewHolder(MoviesHolder holder, int position) {

        Movies movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.rating.setText(String.valueOf(movie.getRating()));
        Log.d(TAG, "onBindViewHolder: "+movie.getYear());
        holder.releaseYear.setText(String.valueOf(movie.getYear()));
        String genreStr = "";
        for (String str : movie.getGenre()) {
            genreStr += str + ", ";
        }
        genreStr = genreStr.length() > 0 ? genreStr.substring(0,
                genreStr.length() - 2) : genreStr;
        holder.genre.setText(genreStr);
        Picasso.with(holder.itemView.getContext()).load(movie.getMovies_image())
                .into(holder.picassoImageView);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

}
