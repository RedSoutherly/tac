package com.tommyhasselman.termsconditions;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.flexbox.FlexboxLayout;
import com.tommyhasselman.termsconditions.model.OrderItem;

import java.util.ArrayList;

/**
 * The BoxDialog is used to show the contents of the packed array in the current Order.
 * It uses the data fields in each Item in the array to display its drawable in the Flexbox Layout.
 */
public class BoxDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box_dialog);

        Controller cont = ((Controller) this.getApplication());

        FlexboxLayout cl = findViewById(R.id.boxFlex);
        ArrayList<OrderItem> boxed = cont.getCurrentOrder().getPackedShuff();

        for (OrderItem item : boxed) {
            ImageView img = new ImageView(getBaseContext());
            img.setImageResource(item.getDrawable());
            FlexboxLayout.LayoutParams lp = new FlexboxLayout.LayoutParams(item.getIntSize(),item.getIntSize());
            img.setLayoutParams(lp);
            img.setScaleType(ImageView.ScaleType.FIT_CENTER);
            img.setColorFilter(item.getArgbColour());
            img.setPadding(20,20,20,20);
            cl.addView(img);
        }

    }
}