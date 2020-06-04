package com.tommyhasselman.termsconditions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.tommyhasselman.termsconditions.model.Player;

import com.tommyhasselman.termsconditions.model.Order;
import com.tommyhasselman.termsconditions.model.OrderItem;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    Player player;
    Controller controller;

    TextView countdownTextField;
    TextView orderTextView;
    TextView boxTextView;
    TextView scoreTextView;
    ImageView bezosImageView;
    ImageButton generateButton;
    Button correctButton;
    Button incorrectButton;
    Order order;
    //final Color red = Color.decode("#FF0000");
    //final Color green = Color.decode("#0x008010");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        controller = ((Controller) this.getApplication());
        player = controller.getPlayer();

        Timer t = new Timer();


        countdownTextField = (TextView) findViewById(R.id.countdownTextField);
        orderTextView = (TextView) findViewById(R.id.orderContents);
        boxTextView = (TextView) findViewById(R.id.boxContents);
        scoreTextView = (TextView) findViewById(R.id.scoreTextView);
        bezosImageView = (ImageView) findViewById(R.id.bezosImageView);
        generateButton = (ImageButton) findViewById(R.id.generateButton);
        correctButton = (Button) findViewById(R.id.correctButton);
        incorrectButton = (Button) findViewById(R.id.incorrectButton);


        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNewBox();
                generateButton.setVisibility(View.GONE);
                generateButton.setEnabled(false);
                correctButton.setVisibility(View.VISIBLE);
                correctButton.setEnabled(true);
                incorrectButton.setVisibility(View.VISIBLE);
                incorrectButton.setEnabled(true);
                bezosImageView.setImageResource(R.drawable.question_bezos);
            }
        });
        correctButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(order.isCorrectlyPacked()) {
                    player.incrementScore();
                    updateScore();
                    bezosImageView.setImageResource(R.drawable.correct_bezos);
                } else {
                    bezosImageView.setImageResource(R.drawable.incorrect_bezos);
                }
                order.setValidated(true);

                correctButton.setVisibility(View.GONE);
                correctButton.setEnabled(false);
                incorrectButton.setVisibility(View.GONE);
                incorrectButton.setEnabled(false);
                generateButton.setVisibility(View.VISIBLE);
                generateButton.setEnabled(true);
            }
        });
        incorrectButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!order.isCorrectlyPacked()) {
                    player.incrementScore();
                    updateScore();
                    bezosImageView.setImageResource(R.drawable.correct_bezos);
                } else {
                    bezosImageView.setImageResource(R.drawable.incorrect_bezos);
                }
                order.setValidated(true);

                correctButton.setVisibility(View.GONE);
                correctButton.setEnabled(false);
                incorrectButton.setVisibility(View.GONE);
                incorrectButton.setEnabled(false);
                generateButton.setVisibility(View.VISIBLE);
                generateButton.setEnabled(true);
            }
        });
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                countdownTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                startActivity(new Intent(MainActivity.this,CinematicActivity.class));
            }
        }.start();


        /*
        // this implementation is proboly bad maybe use timer and schedule task
        while(p.isAlive()){
        TimerTask task = new TimerTask() {
        

            @Override
            public void run() {
                //display a countdown
                //make buttons , score  usable and visable
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, new Date(), 3000);
        //hide count down,score and buttons
        //make a cinematic anc play it  then loop
        }
        */
    }

    /**
     * This method creates a new instance of a Box.
     * It then updates the respective text fields with what
     * the box contains, and what it should contain.
     */
    public void generateNewBox() {
        order = controller.newOrder();
        String orderedContains = "";
        for (OrderItem i : order.getOrdered()) {
            orderedContains += i.toString()+"\n";
        }
        String packedContains = "";
        for (OrderItem i : order.getPacked()) {
            packedContains += i.toString()+"\n";
        }
        orderTextView.setText(orderedContains);
        boxTextView.setText(packedContains);
    }

    public void updateScore() {
        String s = player.getScore() + " packages screened correctly.";
        scoreTextView.setText(s);
    }

}
