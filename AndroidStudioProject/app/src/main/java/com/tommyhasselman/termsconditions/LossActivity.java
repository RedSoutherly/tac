package com.tommyhasselman.termsconditions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LossActivity extends AppCompatActivity {
    /**
     * loss activity is the class resposible for displaying the loss screen generating and listenig
     * to the gohome button and displaying the game loss message
     * TODO impliment unique messages for each different loss condition
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Controller controller = ((Controller) this.getApplication());
        setContentView(R.layout.activity_loss);
        controller.resetSave();
        Button mmButton = findViewById(R.id.mmButton);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.adversity);
        mp.start();

        mmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LossActivity.this, MainMenu.class));
                mp.release();
                finish();
            }
        });

    }
}