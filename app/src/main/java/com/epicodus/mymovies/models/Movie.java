package com.epicodus.mymovies.models;


public class Movie {
    String mTitle;
    String mSynopsis;
    String mImageUrl;


    public Movie() {
    }

    public Movie(String title, String synopsis, String imageUrl) {
        this.mTitle = title;
        this.mSynopsis = synopsis;
        this.mImageUrl = "http://image.tmdb.org/t/p/w500" + imageUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSynopsis() {
        return mSynopsis;
    }

    public String getImageUrl() {
        return mImageUrl;
    }
}