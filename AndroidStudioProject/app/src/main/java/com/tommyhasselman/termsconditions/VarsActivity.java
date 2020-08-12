package com.tommyhasselman.termsconditions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.net.Inet4Address;
import java.util.HashMap;

public class VarsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vars);

        final Controller cont = ((Controller) this.getApplication());

        final EditText balanceEdit = findViewById(R.id.balanceEdit);
        final EditText payRateEdit = findViewById(R.id.payRateEdit);
        final EditText orderSizeEdit = findViewById(R.id.orderSizeEdit);
        final EditText incorrectEdit = findViewById(R.id.incorrectEdit);
        final EditText missingEdit = findViewById(R.id.missingEdit);
        Button doneButton = findViewById(R.id.doneButton);


        balanceEdit.setText(""+cont.getBalance(), TextView.BufferType.EDITABLE);
        payRateEdit.setText(""+cont.getPayRate(), TextView.BufferType.EDITABLE);
        orderSizeEdit.setText(""+cont.getOrderSize(), TextView.BufferType.EDITABLE);
        incorrectEdit.setText(""+cont.getIncorrectItemChance(), TextView.BufferType.EDITABLE);
        missingEdit.setText(""+cont.getMissingItemChance(), TextView.BufferType.EDITABLE);



        LinearLayout ll = findViewById(R.id.linearlay);

        for (HashMap.Entry<String, Object> e : cont.mapVars().entrySet()) {
            String key = e.getKey();
            String value = "" + e.getValue();

            String s = key + ": " + value;

            TextView t = new TextView(getBaseContext());
            t.setTextSize(18);
            t.setPaddingRelative(20,20,20,20);
            t.setText(s);
            ll.addView(t);
        }

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cont.setBalance(Integer.parseInt(balanceEdit.getText().toString()));
                cont.setPayRate(Integer.parseInt(payRateEdit.getText().toString()));
                cont.setOrderSize(Integer.parseInt(orderSizeEdit.getText().toString()));
                cont.setIncorrectItemChance(Double.parseDouble(incorrectEdit.getText().toString()));
                cont.setMissingItemChance(Double.parseDouble(missingEdit.getText().toString()));


                finish();
            }
        });


    }
}