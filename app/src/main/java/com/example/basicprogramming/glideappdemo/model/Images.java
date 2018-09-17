package com.example.basicprogramming.glideappdemo.model;

public class Images {

    private String movieName;
    private String getMovieUrl;

    public Images(String movieName, String getMovieUrl) {
        this.movieName = movieName;
        this.getMovieUrl = getMovieUrl;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getGetMovieUrl() {
        return getMovieUrl;
    }
}
