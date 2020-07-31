package com.tommyhasselman.termsconditions;

import android.content.Context;
import android.content.Intent;
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
        setContentView(R.layout.activity_lobby);

        Controller cont = ((Controller) this.getApplication());

        cont.createSave(this);

        Button workButton = findViewById(R.id.workButton);
        TextView balanceTextView = findViewById(R.id.balanceTextView);
        TextView screenedTextView = findViewById(R.id.screenedTextView);
        TextView welcomeTextView = findViewById(R.id.welcomeTextView);

        String playerBalance = "$"+cont.getBalance();
        String screened = ""+cont.getLifetimeScore();
        String welcome = "Welcome back ";

        balanceTextView.setText(playerBalance);
        screenedTextView.setText(screened);
        welcomeTextView.setText(welcome);

        workButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LobbyActivity.this,MainActivity.class));
            }
        });
    }

}