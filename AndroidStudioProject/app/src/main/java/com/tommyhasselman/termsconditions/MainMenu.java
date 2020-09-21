package com.tommyhasselman.termsconditions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * main menu is resposible for creating and listening to all the buttons in the main menu
 * and entering a save game if one exists or creating a new one.
 */
public class MainMenu extends AppCompatActivity {

    ImageView head;
    Boolean eyebrowsDown;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_new);

        final Controller cont = ((Controller) this.getApplication());

        head = findViewById(R.id.head);
        eyebrowsDown = true;


        if (cont.saveExists(this)) {
            cont.readSave(this);
            System.out.println("read save on create");
        } else {
            cont.resetSave();
        }
        ImageButton titleB =findViewById(R.id.titleButton);
        Button playButton = findViewById(R.id.playButton);
        Button optionsButton = findViewById(R.id.optionsButton);

        titleB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(eyebrowsDown) {
                    head.setImageResource(R.drawable.bezoesup);
                    eyebrowsDown = false;
                } else {
                    head.setImageResource(R.drawable.bezos);
                    eyebrowsDown = true;
                }
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont.playSound(R.raw.angry_boat_2);
                startActivity(new Intent(MainMenu.this, LobbyActivity.class));
                finish();
            }
        });

        optionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont.playSound(R.raw.paper_rustle_short);
                startActivity(new Intent(MainMenu.this, OptionsMenu.class));
            }
        });

    }
}