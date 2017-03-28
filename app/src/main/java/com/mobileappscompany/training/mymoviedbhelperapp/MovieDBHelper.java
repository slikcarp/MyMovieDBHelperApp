package com.mobileappscompany.training.mymoviedbhelperapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 2/24/2017.
 */

public class MovieDBHelper extends SQLiteOpenHelper {

    //Each time that the app detects that this version changes it will fire the onUpdate() method.
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "movies.db";

    public MovieDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        addGenreTable(db);
        addMovieTable(db);
    }

    private void addMovieTable(SQLiteDatabase db) {

    }

    private void addGenreTable(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE" + MovieContract.GenreEntry.TABLE_NAME + " (" +
                    MovieContract.GenreEntry._ID + " INTEGER PRIMARY KEY, " +
                    MovieContract.GenreEntry.COLUMN_NAME + " TEXT NOT NULL);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(
                "CREATE TABLE " + MovieContract.MovieEntry.TABLE_NAME + " (" +
                        MovieContract.MovieEntry._ID + " INTEGER PRIMARY KEY, " +
                        MovieContract.MovieEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                        MovieContract.MovieEntry.COLUMN_RELEASE_DATE + " TEXT NOT NULL, " +
                        MovieContract.MovieEntry.COLUMN_GENRE + " INTEGER NOT NULL, " +
                        "FOREIGN KEY (" + MovieContract.MovieEntry.COLUMN_GENRE + ") " +
                        "REFERENCES " + MovieContract.GenreEntry.TABLE_NAME + "(" +
                        MovieContract.GenreEntry._ID + "));"
        );
    }
}
