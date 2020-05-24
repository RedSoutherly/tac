package com.tommyhasselman.termsconditions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tommyhasselman.termsconditions.model.BasicItem;
import com.tommyhasselman.termsconditions.model.OrderItem;

public class MainActivity extends AppCompatActivity {

    TextView testTextView;
    Button testButton;
    OrderItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testTextView = (TextView) findViewById(R.id.testTextView);
        testButton = (Button) findViewById(R.id.testButton);
        item = new BasicItem();
        testTextView.setText(item.toString());

        /**
         * When testButton is clicked, a new BasicItem instance is generated.
         * testTextView's text is then updated with the new item.
         */
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = new BasicItem();
                testTextView.setText(item.toString());
            }
        });
    }

}
