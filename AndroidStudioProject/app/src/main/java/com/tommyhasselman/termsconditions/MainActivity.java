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
         * When testButton is clicked, a new BasicItem instance is generated.
         * testTextView's text is then updated with the new item.
         */
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNewBox();
            }
        });
    }

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
