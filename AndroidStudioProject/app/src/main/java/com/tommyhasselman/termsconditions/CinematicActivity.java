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
 *  The Class responsible for generating scenarios, generating adn listening to the buttons for the
 *  purpose of keeping track of cinematic choices.
 */
public class CinematicActivity extends AppCompatActivity {
    private TextView message1;
    private Button choice1;
    private Button choice2;
    private Controller controller;
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
        String s = ("Congratulations you packed "+ score +" boxes,\nyou've earn't $" + controller.getBalanceEarnt()+".");
        message1.setText(s);
        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO do something with the choice
                //go back to LobbyActivity
                startActivity(new Intent(CinematicActivity.this,LobbyActivity.class));
            }
        });
        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //TODO do something with the choice
                //go back to LobbyActivity
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
