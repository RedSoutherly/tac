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

import com.tommyhasselman.termsconditions.model.Order;

/**
 * This is a Javadoc CI test.
 */

public class MainActivity extends AppCompatActivity {

    private Controller controller;

    private TextView countdownTextField;
    private TextView scoreTextView;
    private ImageView bezosImageView;
    private Button correctButton;
    private Button incorrectButton;
    private Button finButton;
    private Order order;

    private int ordersCompleted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ordersCompleted = 0;

        controller = ((Controller) this.getApplication());

        countdownTextField = findViewById(R.id.countdownTextField);
        scoreTextView = findViewById(R.id.scoreTextView);
        bezosImageView = findViewById(R.id.bezosImageView);
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
                startActivity(new Intent(MainActivity.this, BoxDialog.class));
            }
        });

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, OrderDialog.class));
            }
        });


        correctButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(order.isCorrectlyPacked()) {
                    ordersCompleted++;
                    bezosImageView.setImageResource(R.drawable.correct_bezos);
                } else {
                    ordersCompleted--;
                    bezosImageView.setImageResource(R.drawable.incorrect_bezos);
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
                    bezosImageView.setImageResource(R.drawable.correct_bezos);
                } else {
                    ordersCompleted--;
                    bezosImageView.setImageResource(R.drawable.incorrect_bezos);
                }
                updateScore();

                order = controller.getNewOrder();
            }
        });
        finButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.endRound(ordersCompleted);
                startActivity(new Intent(MainActivity.this,CinematicActivity.class));
                finish();
            }
        });

        int countdownLength = 30000; // 30 seconds

        if (controller.getPlayerName().equals("debug")) {
            countdownLength = 999999999;
            finButton.setVisibility(View.VISIBLE);
        }

        new CountDownTimer(countdownLength, 1000) {

            int i = 0;

            public void onTick(long millisUntilFinished) {
                String message = ("seconds remaining: " + millisUntilFinished / 1000);
                countdownTextField.setText(message);

                if (i > 2) {
                    bezosImageView.setImageResource(R.drawable.question_bezos);
                    i = 0;
                } else {
                    i++;
                }
            }

            public void onFinish() {
                correctButton.setVisibility(View.GONE);
                incorrectButton.setVisibility(View.GONE);
                finButton.setVisibility(View.VISIBLE);
            }
        }.start();

        varsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, VarsActivity.class));
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
