package com.naeemsiddiq.moviesapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.naeemsiddiq.moviesapp.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Sakhi on 6/23/2017.
 */

public class MovieDetailActivity extends AppCompatActivity {

    private TextView title_TextView,rating_TextView,ryear_TextView,genre_TextView;
    private ImageView imageView;
    String title, rating, releaseYear, genre, image_url;
    private CollapsingToolbarLayout title_collapsingToolbarLayout = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movies_detail_activity);

        title_TextView = (TextView)findViewById(R.id.title);
        rating_TextView = (TextView)findViewById(R.id.rating);
        genre_TextView = (TextView)findViewById(R.id.genre);
        ryear_TextView = (TextView)findViewById(R.id.releaseyear);
        imageView=(ImageView)findViewById(R.id.movies_image);

        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        rating = intent.getStringExtra("rating");
        releaseYear = intent.getStringExtra("year");
        genre = intent.getStringExtra("genreStr");
        image_url = intent.getStringExtra("image_url");


        title_collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_g_name);
        title_collapsingToolbarLayout.setTitle(title);

        Picasso.with(this).load(image_url)
                .into(imageView);
        title_TextView.setText(title);
        rating_TextView.setText(rating);
        ryear_TextView.setText(releaseYear);
        genre_TextView.setText(genre);

    }
}
