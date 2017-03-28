package com.mobileappscompany.training.mymoviedbhelperapp;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentValues values = new ContentValues();
        values.put(MovieContract.MovieEntry.COLUMN_NAME, "Residen Evil");
        values.put(MovieContract.MovieEntry.COLUMN_RELEASE_DATE, "02/13/2017");

        MovieProvider mp = new MovieProvider();
        mp.update(new Uri, values);
    }
}
