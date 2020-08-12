package com.tommyhasselman.termsconditions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LossActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Controller controller = ((Controller) this.getApplication());
        setContentView(R.layout.activity_loss);
        controller.resetSave();
        Button mmButton = findViewById(R.id.mmButton);

        mmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LossActivity.this, MainMenu.class));
                finish();
            }
        });

    }
}