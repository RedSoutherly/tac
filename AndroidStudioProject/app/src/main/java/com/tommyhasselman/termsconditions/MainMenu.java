package com.tommyhasselman.termsconditions;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Controller cont = ((Controller) this.getApplication());

        if (cont.saveExists(this)) {
            cont.readSave(this);
            System.out.println("read save on create");
        } else {
            cont.createSave(this);
        }

        Button playButton = findViewById(R.id.playButton);
        Button optionsButton = findViewById(R.id.optionsButton);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, LobbyActivity.class));
            }
        });

        optionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, OptionsMenu.class));
            }
        });

    }
}