package com.naeemsiddiq.moviesapp.network;

import com.naeemsiddiq.moviesapp.modal.Movies;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Sakhi on 6/21/2017.
 */

public interface ApiService {
    @GET("json/movies.json")
    Call<List<Movies>> getMoviesData();
}
