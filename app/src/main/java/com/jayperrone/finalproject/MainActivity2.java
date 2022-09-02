package com.jayperrone.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private Toolbar toolbar;

    private SQLiteDatabase db;
    private Cursor constantsCursor;
    private int flags = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        db = (new DatabaseHelper(this)).getWritableDatabase();
        constantsCursor = db.rawQuery("SELECT _id, game, year " +
                        "FROM favorite_games ORDER BY game",
                null);

        ListView gameList = findViewById(R.id.game_list);

        ListAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.row, constantsCursor, new String[] {"game", "year"},
                new int[] {R.id.name, R.id.release_year},flags);
        gameList.setAdapter(adapter);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Video Games!");

    }//end of onCreate

    @Override
    public void onDestroy() {
        super.onDestroy();

        constantsCursor.close();
        db.close();
    }//end of onDestroy

}//end of class