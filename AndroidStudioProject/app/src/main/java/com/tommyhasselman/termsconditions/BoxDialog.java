package com.tommyhasselman.termsconditions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.flexbox.FlexboxLayout;
import com.tommyhasselman.termsconditions.model.OrderItem;

import java.util.ArrayList;

public class BoxDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box_dialog);

        Controller cont = ((Controller) this.getApplication());

        FlexboxLayout cl = findViewById(R.id.rootView);

        ArrayList<OrderItem> boxed = cont.getCurrentOrder().getPacked();

        for (OrderItem item : boxed) {
            ImageView img = new ImageView(getBaseContext());
            img.setImageResource(R.drawable.dildo);
            img.setScaleType(ImageView.ScaleType.FIT_CENTER);
            img.setColorFilter(Color.argb(50,255,0,0));
            cl.addView(img);
        }



    }
}