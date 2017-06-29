package com.naeemsiddiq.moviesapp.modal;

import java.util.ArrayList;

/**
 * Created by Sakhi on 6/21/2017.
 */

public class Movies {

    private String image;
    private String title;
    private int releaseYear;
    private double rating;
    private ArrayList<String> genre;

    public Movies() {
    }

    public Movies(String image, String title, int year, double rating, ArrayList<String> genre) {
        this.image = image;
        this.title = title;
        this.releaseYear = year;
        this.rating = rating;
        this.genre = genre;
    }

    public String getMovies_image() {
        return image;
    }

    public void setMovies_image(String movies_image) {
        this.image = movies_image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return releaseYear;
    }

    public void setYear(int year) {
        this.releaseYear = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }
}
