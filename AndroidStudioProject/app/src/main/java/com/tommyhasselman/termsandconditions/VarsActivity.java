package com.tommyhasselman.termsandconditions;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.HashMap;

/**
 * VarsActivity defines and handles the variables dialog available in debug mode. It can be used to
 * change core gameplay variables during gameplay. And also displays all other gameplay variables
 * and their current values in a ScrollView. For debug mode to be available the player name must be
 * set to "debug".
 */
public class VarsActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
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
        final EditText complexityEdit = findViewById(R.id.complexityEdit);
        Button doneButton = findViewById(R.id.doneButton);


        balanceEdit.setText(""+cont.getBalance(), TextView.BufferType.EDITABLE);
        payRateEdit.setText(""+cont.getPayRate(), TextView.BufferType.EDITABLE);
        orderSizeEdit.setText(""+cont.getOrderSize(), TextView.BufferType.EDITABLE);
        incorrectEdit.setText(""+cont.getIncorrectItemChance(), TextView.BufferType.EDITABLE);
        missingEdit.setText(""+cont.getMissingItemChance(), TextView.BufferType.EDITABLE);
        complexityEdit.setText(""+cont.getOrderItemComplexity(), TextView.BufferType.EDITABLE);



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
                cont.setOrderItemComplexity(Integer.parseInt(complexityEdit.getText().toString()));

                finish();
            }
        });


    }
}