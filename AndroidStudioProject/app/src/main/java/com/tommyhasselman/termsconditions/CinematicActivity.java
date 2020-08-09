package com.tommyhasselman.termsconditions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tommyhasselman.termsconditions.model.Cinematic;
import com.tommyhasselman.termsconditions.model.StoryTreeNode;

/**
 * The Class responsible for generating scenarios, generating adn listening to the buttons for the
 * purpose of keeping track of cinematic choices.
 */
public class CinematicActivity extends AppCompatActivity {

    private TextView message1;
    private Button choice1;
    private Button choice2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinematic);
        final Controller controller = ((Controller) this.getApplication());
        final Cinematic c = controller.getStoryNode().getCinematic();
        int score = controller.getPreviousRoundScore();
        message1 = (TextView) findViewById(R.id.message1);
        choice1 = (Button) findViewById(R.id.choice1);
        choice2 = (Button) findViewById(R.id.choice2);
        String s = ("Congratulations you packed " + score + " boxes,\nyou've earn't $" + controller.getBalanceEarnt() + ".");
        message1.setText(s);
        controller.setStoryNode(controller.getStoryNode().getRandomNode());
        controller.setBalance(controller.getBalance() - controller.getStoryNode().getCinematic().getCost()[2]);
        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO impliment costs
                controller.setBalance(controller.getBalance() - controller.getStoryNode().getCinematic().getCost()[0]); // this is a mess maybe i tidy this
                //TODO set depth of consequince to random

                controller.getStoryNode().setLeft(new StoryTreeNode(new Cinematic(Cinematic.getEventCode() + 10)));
                controller.setStoryNode(controller.getStoryNode().getRandomNode());
                //go back to LobbyActivity
                startActivity(new Intent(CinematicActivity.this, LobbyActivity.class));
                //TODO if balance < 0 go to fail case
                finish();
            }
        });
        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.setBalance(controller.getBalance() - controller.getStoryNode().getCinematic().getCost()[1]);
                //TODO do something with the choice
                //go back to LobbyActivity
                controller.setStoryNode(controller.getStoryNode().getRandomNode());
                startActivity(new Intent(CinematicActivity.this, LobbyActivity.class));
                //TODO if balance < 0 go to fail case
                finish();
            }
        });
        new CountDownTimer(5000, 1000) {
            //dont rip this out for codecov
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
