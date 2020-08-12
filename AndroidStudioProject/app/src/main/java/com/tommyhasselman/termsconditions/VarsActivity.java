package com.tommyhasselman.termsconditions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.HashMap;

public class VarsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vars);

        Controller cont = ((Controller) this.getApplication());

        LinearLayout ll = findViewById(R.id.linearlay);

        for (HashMap.Entry<String, Object> e : cont.mapVars().entrySet()) {
            String key = e.getKey();
            String value = "" + e.getValue();

            String s = key + ": " + value;

            TextView t = new TextView(getBaseContext());
            t.setTextSize(18);
            t.setPadding(100,10,10,10);
            t.setText(s);
            ll.addView(t);
        }

    }
}