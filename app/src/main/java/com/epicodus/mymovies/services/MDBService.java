package com.epicodus.mymovies.services;


import android.util.Log;

import com.epicodus.mymovies.Constants;
import com.epicodus.mymovies.models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MDBService {
    public static void findTitle(String movieTitle, Callback callback) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.MOVIEDB_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter("api_key", Constants.MOVIEDB_CONSUMER_KEY);
        urlBuilder.addQueryParameter("query", movieTitle);

        String url = urlBuilder.build().toString();
        Log.d("hi", url);
        OkHttpClient client = new OkHttpClient.Builder()
                .build();


        Request request= new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static void findRating(String movieRating, Callback callback) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.MOVIEDB_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.MOVIEDB_RATING_QUERY_PARAMETER, movieRating);
        String url = urlBuilder.build().toString();

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        Request request= new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }
    public static void findDate(String movieDate, Callback callback) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.MOVIEDB_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.MOVIEDB_DATE_QUERY_PARAMETER, movieDate);
        String url = urlBuilder.build().toString();

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        Request request= new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Movie> processResults(Response response) {
        ArrayList<Movie> movies = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject mdbJSON = new JSONObject(jsonData);
                JSONArray resultsJSON = mdbJSON.getJSONArray("results");
                for (int i = 0; i < resultsJSON.length(); i++) {
                    JSONObject movieJSON = resultsJSON.getJSONObject(i);
                    String title = movieJSON.getString("title");
                    String synopsis = movieJSON.getString("overview");
                    String imageUrl = movieJSON.getString("poster_path");



                Movie movie = new Movie(title, synopsis, imageUrl);
                movies.add(movie);
            }

         }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return movies;
    }
}



