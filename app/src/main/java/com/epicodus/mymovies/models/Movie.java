package com.epicodus.mymovies.models;

/**
 * Created by Guest on 7/7/16.
 */
public class Movie {
    String mTitle;
    String mSynopsis;
    String mImageUrl;


    public Movie() {
    }

    public Movie(String title, String synopsis, String imageUrl) {
        this.mTitle = title;
        this.mSynopsis = synopsis;
        this.mImageUrl = imageUrl;
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