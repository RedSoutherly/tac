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
import com.tommyhasselman.termsconditions.model.OrderItem;

/**
 * Responsible for the buttons and listeners of the main game, also keeps a timer in order to track
 * length of a "work day".
 */

public class MainActivity extends AppCompatActivity {

    private Controller controller;

    private TextView countdownTextField;
    private TextView orderTextView;
    private TextView boxTextView;
    private TextView scoreTextView;
    private ImageView bezosImageView;
    private Button correctButton;
    private Button incorrectButton;
    private Order order;

    private int ordersCompleted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ordersCompleted = 0;

        controller = ((Controller) this.getApplication());

        countdownTextField = findViewById(R.id.countdownTextField);
        orderTextView = findViewById(R.id.orderContents);
        boxTextView = findViewById(R.id.boxContents);
        scoreTextView = findViewById(R.id.scoreTextView);
        bezosImageView = findViewById(R.id.bezosImageView);
        correctButton = findViewById(R.id.correctButton);
        incorrectButton = findViewById(R.id.incorrectButton);

        generateNewBox();




        correctButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(order.isCorrectlyPacked()) {
                    ordersCompleted++;
                    updateScore();
                    bezosImageView.setImageResource(R.drawable.correct_bezos);
                } else {
                    bezosImageView.setImageResource(R.drawable.incorrect_bezos);
                }
                order.setValidated(true);

                generateNewBox();
            }
        });
        incorrectButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!order.isCorrectlyPacked()) {
                    ordersCompleted++;
                    updateScore();
                    bezosImageView.setImageResource(R.drawable.correct_bezos);
                } else {
                    bezosImageView.setImageResource(R.drawable.incorrect_bezos);
                }
                order.setValidated(true);

                generateNewBox();
            }
        });
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                String message = ("seconds remaining: " + millisUntilFinished / 1000);
                countdownTextField.setText(message);
            }

            public void onFinish() {
                controller.endRound(ordersCompleted);
                startActivity(new Intent(MainActivity.this,CinematicActivity.class));
                finish();
            }
        }.start();

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

    /**
     * This method quickly updates the Score text view.
     */
    public void updateScore() {
        String s = ordersCompleted + " packages screened correctly.";
        scoreTextView.setText(s);
    }

}
