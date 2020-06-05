package com.tommyhasselman.termsconditions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LobbyActivity extends AppCompatActivity {

    Button workButton;
    TextView balanceTextView;

    Controller cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        workButton = (Button) findViewById(R.id.workButton);
        balanceTextView = (TextView) findViewById(R.id.balanceTextView);

        cont = ((Controller) this.getApplication());
        String playerBalance = "$"+cont.getBalance();


        balanceTextView.setText(playerBalance);

        workButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LobbyActivity.this,MainActivity.class));
            }
        });
    }

}