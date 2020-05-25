package com.tommyhasselman.termsconditions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tommyhasselman.termsconditions.model.BasicItem;
import com.tommyhasselman.termsconditions.model.Box;
import com.tommyhasselman.termsconditions.model.OrderItem;

public class MainActivity extends AppCompatActivity {

    TextView orderTextView;
    TextView boxTextView;
    Button generateButton;
    OrderItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        orderTextView = (TextView) findViewById(R.id.orderContents);
        boxTextView = (TextView) findViewById(R.id.boxContents);
        generateButton = (Button) findViewById(R.id.generateButton);

        /**
         * When generateButton is clicked, generateNewBox() is called.
         */
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNewBox();
            }
        });
    }

    /**
     * This method creates a new instance of a Box.
     * It then updates the respective text fields with what
     * the box contains, and what it should contain.
     */
    public void generateNewBox() {
        Box b = new Box(3);
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
