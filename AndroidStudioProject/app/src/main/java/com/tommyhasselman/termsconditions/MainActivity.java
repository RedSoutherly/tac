package com.tommyhasselman.termsconditions;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tommyhasselman.termsconditions.model.Player;
import java.util.TimerTask;
import com.tommyhasselman.termsconditions.model.BasicItem;
import com.tommyhasselman.termsconditions.model.Box;
import com.tommyhasselman.termsconditions.model.OrderItem;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    TextView orderTextView;
    TextView boxTextView;
    Button generateButton;
    Button valid;
    Button invalid;
    OrderItem item;
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
        generateButton = (Button) findViewById(R.id.generateButton);
        valid = (Button) findViewById(R.id.Valid);
        invalid= (Button) findViewById(R.id.Invalid);

        /**
         * When generateButton is clicked, generateNewBox() is called.
         */
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNewBox();
                valid.setEnabled(true);
                invalid.setEnabled(true);
            }
        });
        valid.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!b.isDiff()) {
                    p.incrementScore();
                    valid.setBackgroundColor(0xFF0000);
                }
                b.setValidated(true);

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                valid.setEnabled(false);
                invalid.setEnabled(false);
            }
        });
        invalid.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(b.isDiff()) {
                    p.incrementScore();
                    invalid.setBackgroundColor(0xFF0000);
                }
                b.setValidated(true);
                valid.setEnabled(false);
                invalid.setEnabled(false);
            }
        });
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
