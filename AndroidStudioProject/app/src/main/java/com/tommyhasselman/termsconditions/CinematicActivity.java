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

import static java.lang.Thread.sleep;

/**
 * The Class responsible for generating scenarios, generating adn listening to the buttons for the
 * purpose of keeping track of cinematic choices.
 */
public class CinematicActivity extends AppCompatActivity {

    private TextView message1;
    private Button choice1;
    private Button choice2;
    private Button varsButton;

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

        varsButton = findViewById(R.id.varsButton);

        if (controller.getPlayerName().equals("debug")) {
            varsButton.setVisibility(View.VISIBLE);
            varsButton.setEnabled(true);
        }

        String s = ("Congratulations you packed " + score + " boxes,\nyou've earn't $" + controller.getBalanceEarnt() + ".");
        message1.setText(s);
       //onoller.setStoryNode(controller.getStoryNode().getRandomNode());
        controller.setBalance(controller.getBalance() - controller.getStoryNode().getCinematic().getCost()[2]);

        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.setBalance(controller.getBalance() - c.getCost()[0]); // this is a mess maybe i tidy this
                //TODO set depth of consequince to random
                controller.setStoryNode(controller.getStoryNode().getRandomNode());
                if(controller.getStoryNode()==null){
                    controller.setStoryNode(new StoryTreeNode(new Cinematic()));
                }
                //go back to LobbyActivity
                startActivity(new Intent(CinematicActivity.this, LobbyActivity.class));
                //TODO if balance < 0 go to fail case
                finish();
            }
        });
        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.setBalance(controller.getBalance() - c.getCost()[1]);
                controller.getStoryNode().setLeft(new StoryTreeNode(new Cinematic( c.getEventCode()+10)));
                System.out.println(controller.getStoryNode().getCinematic().getEventCode()+"ass");
                controller.setStoryNode(controller.getStoryNode().getRandomNode());
                if(controller.getStoryNode()==null){
                    controller.setStoryNode(new StoryTreeNode(new Cinematic()));
                }
                startActivity(new Intent(CinematicActivity.this, LobbyActivity.class));//go back to LobbyActivity
                //TODO if balance < 0 go to fail case
                finish();
            }
        });
        new CountDownTimer(3500, 1000) {
            //dont rip this out for codecov
            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                if(controller.getRoundsPlayed()<3) {
                    startActivity(new Intent(CinematicActivity.this, LobbyActivity.class));//go back to LobbyActivity
                    finish();

                }else {
                    message1.setText(c.getScenarioChoice());
                    choice1.setText(c.getFirstChoice());
                    choice1.setVisibility(View.VISIBLE);
                    choice2.setText(c.getSecondChoice());
                    choice2.setVisibility(View.VISIBLE);
                }
            }
        }.start();
        //display options and buttons
        //do noting with that

        varsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CinematicActivity.this, VarsActivity.class));
            }
        });
    }

}
