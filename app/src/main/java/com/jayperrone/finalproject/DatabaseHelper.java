package com.jayperrone.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "videogames";
    private static final String GAME = "game";
    private static final String YEAR = "year";

    public DatabaseHelper (Context context){
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }//end of DatabaseHelper

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try{
            sqLiteDatabase.execSQL("CREATE TABLE favorite_games (_id INTEGER PRIMARY KEY AUTOINCREMENT, game TEXT, year TEXT);");
            ContentValues cv = new ContentValues();

            cv.put(GAME, "Persona 5 Royal");
            cv.put(YEAR, "2019");
            sqLiteDatabase.insert("favorite_games", GAME, cv);

            cv.put(GAME, "Dragon Quest XI");
            cv.put(YEAR, "2017");
            sqLiteDatabase.insert("favorite_games", GAME, cv);

            cv.put(GAME, "Fire Emblem Three Houses");
            cv.put(YEAR, "2019");
            sqLiteDatabase.insert("favorite_games", GAME, cv);

            cv.put(GAME, "Dragon Quest VIII");
            cv.put(YEAR, "2004");
            sqLiteDatabase.insert("favorite_games", GAME, cv);

            cv.put(GAME, "Horizon Zero Dawn");
            cv.put(YEAR, "2017");
            sqLiteDatabase.insert("favorite_games", GAME, cv);

        }//end of try
        catch (Exception ex){
            android.util.Log.w("videogames", ex);
        }//end of catch

    }//end of onCreate

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS favorite_games");
        onCreate(sqLiteDatabase);
    }//end of onUpgrade
}//end of class
