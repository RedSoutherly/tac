package com.tommyhasselman.termsconditions;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OptionsMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu);

        final Controller cont = ((Controller) this.getApplication());

        Button resetButton = findViewById(R.id.resetButton);
        Button doneButton = findViewById(R.id.goBackButton);
        final EditText nameField = findViewById(R.id.editTextTextPersonName);
        nameField.setText(cont.getPlayerName());

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder.setMessage("Do you want to reset your save?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                cont.resetSave();
                                Toast.makeText(getApplicationContext(), "Your save has been reset",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont.setPlayerName(nameField.getText().toString());
                finish();
            }
        });
    }
}