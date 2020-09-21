package com.tommyhasselman.termsconditions;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


/**
 * the lobby activity is a view with a button that displays information about how well youre are doing
 * and allowed you to pause before heading back to work
 */
public class LobbyActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby_new);

        final Controller cont = ((Controller) this.getApplication());

        if (cont.saveExists(getBaseContext())) {
            cont.createSave(this);
        } else {
            cont.resetSave();
        }

        Button workButton = findViewById(R.id.workButton);
        Button mmButton = findViewById(R.id.mmButton);
        TextView balanceTextView = findViewById(R.id.balanceText);
        TextView screenedTextView = findViewById(R.id.screenText);
        TextView welcomeTextView = findViewById(R.id.nameText);
        TextView roundsTV = findViewById(R.id.daysText);
        Button varsButton = findViewById(R.id.varsButton);

        String playerBalance = ""+cont.getBalance();
        String screened = ""+cont.getLifetimeScore();
        String welcome = cont.getPlayerName();
        String rounds = ""+cont.getRoundsPlayed();

        if (cont.getPlayerName().equals("debug")) {
            welcome = "~DEBUG~";
            varsButton.setVisibility(View.VISIBLE);
            varsButton.setEnabled(true);
        }

        balanceTextView.setText(playerBalance);
        screenedTextView.setText(screened);
        welcomeTextView.setText(welcome);
        roundsTV.setText(rounds);

        workButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LobbyActivity.this, ConveyorActivity.class));
                finish();
            }
        });

        mmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont.playSound(R.raw.angry_boat_1);
                startActivity(new Intent(LobbyActivity.this, MainMenu.class));
                finish();
            }
        });



        varsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LobbyActivity.this, VarsActivity.class));
            }
        });

    }

}