package com.tommyhasselman.termsconditions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tommyhasselman.termsconditions.model.Cinematic;

/**
 *  the Class resposible for generating scenarios, generating adn listening to the buttons for the
 *  purpose of keeping track of cinimatic choices.
 */
public class CinematicActivity extends AppCompatActivity {
    TextView message1;
    Button choice1;
    Button choice2;
    Controller controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinematic);
        final Cinematic c = new Cinematic();
        controller = ((Controller) this.getApplication());
        int score=controller.getPreviousRoundScore();
        message1= (TextView) findViewById(R.id.message1);
        choice1 = (Button) findViewById(R.id.choice1);
        choice2 = (Button) findViewById(R.id.choice2);
        message1.setText("congradulations you packed "+ score +"boxes, youve earnt $" + controller.getBalanceEarnt());
        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO do something with the choice
                //go back to mainview
                startActivity(new Intent(CinematicActivity.this,LobbyActivity.class));
            }
        });
        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //TODO do something with the choice
                //go back to mainview
             startActivity(new Intent(CinematicActivity.this,LobbyActivity.class));
            }
        });
        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                message1.setText(c.getScenarioChoice());
                choice1.setText(c.getFirstChoice());
                choice1.setVisibility(View.VISIBLE);
                choice2.setText(c.getSecondChoice());
                choice2.setVisibility(View.VISIBLE);
            }
        }.start();
        //display options and buttons
        //do noting with that 
    }

}
