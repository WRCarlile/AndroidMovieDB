package com.epicodus.mymovies.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.mymovies.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.findMoviesTitle)
    Button mFindMoviesTitle;
    @Bind(R.id.findMoviesRating)
    Button mFindMoviesRating;
    @Bind(R.id.findMoviesDate)
    Button mFindMoviesDate;
    @Bind(R.id.title)
    EditText mTitle;
    @Bind(R.id.rating)
    EditText mRating;
    @Bind(R.id.date)
    EditText mDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFindMoviesTitle.setOnClickListener(this);
        mFindMoviesRating.setOnClickListener(this);
        mFindMoviesDate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mFindMoviesTitle) {
            String movieTitle = mTitle.getText().toString();
            Intent intent = new Intent(MainActivity.this, MoviesActivity.class);
            intent.putExtra("title", movieTitle);
            startActivity(intent);
        }
        if (v == mFindMoviesRating) {
            String movieRating = mRating.getText().toString();
            Intent intent = new Intent(MainActivity.this, MoviesActivity.class);
            intent.putExtra("rating", movieRating);
            startActivity(intent);
        }
        if (v == mFindMoviesDate) {
            String movieDate = mDate.getText().toString();
            Intent intent = new Intent(MainActivity.this, MoviesActivity.class);
            intent.putExtra("date", movieDate);
            startActivity(intent);

        }
    }
}
