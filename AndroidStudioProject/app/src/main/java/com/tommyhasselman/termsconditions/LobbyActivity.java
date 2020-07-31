package com.tommyhasselman.termsconditions;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * the lobby activity is a view with a button that displays information about how well youre are doing
 * and allowed you to pause before heading back to work
 */
public class LobbyActivity extends BaseActivity {

    Controller cont = ((Controller) this.getApplication());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        Button workButton = (Button) findViewById(R.id.workButton);
        TextView balanceTextView = (TextView) findViewById(R.id.balanceTextView);
        TextView screenedTextView = (TextView) findViewById(R.id.screenedTextView);
        TextView welcomeTextView = (TextView) findViewById(R.id.welcomeTextView);

        cont = ((Controller) this.getApplication());

        String playerBalance = "$"+cont.getBalance();
        String screened = ""+cont.getLifetimeScore();
        String welcome = "Welcome back " + cont.getPlayerDisplayName();

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