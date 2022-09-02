package com.jayperrone.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Button btnFavorite;
    private EditText enteredFavorite;
    private String favoriteGame;
    private TextView favoriteResult;
    private Button btnChangeActivity;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Video Games!");
        setSupportActionBar(toolbar);

        btnFavorite = (Button) findViewById(R.id.favorite_button);
        enteredFavorite = (EditText) findViewById(R.id.game_question);
        favoriteResult = (TextView) findViewById(R.id.entered_favorite);

        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                favoriteGame = enteredFavorite.getText().toString();
                setFavoriteText(favoriteGame);
            }//end of onClick
        });//end of onClickListener

        btnChangeActivity = (Button) findViewById(R.id.my_favorites);

        btnChangeActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }//end of onClick
        });//end of onClickListener

    }//end of onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.nav_menu, menu);
        return true;
    }//end of onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.game_dialog:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Do you like video games?")
                        .setTitle("A question for you!");
                builder.setCancelable(true);

                builder.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                positiveDialog();
                                dialog.cancel();
                            }
                        });//end of setPositiveButton

                builder.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                negativeDialog();
                                dialog.cancel();
                            }
                        });//end of setNegativeButton

                AlertDialog dialog = builder.create();
                dialog.show();
                break;

            case R.id.funny_option:
                funnyMenuOption();
                break;
        }//end of switch

        return true;

    }//end of onOptionsItemSelected

    public void setFavoriteText(String userFavorite){
        favoriteResult.setText(userFavorite);
    }//end of setFavoriteText

    public void positiveDialog(){
        Toast.makeText(this,"Hooray!", Toast.LENGTH_SHORT).show();
    }//end of positiveDialog

    public void negativeDialog(){
        Toast.makeText(this, "Oh nooooo!", Toast.LENGTH_SHORT).show();
    }//end of negativeDialog

    public void funnyMenuOption(){
        Toast.makeText(this, "Well, I'm happy to see you anyway!", Toast.LENGTH_SHORT).show();
    }//end of funnyMenuOption

}//end of class