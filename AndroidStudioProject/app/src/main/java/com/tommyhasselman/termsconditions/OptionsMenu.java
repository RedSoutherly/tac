package com.tommyhasselman.termsconditions;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OptionsMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu);

        final Controller cont = ((Controller) this.getApplication());

        Button doneButton = findViewById(R.id.goBackButton);
        final EditText nameField = findViewById(R.id.editTextTextPersonName);
        nameField.setText(cont.getPlayerName());

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont.setPlayerName(nameField.getText().toString());
                finish();
            }
        });
    }
}