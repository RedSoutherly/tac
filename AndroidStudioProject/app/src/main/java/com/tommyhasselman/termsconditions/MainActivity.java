package com.tommyhasselman.termsconditions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.tommyhasselman.termsconditions.controller.Controller;
import com.tommyhasselman.termsconditions.model.Player;
import com.tommyhasselman.termsconditions.model.Order;
import com.tommyhasselman.termsconditions.model.OrderItem;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    Player player;
    Controller controller;

    TextView orderTextView;
    TextView boxTextView;
    TextView scoreTextView;
    ImageView bezosImageView;
    Button generateButton;
    Button correctButton;
    Button incorrectButton;
    Order order;
    int boxSize=3;
    //final Color red = Color.decode("#FF0000");
    //final Color green = Color.decode("#0x008010");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        player = new Player();
        controller = new Controller(player);



        Timer t = new Timer();


        orderTextView = (TextView) findViewById(R.id.orderContents);
        boxTextView = (TextView) findViewById(R.id.boxContents);
        scoreTextView = (TextView) findViewById(R.id.scoreTextView);
        bezosImageView = (ImageView) findViewById(R.id.bezosImageView);
        generateButton = (Button) findViewById(R.id.generateButton);
        correctButton = (Button) findViewById(R.id.correctButton);
        incorrectButton = (Button) findViewById(R.id.incorrectButton);


        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNewBox();
                generateButton.setEnabled(false);
                correctButton.setEnabled(true);
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

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                correctButton.setEnabled(false);
                incorrectButton.setEnabled(false);
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
                correctButton.setEnabled(false);
                incorrectButton.setEnabled(false);
                generateButton.setEnabled(true);
            }
        });
        /*
        // this implementation is proboly bad maybe use timer and schedule task
        while(p.isAlive()){
            long time= System.currentTimeMillis();
            long end = time+15000;
            if(time<end){
                //set buttons to valid
            }
            //set buttons to invalid and do a cinematic
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
