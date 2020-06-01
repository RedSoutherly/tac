package com.tommyhasselman.termsconditions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tommyhasselman.termsconditions.model.Player;
import com.tommyhasselman.termsconditions.model.Box;
import com.tommyhasselman.termsconditions.model.OrderItem;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    TextView orderTextView;
    TextView boxTextView;
    ImageView bezosImageView;
    Button generateButton;
    Button correctButton;
    Button incorrectButton;
    Box b;
    int boxSize=3;
    //final Color red = Color.decode("#FF0000");
    //final Color green = Color.decode("#0x008010");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Player p = new Player();
        Timer t = new Timer();


        orderTextView = (TextView) findViewById(R.id.orderContents);
        boxTextView = (TextView) findViewById(R.id.boxContents);
        bezosImageView = (ImageView) findViewById(R.id.bezosImageView);
        generateButton = (Button) findViewById(R.id.generateButton);
        correctButton = (Button) findViewById(R.id.correctButton);
        incorrectButton = (Button) findViewById(R.id.incorrectButton);

        /**
         * When generateButton is clicked, generateNewBox() is called.
         */
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
                if(!b.isDiff()) {
                    p.incrementScore();
                    bezosImageView.setImageResource(R.drawable.correct_bezos);
                } else {
                    bezosImageView.setImageResource(R.drawable.incorrect_bezos);
                }
                b.setValidated(true);

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
                if(b.isDiff()) {
                    p.incrementScore();
                    bezosImageView.setImageResource(R.drawable.correct_bezos);
                } else {
                    bezosImageView.setImageResource(R.drawable.incorrect_bezos);
                }

                b.setValidated(true);
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
        b = new Box(boxSize);
        String orderContains = "";
        for (OrderItem i : b.getBoxShouldContain()) {
            orderContains += i.toString()+"\n";
        }
        String boxContains = "";
        for (OrderItem i : b.getBoxContains()) {
            boxContains += i.toString()+"\n";
        }
        orderTextView.setText(orderContains);
        boxTextView.setText(boxContains);
    }

}
