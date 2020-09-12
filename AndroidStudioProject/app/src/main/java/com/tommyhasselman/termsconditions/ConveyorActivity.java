package com.tommyhasselman.termsconditions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.tommyhasselman.termsconditions.model.Order;

/**
 * ConveyorActivity is where the core gameplay happens. The player is presented with a graphically
 * displayed order and subsequent box. They must validate as many pairings as they can in the given
 * time frame, by tapping the correct or incorrect buttons.
 */

public class ConveyorActivity extends AppCompatActivity {

    private Controller controller;

    private TextView countdownTextField;
    private TextView scoreTextView;
    private ImageView lightImageView;
    private Button correctButton;
    private Button incorrectButton;
    private Button finButton;
    private Order order;

    private int ordersCompleted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conveyor_new);

        ordersCompleted = 0;

        controller = ((Controller) this.getApplication());

        countdownTextField = findViewById(R.id.timeText);
        scoreTextView = findViewById(R.id.scoreText);
        lightImageView = findViewById(R.id.light);
        correctButton = findViewById(R.id.correctButton);
        incorrectButton = findViewById(R.id.incorrectButton);
        ImageButton boxButton = findViewById(R.id.boxButton);
        ImageButton orderButton = findViewById(R.id.orderButton);
        finButton = findViewById(R.id.finButton);
        Button varsButton = findViewById(R.id.varsButton);

        if (controller.getPlayerName().equals("debug")) {
            varsButton.setVisibility(View.VISIBLE);
            varsButton.setEnabled(true);
        }

        order = controller.getNewOrder();


        boxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConveyorActivity.this, BoxDialog.class));
            }
        });

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConveyorActivity.this, OrderDialog.class));
            }
        });


        correctButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(order.isCorrectlyPacked()) {
                    ordersCompleted++;
                    lightImageView.setColorFilter(Color.argb(50,0,255,0));
                } else {
                    ordersCompleted--;
                    lightImageView.setColorFilter(Color.argb(50,255,0,0));
                }
                updateScore();

                order = controller.getNewOrder();
            }
        });
        incorrectButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!order.isCorrectlyPacked()) {
                    ordersCompleted++;
                    lightImageView.setColorFilter(Color.argb(50,0,255,0));
                } else {
                    ordersCompleted--;
                    lightImageView.setColorFilter(Color.argb(50,255,0,0));
                }
                updateScore();

                order = controller.getNewOrder();
            }
        });
        finButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.endRound(ordersCompleted);
                startActivity(new Intent(ConveyorActivity.this,CinematicActivity.class));
                finish();
            }
        });

        int countdownLength = 30000; // 30 seconds

        if (controller.getPlayerName().equals("debug")) {
            countdownLength = 999999999;
            finButton.setVisibility(View.VISIBLE);
            finButton.setEnabled(true);
        }

        new CountDownTimer(countdownLength, 1000) {

            int i = 0;

            public void onTick(long millisUntilFinished) {
                String message = ((millisUntilFinished / 1000) + "s");
                countdownTextField.setText(message);

            }

            public void onFinish() {
                correctButton.setVisibility(View.GONE);
                incorrectButton.setVisibility(View.GONE);
                finButton.setVisibility(View.VISIBLE);
                finButton.setEnabled(true);
            }
        }.start();

        varsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConveyorActivity.this, VarsActivity.class));
            }
        });

    }

    /**
     * This method quickly updates the Score text view.
     */
    public void updateScore() {
        String s = ""+ordersCompleted;
        scoreTextView.setText(s);
    }

}
