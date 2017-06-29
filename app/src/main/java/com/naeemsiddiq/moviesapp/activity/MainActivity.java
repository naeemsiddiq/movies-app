package com.naeemsiddiq.moviesapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

import com.naeemsiddiq.moviesapp.R;
import com.naeemsiddiq.moviesapp.adapter.MoviesAdapter;
import com.naeemsiddiq.moviesapp.modal.Movies;
import com.naeemsiddiq.moviesapp.network.ApiClient;
import com.naeemsiddiq.moviesapp.network.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Movies> moviesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter moviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        getMoviesListFromApi();

    }

    private void getMoviesListFromApi() {
        try {

            ApiService apiService = ApiClient.getRetrofit().create(ApiService.class);
            Call<List<Movies>> moviesListCall = apiService.getMoviesData();

            moviesListCall.enqueue(new Callback<List<Movies>>() {
                @Override
                public void onResponse(Call<List<Movies>> call, Response<List<Movies>> response) {

                    moviesList = response.body();
                    moviesAdapter = new MoviesAdapter(moviesList,MainActivity.this);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setAdapter(moviesAdapter);
                }

                @Override
                public void onFailure(Call<List<Movies>> call, Throwable t) {

                }
            });
        } catch (Exception e) {

        }


    }
}
