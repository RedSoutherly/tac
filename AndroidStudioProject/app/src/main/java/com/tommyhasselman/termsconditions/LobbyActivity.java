package com.tommyhasselman.termsconditions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tommyhasselman.termsconditions.model.BasicItem;


/**
 * the lobby activity is a view with a button that displays information about how well youre are doing
 * and allowed you to pause before heading back to work
 */
public class LobbyActivity extends BaseActivity {

    Controller cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        Button workButton = (Button) findViewById(R.id.workButton);
        TextView balanceTextView = (TextView) findViewById(R.id.balanceTextView);
        TextView screenedTextView = (TextView) findViewById(R.id.screenedTextView);

        cont = ((Controller) this.getApplication());

        String playerBalance = "$"+cont.getBalance();
        String screened = ""+cont.getLifetimeScore();

        balanceTextView.setText(playerBalance);
        screenedTextView.setText(screened);

        workButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LobbyActivity.this,MainActivity.class));
            }
        });
    }

}