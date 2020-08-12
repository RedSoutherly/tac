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

import java.util.Random;

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
    private boolean flipBtn =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinematic);
        final Controller controller = ((Controller) this.getApplication());
        final Cinematic c = controller.getStoryNode().getCinematic();
        int score = controller.getPreviousRoundScore();
        Random rand = new Random();
        int flip=rand.nextInt(2);
        if (flip==1){
            flipBtn=true;
        }

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
                if(flipBtn){
                    controller.setBalance(controller.getBalance() - c.getCost()[1]);
                }else {
                    controller.setBalance(controller.getBalance() - c.getCost()[0]);
                }
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
                if(flipBtn){
                    controller.setBalance(controller.getBalance() - c.getCost()[0]);
                }else{
                    controller.setBalance(controller.getBalance() - c.getCost()[1]);
                    controller.getStoryNode().setLeft(new StoryTreeNode(new Cinematic( c.getEventCode()+10)));
                }
                controller.setStoryNode(controller.getStoryNode().getRandomNode());
                if(controller.getStoryNode()==null){
                    controller.setStoryNode(new StoryTreeNode(new Cinematic()));
                }
                startActivity(new Intent(CinematicActivity.this, LobbyActivity.class));//go back to LobbyActivity
                finish();
            }
        });
        new CountDownTimer(3500, 1000) {
            //dont rip this out for codecov
            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                //exit to loss screen
                if(controller.getBalance()<0){
                    controller.setDaysInDebt(controller.getDaysInDebt()+1);
                    if(controller.getDaysInDebt()>3){
                        startActivity(new Intent(CinematicActivity.this, LossActivity.class));
                        finish();
                    }
                }else{
                    controller.setDaysInDebt(0);
                }
                //dont do a cinematic if in first 3 rounds
                if(controller.getRoundsPlayed()<3) {
                    startActivity(new Intent(CinematicActivity.this, LobbyActivity.class));//go back to LobbyActivity
                    finish();

                }else {
                    message1.setText(c.getScenarioChoice());
                    if(flipBtn){
                        choice1.setText(c.getSecondChoice());
                        choice2.setText(c.getFirstChoice());
                    }else {
                        choice1.setText(c.getFirstChoice());
                        choice2.setText(c.getSecondChoice());
                    }
                    choice1.setVisibility(View.VISIBLE);
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
